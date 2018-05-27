

public class CS401ArrayTest2
{
 public static void main(String[] args) {
 CS401ArrayImpl2<Integer> numbers = new CS401ArrayImpl2<Integer>();
 numbers.add(100); numbers.add(200);
 numbers.add(300); numbers.add(400);
 numbers.add(500); numbers.add(600);
 numbers.add(700); numbers.add(700);
 System.out.println("The total list are");
 print_list(numbers);
 CS401ArrayImpl2<Integer> sub = numbers.subList(1,4);
 System.out.println("the sublist are");
 print_list(sub);
 }
 private static void print_list(CS401ArrayImpl2<Integer> numbers) {
 for (int i = 0; i < numbers.size(); i++)
 {
 System.out.print(numbers.get(i) + " ");
 }
 System.out.println();
 }
}
