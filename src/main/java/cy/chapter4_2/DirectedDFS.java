package cy.chapter4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 有向图的可达性
 */
public class DirectedDFS {

    private boolean[] marked;
    private int count;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        validateVertices(sources);
        for (int v : sources) {
            if (!marked[v])
                dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    public int getCount() {
        return count;
    }

    private void validateVertices(Iterable<Integer> vertices) {
        if (vertices == null)
            throw new IllegalArgumentException("argument is null");
        int V = marked.length;
        for (int v : vertices) {
            if (v < 0 || v >= V)
                throw new IllegalArgumentException("");
        }

    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (v - 1));
    }

    public static void main(String[] args) {
        // read in digraph from command-line argument
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        Bag<Integer> sources = new Bag<>();
        for (int i = 1; i < args.length; i++) {
            int s = Integer.parseInt(args[i]);
            sources.add(s);
        }

        DirectedDFS dfs = new DirectedDFS(G, sources);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v))
                StdOut.print(v + " ");
        }
        StdOut.println();

    }
}
