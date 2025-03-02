import java.util.Scanner;

public class Bai63StarTriangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of rows: ");
        n = sc.nextInt();
        int mx=2*n-1;
        int d=0,mid=mx/2;
        for (int i=0;i<n;++i){
            for (int j=0;j<mx;++j){
                if (j>=mid-d && j<=mid+d){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            d++;
            System.out.println();
        }
    }
}
