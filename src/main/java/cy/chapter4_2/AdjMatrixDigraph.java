package cy.chapter4_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjMatrixDigraph {

    private int V;
    private int E;
    private boolean[][] adj;

    public AdjMatrixDigraph(int V) {
        if (V < 0)
            throw new RuntimeException("Number of vertices must be bigger than 0");
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }

    public AdjMatrixDigraph(int v, int e) {
        this(v);
        if (e < 0)
            throw new RuntimeException("edges smaller than 0");
        if (e > v * v)
            throw new RuntimeException("too many edges");

        while (this.E != e) {
            int V = StdRandom.uniform(v);
            int W = StdRandom.uniform(v);
            addEdge(V, W);
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
    }

    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }

    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
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
            if (hasNext())
                return w++;
            else
                throw new NoSuchElementException();
        }
    }

    @Override
    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
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

    public static void main(String[] args) {
        int V = 10;
        int E = 22;
        AdjMatrixDigraph G = new AdjMatrixDigraph(V, E);
        StdOut.println(G);
    }
}
