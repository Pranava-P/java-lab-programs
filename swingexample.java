package lab4;
import java.awt.Color;
import java.awt.Font;
//A simple Swing application.
import javax.swing.*;
public class swingexample {
	// Constructor name must match the class name exactly
    swingexample() {
        // Create a new JFrame container.
        JFrame jfrm = new JFrame("A Simple Swing Application");
        
        // Increased size: 32pt font is too big for a 275px wide window
        jfrm.setSize(800, 200);
        
        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a text-based label.
        JLabel jlab = new JLabel(" Hello! VI C , Welcome to Swing Programming!");
        
        // Set properties for label
        jlab.setFont(new Font("Verdana", Font.PLAIN, 32));
        jlab.setForeground(new Color(0, 0, 255));
        
        // Add the label to the content pane.
        jfrm.add(jlab);
        
        // Display the frame.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Must match the lowercase class name
                new swingexample(); 
            }
        });
    }
}