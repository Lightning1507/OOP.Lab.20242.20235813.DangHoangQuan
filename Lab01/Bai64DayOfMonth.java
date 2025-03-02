import java.util.Scanner;

public class Bai64DayOfMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m,y;
        System.out.println("Enter the month: ");
        while(true){
            if (sc.hasNextInt()){
                m = sc.nextInt();
                if (m>=1 && m<=12) break;
                else {
                    System.out.println("Invalid month. Please enter again");
                    continue;
                }
            }
            else{
                String s=sc.next().trim();
                if (s.equals("January") || s.equals("Jan") || s.equals("Jan.")) m=1;
                else if (s.equals("February") || s.equals("Feb") || s.equals("Feb.")) m=2;
                else if (s.equals("March") || s.equals("Mar") || s.equals("Mar.")) m=3;
                else if (s.equals("April") || s.equals("Apr") || s.equals("Apr.")) m=4;
                else if (s.equals("May")) m=5;
                else if (s.equals("June") || s.equals("Jun")) m=6;
                else if (s.equals("July") || s.equals("Jul")) m=7;
                else if (s.equals("August") || s.equals("Aug") || s.equals("Aug.")) m=8;
                else if (s.equals("September") || s.equals("Sep") || s.equals("Sept.")) m=9;
                else if (s.equals("October") || s.equals("Oct") || s.equals("Oct.")) m=10;
                else if (s.equals("November") || s.equals("Nov") || s.equals("Nov.")) m=11;
                else if (s.equals("December") || s.equals("Dec") || s.equals("Dec.")) m=12;
                else {
                    System.out.println("Invalid month. Please enter again");
                    continue;
                }
                break;
            }
        }
        while(true){
            System.out.println("Enter the year: ");
            y = sc.nextInt();
            if (y>=0) break;
            System.out.println("Invalid year. Please enter again");
        }
        int ans;
        if (m==2){
            if (y%4==0 && (y%100!=0 || y%400==0)){
                ans = 29;
            } else {
                ans = 28;
            }
        } else if (m==4 || m==6 || m==9 || m==11){
            ans = 30;
        } else {
            ans = 31;
        }
        System.out.println("Number of days in month "+m+" of year "+y+" is "+ans);
    }
}
