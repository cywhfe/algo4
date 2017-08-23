package cy.chapter1;

import cy.chapter1_3.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex3 {
    @Test
    public void ex4() throws Exception {
        String s = "[()]{}{[()()]}}";
        StdOut.print(isParenthese(s));
    }


    private boolean isParenthese(String s) {
        Stack<Character> parntheses = new Stack<>();
        String[] split = s.split("\\s+");
//        Arrays.stream(split).forEach(v -> parntheses.push(v));
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            if (temp == '}') {
                char prev = parntheses.pop();
                if (prev != '{') {
                    System.out.println("not {");
                    return false;
                }
            } else if (temp == ')') {
                char prev = parntheses.pop();
                if (prev != '(') {
                    System.out.println("not (");
                    return false;
                }
            } else if (temp == ']') {
                char prev = parntheses.pop();
                if (prev != '[') {
                    System.out.println("not [");
                    return false;
                }
            } else {
                parntheses.push(temp);
            }
        }
        return true;
    }


    @Test
    public void ex5() throws Exception {
        hex(100);
    }

    private void hex(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        for (int d : stack)
            StdOut.print(d);
        StdOut.println();
    }

    @Test
    public void ex9() throws Exception {
//        completionExpression();

        StringTokenizer tokenizer = new StringTokenizer("123456789", "+-x/()123456789", true);
        while (tokenizer.hasMoreElements()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    private static void completionExpression() {
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
                String op = ops.pop();
                int v = vals.pop();
                String result = vals.pop() + op + v;
                results.push(result);
            } else if (s.equals("S")) {//stop code
                String result = "";
                while (!ops.isEmpty()) {
                    String op = ops.pop();
                    result += "(" + vals.pop() + op + vals.pop() + ")";
                }
                System.out.println("finish: " + result);
            } else
                vals.push(Integer.valueOf(s));
        }
    }

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
                String op = ops.pop();
                int v = vals.pop();
                String result = vals.pop() + op + v;
                results.push(result);
            } else if (s.equals("S")) {//stop code
                String result = "";
                while (!ops.isEmpty()) {
                    String op = ops.pop();
                    result += "(" + vals.pop() + op + vals.pop() + ")";
                }
                System.out.println("finish: " + result);
            } else
                vals.push(Integer.valueOf(s));
        }
    }

}
