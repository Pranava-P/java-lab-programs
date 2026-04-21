package lab5;
import java.awt.Color;
import javax.swing.*;
public class tabbedpane_5b {

    JFrame f;

    tabbedpane_5b() {
        f = new JFrame("JTabbedPane Example");
        
        // Create three panels
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        
        // Set background colors
        p1.setBackground(Color.BLUE);
        p2.setBackground(Color.RED);
        p3.setBackground(Color.GREEN);
        
        // Create the TabbedPane
        JTabbedPane tp = new JTabbedPane();
        
        // Set bounds because the frame layout is set to null
        tp.setBounds(50, 50, 250, 250);
        
        // Add panels to tabs with clean quotes
        tp.add("BLUE", p1);
        tp.add("RED", p2);
        tp.add("GREEN", p3);
        
        // Add components to frame
        f.add(tp);
        
        // Frame settings
        f.setSize(400, 400);
        f.setLayout(null); // Manual positioning via setBounds
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensures program stops on close
        f.setVisible(true);
    }

    public static void main(String[] args) {
        // Run on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new tabbedpane_5b();
            }
        });
    }
}