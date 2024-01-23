import java.util.Scanner;
public class NewtonDividedDifferenceInterpolaton {

        private int totalPoint;
        private double[] x;
        private double[][] y;
        Scanner in = new Scanner(System.in);
        public NewtonDividedDifferenceInterpolaton(int totalPoint) {
            this.totalPoint=totalPoint;
            x=new double[totalPoint];
            y=new double[totalPoint][totalPoint];
        }
        public void input(){
            for(int i=0;i<totalPoint;i++){
                x[i]=in.nextDouble();
                y[i][0]=in.nextDouble();
            }
        }
        public double calculateX_X(double xi,int n){
            double mult=1;
            for(int i=0;i<n;i++){
                mult*=(xi-x[i]);
            }
            return mult;

        }
        public String interpolationValue(double xi){
            for(int i=1;i<totalPoint;i++){
                for(int j=0;j<totalPoint-i;j++){
                    y[j][i]=(y[j+1][i-1]-y[j][i-1])/(x[j+i]-x[j]);
                }
            }
            for(int i=0;i<totalPoint;i++){
                System.out.printf(x[i]+"\t");
                for(int j=0;j<totalPoint-i;j++){
                    System.out.printf("%4.5f\t",y[i][j]);
                }
                System.out.println();
            }
            double sum=y[0][0];
            for(int i=1;i<totalPoint;i++){
               sum+=calculateX_X(xi,i)*y[0][i];
            }
            return String.format("%2.6g\t",sum);
        }
}
