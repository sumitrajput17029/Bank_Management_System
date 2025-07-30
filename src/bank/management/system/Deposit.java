package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1,b2;

    Deposit(String pin){
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

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430,160,400,35);
        l3.add(label1);

        textField = new JTextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(430,200,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);
        
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = textField.getText();

                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
                if (text.length() >= 7) {
                    e.consume();
                }
              }
            });        

        b1 = new JButton("DEPOSIT");
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

        setLayout(null);
        setSize(1550,screenHeight);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        try{
            String amount = textField.getText();
            Date date = new Date();
            
            if (e.getSource() == b1){
                if (textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposit");
                } else {
                	
          // Record withdrawal in DB  
                	ConnectionHandler con1 = new ConnectionHandler();
                	ResultSet resultSet = con1.Statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");

                	// Calculate current balance
                	int balance = 0;
                	while (resultSet.next()) {
                	    if (resultSet.getString("type").equalsIgnoreCase("Deposit")) {
                	        balance += Integer.parseInt(resultSet.getString("amount"));
                	    } else {
                	        balance -= Integer.parseInt(resultSet.getString("amount"));
                	    }
                	}

                	// Record deposit in DB
                	con1.Statement.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                	JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");

                	// Updated balance after deposit
                	int updatedBalance = balance + Integer.parseInt(amount);

                	// Send WhatsApp/SMS Notification
                	String message = "₹" + amount + " has been credited to your account.\nAvailable Balance: ₹" + updatedBalance;
                	
                	 WhatsAppNotification.sendWhatsApp("+918872641349", message);
                	 WhatsAppNotification.sendSMS("+918872641349", message);

                    // Back to main menu
                    setVisible(false);
                    new main_class(pin);
                    
                }
            }else if (e.getSource() == b2){
                setVisible(false);
                new main_class(pin);
            }

        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
      new Deposit("");
    }
}