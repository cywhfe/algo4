package cy.chapter2.c1;

import edu.princeton.cs.algs4.StdOut;

public class Shell extends CompareTemplateADT {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h, StdOut.printf("compare %s-%s, ", j, j - h)) {
                    StdOut.printf("exchange %s %s", j, j - h);
                    StdOut.println();
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }


    public static void main(String[] args) {
//        String[] a = "S O R T E X A M P L E".split(" ");
        String[] a = "E A S Y S H E L L S O R T Q U E S T I O N".split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }


}
