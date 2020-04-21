/*
1.      Разработать оконное приложение «Калькулятор»;
1.1.    Калькулятор должен выполнять 4 простейшие арифметические операции.
1.2.    Калькулятор должен иметь одно окно вывода результатов.
1.3.    Калькулятор работает с двумя параметрами, вводимыми пользователем в окна ввода.
        Подсказка 1: поля ввода в приложении дают читать только текстовые данные. Для преобразования нужно использовать классы-оболочки: https://habrahabr.ru/post/49582/.
        Подсказка 2: можно сделать код гораздо проще, изучив возможности ActionEvent: https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener.
2.      * Научить калькулятор операции возведения в степень.
 */

package Lesson_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calc implements ActionListener {
    JTextField jtfA, jtfB, jtfAnswer;
    JButton jbPlus, jbMinus, jbMultiply, jbSplit, jbExponentiation;
    JLabel jlA, jlB, jlAnswer;

    Calc(){
        JFrame jfrm = new JFrame("Калькулятор");
        jfrm.setSize(280, 120);
        jfrm.setResizable(false);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel borderLt = new JPanel(new BorderLayout());
        JPanel flowLtTop = new JPanel(new FlowLayout());
        JPanel flowLtCenter = new JPanel(new FlowLayout());
        JPanel flowLtBottom = new JPanel(new FlowLayout());

        jtfA = new JTextField(/*"Введите первое число"*/5);
        jtfB = new JTextField(/*"Введите второе число"*/5);
        jtfAnswer = new JTextField(/*"Ответ",*/ 18);
        jbPlus = new JButton("+");
        jbMinus = new JButton("-");
        jbMultiply = new JButton("*");
        jbSplit = new JButton("/");
        jbExponentiation = new JButton("^");
        jlA = new JLabel("Число А:");
        jlB = new JLabel(", Число В:");
        jlAnswer = new JLabel("Ответ:");

        flowLtTop.add(jlA);
        flowLtTop.add(jtfA);
        flowLtTop.add(jlB);
        flowLtTop.add(jtfB);

        flowLtCenter.add(jlAnswer);
        flowLtCenter.add(jtfAnswer);

        flowLtBottom.add(jbPlus);
        flowLtBottom.add(jbMinus);
        flowLtBottom.add(jbMultiply);
        flowLtBottom.add(jbSplit);
        flowLtBottom.add(jbExponentiation);

        borderLt.add(flowLtTop, BorderLayout.NORTH);
        borderLt.add(flowLtCenter, BorderLayout.CENTER);
        borderLt.add(flowLtBottom, BorderLayout.SOUTH);
        jfrm.add(borderLt);

        jbPlus.addActionListener(this);
        jbMinus.addActionListener(this);
        jbMultiply.addActionListener(this);
        jbSplit.addActionListener(this);
        jbExponentiation.addActionListener(this);

        jfrm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        int varA = Integer.parseInt(jtfA.getText());
        int varB = Integer.parseInt(jtfB.getText());

        if (ae.getActionCommand().equals("+")){
            jtfAnswer.setText(String.valueOf(varA + varB));
        } else if (ae.getActionCommand().equals("-")){
            jtfAnswer.setText(String.valueOf(varA - varB));
        } else if (ae.getActionCommand().equals("*")){
            jtfAnswer.setText(String.valueOf(varA * varB));
        } else if (ae.getActionCommand().equals("/")){
            jtfAnswer.setText(String.valueOf(varA / varB));
        } else if (ae.getActionCommand().equals("^")){
            jtfAnswer.setText(String.valueOf((int)(Math.pow(varA, varB))));
        }
    }
}

public class hwLesson6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calc();
            }
        });
    }
}