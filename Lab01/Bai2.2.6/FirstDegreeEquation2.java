import javax.swing.JOptionPane;

public class FirstDegreeEquation2{
    public static void main(String[] args){
        String s1,s2,s3,s4,s5,s6;
        s1 = JOptionPane.showInputDialog("Enter variable a11: ");
        s2 = JOptionPane.showInputDialog("Enter variable a12: ");
        s3 = JOptionPane.showInputDialog("Enter variable b1: ");
        s4 = JOptionPane.showInputDialog("Enter variable a21: ");
        s5 = JOptionPane.showInputDialog("Enter variable a22: ");
        s6 = JOptionPane.showInputDialog("Enter variable b2: ");
        double a11 = Double.parseDouble(s1);
        double a12 = Double.parseDouble(s2);
        double b1 = Double.parseDouble(s3);
        double a21 = Double.parseDouble(s4);
        double a22 = Double.parseDouble(s5);
        double b2 = Double.parseDouble(s6);
        double D=a11*a22-a12*a21;
        double D1=b1*a22-b2*a12;
        double D2=a11*b2-a21*b1;
        if (D == 0){
            if (D1 == 0 && D2 == 0){
                if (b1 == 0 && b2 == 0 || (a11/a21 == a12/a22 && a12/a22 == b1/b2)){
                    JOptionPane.showMessageDialog(null, "The equation has countless solutions");
                } else {
                    JOptionPane.showMessageDialog(null, "The equation has no solution");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The equation has no solution");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Result of x1: "+(D1/D) + "\n" + "Result of x2: "+(D2/D));
        }
        System.exit(0);
    }
}