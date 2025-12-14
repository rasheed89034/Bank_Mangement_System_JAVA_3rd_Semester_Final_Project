package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    JButton button;
    String pin;
    Mini(String pin){
        this.pin = pin;


        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

//
//        JLabel label1 = new JLabel();
//        label1.setBounds(20,140,400,200);
//        add(label1);

        JLabel label2 = new JLabel("Coding Mind244");
        label2.setFont(new Font("System",Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        // --- SCROLL PANE SETUP ---
        JLabel label1 = new JLabel(); // Transaction History Label
        label1.setVerticalAlignment(JLabel.TOP); // Ensure text starts at the top

        // Create a ScrollPane and put label1 inside it
        JScrollPane scroll = new JScrollPane(label1);
        scroll.setBounds(20, 140, 400, 200); // Set position of the SCROLL PANE, not the label
        scroll.getViewport().setBackground(new Color(255, 204, 204)); // Match background color
        scroll.setBorder(null); // Optional: Remove border for cleaner look
        add(scroll);
        // -------------------------

        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin LIKE '%" + pin + "%'");
            while (resultSet.next()){
                String card = resultSet.getString("card_number");
                if (card.length() >= 16) {
                    label3.setText("Card Number: " + card.substring(0, 4) + "XXXXXXXX" + card.substring(12));
                } else {
                    label3.setText("Card Number: " + card);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        Con c = new Con();
        try{
            int balance = 0;

//            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin LIKE '%" + pin + "%'");
//            StringBuilder historyText = new StringBuilder("<html>");
//            while (resultSet.next()) {
////                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br></html>");
//                historyText.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
//                        .append(resultSet.getString("date"))
//                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
//                        .append(resultSet.getString("type"))
//                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
//                        .append(resultSet.getString("amount"))
//                        .append("<br><br>");
//                if (resultSet.getString("type").equals("Deposit")) {
//                    balance += Integer.parseInt(resultSet.getString("amount").replace(" ", ""));
//                } else {
//                    balance -= Integer.parseInt(resultSet.getString("amount").replace(" ", ""));
//                }
//            }
//            // FIX: Close HTML tag OUTSIDE the loop
//            historyText.append("</html>");

            // CALL the procedure instead of writing a raw SELECT query
            ResultSet resultSet = c.statement.executeQuery("CALL get_mini_statement('%" + pin + "%')");

            StringBuilder historyText = new StringBuilder("<html>");

//          What it does: It adds a specific HTML entity repeated 5 times.
//          Meaning: &nbsp; stands for Non-Breaking Space.
//          Why use this? In Java Swing components (like JLabel), if you enable HTML formatting, standard spaces ( ) are often collapsed or ignored.
//          Using &nbsp; forces the text to have a fixed visual gap (padding) between the Date and the next column.

            while (resultSet.next()) {
                historyText.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(resultSet.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(resultSet.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(resultSet.getString("amount"))
                        .append("<br><br>");
            }
            historyText.append("</html>");

            label1.setText(historyText.toString());

            // Set the final text to the label
            label1.setText(historyText.toString());


            label4.setText("Your total balance is Rs = "+balance);

        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            ResultSet resultSet = c.statement.executeQuery("SELECT calculate_balance('%" + pin + "%') AS current_balance");
            if (resultSet.next()) {
                int balance = resultSet.getInt("current_balance");
                label4.setText("Your total balance is Rs = " + balance);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20, 500, 100, 30);
        button.addActionListener(this); // FIX: Add the action listener so the button actually works
        add(button);



        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }

    public static void main(String[] args) {
        new Mini("");
    }
}
