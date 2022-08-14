public class L640 {
    public static void main(String[] args) {
        System.out.println(solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solveEquation("x=x"));
        System.out.println(solveEquation("2x=x"));
        System.out.println(solveEquation("x=0"));
        System.out.println(solveEquation("-x=1"));

    }

    public static String solveEquation(String equation) {
        StringBuilder sb = new StringBuilder(equation);

        if (equation.charAt(0) == '-') {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '-') {
                    sb.replace(i, i + 1, "+");
                } else if (sb.charAt(i) == '+') {
                    sb.replace(i, i + 1, "-");
                }else if (i>0 && equation.charAt(i-1)=='='){
                    sb.insert(i,'-');
                }
            }
        } else {
            sb.insert(0, '+');
        }

        for (int i = 0; i < sb.length(); i++) {
            if (i != 0 && sb.charAt(i) == 'x' && (sb.charAt(i - 1) == '+' || sb.charAt(i - 1) == '-' || sb.charAt(i - 1) == '=')) {
                sb.insert(i, '1');
            } else if (i == 0 && sb.charAt(i) == 'x') {
                sb.insert(i, '1');
            }
        }
        equation = sb.toString();

        int a = 0, b = 0;
        String[] parts = equation.split("=");
        sb = new StringBuilder();
        for (int i = 0; i < parts[0].length() + 1; i++) {
            if (i < parts[0].length()) {
                int startIndex = i;
                if (sb.length() == 0 && startIndex == 0) {
                    sb.append(parts[0].charAt(startIndex));
                    i++;
                } else if (sb.length() == 0 && startIndex != 0) {
                    sb.append(parts[0].charAt(startIndex - 1));
                }

                if (parts[0].charAt(i) != '+' && parts[0].charAt(i) != '-') {
                    sb.append(parts[0].charAt(i));

                    continue;
                }
            }

            if (sb.charAt(sb.length() - 1) == 'x') {
                a += Integer.parseInt(sb.substring(0, sb.length() - 1));
            } else {
                try {
                    b -= Integer.parseInt(sb.substring(0, sb.length()));
                } catch (NumberFormatException ignored) {
                }

            }
            sb.delete(0, sb.length());
        }

        sb = new StringBuilder();
        for (int i = 0; i < parts[1].length() + 1; i++) {
            if (i < parts[1].length()) {
                int startIndex = i;
                if (sb.length() == 0 && startIndex == 0) {
                    sb.append(parts[1].charAt(startIndex));
                    i++;
                } else if (sb.length() == 0 && startIndex != 0) {
                    sb.append(parts[1].charAt(startIndex - 1));
                }

                if (i < parts[1].length() && parts[1].charAt(i) != '+' && parts[1].charAt(i) != '-') {
                    sb.append(parts[1].charAt(i));
                    continue;
                }
            }

            if (sb.charAt(sb.length() - 1) == 'x') {
                a -= Integer.parseInt(sb.substring(0, sb.length() - 1));
            } else {
                try {
                    b += Integer.parseInt(sb.substring(0, sb.length()));
                } catch (NumberFormatException ignored) {
                }

            }
            sb.delete(0, sb.length());
        }

        if (a == 0 && b == 0) {
            return "Infinite solutions";
        } else if (a == 0 && b != 0) {
            return "No solution";
        } else return "x=" + b / a;
    }
}
