package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *  The class to build the display form which shows submitted information.
 */
public class DisplayFormView extends JFrame {
    // Constructor with parameters taking in/detailing user's input
    public DisplayFormView(String name, String address, String age, String gender, String radioSelection) {
        super("Submitted Information");

        // Window features
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        setResizable(true);

        // This window isn't as complex, so we didn't make a separate method for the panel
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 15, 10,30));

        // BoxLayout orders the panel's features vertically (Y_AXIS)
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add components to the panel; we use
        panel.add(new JLabel("Name: " + name));
        panel.add(new JLabel("Address: " + address));
        panel.add(new JLabel("Age: " + age));
        panel.add(new JLabel("Gender: " + gender));
        panel.add(new JLabel("Check Human: " + radioSelection));

        // Add the panel itself
        add(panel);

        // Display the window
        pack();
        setVisible(true);
    }
}
