package lab5;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
public class TabbedColor_5d extends JFrame{
	public TabbedColor_5d() {
        // 1. Setup the Frame
        setTitle("Tabbed Pane Color Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 2. Create the TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // 3. Create Panels with specific colors
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        // 4. Add Tabs to the Pane
        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);

        // 5. Add ChangeListener to detect tab switching
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Get the index of the selected tab
                int selectedIndex = tabbedPane.getSelectedIndex();
                // Get the title of the selected tab
                String title = tabbedPane.getTitleAt(selectedIndex);
                
                System.out.println("Selected Color Tab: " + title);
            }
        });

        // 6. Add TabbedPane to Frame and make visible
        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new TabbedColor_5d());
    }
}