package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {

    String pin;
    JButton b1;
    JLabel label2;

    BalanceEnquriy(String pin){
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

        JLabel label1 = new JLabel("YOUR CURRENT BALANCE IS RS");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430,160,400,35);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430,200,400,35);
        l3.add(label2);

        b1 = new JButton("BACK");
        b1.setBounds(645,378,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int balance = 0;
        try{
            ConnectionHandler con1 = new ConnectionHandler();
            ResultSet resultSet = con1.Statement.executeQuery("select * from bank where pin = '"+pin+"'");
          
            while (resultSet.next()){
            	
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.
                            parseInt(resultSet.getString("amount"));
                }
            }
            
        // Send  Notification
            String message = "Your current account balance is ₹" + balance;
        
            WhatsAppNotification.sendWhatsApp("+918872641349", message);
            WhatsAppNotification.sendSMS("+918872641349", message);   
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        label2.setText(""+balance);

        setLayout(null);
        setSize(1550,screenHeight);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}
