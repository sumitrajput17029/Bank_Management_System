    package bank.management.system;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.KeyAdapter;
    import java.awt.event.KeyEvent;
    import java.sql.ResultSet;

    public class Login extends  JFrame implements ActionListener{// button action performance import action listener( implements ActionListene)
        JLabel label1,label2,label3;
        JTextField textField2;
        JPasswordField passwordField3;
        JButton button1,button2,button3,button4;

        Login() {
            super("Bank Management System");
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
            Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(350,10,100,100);
            add(image);

            ImageIcon ii1= new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
            Image ii2=ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
            ImageIcon ii3= new ImageIcon(ii2);
            JLabel iimage= new JLabel(ii3);
            iimage.setBounds(630,350,100,100);
            add(iimage);

            label1 = new JLabel("WELCOME TO ATM");
            label1.setForeground(Color.WHITE);
            label1.setFont(new Font("AvantGrade",Font.BOLD,38));
            label1.setBounds(230,125,450,40);
            add(label1);

            label2 = new JLabel("Card No:");
            label2.setForeground(Color.WHITE);
            label2.setFont(new Font("Ralway",Font.BOLD,28));
            label2.setBounds(150,190,375,30);
            add(label2);

            textField2 = new JTextField(16);// Limit to 16 characters
            textField2.setBounds(325,190,230,30);
            textField2.setFont(new Font("Arial",Font.BOLD,14));
            add(textField2);

            textField2.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if(!Character.isDigit(c)){// Allow only digits 1-9
                        e.consume();		 // Ignore the input
                    }
                }
            });

            label3 = new JLabel("PIN:");
            label3.setForeground(Color.WHITE);
            label3.setFont(new Font("Ralway",Font.BOLD,28));
            label3.setBounds(150,250,375,30);
            add(label3);

            passwordField3 = new JPasswordField(16);// Limit to 16 characters
            passwordField3.setBounds(325,250,230,30);
            passwordField3.setFont(new Font("Arial",Font.BOLD,14));
            add(passwordField3);

            passwordField3.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    String text = passwordField3.getText();

                    if (!Character.isDigit(c)) {
                        e.consume();
                        return;
                    }
                    if (text.length() >= 4) {
                        e.consume();
                    }
                  }
                });

            button1 = new JButton("SIGN IN");
            button1.setFont(new Font("Arial",Font.BOLD,14));
            button1.setBackground(Color.BLACK);
            button1.setForeground(Color.WHITE);
            button1.setBounds(300,300,100,30);
            button1.addActionListener(this);
            add(button1);

            button2 = new JButton("CLEAR");
            button2.setFont(new Font("Arial",Font.BOLD,14));
            button2.setBackground(Color.BLACK);
            button2.setForeground(Color.WHITE);
            button2.setBounds(430,300,100,30);
            button2.addActionListener(this);
            add(button2);

            button3 = new JButton("SIGN UP");
            button3.setFont(new Font("Arial",Font.BOLD,14));
            button3.setBackground(Color.BLACK);
            button3.setForeground(Color.WHITE);
            button3.setBounds(300,350,250,30);
            button3.addActionListener(this);
            add(button3);

            ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
            Image iii2 = iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
            ImageIcon iii3 = new ImageIcon(iii2);
            JLabel iiimage = new JLabel(iii3);
            iiimage.setBounds(0,0,850,480);
            add(iiimage);

            setLayout(null);
            setSize(850, 480);
            setLocation(300,100);
            setUndecorated(true);
            setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            //overwride funcation, ActionEvent store in (e) button
            try{
                if (e.getSource() == button1) {
                    ConnectionHandler con1 = new ConnectionHandler();
                    String cardno = textField2.getText();
                    String pin = passwordField3.getText();
                    String q = "SELECT * FROM login WHERE card_number = '" + cardno + "' AND pin = '" + pin + "'";
                    ResultSet resultSet = con1.Statement.executeQuery(q);

                    if (resultSet.next()) {
                        setVisible(false);
                        new main_class(pin);
                    }else {
                        JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                        passwordField3.setText("");
                    }

                }else if (e.getSource() == button2) {
                    textField2.setText("");
                    passwordField3.setText("");

                }else if (e.getSource() == button3) {
                    new signup();
                    setVisible(false);
                }

            }catch(Exception E){
                E.printStackTrace();
            }

        }

        public static void main(String[] args) {
            new Login();
        }
    }
