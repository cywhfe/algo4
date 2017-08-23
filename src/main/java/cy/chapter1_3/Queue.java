package cy.chapter1_3;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
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

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

    public Node reverse(Node x) {
        Node first = x;
        Node reverse = null;

        while (first != null) { //链表数据的互换
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public Node reverseRecursion(Node first) {
        if (first == null)
            return null;
        if (first.next == null)
            return first;

        Node second = first.next;
        Node rest = reverse(second);
        second.next = first;
        first.next = null;//?
        return rest;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    public static void main(String[] args) {
        Queue<String> strings = new Queue<>();
        strings.enqueue("a");
        strings.enqueue("b");
        strings.enqueue("c");

        strings.reverse(strings.first);
    }

    private class QueueIterator implements Iterator<Item> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            Node current = first;
            for (int j = 1; j <= i; j++) {
                current = current.next;
            }
            return current.item;
        }
    }
}
