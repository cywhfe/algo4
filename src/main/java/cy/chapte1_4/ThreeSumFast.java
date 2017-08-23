package cy.chapte1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFast {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 23, -1, -8, 32, 34, 2, -13, -2, -5, -100};
        StdOut.print(count(a));
    }

    private static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (BinarySearch.indexOf(a, -a[i] - a[j]) > j)
                    cnt++;
            }
        }
        return cnt;
    }

}
