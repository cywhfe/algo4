package cy.chapter5_1;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Count {

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet("ABCDE");

        int R = alphabet.radix();
        int[] count = new int[R];
        while (StdIn.hasNextChar()) {
            char c = StdIn.readChar();
            if (alphabet.contains(c))
                count[alphabet.toIndex(c)]++;
        }
        for (int c = 0; c < R; c++) {
            StdOut.println(alphabet.toChar(c)+ " " + count[c]);
        }
    }
}
