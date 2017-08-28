package cy.chapter3_5;

import edu.princeton.cs.algs4.SparseVector;
import edu.princeton.cs.algs4.StdOut;

public class SparseMatrix {

    private int n;
    private SparseVector[] rows;

    public SparseMatrix(int n) {
        this.n = n;
        rows = new SparseVector[n];
        for (int i = 0; i < n; i++) {
            rows[i] = new SparseVector(n);
        }
    }

    //put A[i][j] = value
    public void put(int i, int j, double value) {
        if (i < 0 || i >= n)
            throw new IllegalArgumentException("");
        if (j < 0 || j >= n)
            throw new IllegalArgumentException("");
        rows[i].put(j, value);
    }

    //return A[i][j]
    public double get(int i, int j) {
        if (i < 0 || i >= n)
            throw new IllegalArgumentException("");
        if (j < 0 || j >= n)
            throw new IllegalArgumentException("");
        return rows[i].get(j);
    }

    public int nnz() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += rows[i].nnz();
        }
        return sum;
    }

    public SparseVector times(SparseVector x) {
        if (n != x.size()) throw new IllegalArgumentException("Dimensions disagree");

        SparseVector b = new SparseVector(n);
        for (int i = 0; i < n; i++) {
            b.put(i, rows[i].dot(x));
        }
        return b;
    }

    public SparseMatrix plus(SparseMatrix that) {
        if (this.n != that.n)
            throw new RuntimeException("");

        SparseMatrix result = new SparseMatrix(n);
        for (int i = 0; i < n; i++) {
            result.rows[i] = this.rows[i].plus(that.rows[i]);
        }
        return result;
    }

    // return a string representation
    public String toString() {
        String s = "n = " + n + ", nonzeros = " + nnz() + "\n";
        for (int i = 0; i < n; i++) {
            s += i + ": " + rows[i] + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        SparseMatrix A = new SparseMatrix(5);
        SparseVector x = new SparseVector(5);
        A.put(0, 0, 1);
        A.put(1, 1, 1);
        A.put(2, 2, 1);
        A.put(3, 3, 1);
        A.put(4, 4, 1);
        A.put(2, 4, 0.3);
        x.put(0, 0.75);
        x.put(2, 0.11);

        StdOut.println("x " + x);
        StdOut.println("A " + A);
        StdOut.println("Ax" + A.times(x));
        StdOut.println("A+A" + A.plus(A));

    }
}
