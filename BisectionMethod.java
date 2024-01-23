import java.util.Random;

public class BisectionMethod {
    private double a,b,increament,E=0.0001;
    private int iteration=0;
    private boolean ans=true;
    public double function(double x){
        return x*x-1000;
    }
    public String bisection(){
        generateGuessValue();
        if(ans) {
            double x1 = a, x2 = b, x0;
            while (Math.abs(x1 - x2) >= E) {
                x0 = (x1 + x2) / 2;
                if (function(x1) * function(x0) < 0) {
                    x2 = x0;
                } else {
                    x1 = x0;
                }
            }
            return ""+String.format("The Generated interval [%.0f,%.0f]\n", a, b) + "The Root of the given equation :" + String.format("%.5f\n", x1) + "No. of iteration :" + iteration;
        }
        else{
            return "Sorry can't find the root!";
        }
    }
    private void generateGuessValue(){
        increament=1;
        Random random =new Random();
        a=random.nextInt(0,10);
        b=a;
        b+=increament;
        double f1,f2;
        f1=function(a);
        f2=function(b);
        if((f1>0 && f2>f1) || (f1<0 && f2<f1)){
            increament=-increament;
        }
        while(function(a)*function(b)>0){
            iteration++;
            a=b;
            b+=increament;
            if(iteration>1000){
                ans=false;
            }
        }
    }
}
