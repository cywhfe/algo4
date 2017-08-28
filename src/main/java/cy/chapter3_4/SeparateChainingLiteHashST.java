package cy.chapter3_4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by caoyong on 17/8/27.
 */
public class SeparateChainingLiteHashST<Key, Value> {

    private int n;//number of kv pairs
    private int m;//hash table size
    private Node[] st;//array of linked-list symbol tables

    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

    }

    public SeparateChainingLiteHashST() {
        this(997);
    }

    public SeparateChainingLiteHashST(int m) {
        this.m = m;
        st = new Node[m];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key))
                return (Value) x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        n++;
        st[i] = new Node(key, val, st[i]);
    }

    private void delete(Key key) {
        throw new UnsupportedOperationException("delete no support");
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < m; i++) {
            for (Node x = st[i]; x != null; x = x.next)
                queue.enqueue((Key) x.key);
        }
        return queue;
    }

    public static void main(String[] args) {
        SeparateChainingLiteHashST<String, Integer> st = new SeparateChainingLiteHashST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s :
                st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }

}
