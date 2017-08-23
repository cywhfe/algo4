package cy.chapte1_4;

import edu.princeton.cs.algs4.StdOut;

import static edu.princeton.cs.algs4.DoublingRatio.timeTrial;

public class DoublingRatio {


    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }

}


