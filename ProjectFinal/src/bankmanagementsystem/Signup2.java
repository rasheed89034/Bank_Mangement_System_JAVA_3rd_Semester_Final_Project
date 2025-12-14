package bankmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    JTextField textPan,textAadhar;
    JRadioButton r1,r2, e1,e2;
    JButton next;

    String formNumber;
    Signup2(String first){
        super("APPLICATION FORM");

        //------------------------------------------------First we need an image ----------------------------------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        //--------------------------------------------------------reference of instance variable-----------------------------------------
        this.formNumber = first;

        JLabel l1 = new JLabel("Page 2 :- ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,30,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(300,60,600,40);
        add(l2);

        JLabel l3 = new JLabel("Religion : ");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,120,100,30);
        add(l3);
        //--------------------------------------------------------Combo Box-----------------------------------------
        String religion [] = {"Muslim","Sikh","Hindu","Christian","Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(162, 252, 246));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(350,120,320,30);
        add(comboBox);


        JLabel l4 = new JLabel("Category : ");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100,170,100,30);
        add(l4);
        String category [] = {"General","OBC","SC","ST","Other"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBounds(350,170,320,30);
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBackground(new Color(162, 252, 246));
        add(comboBox2);


        JLabel l5 = new JLabel("Income : ");
        l5.setBounds(100,220,100,30);
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        add(l5);
        String income [] = {"Null","Rs : <150,000","Rs : <250,000","Rs : 500,000","Upto Rs : 1,000,000","Above Rs : 1,000,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350,220,320,30);
        comboBox3.setBackground(new Color(162,252,246));
        add(comboBox3);

        JLabel l6 = new JLabel("Education : ");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(100,270,150,30);
        add(l6);
        String education[] = {"Under-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        comboBox4 = new JComboBox(education);
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350,270,320,30);
        comboBox4.setBackground(new Color(162,252,246));
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation : ");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l7.setBounds(100,320,150,30);
        add(l7);
        String occupation[] = {"Salaried","Self_Employed","Business-Man","Student","Retired","Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(350,320,320,30);
        comboBox5.setBackground(new Color(162,252,246));
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number : ");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,370,150,30);
        add(l8);
        textPan = new JTextField("");
        textPan.setFont(new Font("Raleway",Font.BOLD,18));
        textPan.setBounds(350,370,320,30);
        add(textPan);

        JLabel l9 = new JLabel("Aadhar Number : ");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(100,420,180,30);
        add(l9);
        textAadhar = new JTextField("");
        textAadhar.setFont(new Font("Raleway",Font.BOLD,18));
        textAadhar.setBounds(350,420,320,30);
        add(textAadhar);

        JLabel l10 = new JLabel("Senior Citizen : ");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100,470,180,30);
        add(l10);
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBounds(350,470,100,30);
        add(r1);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBounds(620,470,100,30);
        add(r2);


        JLabel l11 = new JLabel("Existing Account : ");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,520,180,30);
        add(l11);
        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway",Font.BOLD,14));
        e1.setBounds(350,520,100,30);
        add(e1);
        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway",Font.BOLD,14));
        e2.setBounds(620,520,100,30);
        add(e2);

        //---------------------------------------------------------------To Select one at a time----------------------------------------------
        ButtonGroup buttonGroup1 = new ButtonGroup();
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        JLabel l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Raleway",Font.BOLD,18));
        l12.setBounds(650,10,100,30);
        add(l12);
        JLabel l13 = new JLabel(formNumber);
        l13.setFont(new Font("Raleway",Font.BOLD,18));
        l13.setBounds(760,10,60,30);
        add(l13);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);



        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        //------------------------------------------------getContentPane use for set color----------------------------------------------------
        getContentPane().setBackground(new Color(162, 252, 246));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //---------------------------------------------------------Start getting all values from the Frame------------------------------------------------------
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = textPan.getText();
        String adhar = textAadhar.getText();

        String scitizen = null;
        if((r1.isSelected())){
            scitizen = "Yes";
        } else if ((r2.isSelected())) {
            scitizen = "No";
        }

        String eaccount = null;
        if((e1.isSelected())){
            eaccount = "Yes";
        } else if ((e2.isSelected())) {
            eaccount = "No";
        }

        //---------------------------------------------------------End of all values from the Frame------------------------------------------------------

        //---------------------------------------------------------Now Store in the database table ------------------------------------------------------
        try {
            if(textPan.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the field");
            }else{
                Con c1 = new Con();
                String q = "insert into signuptwo values(' "+formNumber+" ' , ' "+rel+" ' , ' "+cate+" ' , ' "+inc+" ' , ' "+edu+" ' , ' "+occ+" ' , ' "+pan+" ' , ' "+adhar+" ' , ' "+scitizen+" ' , ' "+eaccount+" ')";
                c1.statement.executeUpdate(q);
                c1.connection.close();

                new Signup3(formNumber);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Signup2("");

    }
}

