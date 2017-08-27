package cy.chapter3_4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by caoyong on 17/8/27.
 */
public class SeparateChainingHashST<Key, Value> {

    private static final int INIT_CAPACITY = 4;

    private int n;
    private int m;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>();
        for (int i = 0; i < m; i++) {
            for (Key key :
                    st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }

        this.m = temp.m;
        this.n = temp.n;
        this.st = temp.st;

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
        if (key == null)
            throw new IllegalArgumentException("argument");
        return get(key) != null;
    }

    private Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument error");
        int i = hash(key);
        return st[i].get(key);
    }

    private void put(Key key, Value value) {
        if (key == null)
            throw new IllegalArgumentException("first is null");
        if (value == null) {
            delete(key);
            return;
        }

        if (n >= 10 * m)
            resize(2 * m);

        int i = hash(key);
        if (!st[i].contains(key))
            n++;
        st[i].put(key, value);
    }

    private void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument error");

        int i = hash(key);
        if (st[i].contains(key))
            n--;
        st[i].delete(key);

        if (m > INIT_CAPACITY && n <= 2 * m)
            resize(m / 2);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < m; i++) {
            for (Key key :
                    st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
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
