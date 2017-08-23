package cy.chapter1_5;

import com.sun.xml.internal.bind.v2.model.core.ID;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class UF {

    protected int[] id;//分量id
    protected int count;//分量数量

    public UF(int N) {
        this.count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++) {//每次都要替换到所有的值
            if (id[i] == pID)
                id[i] = qID;
        }

        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
            String s = StdIn.readString();
            int p = Integer.valueOf(s.split("-")[0]);
            int q = Integer.valueOf(s.split("-")[1]);
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
    }

    public void display() {
        for (int i = 0; i < id.length; i++) {
            StdOut.println(i + "--" + id[i]);
        }
    }

    public void draw() {
        StdDraw.setXscale(-1, id.length + 2);
        StdDraw.setYscale(-1, id.length + 2);
        StdDraw.setPenRadius(0.07);

        for (int i = 0; i < id.length; i++) {
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.point(i, id[i]);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.text(i, id[i], Integer.toString(i) + "--" + Integer.toString(id[i]));
        }


    }

}
