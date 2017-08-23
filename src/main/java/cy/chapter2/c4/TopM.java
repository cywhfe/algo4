package cy.chapter2.c4;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import edu.princeton.cs.algs4.*;

public class TopM {

    public static void main(String[] args) {
        int M = 10;
        MinPQ<Transaction> pq = new MinPQ<>();
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M) {
                pq.delMin();
            }
        }

        Stack<Transaction> stack = new Stack<>();
        while (!pq.isEmpty())
            stack.push(pq.delMin());
        for (Transaction t : stack) {
            StdOut.println(t);
        }
    }
}
