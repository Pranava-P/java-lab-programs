package lab4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class buttonimage_4c extends JFrame implements ActionListener{

	// Component declarations
    JLabel displayLabel;
    JButton btnClock, btnHourGlass;

    // Constructor: Must match the class name exactly
    public buttonimage_4c() {
        // Setup Frame
        setTitle("Button Image Event Handling");
        setLayout(new FlowLayout());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load images (Ensure these files are in your project root folder)
        ImageIcon clockIcon = new ImageIcon("clock.png");
        ImageIcon hourGlassIcon = new ImageIcon("hourglass.png");

        // Initialize buttons with text and icons
        btnClock = new JButton("Digital Clock", clockIcon);
        btnHourGlass = new JButton("Hour Glass", hourGlassIcon);

        // Initialize the message label
        displayLabel = new JLabel("Press a button to see the message...");
        displayLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Register ActionListeners
        btnClock.addActionListener(this);
        btnHourGlass.addActionListener(this);

        // Add components to the frame
        add(btnClock);
        add(btnHourGlass);
        add(displayLabel);

        // Make frame visible
        setVisible(true);
    }

    // Event Handling Logic
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClock) {
            displayLabel.setText("Digital Clock is pressed");
        } else if (e.getSource() == btnHourGlass) {
            displayLabel.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new buttonimage_4c();
            }
        });
    }
}