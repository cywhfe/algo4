package cy.chapter3_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BST;

import java.util.Iterator;

public class BSTInsert {
    public static void main(String[] args) {
        String s = "EASYQUESTION";
        BST<String, String> bst = new BST<String, String>();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            System.out.println(str);
            bst.put(str, str);
        }

        Iterable<String> it = bst.keys();
        Iterator<String> i = it.iterator();
        while (i.hasNext()){
            StdOut.println(i.next());
        }
    }
}
