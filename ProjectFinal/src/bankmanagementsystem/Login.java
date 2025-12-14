package bankmanagementsystem;

//----------------------------For GUI------
import javax.swing.*;
import java.awt.*;
//------------------------------To perform some actions or event on something(buttons) etc.------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//------------------------- For MySQL DataBase---------------
import java.sql.ResultSet;

//------------------------------JFrame Buildup class use for to retrive JButtons Fields etc. & ActionListener is an interface we implement in our class for
// to perform an action on a specific button-------------------
public class Login extends JFrame implements ActionListener {
    // declear golbal to access anywhere------------------------------------------------------------------------------------------------------
    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;

    Login(){
        // should be right here not below setsize or other.------------------------------------------------------------------------------------------------------
        super("Bank Managment System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        // We cannot use ImageIcon class on our frame that's why we convert into JLable to use on our frame------------------------------------------------------------------------------------------------------
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("Icons/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        // use for to set position------------------------------------------------------------------------------------------------------
        iimage.setBounds(630,350,100,100);
        add(iimage);

        // jlabel main work is to show some text on frame------------------------------------------------------------------------------------------------------
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Time Roman",Font.BOLD,38));
        // this is only for to set something according to frame
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No : ");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setFont(new Font("Time Roman",Font.BOLD,14));
        textField2.setBounds(325,190,230,30);
        add(textField2);


        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setBounds(150,250,375,30);
        label3.setForeground(Color.WHITE);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Time Roman",Font.BOLD,14));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.black);
//        button1.setBackground(Color.black);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setBackground(Color.black);
        button2.setBounds(430,300,100,30);
        button2.setFont(new Font("Arial",Font.BOLD,14));
        //-----Default abstract method which declared in ActionListener--------------------------
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setBounds(300,350,250,30);
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setBackground(new Color(0,0,0));
        button3.setForeground(Color.black); // Make text visible
        button3.addActionListener(this);
        add(button3);


        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("Icons/mainBackGround.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        // use for to set position------------------------------------------------------------------------------------------------------
        iiimage.setBounds(0,0,850,480);
        add(iiimage);




        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
//        setUndecorated(true);
        setVisible(true);


    }

    @Override
    // ActionEvent is use for to whenever we click on a button so that action is store in the ActionEvent and the small "e" knows about all actions or buttons which you used in your project
    // Note for this ActionPerformed we already import the "ActionListener" library and implement over login class and outside class we override the function otherwise it will throw an error
    public void actionPerformed(ActionEvent e) {
        // here we have to try catch block because error can be occure
        try{
            // Now here use multiple conditions for buttons
            // e will tell that on which button the user click with the help of getSource() method
            if(e.getSource() == button1){
                //---------------------------------------------------------to check the authorization ---------------------------------------------------------
                Con c = new Con();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                //---------------------------------------------------------to compare cardNumber and pin with stored carNumber and pin---------------------------------------------------------
                //-------------card_number and pin is actually the columns of our database----------------
                String q = "select * from login where card_number LIKE '%" + cardno + "%' and pin LIKE '%" + pin + "%'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    setVisible(false);
                    new Main_Class(pin);
                }
                else {
                    JOptionPane.showConfirmDialog(null,"Invild Card_number or PIN");
                }
            }
            else if (e.getSource() == button2) {
                textField2.setText("");
                passwordField3.setText("");
            }
            else if (e.getSource() == button3) {
                new SignUp();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Login();

    }
}


