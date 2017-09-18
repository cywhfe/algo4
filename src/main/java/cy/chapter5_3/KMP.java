package cy.chapter5_3;

import edu.princeton.cs.algs4.StdOut;

public class KMP {

    private final int R;
    private int[][] dfa;

    private char[] pattern;
    private String pat;

    public KMP(String pat) {
        this.R = 256;
        this.pat = pat;

        //build DFA from pattern
        int m = pat.length();
        dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            x = dfa[pat.charAt(j)][x];
        }
    }

    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        int i, j;

        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[txt.charAt(i)][j];
        }

        if (j == m)
            return i - m;
        return n;
    }

    public static void main(String[] args) {
        String pat = "sss";
        String txt = "adfsdfsasssadfds";

        KMP kmp = new KMP(pat);
        int offset1 = kmp.search(txt);

        StdOut.println("text:    " + txt);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset1; i++) {
            StdOut.print(" ");
        }
        StdOut.println(pat);


    }

}
