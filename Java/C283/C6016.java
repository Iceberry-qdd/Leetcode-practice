package C283;

import java.util.ArrayList;
import java.util.List;

public class C6016 {
    public static void main(String[] args) {
        System.out.println(cellsInRange("A1:F1"));
        System.out.println(cellsInRange("K1:L2"));
    }

    public static List<String> cellsInRange(String s) {
        char[] strArr = s.toCharArray();
        List<String> result = new ArrayList<>();
        for (int col = strArr[0]; col <= strArr[3]; col++) {
            for (int row = strArr[1]; row <= strArr[4]; row++) {
                result.add(String.format("%c%c", col, row));
            }
        }
        return result;
    }
}


