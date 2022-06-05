import java.util.HashSet;
import java.util.Set;

public class L929 {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String realEmail = realEmail(email);
            set.add(realEmail);
        }
        return set.size();
    }

    public static String realEmail(String email) {
        String[] splitEmail = email.split("@");
        String localName = splitEmail[0], domainName = splitEmail[1];

        StringBuilder sb = new StringBuilder();
        String[] splitLocalName = localName.split("\\.");
        for (String s : splitLocalName) {
            sb.append(s);
        }
        localName = sb.toString();
        sb.delete(0, sb.length());

        splitLocalName = localName.split("\\+");
        sb.append(splitLocalName[0]);
        sb.append('@').append(domainName);
        return sb.toString();
    }
}
