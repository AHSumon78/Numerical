import java.util.Scanner;

public class GoussJordan {
    int n;
    double[][] matrix;
    char[] X;
    int[] C;
    double[] d;
    public GoussJordan(int n){
             this.n=n;
             matrix= new double[n][n+1];
            X=new char[n];
            C=new int[n];
            d=new double[n];
                input();
     }
         public void input(){
        System.out.println("Enter the first matrix:");
        Scanner in = new Scanner(System.in);
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
                  matrix[i][j]=in.nextInt();
           }
        }
        System.out.println("Enter the second matrix for varible:");
           for(int i=0;i<n;i++){
                 X[i]=in.next().charAt(0);
           }
        System.out.println("Enter the constant matrix:");
        for(int i=0;i<n;i++){
                C[i]=in.nextInt();
               matrix[i][n]=C[i];
        }
        in.close();
        System.out.println(cal());
    }
    public String cal(){
          for(int j=0; j<n; j++) {
            for(int i=0; i<n; i++) {
               if(i!=j) {
                 double b=matrix[i][j]/matrix[j][j];
                  for(int k=0; k<n+1; k++) { 
                     matrix[i][k]= matrix[i][k]-b*matrix[j][k];
                  }
               }
               
            }
        }
        String ans="";
        for(int i=0; i<n; i++) {
            d[i]=matrix[i][n]/matrix[i][i];
            ans+=(X[i] + "="+d[i]+"\n");
         }
  return ans;
    
  }
}
