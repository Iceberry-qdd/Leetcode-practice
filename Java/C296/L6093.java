package C296;

class TextEditor {
    StringBuilder sb;
    int cursorIndex;

    public TextEditor() {
        sb = new StringBuilder();
        sb.append('|');
        cursorIndex = 0;
    }

    public void addText(String text) {
        //cursorIndex = sb.indexOf("|");
        sb.insert(cursorIndex, text);
        cursorIndex += text.length();
    }

    public int deleteText(int k) {
        //cursorIndex = sb.indexOf("|");
        int realDeleteCount = Math.min(cursorIndex, k);
        sb.delete(cursorIndex - realDeleteCount, cursorIndex);
        cursorIndex -= realDeleteCount;
        return realDeleteCount;
    }

    public String cursorLeft(int k) {
        //cursorIndex = sb.indexOf("|");
        int realMoveCount = Math.min(k, cursorIndex);
        if (realMoveCount != 0) {
            sb.deleteCharAt(cursorIndex);
            cursorIndex = cursorIndex - realMoveCount;
            sb.insert(cursorIndex, "|");
        }

        int realResultCount = Math.min(10, cursorIndex);
        return sb.substring(cursorIndex - realResultCount, cursorIndex);
    }

    public String cursorRight(int k) {
        //cursorIndex = sb.indexOf("|");
        int realMoveCount = Math.min(k, sb.length() - 1 - cursorIndex);
        if (realMoveCount != 0) {
            sb.deleteCharAt(cursorIndex);
            cursorIndex = cursorIndex + realMoveCount;
            sb.insert(cursorIndex, "|");
        }

        int realResultCount = Math.min(10, cursorIndex);
        return sb.substring(cursorIndex - realResultCount, cursorIndex);
    }
}

public class L6093 {
    public static void main(String[] args) {
        /*
        TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
        textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
        textEditor.deleteText(4); // 返回 4
        // 当前文本为 "leet|" 。
        // 删除了 4 个字符。
        textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
        System.out.println(textEditor.cursorRight(3)); // 返回 "etpractice"
        // 当前文本为 "leetpractice|".
        // 光标无法移动到文本以外，所以无法移动。
        // "etpractice" 是光标左边的 10 个字符。
        System.out.println(textEditor.cursorLeft(8)); // 返回 "leet"
        // 当前文本为 "leet|practice" 。
        // "leet" 是光标左边的 min(10, 4) = 4 个字符。
        textEditor.deleteText(10); // 返回 4
        // 当前文本为 "|practice" 。
        // 只有 4 个字符被删除了。
        System.out.println(textEditor.cursorLeft(2)); // 返回 ""
        // 当前文本为 "|practice" 。
        // 光标无法移动到文本以外，所以无法移动。
        // "" 是光标左边的 min(10, 0) = 0 个字符。
        System.out.println(textEditor.cursorRight(6)); // 返回 "practi"
        // 当前文本为 "practi|ce" 。
        // "practi" 是光标左边的 min(10, 6) = 6 个字符。
         */
        TextEditor textEditor = new TextEditor();
        textEditor.addText("jxarid");
        System.out.println(textEditor.cursorLeft(5));

        System.out.println(textEditor.cursorLeft(10));
        textEditor.addText("du");
        System.out.println(textEditor.deleteText(20));

    }

}
