package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1, b2;
    JPasswordField p1, p2;
    String pin;

    Pin(String pin) {
        // We trim here to make sure the NEW pin we send is clean
        this.pin = pin.trim();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 30, 1550, 830);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430, 180, 400, 35);
        l3.add(label1);

        JLabel label2 = new JLabel("NEW PIN : ");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430, 220, 150, 35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(600, 220, 180, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter NEW PIN : ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(430, 250, 400, 35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(600, 255, 180, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(p2);

        b1 = new JButton("CHANGE");
        b1.setBounds(700, 362, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(700, 406, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(1550, 1000);
        setLayout(null);
        setLocation(0, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (e.getSource() == b1) {
                if (p1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                Con c = new Con();

                // ---------------------------------------------------------
                // NEW TRIGGER LOGIC START
                // ---------------------------------------------------------
                // We only update the 'login' table.
                // The MySQL Trigger 'sync_pin_update' will detect this change
                // and automatically update 'bank' and 'signupthree' tables.

                String q2 = "update login set pin = '" + pin1 + "' where pin LIKE '%" + this.pin + "%'";

                int rowCount = c.statement.executeUpdate(q2);

                if (rowCount > 0) {
                    JOptionPane.showMessageDialog(null, "PIN Change Successfully");
                    setVisible(false);
                    // Pass the NEW PIN (pin1) to the main class so they are logged in with the new credentials
                    new Main_Class(pin1);

//                Con c = new Con();
//
//                // IMPORTANT FIX:
//                // We use LIKE '%...%' because your database has hidden spaces (e.g. " 7600 ")
//                // This will find "7600" regardless of spaces around it.
//                String q1 = "update bank set pin = '" + pin1 + "' where pin LIKE '%" + this.pin + "%'";
//                String q2 = "update login set pin = '" + pin1 + "' where pin LIKE '%" + this.pin + "%'";
//                String q3 = "update signupthree set pin = '" + pin1 + "' where pin LIKE '%" + this.pin + "%'";
//
//                c.statement.executeUpdate(q1);
//                c.statement.executeUpdate(q3);
//
//                // We update Login last and check the result
//                int rowCount = c.statement.executeUpdate(q2);
//
//                if (rowCount > 0) {
//                    JOptionPane.showMessageDialog(null, "PIN Change Successfully");
//                    setVisible(false);
//                    new Main_Class(pin1); // Log in with the NEW (clean) PIN
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Old PIN not found. (DB Mismatch)");
                }

            } else if (e.getSource() == b2) {
                new Main_Class(pin);
                setVisible(false);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}