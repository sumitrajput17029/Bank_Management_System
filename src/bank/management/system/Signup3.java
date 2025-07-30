package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r, r2, r3, r4;
    JCheckBox c, c2, c3, c4, c5, c6, c7;
    JButton s, s2;
    String formno;

    Signup3(String formno) {
        this.formno = formno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(120, 5, 150, 100);
        add(image);

        JLabel l1 = new JLabel("page No 3:");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel l2 = new JLabel("Account Details : ");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(280, 70, 400, 40);
        add(l2);

        JLabel l3 = new JLabel("Account Type :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 140, 200, 30);
        add(l3);

        r = new JRadioButton("Saving Account");
        r.setFont(new Font("Raleway", Font.BOLD, 16));
        r.setBounds(100, 180, 150, 30);
        r.setBackground(new Color(204, 255, 204));
        add(r);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBounds(350, 180, 300, 30);
        r2.setBackground(new Color(204, 255, 204));
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBounds(100, 220, 180, 30);
        r3.setBackground(new Color(204, 255, 204));
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBounds(350, 220, 300, 30);
        r4.setBackground(new Color(204, 255, 204));
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4 = new JLabel("Card Number:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 300, 200, 30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-Digit Card Number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100, 330, 200, 20);
        add(l5);

        JLabel l6 = new JLabel("xxxx-xxxx-xxxx-4841");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(330, 300, 250, 30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on atm card/cheque book and statements)");
        l7.setFont(new Font("Raleway", Font.BOLD, 12));
        l7.setBounds(330, 330, 500, 20);
        add(l7);

        JLabel l8 = new JLabel("PIN :");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 370, 200, 30);
        add(l8);

        JLabel l9 = new JLabel("xxxx");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(330, 370, 200, 30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit password)");
        l10.setFont(new Font("Raleway", Font.BOLD, 12));
        l10.setBounds(100, 400, 200, 10);
        add(l10);

        JLabel l11 = new JLabel("Services Required");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 450, 200, 30);
        add(l11);

        c = new JCheckBox("ATM CARD");
        c.setFont(new Font("Raleway", Font.BOLD, 16));
        c.setBackground(new Color(204, 255, 204));
        c.setBounds(100, 490, 150, 30);
        add(c);

        c2 = new JCheckBox("Mobile Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(new Color(204, 255, 204));
        c2.setBounds(100, 530, 180, 30);
        add(c2);

        c3 = new JCheckBox("Cheque Book");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(new Color(204, 255, 204));
        c3.setBounds(100, 570, 150, 30);
        add(c3);

        c4 = new JCheckBox("Internet Banking");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(new Color(204, 255, 204));
        c4.setBounds(350, 490, 200, 30);
        add(c4);

        c5 = new JCheckBox("EMAIL Alerts");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(new Color(204, 255, 204));
        c5.setBounds(350, 530, 180, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(new Color(204, 255, 204));
        c6.setBounds(350, 570, 150, 30);
        add(c6);

        c7 = new JCheckBox("I here by declares that the above entered details correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(new Color(204, 255, 204));
        c7.setBounds(100, 610, 550, 20);
        add(c7);

        JLabel l12 = new JLabel("Form No:- ");
        l12.setFont(new Font("Raleway", Font.BOLD, 18));
        l12.setBounds(620, 30, 100, 30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 18));
        l13.setBounds(720, 30, 100, 30);
        add(l13);

        s = new JButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD, 14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(100, 650, 100, 30);
        s.addActionListener(this);
        add(s);

        s2 = new JButton("Cancel");
        s2.setFont(new Font("Raleway", Font.BOLD, 14));
        s2.setBackground(Color.BLACK);
        s2.setForeground(Color.WHITE);
        s2.setBounds(420, 650, 100, 30);
        s2.addActionListener(this);
        add(s2);

        setLayout(null);
        setSize(850, 830);
        setLocation(400, 0);
        getContentPane().setBackground(new Color(204, 255, 204));
        setUndecorated(true); 
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if (r.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype = "Current Account";
        } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String fac = null;
        if (c.isSelected()) {
            fac += "ATM CARD";
        } else if (c2.isSelected()) {
            fac += "Mobile Banking";
        } else if (c3.isSelected()) {
            fac += "Cheque Book";
        } else if (c4.isSelected()) {
            fac += "Internet Banking";
        } else if (c5.isSelected()) {
            fac += "EMAIL Alerts";
        } else if (c6.isSelected()) {
            fac += "E-Statement";
        } else if (c7.isSelected()) {
            fac += "I here by decleares that the above entered details correct to the best of my knlowledge";
        }
        try {
            if (e.getSource() == s) {
                if (atype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields ");
                } else  {
                    ConnectionHandler con1 = new ConnectionHandler();
                    String q1 = "INSERT INTO signupthree values('" + formno + "','" + atype + "','" + cardno + "','" + pin + "','" + fac + "')";
                    String q2 = "INSERT INTO login values('" + formno + "','" + cardno + "','" + pin + "')";
                    con1.Statement.executeUpdate(q1);
                    con1.Statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number :" + cardno + "\n pin : " + pin);
                    new Deposit(pin);
                    setVisible(false);
                }

            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup3("");
    }
}