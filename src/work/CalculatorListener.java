package work;

import javax.script.ScriptEngine;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorListener implements ActionListener {

    private JButton btn;
    private ScriptEngine engine;
    private JTextField textField;

    public CalculatorListener(JButton btn, ScriptEngine engine, JTextField textField){
        this.btn = btn;
        this.engine = engine;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + btn.getText());
    }
}
