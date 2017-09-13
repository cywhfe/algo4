package cy.chapter4_1;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

public class BaconHistogram {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        String source = args[2];

        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.graph();
        if (!sg.contains(source)) {
            StdOut.println(source + " not in");
            return;
        }

        int s = sg.indexOf(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        int MAX_BACON = 100;
        int[] hist = new int[MAX_BACON + 1];
        for (int v = 0; v < G.V(); v++) {
            int bacon = Math.min(MAX_BACON, bfs.distTo(v));
            hist[bacon]++;

            if (bacon / 2 >= 7 && bacon < MAX_BACON)
                StdOut.printf("%d %s\n", bacon/2, sg.nameOf(v));
        }

        for (int i = 0; i < MAX_BACON; i++) {
            if (hist[i] == 0)
                break;
            StdOut.printf("%3d %8d\n", i/2, hist[i]);
        }
        StdOut.printf("Inf %8d\n", hist[MAX_BACON]);

    }

}
