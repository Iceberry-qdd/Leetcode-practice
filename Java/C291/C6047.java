package C291;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class C6047 {
    public static void main(String[] args) {
        System.out.println(removeDigit("123", '3'));
        System.out.println(removeDigit("1231", '1'));
        System.out.println(removeDigit("551", '5'));
        System.out.println(removeDigit("2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471", '3'));
        System.out.println(removeDigit("133235", '3'));
    }

    public static String removeDigit(String number, char digit) {
        int len = number.length();


        List<Integer> indexList=new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            if (number.charAt(i) != digit) continue;
            indexList.add(i);
            if (i == len - 1) return number.substring(0, len - 1);
            if (number.charAt(i) < number.charAt(i + 1)) {
                return number.substring(0, i) + number.substring(i + 1, len);
            }else if (number.charAt(i) == number.charAt(i + 1)){

            }
        }
        return number;

        /*/
        BigInteger maxNum = new BigInteger(new byte[]{0});
        for (int i = 0; i < len; i++) {
            if (number.charAt(i) != digit) continue;
            String curValue = number.substring(0, i) + number.substring(i + 1, len);
            BigInteger curNum = new BigInteger(curValue);
            maxNum = curNum.max(maxNum);
        }
        return maxNum.toString();

         */
    }
}
