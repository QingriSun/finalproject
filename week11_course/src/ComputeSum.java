import javax.swing.*;

public class ComputeSum {
    public static void main(String[] args) {
        String str1 = JOptionPane.showInputDialog("Enter 1st integer");
        String str2 = JOptionPane.showInputDialog("Enter 2nd integer");
        int i1 = Integer.parseInt(str1);
        int i2 = Integer.parseInt(str2);
        int sum = i1 + i2;
        JOptionPane.showMessageDialog(null,sum, "result", JOptionPane.INFORMATION_MESSAGE);
    }
}
