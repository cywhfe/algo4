package cy.chapte1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFast {


    public static void main(String[] args) {
        int[] a = {-1, 4, 3, 2, 1, 4, 6, 9, -2};
        StdOut.println(count(a));
    }

    private static int count(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (BinarySearch.indexOf(a, -a[i]) > 1)
                cnt++;
        }
        return cnt;
    }

}
