package cyclic_linkedlist;

public class CyclicLinkedList {
    class Node {
        Node next;
        Node prev;
        boolean isSentinel = false;
        Object data;
    }

    private Node sentinel;
    private int size;

    public CyclicLinkedList() {
        sentinel = new Node();
        sentinel.isSentinel = true;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void prepend(Object data) {
        Node new_node = new Node();
        new_node.data = data;
        Node next = sentinel.next;
        Node prev = sentinel;

        next.prev = new_node;
        new_node.next = next;
        prev.next = new_node;
        new_node.prev = prev;

        size++;
    }

    public void append(Object data) {
        Node new_node = new Node();
        new_node.data = data;
        Node next = sentinel;
        Node prev = sentinel.prev;

        next.prev = new_node;
        new_node.next = next;
        prev.next = new_node;
        new_node.prev = prev;

        size++;
    }

    public boolean insert(Object data, int index) {
        if (index > size) {
            return false;
        }
        Node traveler = sentinel;
        for (int i = 0; i < index; i++) {
            traveler = traveler.next;
        }
        Node next = traveler.next;
        Node prev = traveler;
        Node new_node = new Node();
        new_node.data = data;

        next.prev = new_node;
        new_node.next = next;
        prev.next = new_node;
        new_node.prev = prev;
        return true;
    }

    public Object get(int index) {
        if (index >= size) {
            return null;
        }
        Node traveler = sentinel.next;
        for (int i = 0; i < index; i++) {
            traveler = traveler.next;
        }
        return traveler.data;
    }

    public Object remove(int index) {
        if (index >= size) {
            return null;
        }
        Node traveler = sentinel.next;
        for (int i = 0; i < index; i++) {
            traveler = traveler.next;
        }
        Node next = traveler.next;
        Node prev = traveler.prev;
        prev.next = next;
        next.prev = prev;
        return traveler.data;
    }
}