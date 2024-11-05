package View;

import Control.FormController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * The class to build the intake form.
 */
public class IntakeFormView extends JFrame {
    // Create labels for name, age, gender, and address
    private JLabel nameLabel, ageLabel, genderLabel, addressLabel;

    // Create buttons for save, clear, and submit; make these public so the action listeners can access them
    public JButton saveButton, clearButton, submitButton;

    // Create button group for radio buttons
    private ButtonGroup radioGroup;

    // Create radio buttons for questionaire
    private JRadioButton radioButton1, radioButton2;

    // Create text input boxes for name and address
    private JTextArea nameTextArea, addressTextArea;

    // Create comboboxes for age and gender
    private JComboBox<Integer> ageComboBox;
    private JComboBox<String> genderComboBox;

    // Constructor
    public IntakeFormView() {
        super("Intake form");

        // Controller that links display and action listeners
        FormController controller = new FormController(this);

        // Window features
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        setResizable(true);

        // Add form panel to the window
        add(form());

        // Display the window
        pack();
        setVisible(true);

        // Add action listeners for clear and submit
        submitButton.addActionListener(controller);
        clearButton.addActionListener(controller);
    }

    // Intake form panel
    public JPanel form() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 15, 10,30));

        // Name
        JPanel namePanel = new JPanel(new GridLayout(1,2));
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
        // Age options 1-109
        Integer[] age = new Integer[110];
        for (int i = 1; i < 110; i++) {
            age[i] = i;
        }
        ageComboBox = new JComboBox<>(age);
        agePanel.add(ageComboBox);

        // Gender
        JPanel genderPanel = new JPanel(new GridLayout(1,2));
        genderLabel = new JLabel("Gender: ");
        genderLabel.setHorizontalAlignment(JLabel.RIGHT);
        genderPanel.add(genderLabel);
        genderComboBox = new JComboBox<>(new String[] {"F", "M", "NB"});
        genderPanel.add(genderComboBox);

        // Save and clear buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        // Check if human
        JPanel radioPanel = new JPanel(new GridBagLayout());
        JLabel checkLabel = new JLabel("Check Human: ");
        checkLabel.setHorizontalAlignment(JLabel.RIGHT);
        radioGroup = new ButtonGroup();
        radioButton1 = new JRadioButton("BTS is the BEST");
        radioButton2 = new JRadioButton("BTS is the BESTEST");
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);

        radioPanel.add(checkLabel);
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);

        // Submit button
        JPanel submitButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        submitButton = new JButton("Submit");
        submitButtonPanel.add(submitButton);

        // Add components to the panel
        panel.add(namePanel);
        panel.add(addressPanel);
        panel.add(agePanel);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(genderPanel);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(buttonPanel);
        panel.add(radioPanel);
        panel.add(new JLabel());
        panel.add(submitButtonPanel);

        return panel;
    }

    // Getters for display page
    public String getName() {
        return nameTextArea.getText();
    }

    public String getAddress() {
        return addressTextArea.getText();
    }

    public String getAge() {
        if (ageComboBox.getSelectedItem() != null) {
            return (String) ageComboBox.getSelectedItem();
        } else {
            // If the user doesn't select an age
            return "Age Not Selected";
        }
    }

    public String getGender() {
        return (String) genderComboBox.getSelectedItem();
    }

    public String getRadioSelection() {
        if (radioButton1.isSelected()) {
            return "Verified: BTS is the BEST";
        } else if (radioButton2.isSelected()) {
            return "Verified: BTS is the BESTEST";
        } else {
            // If neither buttons are selected
            return "Could Not Be Verified As Human";
        }
    }

    // This is a method used in the controller to clear/reset the form to default values
    public void clearForm() {
        nameTextArea.setText("");
        addressTextArea.setText("");
        ageComboBox.setSelectedIndex(0);
        genderComboBox.setSelectedIndex(0);
        radioGroup.clearSelection();
    }

}
