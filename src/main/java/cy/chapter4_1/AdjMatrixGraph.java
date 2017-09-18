package cy.chapter4_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjMatrixGraph {

    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;
    private int E;
    private boolean[][] adj;

    public AdjMatrixGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }

    public AdjMatrixGraph(int V, int E) {
        this(V);
        if (E < 0)
            throw new RuntimeException("");
        if (E > V * (V - 1) + V)
            throw new RuntimeException("");

        while (this.E != E) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void addEdge(int v, int w) {
        if (!adj[v][w])
            E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }

    public boolean contains(int v, int w) {
        return adj[v][w];
    }

    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }

    private class AdjIterator implements Iterable<Integer>, Iterator<Integer> {
        private int v;
        private int w = 0;

        public AdjIterator(int v) {
            this.v = v;
        }

        @Override
        public Iterator<Integer> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w])
                    return true;
                w++;
            }
            return false;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("");
            }
            return w++;
        }

        public void remove() {
            throw new UnsupportedOperationException("");
        }

        // string representation of Graph - takes quadratic time
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(V + " " + E + NEWLINE);
            for (int v = 0; v < V; v++) {
                s.append(v + ": ");
                for (int w : adj(v)) {
                    s.append(w + " ");
                }
                s.append(NEWLINE);
            }
            return s.toString();
        }

    }

    public static void main(String[] args) {
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        AdjMatrixGraph G = new AdjMatrixGraph(V, E);
        StdOut.println(G);
    }
}
