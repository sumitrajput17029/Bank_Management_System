package bank.management.system;

import javax.swing.*;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;

    mini(String pin){
        this.pin = pin;

        getContentPane().setBackground(new Color(255, 255, 255));
        setSize(400,600);
        setLocation(20, 20);
        setUndecorated(true);
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2 = new JLabel("MINI STATEMENTS :");
        label2.setFont(new Font("System",Font.BOLD,15));
        label2.setBounds(100,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);
        
        JLabel label5 = new JLabel();
        label5.setBounds(20,100,300,20);
        add(label5);


        try{
             ConnectionHandler con1  = new ConnectionHandler();
             
             String fromNo = null;
             ResultSet resultSet1 = con1.Statement.executeQuery("select * from login where pin = '"+pin+"'");
            
             if (resultSet1.next()) {
                 String cardNumber = resultSet1.getString("card_number");
                 fromNo = resultSet1.getString("from_no");
                 
               label3.setText("CARD NUMBER : "+ resultSet1.getString("card_number").substring (0,4)+"XXXXXXXX"+resultSet1.getString("card_number").substring(12));
           }else {
        	   label3.setText("CARD NUMBER : Not Found");
           }
     
              ResultSet resultSet2 = con1.Statement.executeQuery("select * from signup Where from_no  = '"+fromNo+"'");
        	  
        	  if(resultSet2.next()) {
        	  label5.setText("name : "+ resultSet2.getString("name"));
        	  }else {
        		  label5.setText("Name : Not Found");
        	  }
       
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            int balance =0;
            ConnectionHandler con1  = new ConnectionHandler();
            ResultSet resultSet = con1.Statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){

                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your Total Balance is Rs "+balance);
            
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new mini("");
    }
}
