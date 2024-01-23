public class NewtonRaphsonMethod {
    public double f(double x){
        return x*x*x-2*x-5;
    }
    public double df(double x){
        return 3*x*x-2;
    }
    public String NewtonRaphson(double a,double b,double E){
        double x1,x0=(a+b)/2;
        double x2=x0;
               x1=x0-f(x0)/df(x0);
               while(Math.abs(x1-x0)>=E) {
                   x0 = x1;
                   x2 = x1 - f(x1) / df(x1);
                   x1 = x2;
               }
            return String.format("The root of the equation is :%.6f",x1);
    }
}
