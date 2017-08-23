package cy.chapter1_3;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        return first.item;
    }

    public Stack<String> copy(Stack<String> stack) {
        Stack<String> newStack = new Stack<>();
        if (stack.size() > 0) {
            newStack = stack;
        }

        while (iterator().hasNext()) {
            newStack.push((String) iterator().next());
        }
        return newStack;
    }

    public void delTail() {
        if (size() == 0)
            throw new NoSuchElementException("not need del");
        if (size() == 1) {
            first = null;
            N = 0;
            return;
        }

        //删除尾元素
        Node current = first;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = current.next.next;
        N--;
    }

    public void del(int k) {
        if (N < k - 1) {
            throw new NoSuchElementException("not need del");
        }
        if (k - 2 < 0) {
            first = first.next;
            N--;
            return;
        }
        Node current = first;
        for (int i = 0; i < N; i++) {
            if (i == k - 2) {
                current.next = current.next.next;
                N--;
            }
            current = current.next;
        }
    }

    //it迭代，查找比对值
    public Item find(Stack<Item> stack, String key) {
        return null;
    }

    public void removeAfter(Stack stack) {
        for (int i = 0; i < stack.size(); i++) {
            Node current = stack.first;
            current = current.next;

            if (i == stack.size() - 2) {
                current.next = current.next.next;
            }
        }
    }

    //创建一个新stack，把两个push过去
    public void insertAfter(Stack stack, Stack stack2) {

    }

    public void remove(Stack item, String key) {
        for (int i = 0; i < item.size(); i++) {
            Node current = item.first;
            if (current.next.item.equals(key)) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public int max(Node first) {
        int max = 0;
        if (first.next == null) {
            Integer val = Integer.valueOf(first.item.toString());
            if (val > max) {
                max = val;
            }
        } else {
            int val = max(first.next);
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        strings.push("aaa");
        strings.push("bbb");
        strings.push("ccc");
//        strings.delTail();
        System.out.println(strings);
        strings.del(1);
        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Stack<Integer> ints = new Stack<>();
        ints.push(100);
        ints.push(10);
        ints.push(00);

        System.out.println(ints.max(ints.first));
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
