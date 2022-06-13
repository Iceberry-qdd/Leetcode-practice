package C297;

public class C5259 {
    public static void main(String[] args) {
        System.out.println(calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
        System.out.println(calculateTax(new int[][]{{2, 50}}, 0));
        System.out.println(calculateTax(new int[][]{{1,0},{2,97},{3,20},{4,89},{5,54}},5));
    }

    public static double calculateTax(int[][] brackets, int income) {
        int len = brackets.length;
        double sum = 0;

        if (income <= brackets[0][0]) {
            sum += income * brackets[0][1] * 0.01;
        } else sum += brackets[0][0] * brackets[0][1] * 0.01;

        for (int i = 1; i < len; i++) {
            int money = 0;
            if (income >= brackets[i][0]) {
                money = brackets[i][0] - brackets[i - 1][0];
            } else if (income < brackets[i][0] && income > brackets[i - 1][0]) {
                money = income - brackets[i - 1][0];
            } else break;
            sum += money * brackets[i][1] * 0.01;
        }
        return sum;
    }
}
