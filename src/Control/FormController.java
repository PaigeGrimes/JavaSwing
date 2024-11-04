package Control;

import View.IntakeFormView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormController implements ActionListener {
    private IntakeFormView formView;
    public FormController(IntakeFormView formView) {
        this.formView = formView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(actionCommand.equals("")) {

        }
    }
}
