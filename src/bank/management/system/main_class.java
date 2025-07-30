package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    main_class(String pin) {
        this.pin = pin;
        
        // Get screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1450, screenHeight, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1450,screenHeight);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 20));
        label.setBounds(430,160,700,35);
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(382,249,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(645,249,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CARD");
        b3.setBounds(382,292,150,35);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(645,292,150,35);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(382,335,150,35);
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(645,335,150,35);
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(645,378,150,35);
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550,screenHeight);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == b1) {
            new Deposit(pin);
            setVisible(false);
        }else if (e.getSource()== b2){
            new Withdrawal(pin);
            setVisible(false);
        }else if (e.getSource()== b3){
            new FastCash(pin);
            setVisible(false);
        }else if (e.getSource()== b4){
            new mini(pin);
            setVisible(false);
        }else if (e.getSource()== b5){
            new Pin(pin);
            setVisible(false);
        }else if (e.getSource()==b6) {
            new BalanceEnquriy(pin);
            setVisible(false);
        }else if (e.getSource()==b7){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new main_class("");
    }
}
