package cy.chapter3_1;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {

    public static void main(String[] args) {
        int minlen = 1;
        ST<String, Integer> st = new ST<>();
        while (!st.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlen)
                st.put(word, 1);
            else
                st.put(word, st.get(word) + 1);
        }

        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }
        StdOut.print(max + " " + st.get(max));
    }

}
