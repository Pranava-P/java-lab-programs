package lab4;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class buttonexample_4b {
	JLabel l1;

    // Constructor (must match class name)
    buttonexample_4b() {

        JFrame f = new JFrame("Button Example");

        l1 = new JLabel();
        l1.setBounds(50, 50, 700, 100);
        l1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));

        JButton b1 = new JButton("India");
        JButton b2 = new JButton("Srilanka");

        b1.setBounds(50, 200, 100, 50);
        b2.setBounds(170, 200, 100, 50);

        // Action for Button 1
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("India is pressed");
            }
        });

        // Action for Button 2
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("SriLanka is pressed");
            }
        });

        f.add(b1);
        f.add(b2);
        f.add(l1);

        f.setSize(350, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new buttonexample_4b();   // FIXED
    }
}