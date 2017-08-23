package cy.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionPathCompressionUF extends UF {
    public QuickUnionPathCompressionUF(int N) {
        super(N);
    }

    public int find(int p) {
        int root = p;
        while (root != id[root])
            root = id[root];

        while (p != root) {//相当于是一次找到根节点,这样当一棵树的所有非根节点都被链接到根节点后，find操作就可以直接通过判断是否有公共根节点判断是否连通。
            int newp = id[p];
            id[p] = root;
            p = newp;
        }

        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        id[rootP] = rootQ;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new QuickUnionPathCompressionUF(N);
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
        uf.display();
        uf.draw();
    }
}
