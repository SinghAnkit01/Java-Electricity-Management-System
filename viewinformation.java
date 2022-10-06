import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.sql.ResultSet;
import java.sql.*;

public class viewinformation extends JFrame implements ActionListener {
    JButton cancel;
    String newmeter;
    viewinformation(String newmeter){
        this.newmeter=newmeter;
        System.out.println(newmeter);
        setBounds(300, 50, 850, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250, 0, 500, 40);
        heading.setFont(new Font("Railway",Font.BOLD,20));
        add(heading);

        // name
        JLabel name = new JLabel("Name : ");
        name.setBounds(70, 80, 100, 20);
        name.setFont(new Font("Railway",Font.PLAIN,16));
        add(name);

        JLabel name1 = new JLabel("");
        name1.setBounds(250, 80, 100, 20);
        name1.setFont(new Font("Railway",Font.PLAIN,16));
        add(name1);

        // meter-no
        JLabel meter = new JLabel("Meter-No : ");
        meter.setBounds(70, 140, 100, 20);
        meter.setFont(new Font("Railway",Font.PLAIN,16));
        add(meter);

        JLabel meter1 = new JLabel("");
        meter1.setBounds(250, 140, 100, 20);
        meter1.setFont(new Font("Railway",Font.PLAIN,16));
        add(meter1);

        // address

        JLabel address = new JLabel("Address : ");
        address.setBounds(70, 200, 100, 20);
        address.setFont(new Font("Railway",Font.PLAIN,16));
        add(address);

        JLabel address1 = new JLabel("");
        address1.setBounds(250, 200, 150, 20);
        address1.setFont(new Font("Railway",Font.PLAIN,16));
        add(address1);

        // state

        
        JLabel state = new JLabel("State : ");
        state.setBounds(70, 260, 180, 20);
        state.setFont(new Font("Railway",Font.PLAIN,16));
        add(state);

        JLabel state1 = new JLabel("");
        state1.setBounds(250, 260, 100, 20);
        state1.setFont(new Font("Railway",Font.PLAIN,16));
        add(state1);


        // city

        
        JLabel city = new JLabel("City : ");
        city.setBounds(460, 80, 100, 20);
        city.setFont(new Font("Railway",Font.PLAIN,16));
        add(city);

        JLabel city1 = new JLabel("");
        city1.setBounds(610,80, 100, 20);
        city1.setFont(new Font("Railway",Font.PLAIN,16));
        add(city1);
        
        // email

        JLabel email = new JLabel("EMail-Id : ");
        email.setBounds(460, 140, 100, 20);
        email.setFont(new Font("Railway",Font.PLAIN,16));
        add(email);

        JLabel email1 = new JLabel("");
        email1.setBounds(610,140, 160, 20);
        email1.setFont(new Font("Railway",Font.PLAIN,16));
        add(email1);

        // phone

        JLabel phone = new JLabel("Phone-No : ");
        phone.setBounds(460, 200, 100, 20);
        phone.setFont(new Font("Railway",Font.PLAIN,16));
        add(phone);

        JLabel phone1 = new JLabel("");
        phone1.setBounds(610,200, 100, 20);
        phone1.setFont(new Font("Railway",Font.PLAIN,16));
        add(phone1);
        
        try {
            System.out.println(newmeter);
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+newmeter+"' ") ;
             if(rs.next()) {
                System.out.println("meter-no exist");
            name1.setText(rs.getString("name"));
            meter1.setText(rs.getString("meter_no"));
            address1.setText(rs.getString("address"));
            city1.setText(rs.getString("city"));
            state1.setText(rs.getString("state"));
            email1.setText(rs.getString("email"));
            phone1.setText(rs.getString("phone"));
           }else{
            JOptionPane.showMessageDialog(null, "No records found");
           }
        } catch (Exception e) 
        {
           e.printStackTrace();
        }
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(350, 340, 100, 25);
        add(cancel);

        ImageIcon vcus = new ImageIcon(ClassLoader.getSystemResource("viewcustomer.jpg"));
        Image vcus1 = vcus.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon vcus2 = new ImageIcon(vcus1);
        JLabel image = new JLabel(vcus2);
        image.setBounds(120, 350, 600, 300);
        add(image);




        setVisible(true);
    }

    public static void main(String[] args) {
        new viewinformation("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()== cancel){
        setVisible(false);
      } 
    }
}
