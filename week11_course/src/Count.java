// this program is used to practice basic function of swing
// counting how many times does the user press the button

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Count extends JFrame {
    private JLabel fLabel;
    private JTextField textField;
    private JButton btn;
    private int count = 0;

    // constructor
    public Count ()
    {
        super("times that the button being pressed");

        setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set label
//        fLabel =new JLabel("Count");
//        add(fLabel);
           add(new JLabel("Count"));

           // set text
           textField = new JTextField("0");
           textField.setPreferredSize(new Dimension(40,30));
           add(textField);

           // set button
           btn = new JButton("count");
           add(btn);
            // link the listener with the button
            btn.addActionListener(new btnListener());

           // set what is added above this code visible!
        setVisible(true);
    }

    // set an event listener
    public class btnListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            count++;
            textField.setText(count + ""); // this "count + """ turns int count into a string!
        }
    }


    public static void main(String[] args) {
        Count count = new Count();
    }

}
