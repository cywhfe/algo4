package cy.chapter4_1;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;

public class SymbolGraph {

    private ST<String, Integer> st;
    private String[] keys;
    private Graph graph;

    public SymbolGraph(String filename, String delimiter) {
        st = new ST<>();

        In in = new In(filename);
        while (!in.isEmpty()) {//正向序列
            String[] a = in.readLine().split(delimiter);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        StdOut.println("Done reading " + filename);

        keys = new String[st.size()];//反向列表
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        graph = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                graph.addEdge(v, w);
            }
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph graph = sg.graph();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            if (sg.contains(source)) {
                int s = sg.index(source);
                for (int v : graph.adj(s)) {
                    StdOut.println(" " + sg.name(v));
                }
            } else
                StdOut.println("input not contain " + source + "");
        }
    }

    private String name(int v) {
        validateVertex(v);
        return keys[v];
    }

    public String nameOf(int v) {
        validateVertex(v);
        return keys[v];
    }

    private void validateVertex(int v) {
        int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (v - 1));
    }

    private int index(String s) {
        return st.get(s);
    }

    public int indexOf(String s) {
        return st.get(s);
    }

    private boolean contains(String s) {
        return st.contains(s);
    }

    private Graph graph() {
        return graph;
    }

}
