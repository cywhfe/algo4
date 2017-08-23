package cy.chapter1_3;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] a = (T[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(T t) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = t;
    }

    public T pop() {
        T t = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;//FILO

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        stack.push("aaa");
        System.out.println(stack.size());
        stack.push("bb");
        System.out.println(stack.size());
        stack.push("ccc");
        System.out.println(stack.size());
        stack.push("ddd");
        System.out.println(stack.size());
        stack.push("eee");
        System.out.println(stack.size());
        stack.push("fff");
        System.out.println(stack.size());
    }


}



