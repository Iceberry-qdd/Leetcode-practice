import java.util.ArrayList;
import java.util.List;

public class L386 {
    public static void main(String[] args) {
        List<Integer> result = lexicalOrder(13);
        System.out.println(result);

        result = lexicalOrder(101);
        System.out.println(result);
    }


    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = 1; i < n; i++) {
            result.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                while (j % 10 == 9 || j + 1 > n) j /= 10;
                j++;
            }
        }
        return result;
    }

}
