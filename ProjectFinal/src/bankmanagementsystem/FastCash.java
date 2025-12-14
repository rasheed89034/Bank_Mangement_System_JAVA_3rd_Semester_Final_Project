package bankmanagementsystem;


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
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0,30,1550,830);
        add(l4);

        JLabel label = new JLabel("Select Withdrawal Amount");
        label.setBounds(470,180,700,35);
        label.setForeground(Color.white);
        label.setFont(new Font("System",Font.BOLD,23));
        l4.add(label);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.white);
        b1.setBackground(new Color(4, 98, 76));
        b1.setBounds(410,274,150,35);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        l4.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.white);
        b2.setBackground(new Color(4, 98, 76));
        b2.setBounds(670,274,180,35);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        l4.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.white);
        b3.setBackground(new Color(4, 98, 76));
        b3.setBounds(410,318,150,35);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.addActionListener(this);
        l4.add(b3);


        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.white);
        b4.setBackground(new Color(4, 98, 76));
        b4.setBounds(670,318,180,35);
        b4.setOpaque(true);
        b4.setBorderPainted(false);
        b4.addActionListener(this);
        l4.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.white);
        b5.setBackground(new Color(4, 98, 76));
        b5.setBounds(410,362,150,35);
        b5.setOpaque(true);
        b5.setBorderPainted(false);
        b5.addActionListener(this);
        l4.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.white);
        b6.setBackground(new Color(4, 98, 76));
        b6.setBounds(670,362,180,35);
        b6.setOpaque(true);
        b6.setBorderPainted(false);
        b6.addActionListener(this);
        l4.add(b6);

        b7 = new JButton("BACK");
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
        if(e.getSource() == b7){
            setVisible(false);
            new Main_Class(pin);
        }else{
            //---------------------------------.getsource() return an object that's why we use JButton otherwise will give an error and substring we use to remove the "Rs. "------------------------
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Con c = new Con();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = ' " +pin.replace(" ", "")+ " ' ");
                int balance = 0;
                while (resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount").replace(" ", ""));
                    }else{
                        balance -= Integer.parseInt(resultSet.getString("amount").replace(" ", ""));
                    }
                }
                String num = "17";
                if(e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showConfirmDialog(null,"Insufficient Balance");
                    return;
                }

                c.statement.executeUpdate("insert into bank values (' " + pin + " ', ' " +date+ " ' , 'Withdrawal' , ' " +amount+ " ')");
                JOptionPane.showConfirmDialog(null,"Rs. "+amount+" Debited Successfully");

            }catch (Exception E){
                E.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Could not process transaction. Check console for details.");
            }

            setVisible(false);
            new Main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

