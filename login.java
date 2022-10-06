// package com.ems.electricity_management_system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

// import javax.swing.*;
public class login extends JFrame implements ActionListener,Runnable{
    Thread t;
    JButton log3,log,log2;
    JTextField user1,pass1;
    Choice loggin;
    login(){
        
        //  super("Login page1");
        // super must be the statement of constructor 
        // full access of frame and set background to white
        getContentPane().setBackground(Color.WHITE);
        setSize(600,300);
        
        // label for username,password,logginas
        JLabel user = new JLabel("Username:");
        // use to write anything on the frame
        user.setFont(new Font("Railway",Font.BOLD,14));
        user.setBounds(300, 20, 100, 20);
        // setBounds() is with respect to frame
        add(user);

        JLabel pass = new JLabel("Password:");
        // use to write anything on the frame
        pass.setFont(new Font("Railway",Font.BOLD,14));
        pass.setBounds(300, 60, 100, 20);
        // setBounds() is with respect to frame
        add(pass);

        JLabel loginas = new JLabel("Loginin in as:");
        // use to write anything on the frame
        loginas.setFont(new Font("Railway",Font.BOLD,14));
        loginas.setBounds(300, 100, 100, 20);
        // setBounds() is with respect to frame
        add(loginas);

        // textfield for username,password,loggin in as
         user1  = new JTextField();
        // user1.setFont(new Font("Railway",Font.BOLD,14));
        user1.setBounds(400, 20, 160, 25);
        add(user1);

         pass1  = new JTextField();
        // pass1.setFont(new Font("Railway",Font.BOLD,14));
        pass1.setBounds(400, 60, 160, 25);
        add(pass1);

         loggin = new Choice();
        loggin.add("Select");
        loggin.add("Admin");
        loggin.add("Customer");
        loggin.setBounds(400, 100, 160, 25);
        add(loggin);

        // button
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
         log = new JButton("Login",i3);
        log.addActionListener(this);
        log.setBounds(330,150,100,25);
        add(log);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("cancel.jpg"));
        Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
         log2= new JButton("Cancel",i6);
        log2.addActionListener(this);
        log2.setBounds(450,150,100,25);
        add(log2);


        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("signup.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
         log3 = new JButton("Signup",i9);
        log3.setBounds(390,190,100,25);
        log3.addActionListener(this);
        add(log3);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
        Image i11 = i10.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image = new JLabel(i12);
        image.setBounds(50, 0, 250, 250);
        add(image);



        setTitle("Login page");
        setLayout(null);
        // after writing setLayout() we tell swing that we are creating our know layout using setBounds() method. 
        setLocation(400,200);
        // setLocation() is with respect to screen.
        setVisible(true);

    }

    public static void main(String[] args) {
        new login();
    }
    int clicks = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == log3){
            // signup
            setVisible(false);
            new signup().setVisible(true);
        }else if(e.getSource() == log2){
            // cancel
           
             setVisible(false);
            
            // user1.setText("");
            // pass1.setText("");
           

        }else if(e.getSource() == log){
        // login
        String suser = user1.getText();
        String spass = pass1.getText();
        String user = loggin.getSelectedItem();
        
        if(suser.equals("")){
            JOptionPane.showMessageDialog(null, "Username is required ");
        
          }else if(spass.equals("")){
            JOptionPane.showMessageDialog(null, "Password is required ");
          }else if(spass.equals("")){
            JOptionPane.showMessageDialog(null, "Loggin is required ");
          }else{
       
        clicks++;
        System.out.println("successfully loged in");
        // clicks++;
        System.out.println("No of clicks : " + clicks);   
        if(clicks>2){
            log.setEnabled(false);
            JOptionPane.showMessageDialog(null, " Multiple attempts login after 20 seconds");
            t = new Thread(this);
            t.start();
                } 

                try {


                    conn c = new conn();
                    String query = "select * from login where username ='" +suser+"' and password ='"+spass+"' and user = '"+user+"'  ";
                    ResultSet rs = c.s.executeQuery(query);
                    // ddl command
                    if(rs.next()){
                        System.out.println("Login successfully.....");
                        String meter = rs.getString("meter_no");
                        setVisible(false);
                        new project(suser,user,meter).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid Login" + "\n" + "Check username and Password");
                        user1.setText("");
                        pass1.setText("");
                    
                }
                } catch (Exception ea) {
                   ea.printStackTrace();
                }

                // try {


                //     conn c = new conn();
                //     String query1 = "select * from login where username ='" +suser+"' and password ='"+spass+"' and user = '"+user+"'  ";
                //     ResultSet rs1 = c.s.executeQuery(query1);
                //     // ddl command
                //     if(rs1.next()){
                //         System.out.println("Login successfully.....");
                //         setVisible(false);
                //         new project(suser).setVisible(true);
                //     }else{
                //         JOptionPane.showMessageDialog(null,"Invalid Login" + "\n" + "Check username and Password");
                //         user1.setText("");
                //         pass1.setText("");
                    
                // }
                // } catch (Exception ea) {
                //    ea.printStackTrace();
                // }
            
        
        // log.setEnabled(false);
            // try {
            //     int clicks = 0;
            //     clicks++;
            //     if(clicks>3){
            //         log.setEnabled(false);
            //         JOptionPane.showMessageDialog(null, "You cant login");
            //     }
            // } catch (Exception ea) {
            //    System.out.println(ea);
            // }

       
        }
    }
        
    }

    @Override
    public void run() {
      
        try {
            Thread.sleep(20000);
            log.setEnabled(true);
        } catch (Exception e) {
        e.printStackTrace();
        }
        
    }

   
}
   

