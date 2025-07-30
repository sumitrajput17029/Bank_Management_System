package bank.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class signup extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4,r5;
    JButton next;

    JTextField textName , textFname,textEmail,textAdd,textCity,textPincode,textState;

    JDateChooser dateChooser;

   Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    signup() {
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO :"+ first);
        label1.setBounds(160, 35, 600, 40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(350, 70, 600, 40);
        label2.setFont(new Font("Ralway",Font.BOLD,30));
        add(label2);

        JLabel label3 = new JLabel("Personal Details :");
        label3.setBounds(350, 110, 600, 30);
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);

        JLabel labelName = new JLabel("Name : ");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(100,150,100,30);
        add(labelName);

        textName = new JTextField(20);
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,150,400,30);
        add(textName);

        textName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') {
                    e.consume();
                }
            }
        });

        JLabel labelfName = new JLabel("Father's Name : ");
        labelfName.setFont(new Font("Raleway",Font.BOLD,20));
        labelfName.setBounds(100,190,200,30);
        add(labelfName);

        textFname = new JTextField(20);
        textFname.setFont(new Font("Raleway",Font.BOLD,14));
        textFname.setBounds(300,190,400,30);
        add(textFname);

        textFname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') {
                    e.consume();
                }
            }
        });

        JLabel LabelG = new JLabel("Gender :");
        LabelG.setFont(new Font("Raleway",Font.BOLD,20));
        LabelG.setBounds(100,230,200,30);
        add(LabelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(245, 245, 245));
        r1.setBounds(300,230,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(245, 245, 245));
        r2.setBounds(450,230,90,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,270,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,270,400,30);
        add(dateChooser);

        JLabel LabelE = new JLabel("Email Address :");
        LabelE.setFont(new Font("Raleway",Font.BOLD,20));
        LabelE.setBounds(100,325,200,30);
        add(LabelE);

        textEmail = new JTextField(20);
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,325,400,30);
        add(textEmail);

        JLabel LabelMS = new JLabel("Marital Status :");
        LabelMS.setFont(new Font("Raleway",Font.BOLD,20));
        LabelMS.setBounds(100,375,200,30);
        add(LabelMS);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(new Color(245, 245, 245));
        r3.setBounds(300,375,90,30);
        add(r3);

        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(new Color(245, 245, 245));
        r4.setBounds(450,375,100,30);
        add(r4);

        r5= new JRadioButton("Other");
        r5.setFont(new Font("Raleway",Font.BOLD,14));
        r5.setBackground(new Color(245, 245, 245));
        r5.setBounds(630,375,100,30);
        add(r5);

        ButtonGroup buttonMN = new ButtonGroup();
        buttonMN.add(r3);
        buttonMN.add(r4);
        buttonMN.add(r5);

        JLabel LabelAdd = new JLabel("Address :");
        LabelAdd.setFont(new Font("Raleway",Font.BOLD,20));
        LabelAdd.setBounds(100,430,200,30);
        add(LabelAdd);

        textAdd = new JTextField(30);
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,430,400,30);
        add(textAdd);

        textAdd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') {
                    e.consume();
                }
            }
        });

        JLabel LabelCity = new JLabel("City :");
        LabelCity.setFont(new Font("Raleway",Font.BOLD,20));
        LabelCity.setBounds(100,470,200,30);
        add(LabelCity);

        textCity = new JTextField(20);
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,470,400,30);
        add(textCity);

        textCity.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') {
                    e.consume();
                }
            }
        });



        JLabel LabelPin = new JLabel("Pin Code :");
        LabelPin.setFont(new Font("Raleway",Font.BOLD,20));
        LabelPin.setBounds(100,510,200,30);
        add(LabelPin);
       
        textPincode = new JTextField(20);
        textPincode.setFont(new Font("Raleway",Font.BOLD,14));
        textPincode.setBounds(300,510,400,30);
        add(textPincode);

        textPincode.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) ) {
                    e.consume();
                }
            }
        });

        JLabel LabelState = new JLabel("State :");
        LabelState.setFont(new Font("Raleway",Font.BOLD,20));
        LabelState.setBounds(100,550,200,30);
        add(LabelState);

        textState = new JTextField(20);
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        textState.setBounds(300,550,400,30);
        add(textState);

        textState.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') {
                    e.consume();
                }
            }
        });

        next  = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,610,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(null);
        setSize(850, 800);
        setLocation(400, 0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String DOB = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";

        } else if (r2.isSelected()) {
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital = null;
        if (r3.isSelected()) {
            marital = "Married";
        } else if (r4.isSelected()) {
            marital = "Unmarried";

        } else if (r5.isSelected()) {
            marital = "Other";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPincode.getText();
        String state = textState.getText();

        try {
        	String Email = textEmail.getText().trim();
        	
        	 if (email.isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Email field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
             } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                 JOptionPane.showMessageDialog(null, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
             } else {
                 JOptionPane.showMessageDialog(null, "Email submitted: " + email, "Success", JOptionPane.INFORMATION_MESSAGE);
             }
        	 
            if(textName.getText().equals("")||textFname.getText().equals("")){ // fill the data user.
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }else {
                //connection the database or statement execute con1
                ConnectionHandler con1  = new ConnectionHandler();
                String q = "INSERT INTO signup values('" + formno + "','" + name + "','" + fname + "','" + DOB + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                con1.Statement.executeUpdate(q);

                new Signup2(formno);
                setVisible(false);
            }
            System.out.println("Data inserted successfully!");
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signup();
    }
}


