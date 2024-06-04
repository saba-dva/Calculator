import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener
{
    JFrame frame;
    JPanel panel;
    JTextField textField = new JTextField();
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButton = new JButton[10];
    JButton add, sub, mul, div;
    JButton dec, equ, del, clr, neg, t;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator()
    {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(400, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBounds(0, 0, 400, 500);
        panel.setBackground(Color.darkGray);
        panel.setLayout(null);
        textField.setBounds(105, 75, 200, 70);
        textField.setEditable(false);
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        equ = new JButton("=");
        del = new JButton("Del");
        clr = new JButton("Clr");
        neg = new JButton("-");
        t = new JButton("!");
        functionButton[0] = add;
        functionButton[1] = sub;
        functionButton[2] = mul;
        functionButton[3] = div;
        functionButton[4] = dec;
        functionButton[5] = equ;
        functionButton[6] = del;
        functionButton[7] = clr;
        functionButton[8] = neg;
        functionButton[9] = t;
        for (int i = 0; i < 10; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
        }
        del.setBounds(140, 160, 70, 60);
        clr.setBounds(75, 160, 70, 60);
        neg.setBounds(270, 270, 70, 60);
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }
        numberButtons[1].setBounds(75, 325, 70, 60);
        panel.add(numberButtons[1]);
        numberButtons[2].setBounds(140, 325, 70, 60);
        panel.add(numberButtons[2]);
        numberButtons[3].setBounds(205, 325, 70, 60);
        panel.add(numberButtons[3]);
        numberButtons[4].setBounds(75, 270, 70, 60);
        panel.add(numberButtons[4]);
        numberButtons[5].setBounds(140, 270, 70, 60);
        panel.add(numberButtons[5]);
        numberButtons[6].setBounds(205, 270, 70, 60);
        panel.add(numberButtons[6]);
        numberButtons[7].setBounds(75, 215, 70, 60);
        panel.add(numberButtons[7]);
        numberButtons[8].setBounds(140, 215, 70, 60);
        panel.add(numberButtons[8]);
        numberButtons[9].setBounds(205, 215, 70, 60);
        panel.add(numberButtons[9]);
        numberButtons[0].setBounds(75, 380, 135, 60);
        panel.add(numberButtons[0]);
        add.setBounds(270, 325, 70, 60);
        panel.add(add);
        sub.setBounds(270, 270, 70, 60);
        panel.add(sub);
        mul.setBounds(270, 215, 70, 60);
        panel.add(mul);
        dec.setBounds(205, 380, 70, 60);
        panel.add(dec);
        equ.setBounds(270, 380, 70, 60);
        panel.add(equ);
        div.setBounds(270, 160, 70, 60);
        panel.add(div);
        neg.setBounds(205, 160, 70, 60);
        panel.add(neg);
        del.setBounds(140, 160, 70, 60);
        panel.add(del);
        clr.setBounds(75, 160, 70, 60);
        frame.add(clr);
        t.setBounds(320,420,70,60);
        panel.add(t);
        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
    }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            for (int i = 0; i < 10; i++)
            {
               if(e.getSource() == numberButtons[i])
               {
                   textField.setText(textField.getText().concat(String.valueOf(i)));
               }
            }
            if(e.getSource() == t)
            {
                double temp = 0;
                num1 = Double.parseDouble(textField.getText());
                temp = (num1 * num1);
                textField.setText("");
                textField.setText(String.valueOf(temp));

            }
            if(e.getSource() == add)
            {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if(e.getSource() == sub)
            {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if(e.getSource() == mul)
            {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if(e.getSource() == div)
            {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }

            if(e.getSource() == equ)
            {
                num2 = Double.parseDouble(textField.getText());
                switch(operator)
                {
                    case '+':
                        result = num1 + num2;
                        break;
                    case  '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':

                        try{
                            result = num1 / num2;
                        }
                        catch (ArithmeticException ex)
                        {
                            System.out.println("Error: " + ex.getMessage());
                            System.out.println("Cannot divide a value by zero.");
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
            if(e.getSource() == clr)
            {
                textField.setText("");
            }
            if(e.getSource() == del)
            {
                String temp = textField.getText();
                String temp2 = temp.substring(0,temp.length()-1);
                textField.setText(temp2);
            }
            if(e.getSource() == neg)
            {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));
            }
            if(e.getSource() == dec)
            {
                textField.setText((textField.getText().concat(".")));
            }
        }
    public static void main(String[] args)
    {
        new Calculator();
    }
}











