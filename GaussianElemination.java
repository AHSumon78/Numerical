import java.util.Scanner;

class GaussianElemination{
    int unknown;
    int[][] A;
    char[] X;
    int[] C;
    int[] d;
    public GaussianElemination(int unknown){
             this.unknown=unknown;
             A= new int[unknown][unknown];
            X=new char[unknown];
            C=new int[unknown];
            d=new int[unknown];
                input();
     }
    public void input(){
        System.out.println("Enter the first matrix:");
        Scanner in = new Scanner(System.in);
        for(int i=0;i<unknown;i++){
           for(int j=0;j<unknown;j++){
                  A[i][j]=in.nextInt();
           }
        }
        System.out.println("Enter the second matrix for varible:");
           for(int i=0;i<unknown;i++){
                 X[i]=in.next().charAt(0);
           }
        System.out.println("Enter the constant matrix:");
        for(int i=0;i<unknown;i++){
                C[i]=in.nextInt();
        }
        in.close();
        System.out.println(cal());
    }
    private String cal(){
        for(int i=0;i<unknown-1;i++){
            for(int j=i+1;j<unknown;j++){
                int m=A[j][i]/A[i][i];
                for(int k=i+1;k<unknown;k++){
                    A[j][k]=A[j][k]-m*A[i][k];
                }
                C[j]=C[j]-m*C[i];
            }
        }
        d[unknown-1]=C[unknown-1]/A[unknown-1][unknown-1];
        for(int i=unknown-2;i>=0;i--){
            int sum=0;
            for(int j=i+1;j<unknown;j++){
                sum+=A[i][j]*d[j];
            }
            d[i]=(C[i]-sum)/A[i][i];
        }
        String ans="";
        for(int i=0;i<unknown;i++){
            ans+=(X[i]+"="+ d[i]+"\n");
        }
        return ans;
    }
}