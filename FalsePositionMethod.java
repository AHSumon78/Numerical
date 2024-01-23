import java.util.Random;

public class FalsePositionMethod {
    private double a,b,E=0.0001,increament;
    public double f(double x){
        return x*x-1000;
    }
    public String falsePosition(){
        generateGuessValue();
        System.out.println(a+" "+b);
        double x0=0;
        while (Math.abs(b - a) >= E) {
          x0=(a*f(b)-b*f(a))/(f(b)-f(a));
          if(f(x0)==0){
              break;
          }
          if(f(a)*f(x0)<0){
              b=x0;
          }
          else{
              a=x0;
          }
        }
        return String.format("The root of the equation is :%.4f",a);
    }
    private void generateGuessValue(){
        increament=1;
        Random random=new Random();
        a=random.nextInt(0,10);
        b=a;
        b+=increament;
        double f1,f2;
        f1=f(a);
        f2=f(b);
        if((f1>0 && f2>f1) || (f1<0 && f2<f1)){
            increament=-increament;
        }
        while(f(a)*f(b)>0){
            a=b;
            b+=increament;
        }
    }
}
