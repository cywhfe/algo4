package cy.chapter3;

import edu.princeton.cs.algs4.ST;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    public static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    public ArrayST() {
        this(INIT_CAPACITY);
    }

    public ArrayST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public void put(Key key, Value val) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].compareTo(key) == 0) {
                vals[i] = val;
            }
            keys[n] = key;
            vals[n] = val;
            n++;
        }
    }

    public Value get(Key key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].compareTo(key) == 0)
                return vals[i];
        }
        return null;
    }

    public void delete(Key key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].compareTo(key) == 0) {
                keys[i] = null;
                vals[i] = null;

                if (i < n) {
                    keys[i] = keys[i + 1];
                    vals[i] = vals[i + 1];
                    n--;
                }
            }
        }
    }


    public boolean contains(Key key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].compareTo(key) == 0)
                return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }
}

