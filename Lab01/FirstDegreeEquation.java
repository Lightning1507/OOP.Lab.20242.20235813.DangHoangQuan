import javax.swing.JOptionPane;

public class FirstDegreeEquation{
    public static void main(String[] args){
        String s1,s2;
        s1 = JOptionPane.showInputDialog("Enter variable a: ");
        s2 = JOptionPane.showInputDialog("Enter variable b: ");
        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);
        if (num1 == 0){
            if (num2 == 0){
                JOptionPane.showMessageDialog(null, "The equation has many solutions");
            } else {
                JOptionPane.showMessageDialog(null, "The equation has no solution");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Result of equation: "+(-num2/num1));
        }
        System.exit(0);
    }
}