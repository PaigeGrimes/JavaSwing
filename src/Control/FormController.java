package Control;

import View.DisplayFormView;
import View.IntakeFormView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  This class handles the interactions between the action listeners and the buttons clicked by the user
 */
public class FormController implements ActionListener {
    // The intake form that is being listened to
    private IntakeFormView formView;

    // Constructor initializing the controller with the form
    public FormController(IntakeFormView formView) {
        this.formView = formView;
    }

    // Triggered when the action (button is pressed) is performed
    @Override
    public void actionPerformed(ActionEvent e) {
        // If the submit button is clicked
        if (e.getSource() == formView.submitButton) {
            // Collect the data from the form using getter methods
            String name = formView.getName();
            String address = formView.getAddress();
            String age = formView.getAge();
            String gender = formView.getGender();
            String radioSelection = formView.getRadioSelection();

            // Display the submitted information on a new page (Creating a DisplayFormView object)
            new DisplayFormView(name, address, age, gender, radioSelection);
            formView.setVisible(false);  // Hide the intake form
        } else if (e.getSource() == formView.clearButton) { // If the clear button is clicked
            // Call the clearForm() method in IntakeFormView that resets the form to default values
            formView.clearForm();
        }
    }
}
