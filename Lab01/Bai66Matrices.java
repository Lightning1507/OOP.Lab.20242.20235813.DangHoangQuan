import java.util.Scanner;

public class Bai66Matrices {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1,m1;
        System.out.println("Enter number of rows and columns of first matrix: ");
        n1=sc.nextInt(); m1=sc.nextInt();
        int[][] a = new int[n1][m1];
        System.out.println("Enter elements: ");
        int sum=0; double avg;
        for (int i=0;i<n1;i++){
            for (int j=0;j<m1;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int n2,m2;
        System.out.println("Enter number of rows and columns of second matrix: ");
        n2=sc.nextInt(); m2=sc.nextInt();
        int[][] b = new int[n2][m2];
        System.out.println("Enter elements: ");
        for (int i=0;i<n2;i++){
            for (int j=0;j<m2;j++){
                b[i][j]=sc.nextInt();
            }
        }
        if (n1!=n2 || m1!=m2){
            System.out.println("Matrices are not of same size");
            return;
        }
        int[][] c = new int[n1][m1];
        for (int i=0;i<n1;i++){
            for (int j=0;j<m1;j++){
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        System.out.println("Sum of matrices: ");
        for (int i=0;i<n1;i++){
            for (int j=0;j<m1;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}
