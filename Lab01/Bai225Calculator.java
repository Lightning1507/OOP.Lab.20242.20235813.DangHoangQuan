import javax.swing.JOptionPane;

public class Bai225Calculator{
    public static void main(String[] args){
        String s1,s2;
        s1 = JOptionPane.showInputDialog("Enter the first number: ");
        s2 = JOptionPane.showInputDialog("Enter the second number: ");
        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);
        if (num2==0){
            JOptionPane.showMessageDialog(null, "Result of sum "+(num1+num2) + "\n" + 
        "Result of subtraction "+(num1-num2) + 
        "\n" + "Result of division: Cannot" + 
        "\n" + "Result of multiplication "+(num1*num2) + 
        "\n" + "Result of remainder: Cannot ");
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Result of sum "+(num1+num2) + "\n" + 
        "Result of subtraction "+(num1-num2) + 
        "\n" + "Result of division "+(num1/num2) + 
        "\n" + "Result of multiplication "+(num1*num2) + 
        "\n" + "Result of remainder "+(num1%num2));
        System.exit(0);
    }
}
