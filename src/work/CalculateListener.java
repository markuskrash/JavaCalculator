package work;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateListener implements ActionListener {

    private JButton btn;
    private ScriptEngine engine;
    private JTextField textField;

    public CalculateListener(JButton btn, ScriptEngine engine, JTextField textField){
        this.btn = btn;
        this.engine = engine;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(engine.eval(textField.getText()).toString().endsWith(".0")){
                textField.setText(engine.eval(textField.getText()).toString().substring(0, engine.eval(textField.getText()).toString().length() - 2));
            }else {
                textField.setText(engine.eval(textField.getText()).toString());
            }
        } catch (ScriptException ex) {
            throw new RuntimeException(ex);
        }
    }
}
