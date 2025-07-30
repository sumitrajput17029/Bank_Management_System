package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    FastCash(String pin){
        this.pin = pin;
        
     // Get screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1450, screenHeight, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1450, screenHeight);
        add(l3);

        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 20));
        label.setBounds(430,140,700,35);
        l3.add(label);

        b1 = new JButton("Rs. 100");
        b1.setBounds(382,249,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setBounds(645,249,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setBounds(382,292,150,35);
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setBounds(645,292,150,35);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setBounds(382,335,150,35);
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setBounds(645,335,150,35);
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setBounds(645,378,150,35);
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1450, screenHeight);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b7) {
            setVisible(false);
            new main_class(pin);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            ConnectionHandler con1 = new ConnectionHandler();
            Date date = new Date();
            try{
                // Fetch transactions for the user
                ResultSet resultSet = con1.Statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;

                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                
                int withdrawAmount = Integer.parseInt(amount);// `amount` should be set based on button clicked
                String num ="17";

                if (e.getSource() != b7 && balance < (withdrawAmount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }

                con1.Statement.executeUpdate("insert into bank values ('"+pin+"','"+date+"','withdrawl','"+withdrawAmount+"')");
                JOptionPane.showMessageDialog(null,"Rs. "+withdrawAmount+" Debited Successfully");
                
                int updatedBalance = balance - withdrawAmount;
            
                String message = "₹" + withdrawAmount + " has been debited from your account.\nAvailable Balance: ₹" + updatedBalance;

     // Send WhatsApp and SMS notifications
                WhatsAppNotification.sendWhatsApp("+918872641349", message);
                WhatsAppNotification.sendSMS("+918872641349", message);
             
            }catch (Exception E ){
                E.printStackTrace();
            }
            setVisible(false);
            new main_class(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
