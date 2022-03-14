public class L393 {
    public static void main(String[] args) {
        int[] data = {235, 140, 136, 4};
        System.out.println(validUtf8(data));
        data = new int[]{235, 140, 4};
        System.out.println(validUtf8(data));
        data = new int[]{197, 130, 1};
        System.out.println(validUtf8(data));
        data = new int[]{237};
        System.out.println(validUtf8(data));
        data = new int[]{230, 136, 145};
        System.out.println(validUtf8(data));
        data = new int[]{145};
        System.out.println(validUtf8(data));

    }

    public static boolean validUtf8(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (count > 1) {
                if (data[i] >> 6 == 0b10) count--;
                else return false;
            } else if (data[i] >> 7 == 0) {
                count = 1;
            } else if (data[i] >> 5 == 0b110) {
                count = 2;
            } else if (data[i] >> 4 == 0b1110) {
                count = 3;
            } else if (data[i] >> 3 == 0b11110) {
                count = 4;
            } else return false;
        }
        return count == 1;
    }
}
