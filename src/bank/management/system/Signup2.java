package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textPan,textAadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;

    String formno;
    Signup2(String formno){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 5, 100, 100);
        add(image);

        this.formno = formno;

        JLabel label1 = new JLabel("Page NO : 2");
        label1.setFont(new Font("Ralway",Font.BOLD,22));
        label1.setBounds(300, 30, 600, 40);
        add(label1);

        JLabel label2 = new JLabel("Additonal Details :");
        label2.setFont(new Font("Ralway",Font.BOLD,22));
        label2.setBounds(300, 60, 600, 40);
        add(label2);

        JLabel label3 = new JLabel("Religion :");
        label3.setFont(new Font("Ralway",Font.BOLD,18));
        label3.setBounds(100, 120, 100, 30);
        add(label3);

        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(230, 240, 255));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);

        JLabel label4 = new JLabel("Category :");
        label4.setFont(new Font("Ralway",Font.BOLD,18));
        label4.setBounds(100, 170, 100, 30);
        add(label4);

        String Category [] = {"General","OBC","SC","ST","Other"};
        comboBox2 = new JComboBox(Category);
        comboBox2.setBackground(new Color(230, 240, 255));
        comboBox2.setBounds(350,170,320,30);
        add(comboBox2);

        JLabel label5 = new JLabel("Income :");
        label5.setFont(new Font("Ralway",Font.BOLD,18));
        label5.setBounds(100, 220, 100, 30);
        add(label5);

        String income [] = {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000",};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(230, 240, 255));
        comboBox3.setBounds(350,220,320,30);
        add(comboBox3);

        JLabel label6 = new JLabel("Educational :");
        label6.setFont(new Font("Ralway",Font.BOLD,18));
        label6.setBounds(100, 270, 150, 30);
        add(label6);

        String educational [] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others",};
        comboBox4 = new JComboBox(educational);
        comboBox4.setBackground(new Color(230, 240, 255));
        comboBox4.setBounds(350,270,320,30);
        add(comboBox4);

        JLabel label7 = new JLabel("Occupation :");
        label7.setFont(new Font("Ralway",Font.BOLD,18));
        label7.setBounds(100, 320, 150, 30);
        add(label7);

        String occupation [] = {"Salaried","Self-Employed","Business","Student","Others",};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(new Color(230, 240, 255));
        comboBox5.setBounds(350,320,320,30);
        add(comboBox5);

        											//A valid PAN number is 10 characters long. 
        JLabel label8 = new JLabel("PAN Number :");//2.It follows the pattern: 5 letters, 4 digits, 1 letter "ABCDE1234F"
        label8.setFont(new Font("Ralway",Font.BOLD,18));
        label8.setBounds(100, 370, 150, 30);
        add(label8);						

        textPan = new JTextField(10);
        textPan.setFont(new Font("Ralway",Font.BOLD,18));
        textPan.setBounds(350, 370, 320, 30);
        add(textPan);
        
        textPan.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = textPan.getText();

                if (text.length() >= 10) {
                    e.consume(); // limit to 10 characters
                    return;
                }

                int pos = text.length();
                if (pos < 5) {
                    // First 5 must be uppercase letters
                    if (!Character.isLetter(c) || !Character.isUpperCase(c)) {
                        e.consume();
                    }
                } else if (pos < 9) {
                    // Next 4 must be digits
                    if (!Character.isDigit(c)) {
                        e.consume();
                    }
                } else {
                    // Last character must be a letter (usually uppercase)
                    if (!Character.isLetter(c) || !Character.isUpperCase(c)) {
                        e.consume();
                    }
                }
            }
        });
        

        JLabel label9 = new JLabel("Adhar Number :");  //It must be 12 digits long. Only numeric digits (0–9) are allowed
        label9.setFont(new Font("Ralway",Font.BOLD,18));
        label9.setBounds(100, 420, 180, 30);
        add(label9);

        textAadhar = new JTextField(14);
        textAadhar.setFont(new Font("Ralway",Font.BOLD,18));
        textAadhar.setBounds(350, 420, 320, 30);
        add(textAadhar);

        textAadhar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = textAadhar.getText();
                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
             // Limit length to 12 digits
                if (text.length() >= 12) {
                    e.consume();
                }
            }
        });

        JLabel label10 = new JLabel("Senior Scitizen :");
        label10.setFont(new Font("Ralway",Font.BOLD,18));
        label10.setBounds(100, 470, 180, 30);
        add(label10);

        r1 = new JRadioButton("yes");
        r1.setFont(new Font("Ralway",Font.BOLD,14));
        r1.setBackground(new Color(230, 240, 255));
        r1.setBounds(350,470,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Ralway",Font.BOLD,14));
        r2.setBackground(new Color(230, 240, 255));
        r2.setBounds(460,470,100,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel label11 = new JLabel("Existing Account :");
        label11.setFont(new Font("Ralway",Font.BOLD,18));
        label11.setBounds(100, 520, 180, 30);
        add(label11);

        e1 = new JRadioButton("yes");
        e1.setFont(new Font("Ralway",Font.BOLD,14));
        e1.setBackground(new Color(230, 240, 255));
        e1.setBounds(350,520,100,30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Ralway",Font.BOLD,14));
        e2.setBackground(new Color(230, 240, 255));
        e2.setBounds(460,520,100,30);
        add(e2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        JLabel label12 = new JLabel("Form No:- ");
        label12.setFont(new Font("Ralway",Font.BOLD,18));
        label12.setBounds(620, 20, 100, 30);
        add(label12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Ralway",Font.BOLD,18));
        l13.setBounds(720,20,100,30);
        add(l13);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570,600,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,830);
        setLocation(400,0);
        setUndecorated(true);
        getContentPane().setBackground(new Color(230, 240, 255));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String Pan = textPan.getText();
        String adhar = textAadhar.getText();

        String Scitizen = null;
        if (r1.isSelected()) {
            Scitizen = "Yes";
        } else if (r2.isSelected()) {
            Scitizen = "No";
        }
        String eAccount = null;
        if (e1.isSelected()) {
            eAccount = "Yes";
        } else if (e2.isSelected()) {
            eAccount = "No";
        }

        try {
            if (textPan.getText().equals("") || textAadhar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhar Number! It must be 12 digits.");
            } else{
          }

            ConnectionHandler con1 = new ConnectionHandler();
            String q = "INSERT INTO signuptwo values('" + formno + "','" + rel + "','" + cate + "','" + inc + "','" + edu + "','" + occ + "','" + Pan + "','" + adhar + "','" + Scitizen + "','" + eAccount + "')";
            con1.Statement.executeUpdate(q);
            
            new Signup3(formno);
            setVisible(false);

            System.out.println("Data inserted successfully!");

        } catch (Exception E) {
            E.printStackTrace();
       }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}