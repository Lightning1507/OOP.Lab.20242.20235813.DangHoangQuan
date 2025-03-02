import java.util.Scanner;

public class Bai65Array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter number of elements: ");
        n=sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements: ");
        int sum=0; double avg;
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
            sum+=a[i];
        }
        for (int i=0;i<n;++i){
            for (int j=i+1;j<n;++j){
                if (a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        System.out.println("Sorted array: ");
        for (int i=0;i<n;++i) System.out.print(a[i]+" ");
        System.out.println();
        avg=(double)sum/n;
        System.out.println("Sum of elements: "+sum);
        System.out.println("Average of elements: "+avg);
    }
}
