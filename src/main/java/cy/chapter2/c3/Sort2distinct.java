package cy.chapter2.c3;

import edu.princeton.cs.algs4.StdOut;

public class Sort2distinct {

    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length - 1;
        int i = 0;
        while (i <= gt) {
            int cmp = a[i].compareTo(a[lt]);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        String s = "abcdlkwjer";
        int n = s.length();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.substring(i, i + 1);
        }

        sort(a);
        for (int i = 0; i < n; i++) {
            StdOut.print(a[i]);
        }
        StdOut.println();
    }
}
