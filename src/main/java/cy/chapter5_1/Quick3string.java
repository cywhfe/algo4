package cy.chapter5_1;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3string {

    public static final int CUTOFF = 15;

    public static void sort(String[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1, 0);
        assert isSorted(a);
    }

    private static boolean isSorted(String[] a) {
        return false;
    }

    private static void sort(String[] a, int lo, int hi, int d) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if      (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else              i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt-1, d);
        if (v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, hi, d);
    }

    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // return the dth character of s, -1 if d = length of s
    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }


    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(String v, String w, int d) {
        assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i))
                return true;
            if (v.charAt(i) > w.charAt(i))
                return false;
        }
        return v.length() < w.length();
    }

    public static void main(String[] args) {
        // read in the strings from standard input
        String[] a = StdIn.readAllStrings();
        int n = a.length;

        // sort the strings
        sort(a);

        // print the results
        for (int i = 0; i < n; i++)
            StdOut.println(a[i]);
    }

}
