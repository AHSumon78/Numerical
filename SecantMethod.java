import java.util.Random;

public class SecantMethod {
    private double a,b,E=0.0001;
    public double f(double x){
        return x*x-10;
    }
    public String secant(){
        generateGuessValue();
        double c=0,d;
        d=Math.min(a,b);
        b=Math.max(a,b);
        a=d;
        System.out.println(a+" "+b);

            while(Math.abs(a-b)>=E) {
                c = b - f(b) * ((b - a) / (f(b) - f(a)));
                a = b;
                b = c;
                System.out.println(a+" "+b);
            }
        return ""+c;
    }
     public  void generateGuessValue(){
        double increament=1;
         Random random = new Random();
         a= random.nextInt(0,10);
         b+=increament;
         double f1,f2;
         f1=f(a);
         f2=f(b);
         if((f1>0 && f1<f2) || (f1<0 && f1>f2)){
             increament=-increament;
         }
         while(f(a)*f(b)>0){
             a=b;
             b+=increament;
         }
     }
}
