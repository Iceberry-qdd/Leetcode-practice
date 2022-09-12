public class L1592 {
    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces("  hello"));
    }

    public static String reorderSpaces(String text) {
        int totalSpace = 0, wordCount = 0,j=0;
        char lastCh = ' ';
        for (char ch : text.toCharArray()) {
            if (ch == ' ') totalSpace++;
            if (ch == ' ' && lastCh != ' ') wordCount++;
            if (j==text.length()-1 && ch!= ' ') wordCount++;
            lastCh = ch;
            j++;
        }

        lastCh = ' ';
        StringBuilder sb = new StringBuilder(text.length());
        if (wordCount==1){
            for (char ch : text.toCharArray()) {
                if (ch==' ') continue;
                sb.append(ch);
            }
            for (int i = 0; i < totalSpace; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }


        int preSpaceCount = totalSpace / (wordCount - 1), n = 0, curWordCount = 0;
        for (char ch : text.toCharArray()) {
            if (ch == ' ' && lastCh == ' ') continue;
            if (ch == ' ' && lastCh != ' ' && curWordCount == wordCount - 1) {
                continue;
            }
            if (ch == ' ' && lastCh != ' ') {
                for (int i = 0; i < preSpaceCount; i++) {
                    sb.append(' ');
                    totalSpace--;
                }
                curWordCount++;
            }
            if (ch != ' ') {
                sb.append(ch);
            }
            lastCh = ch;
            n++;
        }
        for (int i = 0; i < totalSpace; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
