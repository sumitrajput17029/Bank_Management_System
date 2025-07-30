package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Pin extends JFrame  implements ActionListener {
    String Pin;
    JPasswordField p1,p2;
    JButton b1,b2;

    Pin(String Pin){
        this.Pin = Pin;
        
     // Get screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1450, screenHeight, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1450,screenHeight);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN :");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(400,200,400,35);
        l3.add(label1);


        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(390,249,150,35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(500,249,180,25);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p1);
        
        p1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = p1.getText();

                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
                if (text.length() >= 4) {
                    e.consume();
                }
              }
            });

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(390,292,400,35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(550,292,180,25);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(p2);
        
        p2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = p2.getText();

                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
                if (text.length() >= 4) {
                    e.consume();
                }
              }
            });

        b1 = new JButton("CHANGE");
        b1.setBounds(645,335,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(645,378,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(1550,screenHeight);
        setLayout(null);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match!\nIt must be 4 digits.");
                return;
            }
            if (e.getSource() == b1) {
                if (p1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                ConnectionHandler con1 = new ConnectionHandler();
                String q1 = "update bank set pin = '" + pin1 + "' where pin = '" + Pin + "'";
                String q2 = "update login set pin = '" + pin1 + "' where pin = '" + Pin + "'";
                String q3 = "update signupthree set pin = '" + pin1 + "' where pin = '" + Pin + "'";

                con1.Statement.executeUpdate(q1);
                con1.Statement.executeUpdate(q2);
                con1.Statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                setVisible(false);
                new main_class(Pin);

            } else if (e.getSource() == b2) {
                new main_class(Pin);
                setVisible(false);

            }
        } catch (SQLException E) {
            E.printStackTrace();
        }


    }

        public static void main(String[] args) {
        new Pin("");
    }
}
