import java.util.Scanner;

public class leastTest {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Enter total points");

        LestSquareMethod lestSquareMethod = new LestSquareMethod(in.nextInt());
        lestSquareMethod.inputs();
        System.out.println(lestSquareMethod.result());
    }
}
