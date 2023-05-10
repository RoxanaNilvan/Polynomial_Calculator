package ro.tuc.view;

import ro.tuc.model.Operation;
import ro.tuc.model.Polynomial;
import ro.tuc.model.PolynomialPattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
public class View extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JLabel labelPolynomial1;
    private JLabel labelPolynomial2;
    private JLabel labelResult;
    private JTextField textPolynomial1;
    private JTextField textPolynomial2;
    private JTextField textResult;
    public JButton add;
    public JButton subtract;
    public JButton multiply;
    public JButton divide;
    public JButton derive;
    public JButton integrate;

    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton button6;
    public JButton button7;
    public JButton button8;
    public JButton button9;
    public JButton button0;
    public JButton buttonX;
    public JButton buttonPlus;
    public JButton buttonMinus;
    public JButton buttonVirgula;
    public JButton buttonDegree;
    public JButton buttonBack;
    public JButton buttonReset;
    private boolean isTextPolynomial1Selected;
    private boolean isTextPolynomial2Selected;

    public View(String name){
        this.frame = new JFrame(name);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500, 500);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.labelPolynomial1 = new JLabel("Polynomial 1");
        this.labelPolynomial1.setBounds(10, 30, 100, 30);
        this.panel.add(this.labelPolynomial1);

        this.textPolynomial1 = new JTextField(" ");
        this.textPolynomial1.setBounds(100, 30, 250, 30);
        textPolynomial1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                isTextPolynomial1Selected = true;
            }
        });
        this.panel.add(this.textPolynomial1);

        this.labelPolynomial2 = new JLabel("Polynomial 2");
        this.labelPolynomial2.setBounds(10, 70, 100, 30);
        this.panel.add(this.labelPolynomial2);

        this.textPolynomial2 = new JTextField(" ");
        this.textPolynomial2.setBounds(100, 70, 250, 30);
        textPolynomial2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                isTextPolynomial2Selected = true;
            }
        });
        this.panel.add(this.textPolynomial2);

        this.labelResult = new JLabel("Result");
        this.labelResult.setBounds(10, 110, 100, 30);
        this.panel.add(this.labelResult);

        this.textResult = new JTextField(" ");
        this.textResult.setBounds(100, 110, 250, 30);
        this.panel.add(this.textResult);

        this.add = new JButton("Add");
        this.add.setBounds(10, 160, 100, 30);
        this.add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Polynomial polynomial1 = PolynomialPattern.parse(textPolynomial1.getText());
               Polynomial polynomial2 = PolynomialPattern.parse(textPolynomial2.getText());

               if(polynomial1.toString().equals("0")){
                   JOptionPane.showMessageDialog(frame,
                           "Primul polinom nu este introdus corect");
                            textPolynomial1.setText(" ");
               }

                if(polynomial2.toString().equals("0")){
                    JOptionPane.showMessageDialog(frame,
                            "Al doilea polinom nu este introdus corect");
                            textPolynomial2.setText(" ");
                }

                Polynomial result = Operation.add(polynomial1, polynomial2);

                System.out.println("Polynomial 1: " + polynomial1.toString());
                System.out.println("Polynomial 2: "  + polynomial2.toString());
                System.out.println("Result: " + result.toString());
                textResult.setText(result.toString());
            }
        });
        this.panel.add(this.add);

        this.subtract = new JButton("Substract");
        this.subtract.setBounds(10, 200, 100, 30);
        this.subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = PolynomialPattern.parse(textPolynomial1.getText());
                Polynomial polynomial2 = PolynomialPattern.parse(textPolynomial2.getText());
                if(polynomial1.toString().equals("0")){
                    JOptionPane.showMessageDialog(frame,
                            "Primul polinom nu este introdus corect");
                    textPolynomial1.setText(" ");
                }

                if(polynomial2.toString().equals("0")){
                    JOptionPane.showMessageDialog(frame,
                            "Al doilea polinom nu este introdus corect");
                    textPolynomial2.setText(" ");
                }
                Polynomial result = Operation.subtract(polynomial1, polynomial2);

                System.out.println("Result: " + result.toString());
                textResult.setText(result.toString());
            }
        });
        this.panel.add(this.subtract);

        this.multiply = new JButton("Multiply");
        this.multiply.setBounds(120, 160, 100, 30);
        this.multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = PolynomialPattern.parse(textPolynomial1.getText());
                Polynomial polynomial2 = PolynomialPattern.parse(textPolynomial2.getText());
                if(polynomial1.toString().equals("0")){
                    JOptionPane.showMessageDialog(frame,
                            "Primul polinom nu este introdus corect");
                    textPolynomial1.setText(" ");
                }

                if(polynomial2.toString().equals("0")){
                    JOptionPane.showMessageDialog(frame,
                            "Al doilea polinom nu este introdus corect");
                    textPolynomial2.setText(" ");
                }
                Polynomial result = Operation.multiplication(polynomial1, polynomial2);

                System.out.println("Result: " + result.toString());
                textResult.setText(result.toString());
            }
        });
        this.panel.add(this.multiply);

        this.divide = new JButton("Divide");
        this.divide.setBounds(120, 200, 100, 30);
        this.divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = PolynomialPattern.parse(textPolynomial1.getText());
                Polynomial polynomial2 = PolynomialPattern.parse(textPolynomial2.getText());
                if(polynomial1.toString().equals("0")){
                    JOptionPane.showMessageDialog(frame,
                            "Primul polinom nu este introdus corect");
                    textPolynomial1.setText(" ");
                }

                if(polynomial2.toString().equals("0")){
                    JOptionPane.showMessageDialog(frame,
                            "Al doilea polinom nu este introdus corect");
                    textPolynomial2.setText(" ");
                }
                Polynomial results[] = Operation.divide(polynomial1, polynomial2);
                textResult.setText("Cat : " + results[0].toString() + "  Rest : " + results[1].toString());
            }
        });
        this.panel.add(this.divide);

        this.derive = new JButton("Derive");
        this.derive.setBounds(230, 160, 100, 30);
        this.derive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = PolynomialPattern.parse(textPolynomial1.getText());
                Polynomial polynomial2 = PolynomialPattern.parse(textPolynomial2.getText());
                if(polynomial1.toString().equals("0")){
                    JOptionPane.showMessageDialog(frame,
                            "Primul polinom nu este introdus corect");
                    textPolynomial1.setText(" ");
                }

                Polynomial result = new Polynomial();

                if(isTextPolynomial1Selected){
                    result = Operation.derivative(polynomial1);
                }
                else{
                    if(isTextPolynomial2Selected){
                        result = Operation.derivative(polynomial2);
                    }
                }

                // display the result
                System.out.println("Result: " + result.toString());
                textResult.setText(result.toString());
            }
        });
        this.panel.add(this.derive);

        this.buttonBack = new JButton("Delete");
        this.buttonBack.setBounds(340, 160, 100, 30);
        this.buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    String text = textPolynomial1.getText();
                    if(!text.isEmpty()) {
                        textPolynomial1.setText(text.substring(0, text.length() - 1));
                        isTextPolynomial1Selected = false;
                    }
                }

                if(isTextPolynomial2Selected) {
                    String text = textPolynomial2.getText();
                    if (!text.isEmpty()) {
                        textPolynomial2.setText(text.substring(0, text.length() - 1));
                        isTextPolynomial2Selected = false;
                    }
                }
            }
        });
        this.panel.add(this.buttonBack);

        this.integrate = new JButton("Integrate");
        this.integrate.setBounds(230, 200, 100, 30);
        this.integrate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = PolynomialPattern.parse(textPolynomial1.getText());
                Polynomial polynomial2 = PolynomialPattern.parse(textPolynomial2.getText());
                if(polynomial1.toString().equals("0")){
                    JOptionPane.showMessageDialog(frame,
                            "Primul polinom nu este introdus corect");
                    textPolynomial1.setText(" ");
                }

                Polynomial result = new Polynomial();

                if(isTextPolynomial1Selected){
                    result = Operation.integral(polynomial1);
                }
                else{
                    if(isTextPolynomial2Selected){
                        result = Operation.integral(polynomial2);
                    }
                }

                // display the result
                System.out.println("Result: " + result.toString());
                textResult.setText(result.toString());
            }
        });
        this.panel.add(this.integrate);

        this.buttonReset = new JButton("Reset");
        this.buttonReset.setBounds(340, 200, 100, 30);
        this.buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPolynomial1.setText("");
                textPolynomial2.setText("");
                textResult.setText("");
            }
        });
        this.panel.add(this.buttonReset);

        this.button1 = new JButton("1");
        this.button1.setBounds(10, 250, 50, 50);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "1");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "1");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button1);

        this.button2 = new JButton("2");
        this.button2.setBounds(70, 250, 50, 50);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "2");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "2");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button2);

        this.button3 = new JButton("3");
        this.button3.setBounds(130, 250, 50, 50);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "3");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "3");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button3);

        this.button0 = new JButton("0");
        this.button0.setBounds(200, 250, 50, 50);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "0");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "0");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button0);

        this.buttonX = new JButton("X");
        this.buttonX.setBounds(260, 250, 50, 50);
        buttonX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "x");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "x");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.buttonX);

        this.buttonDegree = new JButton("^");
        this.buttonDegree.setBounds(320, 250, 50, 50);
        buttonDegree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "^");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "^");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.buttonDegree);

        this.button4 = new JButton("4");
        this.button4.setBounds(10, 310, 50, 50);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "4");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "4");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button4);

        this.button5 = new JButton("5");
        this.button5.setBounds(70, 310, 50, 50);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "5");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "5");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button5);

        this.button6 = new JButton("6");
        this.button6.setBounds(130, 310, 50, 50);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "6");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "6");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button6);

        this.button7 = new JButton("7");
        this.button7.setBounds(10, 370, 50, 50);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "7");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "7");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button7);

        this.button8 = new JButton("8");
        this.button8.setBounds(70, 370, 50, 50);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "8");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "8");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button8);

        this.button9 = new JButton("9");
        this.button9.setBounds(130, 370, 50, 50);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "9");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "9");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.button9);

        this.buttonPlus = new JButton("+");
        this.buttonPlus.setBounds(200, 310, 50, 50);
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "+");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "+");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.buttonPlus);

        this.buttonMinus = new JButton("-");
        this.buttonMinus.setBounds(260, 310, 50, 50);
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + "-");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + "-");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.buttonMinus);

        this.buttonVirgula = new JButton(".");
        this.buttonVirgula.setBounds(320, 310, 50, 50);
        buttonVirgula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTextPolynomial1Selected) {
                    textPolynomial1.setText(textPolynomial1.getText() + ".");
                    isTextPolynomial1Selected = false;
                }

                if(isTextPolynomial2Selected){
                    textPolynomial2.setText(textPolynomial2.getText() + ".");
                    isTextPolynomial2Selected = false;
                }
            }
        });
        this.panel.add(this.buttonVirgula);
        Color color = new Color(134, 204, 213, 168);
        this.panel.setBackground(color);
        this.frame.setContentPane(panel);
        this.frame.setVisible(true);
    }
    public JTextField getTextPolynomial1() {
        return textPolynomial1;
    }

    public JTextField getTextPolynomial2() {
        return textPolynomial2;
    }

    public JTextField getTextResult() {
        return textResult;
    }
}