public class L591 {
    public static void main(String[] args) {
        System.out.println(isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
        System.out.println(isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
        System.out.println(isValid("<A>  <B> </A>   </B>"));
    }

    public static boolean isValid(String code) {
        code = code.replaceAll("<!\\[CDATA\\[.*?]]>|t", "-");
        String s = "";
        while (!s.equals(code)) {
            s = code;
            code = code.replaceFirst("<([A-Z]{1,9})>[^<]*</\\1>", "t");
        }
        return "t".equals(code);
    }
}
