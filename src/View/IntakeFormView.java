package View;

import Control.FormController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * The class to build the intake form.
 */
public class IntakeFormView extends JFrame {
    private JButton saveButton;
    private JButton clearButton;
    private JLabel nameLabel;
    private JButton checkHumanLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel addressLabel;

    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JTextArea nameTextArea;
    private JTextArea addressTextArea;
    private JComboBox<Integer> comboBox;

    public IntakeFormView() {
        super("Intake form");
        FormController controller = new FormController(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        setResizable(true);

        add(form());

        //Display the window.
        pack();
        setVisible(true);
    }

    public JPanel form() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 15, 10,30));

        JPanel namePanel = new JPanel(new GridLayout(1,2));
        // Name
        nameLabel = new JLabel("Name:");
        nameTextArea = new JTextArea();
        nameTextArea.setPreferredSize(new Dimension(150, 25)); // Set preferred size for name field
        namePanel.add(nameLabel);
        namePanel.add(nameTextArea);

        // Address
        JPanel addressPanel = new JPanel(new GridLayout(1,2));
        addressLabel = new JLabel("Address:");
        addressTextArea = new JTextArea();
        addressTextArea.setPreferredSize(new Dimension(150, 25)); // Set preferred size for address field
        addressPanel.add(addressLabel);
        addressPanel.add(addressTextArea);

        // Age
        JPanel agePanel = new JPanel(new GridLayout(1,2));
        ageLabel = new JLabel("Age: ");
        ageLabel.setHorizontalAlignment(JLabel.RIGHT);
        agePanel.add(ageLabel);
        Integer[] age = new Integer[110];
        for (int i = 1; i < 110; i++) {
            age[i] = i;
        }
        comboBox = new JComboBox<>(age);
        agePanel.add(comboBox);

        // Gender
        JPanel genderPanel = new JPanel(new GridLayout(1,2));
        genderLabel = new JLabel("Gender: ");
        // TODO: How to handle this? Options M | F | NB ?
        JLabel gender = new JLabel("M | F | NB");
        genderPanel.add(genderLabel);
        genderPanel.add(gender);

        //
        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        // Create submit button
        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        // Check if human
        JPanel radioPanel = new JPanel(new GridBagLayout());
        JLabel checkLabel = new JLabel("Check Human: ");
        checkLabel.setHorizontalAlignment(JLabel.RIGHT);
        ButtonGroup radioGroup = new ButtonGroup();
        radioButton1 = new JRadioButton("BTS is the BEST");
        radioButton2 = new JRadioButton("BTS is the BESTEST");
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);

        radioPanel.add(checkLabel);
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);


        // Add components to the panel
        panel.add(namePanel);
        panel.add(addressPanel);
        panel.add(agePanel);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(genderPanel);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(buttonPanel);
        panel.add(radioPanel);

        return panel;
    }

}
