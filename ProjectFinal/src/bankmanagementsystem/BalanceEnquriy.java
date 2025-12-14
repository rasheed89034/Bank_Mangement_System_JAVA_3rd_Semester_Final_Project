package bankmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {
    String pin;
    JLabel label2;
    JButton b1;
    BalanceEnquriy(String pin){
        this.pin = pin;
        System.out.println("Troubleshooting: Pin passed to BalanceEnquiry is: " + this.pin);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,30,1550,830);
        add(l3);
        JLabel label1 = new JLabel("YOUR CURRENT BALANCE IS Rs");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,14));
        label1.setBounds(430,180,500,35);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(430,220,400,35);
        l3.add(label2);

        b1 = new JButton("Back");
        b1.setBounds(700,406,150,35);
        b1.setBackground(new Color(4, 98, 76));
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        int balance = 0;
        try{
            Con c = new Con();

            // calling the MySQL function we created
            // verify if your pin needs spaces like '" + pin + "' or just '" + pin + "'"
//            String query = "SELECT calculate_balance('" + pin + "') AS current_balance";
            // We add '%' wildcards to match the PIN even if there are spaces in the DB
            String query = "SELECT calculate_balance('%" + pin + "%') AS current_balance";

            ResultSet resultSet = c.statement.executeQuery(query);

            // We only expect one result now, so we use 'if' instead of 'while'
            if (resultSet.next()) {
                balance = resultSet.getInt("current_balance");
            }


//            Con c = new Con();
//            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = ' "+pin+" ' ");
//            while (resultSet.next()){
//                if(resultSet.getString("type").equals("Deposit")){
//                    balance += Integer.parseInt(resultSet.getString("amount").replace(" ", ""));
//                }else{
//                    balance -= Integer.parseInt(resultSet.getString("amount").replace(" ", ""));
//                }
//            }

        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Main_Class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}

