import java.util.HashMap;
import java.util.Map;

public class L860 {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));

        bills = new int[]{5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(bills));

        bills = new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int len = bills.length;
        int[] money = new int[3];
        for (int i = 0; i < len; i++) {
            switch (bills[i]) {
                case 5:
                    money[0]++;
                    break;
                case 10:
                    if (money[0] <= 0) return false;
                    money[1]++;
                    money[0]--;
                    break;
                case 20:
                    if (money[0] <= 0) return false;
                    if (money[1] <= 0 && money[0] < 3) return false;
                    if (money[1] <= 0) {
                        money[0] -= 3;
                    } else {
                        money[1]--;
                        money[0]--;
                        money[2]++;
                    }
                    break;
            }
        }
        return true;
    }
}
