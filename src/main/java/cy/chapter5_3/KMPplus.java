package cy.chapter5_3;


import edu.princeton.cs.algs4.StdOut;

public class KMPplus {

    private String pattern;
    private int[] next;

    public KMPplus(String pattern) {
        this.pattern = pattern;
        int m = pattern.length();
        next = new int[m];
        int j = -1;
        for (int i = 0; i < m; i++) {
            if (i == 0)
                next[i] = -1;
            else if (pattern.charAt(i) != pattern.charAt(j))
                next[i] = j;
            else
                next[i] = next[j];

            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
            j++;
        }

        for (int i = 0; i < m; i++) {
            StdOut.println("next[" + i + "] = " + next[i]);
        }
    }

    public int search(String text) {
        int m = pattern.length();
        int n = text.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            while (j >= 0 && text.charAt(i) != pattern.charAt(j))
                j = next[j];
            j++;
        }

        if (j == m)
            return i - m;
        return n;
    }

    public static void main(String[] args) {
        String pat = "ABABAC";
        String txt = "adfsdfsasssadfds";

        KMPplus kmp = new KMPplus(pat);
        int offset1 = kmp.search(txt);

        StdOut.println("text:    " + txt);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset1; i++) {
            StdOut.print(" ");
        }
        StdOut.println(pat);
    }

}
