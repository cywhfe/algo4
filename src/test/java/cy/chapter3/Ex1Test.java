package cy.chapter3;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class Ex1Test {

    @Test
    public void ex1() throws Exception {
        ST<String, Double> gradeMaps = new ST<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            if (gradeMaps.contains(s)) {
                StdOut.println(gradeMaps.get(s));
            }
        }
    }

    @Test
    public void ex2() throws Exception {


    }
}
