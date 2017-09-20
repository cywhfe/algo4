package cy.chapter5_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * BM算法， 最简单的实现，
 * 分为两种，此为坏字符规则，另有好后缀规则实现
 */
public class BoyerMoore {

    private final int R;
    private int[] right;//bad-character skip array

    private char[] pattern;//store the pattern as a character array
    private String pat;// or as string

    public BoyerMoore(String apt) {
        this.R = 256;
        this.pat = apt;

        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < pat.length(); j++) {
            right[pat.charAt(j)] = j;
        }
    }

    public BoyerMoore(char[] pattern, int R) {
        this.R = R;
        this.pattern = new char[pattern.length];
        for (int j = 0; j < pattern.length; j++) {
            this.pattern[j] = pattern[j];
        }

        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < pattern.length; j++) {
            right[pattern[j]] = j;
        }
    }

    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        int skip;
        for (int i = 0; i < n - m; i += skip) {//n-m结束
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {//m-1, pattern长度-1位开始计数
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = Math.max(1, j - right[txt.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0)
                return i;//found
        }
        return n;
    }

    public int search(char[] text) {
        int m = pattern.length;
        int n = text.length;
        int skip;
        for (int i = 0; i < n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pattern[j] != text[i + j]) {
                    skip = Math.max(1, j - right[text[i + j]]);
                    break;
                }
            }
            if (skip == 0)
                return i;//found
        }
        return n;//not found
    }

    public static void main(String[] args) {
        String pat = "NEEDLE";
        String txt = "FINDINAHAYSTACKNEEDLEINA";
        char[] pattern = pat.toCharArray();
        char[] text = txt.toCharArray();

        BoyerMoore boyerMoore1 = new BoyerMoore(pat);
        int offset1 = boyerMoore1.search(txt);

        // print results
        StdOut.println("text:    " + txt);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset1; i++) {
            StdOut.print(" ");
        }
        StdOut.println(pat);


    }

}
