package cy.chapter2.c1;

import edu.princeton.cs.algs4.In;

public class Selection extends CompareTemplateADT {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = "S O R T E X A M P L E".split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
