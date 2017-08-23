package cy.chapte1_4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {

    public static void main(String[] args) {
        StdDraw.setXscale(0, 100000);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(.01);

        for (int N = 250; true; N += N) {
            double time = timeTrail(N);
            StdOut.printf("%7d %5.1f\n", N, time);

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(N, time);
        }
    }

    private static double timeTrail(int n) {
        int MAX = 1000000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }

        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
}
