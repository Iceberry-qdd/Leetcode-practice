import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L811 {
    public static void main(String[] args) {
        List<String> result = subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(result);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>(cpdomains.length * 3);
        for (String cpdomain : cpdomains) {
            String[] cpdSplits = cpdomain.split("[ .]");
            int count = Integer.parseInt(cpdSplits[0]);
            StringBuilder sb = new StringBuilder();
            for (int i = cpdSplits.length - 1; i > 0; i--) {
                sb.insert(0, i == cpdSplits.length - 1 ? "" : ".").insert(0, cpdSplits[i]);
                map.merge(sb.toString(), count, Integer::sum);
            }
        }

        List<String> result = new ArrayList<>(map.size());
        map.forEach((k, v) -> {
            String item = String.format("%d %s", v, k);
            result.add(item);
        });
        return result;
    }
}
