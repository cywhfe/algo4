package cy.chapter4_4;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import javafx.scene.input.KeyCode;

import static javafx.scene.input.KeyCode.G;

public class CPM {

    private CPM() {
    }

    public static void main(String[] args) {

        int n = StdIn.readInt();
        StdIn.readLine();

        int s = 2 * n;
        int t = 2 * n + 1;

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2 * n + 2);
        for (int i = 0; i < n; i++) {
            String[] a = StdIn.readLine().split("\\s+");

            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(i, i + n, duration));
            G.addEdge(new DirectedEdge(s, i, 0));
            G.addEdge(new DirectedEdge(i + n, t, 0));

//            int m = StdIn.readInt();
            for (int j = 1; j < a.length; j++) {
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(n + i, successor, 0));
            }
        }

        AcyclicLP lp = new AcyclicLP(G, s);

        // print results
        StdOut.println(" job   start  finish");
        StdOut.println("--------------------");
        for (int i = 0; i < n; i++) {
            StdOut.printf("%4d %7.1f %7.1f\n", i, lp.distTo(i), lp.distTo(i+n));
        }
        StdOut.printf("Finish time: %7.1f\n", lp.distTo(t));
    }
}
