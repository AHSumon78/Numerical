import java.util.Scanner;

public class LagrangesInterpolation {
    private int totalPoint;
    private double[] x;
    private double[] y;
    Scanner in = new Scanner(System.in);
    public LagrangesInterpolation(int totalPoint) {
        this.totalPoint=totalPoint;
       x=new double[totalPoint];
       y=new double[totalPoint];
    }
    public void input(){
        for(int i=0;i<totalPoint;i++){
           x[i]=in.nextDouble();
           y[i]=in.nextDouble();
        }
    }
    public double calculateX_X(double xi,int n){
        double multL=1;
        double multH=1;
        for(int i=0;i<totalPoint;i++){
            if(i!=n) {
                multH *= (x[n] - x[i]);
            }
        }
        for(int i=0;i<totalPoint;i++){
            if(i!=n)
                multL*=(xi-x[i]);
        }
       return (multL/multH)*y[n];

    }
    public String interpolationValue(double xi){
        double sum=0;
         for(int i=0;i<totalPoint;i++){
             sum+=calculateX_X(xi,i);
         }
         return String.format("%2.6g\t",sum);
    }
}
