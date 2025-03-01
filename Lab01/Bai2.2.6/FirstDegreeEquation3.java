import javax.swing.JOptionPane;

public class FirstDegreeEquation3{
    public static void main(String[] args){
        String s1,s2,s3;
        s1 = JOptionPane.showInputDialog("Enter variable a: ");
        s2 = JOptionPane.showInputDialog("Enter variable b: ");
        s3 = JOptionPane.showInputDialog("Enter variable c: ");
        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double c = Double.parseDouble(s3);
        double delta=b*b-4*a*c;
        if (a==0){
            if (b==0){
                if (c==0){
                    JOptionPane.showMessageDialog(null, "The equation has countless solutions");
                } else {
                    JOptionPane.showMessageDialog(null, "The equation has no solution");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The equation has one solution: "+(-c/b));
            }
            System.exit(0);
        }
        if (delta < 0){
            JOptionPane.showMessageDialog(null, "The equation has no solution");
        } else if (delta == 0){
            JOptionPane.showMessageDialog(null, "The equation has one solution: "+(-b/(2*a)));
        } else {
            JOptionPane.showMessageDialog(null, "The equation has two solutions: "+((-b+Math.sqrt(delta))/(2*a)) + " and " + ((-b-Math.sqrt(delta))/(2*a)));
        }
        System.exit(0);
    }
}