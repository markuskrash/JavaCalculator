package work;

import javax.script.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame{

    private ScriptEngine engine;

    private JButton btnNumbers[][];

    private JButton btnPlus, btnMinus, btnDivide, btnMultiply, btnEqual, btnZero;

    private JTextField textField;

    public Calculator(){
        setTitle("Калькулятор");
        Dimension screenSize = getToolkit().getScreenSize();
        Dimension windowSize = new Dimension(screenSize.width / 2, screenSize.height / 2);
        setSize(windowSize);
        Point windowPosition = new Point(screenSize.width / 4, screenSize.height / 4);
        setLocation(windowPosition);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        engine = new ScriptEngineManager().getEngineByExtension("js");

        setLayout(new GridBagLayout());

        btnNumbers = new JButton[3][3];

        textField = new JTextField("");
        textField.setEnabled(false);
        textField.setDisabledTextColor(Color.black);
        textField.setFont(new Font("Default", 0, 30));

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                btnNumbers[i][j] = new JButton(Integer.toString(i*3+j + 1));
                btnNumbers[i][j].addActionListener(new CalculatorListener(btnNumbers[i][j], engine, textField));
                GridBagConstraints gbc = new GridBagConstraints(
                        j, i + 1, 1, 1, 1, 1,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(2, 2, 2, 2), 0, 0
                );
                add(btnNumbers[i][j], gbc);
            }
        }

        GridBagConstraints gbc = new GridBagConstraints(
                0, 4, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0
        );
        btnZero = new JButton("0");
        btnZero.addActionListener(new CalculatorListener(btnZero, engine, textField));
        add(btnZero, gbc);

        gbc = new GridBagConstraints(
                1, 4, 2, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0
        );
        btnEqual = new JButton("=");
        btnEqual.addActionListener(new CalculateListener(btnEqual, engine, textField));
        add(btnEqual, gbc);

        gbc = new GridBagConstraints(
                0, 0, 4, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0
        );
        add(textField, gbc);

        gbc = new GridBagConstraints(
                3, 1, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0
        );
        btnDivide = new JButton("/");
        btnDivide.addActionListener(new CalculatorListener(btnDivide, engine, textField));
        add(btnDivide, gbc);

        gbc = new GridBagConstraints(
                3, 2, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0
        );
        btnMultiply = new JButton("*");
        btnMultiply.addActionListener(new CalculatorListener(btnMultiply, engine, textField));
        add(btnMultiply, gbc);

        gbc = new GridBagConstraints(
                3, 3, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0
        );
        btnMinus = new JButton("-");
        btnMinus.addActionListener(new CalculatorListener(btnMinus, engine, textField));
        add(btnMinus, gbc);

        gbc = new GridBagConstraints(
                3, 4, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0
        );
        btnPlus = new JButton("+");
        btnPlus.addActionListener(new CalculatorListener(btnPlus, engine, textField));
        add(btnPlus, gbc);




    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}