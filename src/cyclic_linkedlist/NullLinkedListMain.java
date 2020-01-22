package cyclic_linkedlist;

public class NullLinkedListMain{
    public static void main(String... args) {
        NullLinkedList list = new NullLinkedList();
        
        //The order will be 12,4,1,2,6
        list.append(new Integer(2));
        list.append(new Integer(6));
        list.prepend(new Integer(1));
        list.prepend(new Integer(4));
        list.prepend(new Integer(12));

        System.out.print(list.deleteNthNode(0));        
    }
}