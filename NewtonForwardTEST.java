import java.util.Scanner;

public class NewtonForwardTEST {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n;
        n=in.nextInt();
        NewtonForward newtonForward=new NewtonForward(n);
        newtonForward.inputPoints();
        System.out.println("Now enter x");
        double x;
        x=in.nextDouble();
        System.out.println(newtonForward.getValueForX(x));
    }
}
