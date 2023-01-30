import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // LinkedList<Integer> ls = new LinkedList();
        // if we dont specify integer above then each node can have a
        // different type

//        ls.addLast(10);
//        ls.addLast(20);
//        ls.addLast(30);
//        ls.addFirst(5);
//        System.out.println(ls);  // looks like an array but actually a list!
//        System.out.println(ls.contains(10));
//        System.out.println(ls.indexOf(20));
//        System.out.println(ls.size());
//        var array = ls.toArray();
//        System.out.println(array.toString());
        LinkList ll = new LinkList();
        ll.addFirst(5);
        ll.addFirst(30);
        ll.addFirst(2);
        ll.print();

        System.out.println("Deleting first...");
        ll.deleteFirst();
        ll.print();

        System.out.println("contains?");
        System.out.println(ll.contains(5));
        System.out.println(ll.contains(30));

        System.out.println("index of");
        System.out.println(ll.indexOf(5));
        System.out.println(ll.indexOf(30));

        System.out.println("add last");
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(35);
        ll.print();

        System.out.println();
        ll.addFirst(8);
        ll.addFirst(0);
        ll.addFirst(3);
        ll.print();
    }
}
