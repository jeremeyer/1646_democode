package cyclic_linkedlist;

public class CyclicLinkedListMain {
    public static void main(String... args) {
        CyclicLinkedList list = new CyclicLinkedList();

        list.append(new Integer(5));
        list.append(new Integer(0));
        list.prepend(new Integer(3));

        Integer middle = (Integer) list.remove(1);
        System.out.println(middle);
    }
}