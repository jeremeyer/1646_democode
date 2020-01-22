package cyclic_linkedlist;

//I(Sam) just decided to keep it in a single file with the main at the top
public class NullLinkedList{

    class Node{
        Node next;
        int data;
    }

    Node head;
    Node tail;
    int size = 0;

    public void prepend(int a){
        Node new_node = new Node();
        new_node.data = a;

        if(head==null){
            head = new_node;
            tail = new_node;
        }else{
            new_node.next = head;
            head = new_node;
        }
        size++;
    }

    public void append(int a){
        Node new_node = new Node();
        new_node.data = a;

        if(head==null){
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
        size++;
    }

    public int deleteFirst(){
        if (head==null){
            throw new IndexOutOfBoundsException();
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public int deleteNthNode(int n){
        if(n>=size){
            throw new IndexOutOfBoundsException();
        }
        Node traveler = head;
        for(int i=0; i<n-1; i++){
            traveler = traveler.next;
        }
        int value = traveler.next.data;
        traveler.next = traveler.next.next;
        size--;
        return value;
    }
}