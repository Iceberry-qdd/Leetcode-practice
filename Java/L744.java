public class L744 {
    public static void main(String[] args) {
        char[] letter = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letter, 'a'));

        letter = new char[]{'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letter, 'c'));

        letter = new char[]{'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letter, 'd'));

        letter = new char[]{'e','e','e','e','e','e','n','n','n','n'};
        System.out.println(nextGreatestLetter(letter, 'e'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) left = mid + 1;
            if (letters[mid] > target) right = mid - 1;
        }
        return letters[left % len];
    }
}
