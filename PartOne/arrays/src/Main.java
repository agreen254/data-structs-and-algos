import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        int[] numbers = new int[3];
//        System.out.println(Arrays.toString(numbers));
//        numbers[0] = 10;
//        numbers[1] = 20;
//        numbers[2] = 30;
//
//        int[] nums_init = { 10, 20, 30, 40, 50 };
//        System.out.println(numbers.length);
//        System.out.println(Arrays.toString(nums_init));
//        System.out.println(nums_init.length);

        Array numbers = new Array(1);
        numbers.insert(5);
        numbers.insert(2);
        numbers.insert(3);
        numbers.insert(1);
        numbers.insert(2);
        numbers.removeAt(3);
        numbers.removeAt(2);
        numbers.removeAtMosh(2);

        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(15);
        al.add(12);
        System.out.println(al);
        al.remove(0);
        System.out.println(al);
        al.indexOf(20);
        al.lastIndexOf(12);
        al.contains(8);
        al.size();
        al.toArray();

        Array its = new Array(1);
        its.insert(1);
        its.insert(10);
        its.insert(12);
        its.insert(18);
        its.insert(24);

        int[] other = { 3, 5, 7, 18, 9, 10};
        int[] result = its.intersect(other);
        System.out.println(Arrays.toString(result));

        Array reversed = its.reverse();
        reversed.print();
        reversed.insertAt(1, 5);
        reversed.print();
    }
}
