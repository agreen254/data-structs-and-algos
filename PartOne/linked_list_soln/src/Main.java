import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
//        System.out.println(list.indexOf(10));
//        System.out.println(list.indexOf(30));
//        System.out.println(list.indexOf(11));
//        System.out.println(list.contains(40));
//        System.out.println(list.contains(30));
        System.out.println(list.size());

        System.out.println("reversal");
        list.reverse();
        var array = list.toArray();
        System.out.println(Arrays.toString(array));
    }
}
