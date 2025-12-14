package bankmanagementsystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {
    JTextField textName , textFName,textEmail , textAdd, textCity,textPin,textState;
    JDateChooser dateChooser;

    // JradioButtons------------------------------------------------------------------------------------------------------
    JRadioButton r1,r2,m1,m2,m3;

    JButton next;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) +1000L;
    String first = " " + Math.abs(first4);

    String formNumber;



    SignUp(){

        super("APPLICATION FOEM");
        this.formNumber = first;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel lable1 = new JLabel("APPLICATION FORM NO : "+first);
        lable1.setBounds(160,20,700,40);
        lable1.setFont(new Font("Raleway",Font.BOLD,38));
        add(lable1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Arial",Font.BOLD,22));
        label2.setBounds(330,70,600,30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details ");
        label3.setBounds(290,90,600,30);
        label3.setFont(new Font("Arial",Font.BOLD,22));
        add(label3);

        // Form Lables --------------------------------------------------------------------------------------------------------------------
        JLabel labelName = new JLabel("Name : ");
        labelName.setBounds(100,190,100,30);
        labelName.setFont(new Font("Arial",Font.BOLD,22));
        add(labelName);
        textName = new JTextField();
        textName.setBounds(300,190,400,30);
        textName.setFont(new Font("Arial",Font.BOLD,14));
        add(textName);

        JLabel labelFName = new JLabel("Father's Name : ");
        labelFName.setBounds(100,240,200,30);
        labelFName.setFont(new Font("Raleway",Font.BOLD,22));
        add(labelFName);
        textFName = new JTextField();
        textFName.setBounds(300,240,400,30);
        textFName.setFont(new Font("Raleway",Font.BOLD,14));
        add(textFName);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(100,290,200,30);
        labelGender.setFont(new Font("Arial",Font.BOLD,22));
        add(labelGender);
        r1 =new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBounds(300,290,100,30);
//        r1.setBackground(new Color(222,255,228));
        add(r1);
        r2 =new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
//        r2.setBackground(new Color(222,255,228));
        r2.setBounds(450,290,100,30);
        add(r2);
        // for selection only one radio Button use Button Group class-------------------------------------------------------------------------
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);


        // Jar file is must for adding calander------------------------------------------------------------------------------------------------------
        JLabel DOB = new JLabel("Date Of Birth : ");
        DOB.setBounds(100,340,200,30);
        DOB.setFont(new Font("Arial",Font.BOLD,22));
        add(DOB);
        // For Calander use JDateChooser------------------------------------------------------------------------------------------------------
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);

        JLabel labelEmail = new JLabel("Email Address : ");
        labelEmail.setBounds(100,390,200,30);
        labelEmail.setFont(new Font("Raleway",Font.BOLD,22));
        add(labelEmail);
        textEmail = new JTextField();
        textEmail.setBounds(300,390,400,30);
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        add(textEmail);

        JLabel labelMs = new JLabel("Martial Status : ");
        labelMs.setBounds(100,440,200,30);
        labelMs.setFont(new Font("Raleway",Font.BOLD,22));
        add(labelMs);
        m1 = new JRadioButton("Married  ");
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBounds(300,440,100,30);
        add(m1);
        m2 =new JRadioButton("Unmarried  ");
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBounds(450,440,150,30);
        add(m2);
        m3 =new JRadioButton("Other  ");
        m3.setFont(new Font("Raleway",Font.BOLD,14));
        m3.setBounds(620,440,150,30);
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        JLabel labelAdd = new JLabel("Address : ");
        labelAdd.setBounds(100,490,200,30);
        labelAdd.setFont(new Font("Raleway",Font.BOLD,22));
        add(labelAdd);
        textAdd = new JTextField();
        textAdd.setBounds(300,490,400,30);
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        add(textAdd);

        JLabel labelCity = new JLabel("City : ");
        labelCity.setBounds(100,540,200,30);
        labelCity.setFont(new Font("Raleway",Font.BOLD,22));
        add(labelCity);
        textCity = new JTextField();
        textCity.setBounds(300,540,400,30);
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        add(textCity);

        JLabel labelPin = new JLabel("Pin Code : ");
        labelPin.setBounds(100,590,200,30);
        labelPin.setFont(new Font("Raleway",Font.BOLD,22));
        add(labelPin);
        textPin = new JTextField();
        textPin.setBounds(300,590,400,30);
        textPin.setFont(new Font("Raleway",Font.BOLD,14));
        add(textPin);

        JLabel labelState = new JLabel("State : ");
        labelState.setBounds(100,640,200,30);
        labelState.setFont(new Font("Raleway",Font.BOLD,22));
        add(labelState);
        textState = new JTextField();
        textState.setBounds(300,640,400,30);
        textState.setFont(new Font("Raleway",Font.BOLD,14));
        add(textState);

        next = new JButton("Next ");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(255,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }

    //-------------------------------------------------------------------------------------To Store Data through Next Button------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        //-------------------------------------------------------------------------------------First Define All The Variables----------------------------------------------------
        String formNumber = first;
        String name = textName.getText();
        String fName = textFName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        //-------------------------------------------------------------------------------------Condition for Male/Female----------------------------------------------------
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }
        String email = textEmail.getText();
        //--------------------------------------------------------------------------------------Condition for Marital Status----------------------------------------------------
        String marital = null;
        if (m1.isSelected()) {
            marital = "Married";
        } else if (m2.isSelected()) {
            marital = "Unmarried";
        } else if (m3.isSelected()) {
            marital = "Other";
        }

        String address = textAdd.getText();
        String city = textCity.getText();
        String pinCode = textPin.getText();
        String state = textState.getText();

        try {
            //--------------------------------------------------------------------------------------If Name is Null then we will get the below Exception----------------------------------------------------
            if (textName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill All The Fields");
            } else {
                //--------------------------------------------------------------------------------------Create an object of "Con" class ----------------------------------------------------
                Con con1 = new Con();
                String q = "insert into signup values(' "+ formNumber+ " ' , ' "+name+" ' , ' "+fName+ " ' , ' "+dob+" ' , ' "+gender+" ' , ' "+email+" ' , ' "+marital+" ' , ' "+address+" ' , ' "+city+" ' , ' "+pinCode+" ' , ' "+state+" ')";

                //-----------------------------------------------------------------------To Store data in the data base use executeUpdate() Method----------------------------------------------------
                con1.statement.executeUpdate(q);
                con1.connection.close();

                new Signup2(first);
                setVisible(false);
//                new Signup2();
//                setVisible(false);


//--------------------------------------------------------------------------------------Both Method Have THe Same Work----------------------------------------------------------------


/*                String q = "INSERT INTO signup (Form_no, Name, Father_Name, DOB, Gender, Email, Marital_status, Address, City, Pincode, State) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement ps = con1.connection.prepareStatement(q);

                ps.setString(1, formNumber.trim());
                ps.setString(2, name);
                ps.setString(3, fName);
                ps.setString(4, dob);
                ps.setString(5, gender);
                ps.setString(6, email);
                ps.setString(7, marital);
                ps.setString(8, address);
                ps.setString(9, city);
                ps.setString(10, pinCode);

                // ... (remaining 9 setString calls)
                ps.setString(11, state);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully! Rows affected: " + rowsAffected);
                } else {
                    System.out.println("No rows affected. Insertion failed silently.");
                }

                ps.close();
                con1.connection.close();

                new Signup2();
                setVisible(false);*/


            }
        } catch (Exception E) {
//            E.printStackTrace();
            JOptionPane.showMessageDialog(null, "DATABASE ERROR: Data was NOT saved.");
        }
    }

        public static void main(String[] args) {
            new SignUp();
    }
}
