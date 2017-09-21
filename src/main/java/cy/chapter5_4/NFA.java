package cy.chapter5_4;

import edu.princeton.cs.algs4.*;

/**
 * 有限状态机
 */
public class NFA {

    private Digraph graph;
    private String regexp;
    private final int m;

    public NFA(String regexp) {
        this.regexp = regexp;
        m = regexp.length();
        Stack<Integer> ops = new Stack<>();
        graph = new Digraph(m + 1);
        for (int i = 0; i < m; i++) {
            int lp = i;
            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '|')
                ops.push(i);
            else if (regexp.charAt(i) == ')') {
                int or = ops.pop();

                //2-way or operator
                if (regexp.charAt(or) == '|') {
                    lp = ops.pop();
                    graph.addEdge(lp, or + 1);
                    graph.addEdge(or, i);
                } else if (regexp.charAt(or) == '(')
                    lp = or;
                else
                    assert false;
            }

            if (i < m - 1 && regexp.charAt(i + 1) == '*') {
                graph.addEdge(lp, i + 1);
                graph.addEdge(i + 1, lp);
            }

            if (regexp.charAt(i) == '(' || regexp.charAt(i) == '*' || regexp.charAt(i) == ')') {
                graph.addEdge(i, i + 1);
            }
        }

        if (ops.size() != 0)
            throw new IllegalArgumentException("invalid regular expression");
    }

    public boolean recognizes(String txt) {
        DirectedDFS dfs = new DirectedDFS(graph, 0);
        Bag<Integer> pc = new Bag<>();
        for (int v = 0; v < graph.V(); v++) {
            if (dfs.marked(v))
                pc.add(v);
        }

        //compute possible NFA states for txt[i+1]
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '*' || txt.charAt(i) == '|' || txt.charAt(i) == '(' || txt.charAt(i) == ')')
                throw new IllegalArgumentException("text contains the metacharacter '" + txt.charAt(i) + "'");

            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v == m)
                    continue;
                if (regexp.charAt(v) == regexp.charAt(i) || regexp.charAt(v) == '.')
                    match.add(v + 1);
            }
            dfs = new DirectedDFS(graph, match);
            pc = new Bag<>();
            for (int v = 0; v < graph.V(); v++) {
                if (dfs.marked(v))
                    pc.add(v);
            }

            if (pc.size() == 0)
                return false;
        }

        for (int v : pc) {
            if (v == m)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String regexp = "(A**)";
        String txt = "ABABA";
        NFA nfa = new NFA(regexp);
        StdOut.println(nfa.recognizes(txt));
    }
}


