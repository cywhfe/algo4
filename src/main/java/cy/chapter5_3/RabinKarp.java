package cy.chapter5_3;

import edu.princeton.cs.algs4.StdOut;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {

    private String pat;//the pattern
    private long patHash;//pattern hash value
    private int m;//pattern length
    private long q;//a lgarge prime
    private int R;//radix
    private long RM;//R^(M-1)%Q

    public RabinKarp(char[] pattern, int r) {
        this.pat = String.valueOf(pattern);
        this.R = r;
        throw new UnsupportedOperationException("op not supported yet");
    }

    public RabinKarp(String pat) {
        this.pat = pat;
        R = 256;
        m = pat.length();
        q = longRandomPrime();

        RM = 1;
        for (int i = 1; i < m - 1; i++) {
            RM = (R * RM) % q;
        }
        patHash = hash(pat, m);
    }

    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++) {
            h = (R * h + key.charAt(j)) % q;
        }
        return h;
    }

    private boolean check(String txt, int i) {
        for (int j = 0; j < m; j++) {
            if (pat.charAt(j) != txt.charAt(j + j))
                return false;
        }
        return true;
    }

    public int search(String txt) {
        int n = txt.length();
        if (n < m)
            return n;

        long txtHash = hash(txt, m);
        if (patHash == txtHash && check(txt, 0))
            return 0;

        for (int i = m; i < n; i++) {
            //remove leading digit, add trailing digit, check for match;
            txtHash = (txtHash + q - RM * txt.charAt(i - m) % q) % q;
            txtHash = (txtHash * R + txt.charAt(i)) % q;

            //match
            int offset = i - m + 1;
            if (patHash == txtHash && check(txt, offset)) {
                return offset;
            }
        }

        //no match
        return n;
    }

    private long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) {
        String pat = "dds";
        String txt = "abcdadfddsdsa";

        RabinKarp searcher = new RabinKarp(pat);
        int offset = searcher.search(txt);

        StdOut.println("text:    " + txt);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            StdOut.print(" ");
        }
        StdOut.println(pat);

    }
}
