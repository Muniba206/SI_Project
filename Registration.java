import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author TalhaMahmoodSheikh
 */
public class Registration extends JFrame implements ActionListener {
     JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField tf1, tf2, tf5, tf6, tf7, tf8;
    JButton btn1, btn2;
    JPasswordField p3, p4;
 
    Registration()
     {
        setVisible(true);
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration Form in Java");
 
        l1 = new JLabel("Employee Registration Form");
        l1.setForeground(Color.black);
        l1.setFont(new Font("Cambria", Font.BOLD, 20));
 
        l2 = new JLabel("Name:");
        l3 = new JLabel("Email:");
        l4 = new JLabel("Passowrd:");
        l5 = new JLabel("Confirm Password:");
        l6 = new JLabel("Age:");
        l7 = new JLabel("Institution:");
        l8 = new JLabel("Phone No:"); 
        l9 = new JLabel ("Position");
        tf1 = new JTextField();
        tf2 = new JTextField();
        p3 = new JPasswordField();
        p4 = new JPasswordField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
 
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
 
        btn1.addActionListener(this);
        btn2.addActionListener(this);
 
        l1.setBounds(120, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        l9.setBounds (80, 350, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p3.setBounds(300, 150, 200, 30);
        p4.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        tf8.setBounds(300,350,200,30);
        btn1.setBounds(50, 390, 100, 30);
        btn2.setBounds(170, 390, 100, 30);
 
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p3);
        add(l5);
        add(p4);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(l9);
        add(tf8);
        add(btn1);
        add(btn2);
    }
 
    public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == btn1)
         {
            int x = 0;
            String s1 = tf1.getText();
            String s2 = tf2.getText();
 
            char[] s3 = p3.getPassword();
            char[] s4 = p4.getPassword(); 
            String s9 = new String(s3);
            String s10 = new String(s4);
 
            String s5 = tf5.getText();
            String s6 = tf6.getText();
            String s7 = tf7.getText();
            String s8 = tf8.getText();
            if (s9.equals(s10))
           {
                try
               {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Employees","root","MUNIBA");
                    System.out.println("Succesfully connected to Database");
                    Statement stmt = con.createStatement();
                   /* String sql = "CREATE DATABASE Employees";
                    stmt.executeUpdate(sql);
                    System.out.println("Database created successfully...");*/
                   /* String sql1 = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " Name VARCHAR(255), " + 
                   " Email VARCHAR(255), " + 
                   " Password VARCHAR(255), " + 
                   "Age INT(14)," +
                   "Institution VARCHAR(255),"+
                   "Phone INT (20)," +
                            "Position VARCHAR(255),"+
                   " PRIMARY KEY ( id ))"; 
                    stmt.executeUpdate(sql1);*/
                    PreparedStatement ps = con.prepareStatement("insert into REGISTRATION values(?,?,?,?,?,?,?)");
                    //String sql2= "Insert into REGISTRATION values(?,?,?,?,?,?,?)";
                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setString(3, s9);
                    ps.setString(4, s5);
                    ps.setString(5, s6);
                    ps.setString(6, s7);
                    ps.setString(7, s8);
                    ResultSet rs = ps.executeQuery();
                    x++;
                    if (x > 0) 
                    {
                        JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
                    }
                }
          catch (Exception ex) 
                {
                    System.out.println(ex);
                }
            }
          else
           {
                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
            } 
        } 
          else
       {
            tf1.setText("");
            tf2.setText("");
            p3.setText("");
            p4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            tf8.setText("");
        }
    } 
    public static void main(String args[])
   {
        new Registration();
    }
}
    

