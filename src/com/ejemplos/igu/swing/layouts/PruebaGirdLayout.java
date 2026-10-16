package com.ejemplos.igu.swing.layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaGirdLayout {
    public static void main(String[] args) {
        MarcoGridLayout marco = new MarcoGridLayout();
        LaminaGridLayout lamina = new LaminaGridLayout(marco.display);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(lamina, BorderLayout.CENTER);
    }
}

class MarcoGridLayout extends JFrame {
    public Display display = new Display();

    MarcoGridLayout() {
        setTitle("Prueba Grid layout");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(new BorderLayout());

        JPanel displayPanel = new JPanel();

        displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        displayPanel.add(display);
        add(displayPanel, BorderLayout.NORTH);
    }
}

class Display extends JLabel {
    private boolean initState = true;

    Display() {
        super("0");
    }

    boolean getState() {
        return initState;
    }

    void changeState() {
        if (initState) {
            initState = false;
        } else {
            initState = true;
        }
    }
}

class LaminaGridLayout extends JPanel {

    LaminaGridLayout(Display display) {
        String[][] botones = {
                { "7", "8", "9", "/" },
                { "4", "5", "6", "*" },
                { "1", "2", "3", "-" },
                { "0", ".", "=", "+" }
        };
        setLayout(new GridLayout(botones.length, botones[0].length));

        crearBotones(botones, display);

    }

    private void crearBotones(String[][] botones, Display display) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                JButton button = new JButton(botones[i][j]);
                if (button.getText().matches("[0-9.]")) {
                    button.addActionListener(new ActionNumber(display, button.getText()));
                } else {
                    button.addActionListener(new ActionOperation(display, button.getText()));
                }
                add(button);
            }
        }
    }
}

class ActionNumber implements ActionListener {
    String number;
    Display display;

    ActionNumber(Display display, String number) {
        this.display = display;
        this.number = number;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (display.getState()) {
            display.setText("");
            display.changeState();
        }
        display.setText(display.getText() + number);
    }
}

class ActionOperation implements ActionListener {
    private static double result = 0;
    private static String lastOperation = "=";

    String operation;
    Display display;

    ActionOperation(Display display, String operation) {
        this.operation = operation;
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        calculate(lastOperation, Double.parseDouble(display.getText()));

        lastOperation = operation;

        if (!display.getState()) {
            display.changeState();
        }
    }

    private void calculate(String operation, double number) {
        if (operation.equals("+")) {
            result += number;
        } else if (operation.equals("-")) {
            result -= number;
        } else if (operation.equals("*")) {
            result *= number;
        } else if (operation.equals("/")) {
            result /= number;
        } else if (operation.equals("=")) {
            result = number;
        }

        display.setText("" + result);

    }
}