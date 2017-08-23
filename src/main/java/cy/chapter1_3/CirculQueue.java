package cy.chapter1_3;

public class CirculQueue<Item> {

    private Node last;
    private int n;

    private class Node {
        private Item item;
        Node next;
    }

    public boolean isEmpty() {
        return last.next == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        /*Node node = new Node();
        node.item = item;
        item = last.item;
        node = last.next;
        n++;*/

        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        oldlast.next = last;
        n++;

    }

    public Item dequeue() {
        Item item = last.item;
        last = last.next;
        n--;
        return item;
    }

}
