import java.util.Scanner;

public class LestSquareMethod {
    private Scanner in=new Scanner(System.in);
    private int totalpoints;
    private double[] x,y;
    private double xb=0,yb=0;
    public LestSquareMethod(int totalpoints ) {
        this.totalpoints=totalpoints;
        x=new double[totalpoints];
        y=new double[totalpoints];
    }
   public void inputs(){
        for(int i=0;i<totalpoints;i++){
            x[i]=in.nextDouble();
            xb+=x[i];
            y[i]=in.nextDouble();
            yb+=y[i];
        }
    }
    public String result(){
        double[] xi=new double[totalpoints];
        double[] xi2=new double[totalpoints];
        double[] yi=new double[totalpoints];
        double[] XY=new double[totalpoints];
        double Sxy=0,Sx2=0;
        xb=xb/totalpoints;
        yb=yb/totalpoints;
        for(int i=0;i<totalpoints;i++){
            xi[i]=xb-x[i];
            yi[i]=yb-y[i];
            XY[i]=xi[i]*yi[i];
            xi2[i]=xi[i]*xi[i];
            Sxy+=XY[i];
            Sx2+=xi2[i];
        }
        double m=Sxy/Sx2;
        double c=yb-m*xb;
        return "y = "+String.format("%.2f",m)+"x + "+String.format("%.2f",c);
    }
    public void draw(){

    }
}
