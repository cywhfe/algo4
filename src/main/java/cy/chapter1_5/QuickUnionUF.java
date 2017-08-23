package cy.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF extends UF {
    public QuickUnionUF(int N) {
        super(N);
    }

    public int find(int p) {//让值与索引必须一致，返回对应的根节点
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {//右节点的根赋值给左根节点
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        id[pRoot] = qRoot;

        count--;
    }

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(10);
        while (!StdIn.isEmpty()) {
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
        uf.display();
        uf.draw();
    }
}
