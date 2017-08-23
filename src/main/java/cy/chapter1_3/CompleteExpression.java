package cy.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

public class CompleteExpression {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Integer> vals = new Stack<>();
        Stack<String> results = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals(")")) {
                if (vals.isEmpty()) {
                    continue;
                }
                String op = ops.pop();
                int v = vals.pop();
                String result = vals.pop() + op + v;
                results.push(result);
            } else if (s.equals("S")) {//stop code
                while (!ops.isEmpty()) {
                    String op = ops.pop();
                    String last = results.pop();
                    String first = results.pop();
                    String expression = "(" + first+ ")" + op + "(" + last + ")";
                    results.push(expression);
                }
                System.out.println("finish: " + "(" + results.pop() + ")");
            } else
                vals.push(Integer.valueOf(s));
        }
    }
}
