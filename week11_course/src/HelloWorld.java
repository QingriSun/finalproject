// my first GUI practice

import javax.swing.*;
import java.awt.*;

public class HelloWorld extends JFrame{
    private JLabel label;
    private JLabel label2;

    public HelloWorld()
    {
        // set the title of the JFrame
        super("Our first swing program.");

        setLayout(new FlowLayout());
        label = new JLabel("Hello World!");
        label.setFont(new Font("FontName",Font.PLAIN, 300));
        add(label);

        label2 = new JLabel("hello word! (italically)");
        label2.setFont(new Font("Italic style", Font.ITALIC, 80));
        add(label2);
    }

    public static void main(String[] args) {
        JFrame gui = new HelloWorld();

        // set the close button
        //public void setDefaultCloseOperation(int operation);
        // EXIT_ON_CLOSE, DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the size of the frame
        gui.setSize(800, 600);

        // make the frame visible
        gui.setVisible(true);
    }
}
