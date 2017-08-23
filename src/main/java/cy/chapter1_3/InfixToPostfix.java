package cy.chapter1_3;

public class InfixToPostfix {

    //    public static final Stack<Integer> vals = new Stack<>();
    public static final Stack<String> vals = new Stack<>();
    public static final Stack<String> ops = new Stack<>();
    public static final Stack<String> results = new Stack<>();

    public static void main(String[] args) {
        String s = "(1+2)*3+6 ";

        String expr = "";
        char[] chars = s.toCharArray();
        boolean isBracket = false;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    ops.push(String.valueOf(chars[i]));
                    break;
                case ')':
                    while (!ops.isEmpty()) {
                        String last = vals.pop();
                        String first = vals.pop();
                        String result = first + last + ops.pop();
                        vals.push(result);
                        expr += result;
                    }
                    break;
                case ' '://stop
                    while (!ops.isEmpty()) {
                        String last = vals.pop();
                        String first = vals.pop();
                        String result = last + first + ops.pop();
                        expr += result;
                    }
                    System.out.println(expr);
                default:
                    vals.push(String.valueOf(chars[i]));
                    /*if (isBracket) {
                        String last = vals.pop();
                        String first = vals.pop();
                        String result = last + first + ops.pop();
                        vals.push(result);
                        isBracket = false;
                        break;
                    }

                    while (ops.size() > 1) {
                        String last = vals.pop();
                        String first = vals.pop();
                        String result = last + first + ops.pop();
                        vals.push(result);
                    }*/
                    while (!ops.isEmpty()) {
                        String last = vals.pop();
                        String first = vals.pop();
                        String result = last + first + ops.pop();
                        vals.push(result);
                        expr += result;
                    }
            }
        }
    }
}
