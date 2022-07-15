public class L717 {
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 1, 0}));
        System.out.println(isOneBitCharacter(new int[]{0,0,0}));
        System.out.println(isOneBitCharacter(new int[]{0}));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int len = bits.length, i;
        if (len == 1 && bits[0] == 0) return true;
        for (i = 0; i < len;) {
            if (bits[i] == 1) i += 2;
            else if (bits[i] == 0) i++;
            if (i == len - 1) return true;
        }
        return false;
    }
}
