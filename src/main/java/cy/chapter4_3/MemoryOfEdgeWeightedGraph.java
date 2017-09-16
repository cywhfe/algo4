package cy.chapter4_3;

import com.javamex.classmexer.MemoryUtil;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MemoryOfEdgeWeightedGraph {

    public static void main(String[] args) {
        Edge e = new Edge(123456, 654321, 1.0);
        StdOut.println("size of edge = " + MemoryUtil.memoryUsageOf(e) + " bytes");

        int n = 40;
        int[] V = new int[n];
        int[] E = new int[n];

        long[] memory = new long[n];
        for (int i = 0; i < n; i++) {
            V[i] = 2 * StdRandom.uniform(500);
            E[i] = V[i] * StdRandom.uniform(10);
            EdgeWeightedGraph G = new EdgeWeightedGraph(V[i]);
            for (int j = 0; j < E[i]; j++) {
                int v = StdRandom.uniform(V[i]);
                int w = StdRandom.uniform(V[i]);
                double weight = StdRandom.uniform(0.0, 1.0);
                G.addEdge(new Edge(v, w, weight));
            }
            memory[i] = MemoryUtil.deepMemoryUsageOf(G);
        }

        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = memory[i];
        }

        double[][] x = new double[n][3];
        for (int i = 0; i < n; i++) {
            x[i][0] = 1.0;
            x[i][1] = V[i];
            x[i][2] = E[i];
        }

    }

}
