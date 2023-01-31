import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
//        System.out.println(list.indexOf(10));
//        System.out.println(list.indexOf(30));
//        System.out.println(list.indexOf(11));
//        System.out.println(list.contains(40));
//        System.out.println(list.contains(30));

        System.out.println("Reverse");
        list.reverseSoln();
        var arraySoln = list.toArray();
        System.out.println(Arrays.toString(arraySoln));
        list.reverse();
        var ar3 = list.toArray();
        System.out.println(Arrays.toString(ar3));

        System.out.println("Kth Node from End");
        System.out.println(list.kFromEndFirst(5));
        System.out.println(list.kFromEndSecond(6));
        System.out.println(list.kFromEndSoln(2));

        System.out.println("Print Middle");
        list.printMiddle();
        list.addLast(70);
        list.printMiddle();
        list.removeFirst();
        list.printMiddle();
        System.out.println(Arrays.toString(list.toArray()));
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.printMiddle();
    }
}
