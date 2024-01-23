import java.util.Scanner;

public class NewtonForward {
    private int points;
    private double[] x;
    private double[][]y;
    public NewtonForward( int p){
        points=p;
        x=new double[p];
        y=new double[p][p];
    }
    public void inputPoints(){
        Scanner in=new Scanner(System.in);
        for(int i=0;i<points;i++){
            x[i]=in.nextDouble();
            y[i][0]=in.nextDouble();
        }
    }
    public void forwardTable(){
        for(int i=1;i<points;i++){
            for(int j=0;j<points-i;j++){
                y[j][i]=y[j+1][i-1]-y[j][i-1];
            }
        }
    }
    public void printTable(){
        for(int i=0;i<points;i++){
            System.out.printf(x[i]+"\t");
            for(int j=0;j<points-i;j++){
                System.out.printf("%4.5f\t",y[i][j]);
            }
            System.out.println();
        }
    }
    public double getValueForX(double val){
        forwardTable();
        printTable();
        double u=(val-x[0])/(x[1]-x[0]);
        double sum=y[0][0];
        for(int i=1;i<points;i++){
            sum+=(Cal_U(u,i)*y[0][i]/fact(i));
        }
        return sum;
    }
    private double Cal_U(double u,int n){
        double mult=u;
        for(int i=1;i<n;i++){
           mult*=(u-i);
        }
        return mult;
    }
    private double fact(int n){
        double mult=1;
        for(int i=2;i<=n;i++){
            mult*=i;
        }
        return  mult;
    }
}
