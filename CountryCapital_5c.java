package lab5;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.HashMap;
import java.util.Map;
public class CountryCapital_5c extends JFrame {
	
	private JList<String> countryList;
    private Map<String, String> capitals;

    public CountryCapital_5c() {
        // 1. Initialize the Capital Data
        capitals = new HashMap<>();
        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "Addis Ababa");
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        // 2. Create the list model and add countries
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String country : capitals.keySet()) {
            listModel.addElement(country);
        }

        // 3. Setup JList
        countryList = new JList<>(listModel);
        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 4. Add Event Listener
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // getValueIsAdjusting() ensures the code only runs once per click
                if (!e.getValueIsAdjusting()) {
                    String selectedCountry = countryList.getSelectedValue();
                    if (selectedCountry != null) {
                        String capital = capitals.get(selectedCountry);
                        System.out.println("Capital of " + selectedCountry + " is: " + capital);
                    }
                }
            }
        });

        // 5. Setup Frame
        add(new JScrollPane(countryList));
        setTitle("Country Capital Finder");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CountryCapital_5c());
    }
}