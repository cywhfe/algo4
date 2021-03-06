package cy.chapter5_5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.TST;

public class LZW {

    private static final int R = 256;//number of input chars
    public static final int L = 4086;//number of codewords = 2^w
    public static final int W = 12; //codeword width

    private LZW() {
    }

    public static void compress() {
        String input = BinaryStdIn.readString();
        TST<Integer> st = new TST<>();
        for (int i = 0; i < R; i++) {
            st.put("" + (char) i, i);
        }
        int code = R + 1;//R is codeword for EOF

        while (input.length() > 0) {
            String s = st.longestPrefixOf(input);
            BinaryStdOut.write(st.get(s), W);
            int t = s.length();
            if (t < input.length() && code < L)
                st.put(input.substring(0, t + 1), code++);
            input = input.substring(t);
        }
        BinaryStdOut.write(R, W);
        BinaryStdOut.close();
    }

    public static void expand() {
        String[] st = new String[L];
        int i;

        for (i = 0; i < R; i++) {
            st[i] = "" + (char) i;
        }
        st[i++] = "";

        int codeword = BinaryStdIn.readInt(W);
        if (codeword == R)
            return;
        String val = st[codeword];

        while (true) {
            BinaryStdOut.write(val);
            codeword = BinaryStdIn.readInt(W);
            if (codeword == R)
                break;
            String s = st[codeword];
            if (i == codeword)
                s = val + val.charAt(0);
            if (i < L)
                st[i++] = val + s.charAt(0);
            val = s;
        }

        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if (args[0].equals("-"))
            compress();
        else if (args[0].equals("+"))
            expand();
        else
            throw new IllegalArgumentException("");
    }
}
