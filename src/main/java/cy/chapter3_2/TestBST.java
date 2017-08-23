package cy.chapter3_2;

import edu.princeton.cs.algs4.StdOut;

public class TestBST {

    public static void main(String[] args) {
        String test = "S E A R C H E X A M P L E";
        String[] keys = test.split(" ");
        int n = keys.length;
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; i < n; i++)
            st.put(keys[i], i);

        StdOut.println(st.size() + " " + st.min() + " " + st.max());

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }



    }

}
