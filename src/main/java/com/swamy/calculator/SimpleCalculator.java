import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        JTextField text = new JTextField();
        text.setEditable(false);

        frame.setLayout(new BorderLayout());
        frame.add(text, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        String[] buttons = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0","C","=","+"
        };

        final double[] num1 = new double[1];
        final String[] operator = new String[1];

        for(String b : buttons){
            JButton button = new JButton(b);
            panel.add(button);

            button.addActionListener(e -> {
                String cmd = e.getActionCommand();

                if(cmd.matches("[0-9]")){
                    text.setText(text.getText() + cmd);
                }
                else if(cmd.equals("C")){
                    text.setText("");
                }
                else if(cmd.equals("=")){
                    double num2 = Double.parseDouble(text.getText());
                    double result = 0;

                    switch(operator[0]){
                        case "+": result = num1[0] + num2; break;
                        case "-": result = num1[0] - num2; break;
                        case "*": result = num1[0] * num2; break;
                        case "/": result = num1[0] / num2; break;
                    }

                    text.setText(String.valueOf(result));
                }
                else{
                    num1[0] = Double.parseDouble(text.getText());
                    operator[0] = cmd;
                    text.setText("");
                }
            });
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
