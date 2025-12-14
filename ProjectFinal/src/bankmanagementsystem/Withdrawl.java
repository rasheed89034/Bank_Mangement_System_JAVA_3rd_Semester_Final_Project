package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    Withdrawl(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,30,1550,830);
        add(l3);
        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL AMOUNT IS : Rs = 10000");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,14));
        label1.setBounds(460,180,500,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLZ ENTER YOUR AMOUNT");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);

        textField = new TextField();
        textField.setBackground(new Color(4, 98, 76));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("Withdrawal");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(4, 98, 76));
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(4, 98, 76));
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l3.add(b2);









        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showConfirmDialog(null, "Plz enter the amount you want to withdrawal");
                } else {
                    Con c = new Con();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = ' " +pin.replace(" ", "")+ " ' ");

                    int balance = 0;
                    while (resultSet.next()) {
                        //------------------------------------------------ if type = to Deposit then balance will add else balance will deduct from account------------------------------------------------------------
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount").replace(" ", ""));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount").replace(" ", ""));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showConfirmDialog(null, "Insufficient Balance");
                        return;
                    }
                    //------------------------------------------------ amount (user want to withdrawal)------------------------------------------------------------
                    c.statement.executeUpdate("insert into bank values (' " + pin + " ', ' " +date+ " ' , 'Withdrawal' , ' " +amount+ " ')");
                    JOptionPane.showConfirmDialog(null, "Rs = " +amount+ " Debited Successfully");
                    setVisible(false);
                    new Main_Class(pin);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
            new Main_Class(pin);
        }

    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}

