package bankmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    Main_Class(String pin){
        //---------------------------------------------------------this "Pin" came from login page, and we get here---------------------------------------------------------
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0,30,1550,830);
        add(l4);

        JLabel label = new JLabel("PLZ select your Transaction");
        label.setBounds(430,180,700,35);
        label.setForeground(Color.white);
        label.setFont(new Font("System",Font.BOLD,28));
        l4.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.white);
        b1.setBackground(new Color(4, 98, 76));
        b1.setBounds(410,274,150,35);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        l4.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setForeground(Color.white);
        b2.setBackground(new Color(4, 98, 76));
        b2.setBounds(670,274,180,35);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        l4.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.white);
        b3.setBackground(new Color(4, 98, 76));
        b3.setBounds(410,318,150,35);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.addActionListener(this);
        l4.add(b3);


        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.white);
        b4.setBackground(new Color(4, 98, 76));
        b4.setBounds(670,318,180,35);
        b4.setOpaque(true);
        b4.setBorderPainted(false);
        b4.addActionListener(this);
        l4.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.white);
        b5.setBackground(new Color(4, 98, 76));
        b5.setBounds(410,362,150,35);
        b5.setOpaque(true);
        b5.setBorderPainted(false);
        b5.addActionListener(this);
        l4.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.white);
        b6.setBackground(new Color(4, 98, 76));
        b6.setBounds(670,362,180,35);
        b6.setOpaque(true);
        b6.setBorderPainted(false);
        b6.addActionListener(this);
        l4.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.white);
        b7.setBackground(new Color(4, 98, 76));
        b7.setBounds(670,406,180,35);
        b7.setOpaque(true);
        b7.setBorderPainted(false);
        b7.addActionListener(this);
        l4.add(b7);




        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            //---------------------------------------------------------if a person want to deposit amount so the person must be in his/her account ---------------------------------------------------------
            new Deposit(pin);
            setVisible(false);
        }
        else if (e.getSource() == b7) {
            //-----------------------------------To close all the program ------------------ with set visible(false) only frame will close--------------
            System.exit(0);
        }
        else if (e.getSource() == b2) {
            new Withdrawl(pin);
            setVisible(false);
        }
        else if (e.getSource()==b6) {
            setVisible(false);
            new BalanceEnquriy(pin);
        }
        else if (e.getSource() ==b3) {
            new FastCash(pin);
            setVisible(false);
        }
        else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);
        } else if (e.getSource() == b4) {
            new Mini(pin);
        }
    }

    public static void main(String[] args) {
        new Main_Class("");
    }
}

