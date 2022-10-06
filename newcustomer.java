// package com.ems.electricity_management_system;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.sql.ResultSet;
import java.util.*;

public class newcustomer extends JFrame implements ActionListener{

    JTextField tfname,tfadd,tfstate,tfcity,tfemail,tfphone;
    JButton next,cancel,otp;
    JLabel met1;
    newcustomer(){

        setSize(700,500);
        setLocation(400,100);

        // adding panel
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Railway",Font.PLAIN,24));
        p.add(heading);

        // customer name
        JLabel name = new JLabel("Customer Name : ");
        name.setBounds(100, 80, 200, 20);
        name.setFont(new Font("Railway",Font.BOLD,16));
        p.add(name);
        tfname = new JTextField();
        tfname.setBounds(240, 80, 170, 25);
        p.add(tfname);

        // meterno
        JLabel met = new JLabel("Meter-No               : ");
        met.setBounds(100, 120, 150, 20);
        met.setFont(new Font("Railway",Font.BOLD,16));
        p.add(met);
         met1 = new JLabel("");
        met1.setBounds(240, 120, 200, 20);
        met1.setFont(new Font("Railway",Font.BOLD,16));
        p.add(met1);
        // generating random number by using long datatype
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        met1.setText( " " + Math.abs(number));
        // converting long datatype to String datatype 
        // sourround Random number by math.abs because random no can be negative.

        // Address
        JLabel add = new JLabel("Address                :");
        add.setBounds(100, 160, 200, 20);
        add.setFont(new Font("Railway",Font.BOLD,16));
        p.add(add);
        tfadd = new JTextField();
        tfadd.setBounds(240, 160, 170, 25);
        tfadd.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String add = tfadd.getText();
                char[] chars = add.toCharArray();
                for (char c : chars) {
                    if ((!Character.isLetter(c)) && (!Character.isWhitespace(c)) && (!Character.isDigit(c))) {
                        JOptionPane.showMessageDialog(null, "Only Characters and Digits are allowed");
                        tfadd.setText("");
                    }

                }
                // if (!(name2.matches("[a-zA-Z]+"))) {
                // JOptionPane.showMessageDialog(null, "only charecter are allowed");
                // textfield1.setText("");
                // }
                // // int l = value.length();
                if (add.length() > 45) {
                    JOptionPane.showMessageDialog(null, "Maximum 45 Character are allowed");
                    tfadd.setText("");
                }
                // System.out.println(l);

            }
        });
        p.add(tfadd);

         // state
         JLabel state = new JLabel("state                       :");
         state.setBounds(100, 200, 200, 20);
         state.setFont(new Font("Railway",Font.BOLD,16));
         p.add(state);
         tfstate = new JTextField();
         tfstate.setBounds(240, 200, 170, 25);
         tfstate.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String state = tfstate.getText();
                char[] chars = state.toCharArray();
                for (char c : chars) {
                    if ((!Character.isLetter(c)) && (!Character.isWhitespace(c))) {
                        JOptionPane.showMessageDialog(null, "Only Characters are allowed");
                        tfstate.setText("");
                    }

                }
                // if (!(name2.matches("[a-zA-Z]+"))) {
                // JOptionPane.showMessageDialog(null, "only charecter are allowed");
                // textfield1.setText("");
                // }
                // // int l = value.length();
                if (state.length() > 30) {
                    JOptionPane.showMessageDialog(null, "Maximum 15 digits are allowed");
                    tfstate.setText("");
                }
                // System.out.println(l);

            }
        });

         p.add(tfstate);
         
          // city
        JLabel city = new JLabel("City                         :");
        city.setBounds(100, 240, 200, 20);
        city.setFont(new Font("Railway",Font.BOLD,16));
        p.add(city);
        tfcity = new JTextField();
        tfcity.setBounds(240, 240, 170, 25);
        tfcity.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String city = tfcity.getText();
                char[] chars = city.toCharArray();
                for (char c : chars) {
                    if ((!Character.isLetter(c)) && (!Character.isWhitespace(c))) {
                        JOptionPane.showMessageDialog(null, "Only Characters are allowed");
                        tfcity.setText("");
                    }

                }
                // if (!(name2.matches("[a-zA-Z]+"))) {
                // JOptionPane.showMessageDialog(null, "only charecter are allowed");
                // textfield1.setText("");
                // }
                // // int l = value.length();
                if (city.length() > 15) {
                    JOptionPane.showMessageDialog(null, "Maximum 15 Character are allowed");
                    tfcity.setText("");
                }
                // System.out.println(l);

            }
        });

        p.add(tfcity);

           // email
           JLabel email = new JLabel("EMail                      :");
           email.setBounds(100, 280, 200, 20);
           email.setFont(new Font("Railway",Font.BOLD,16));
           p.add(email);
           tfemail = new JTextField();
           tfemail.setBounds(240, 280, 170, 25);
           tfemail.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String email = tfemail.getText();
                if (email.length() > 35) {
                    JOptionPane.showMessageDialog(null, "Maximum 35 characters are allowed");
                    tfemail.setText("");
                }
            }
        });
          
        tfemail.addMouseListener(new MouseListener(){
            String email1 = tfemail.getText();
            @Override
            public void mouseClicked(MouseEvent e) {
              JOptionPane.showMessageDialog(null, "Enter valid emailaddress" + "\n" + "you will receive all your updates on this email-id");
             
            }
            

            @Override
            public void mousePressed(MouseEvent e) {
                
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // JOptionPane.showMessageDialog(null,"you will get;");   
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
                
            }
            
        });
           p.add(tfemail);

            // phone
            JLabel phone = new JLabel("Phone-No             :");
            phone.setBounds(100, 320, 200, 20);
            phone.setFont(new Font("Railway",Font.BOLD,16));
            p.add(phone);
            tfphone = new JTextField();
            tfphone.setBounds(240, 320, 170, 25);
            tfphone.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    String phone = tfphone.getText();
                    char[] chars = phone.toCharArray();
                    for (char c : chars) {
                        if ((!Character.isDigit(c))) {
                            JOptionPane.showMessageDialog(null, "Only digits are allowed");
                            tfphone.setText("");
                        }
                         // // int l = value.length();
                       
    
                    }
                    if (phone.length() > 9) {
                        JOptionPane.showMessageDialog(null, "Maximum 10 digits are allowed");
                        tfphone.setText("");
                        
                    }
                }
                });
            p.add(tfphone);
              // adding button for otp

            otp = new JButton("Generate otp");
            otp.setBounds(260, 350, 150, 25);
            // otp.setForeground(Color.WHITE);
            // otp.setBackground(Color.BLACK);
            otp.addActionListener(this);
            p.add(otp); 


        //  adding button       
            next = new JButton("Next");
            next.setBounds(170, 390, 100, 25);
            next.setForeground(Color.WHITE);
            next.setBackground(Color.BLACK);
            next.addActionListener(this);
            p.add(next);   
            
            cancel = new JButton("Cancel");
            cancel.setBounds(300, 390, 100, 25);
            cancel.setForeground(Color.WHITE);
            cancel.setBackground(Color.BLACK);
            cancel.addActionListener(this);
            p.add(cancel);   

        // bydefault layoyt is border-layout for changing into another layout
        setLayout(new BorderLayout());
        add(p,"Center");
        // adding panel at center to border-layout;
        // if we will comment given codes we dont receive any error
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hicon1.jpg"));
        Image i5 = i4.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        // add(image);
        // this will add image at center of frame
        add(image,"West");
        // border-layout works as border like east,west,north,south
        getContentPane().setBackground(Color.white);

        setVisible(true);

    }

    public static void main(String[] args) {
        new newcustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == next){
        System.out.println("next is clicked");
        String name = tfname.getText();
        String meter = met1.getText();
        String address = tfadd.getText();
        String state = tfstate.getText();
        String city = tfcity.getText();
        String email = tfemail.getText();
        String phone = tfphone.getText();

      try {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name is Required");
            // this method is use to pop-up dialog box in windows
        } else if (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Address is Required");
        } else if (state.equals("")) {
            JOptionPane.showMessageDialog(null, "State is Required");
        }  else if (city.equals("")) {
            JOptionPane.showMessageDialog(null, "City is Required");
        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email is Required");
        } else if (phone.equals("")) {
            JOptionPane.showMessageDialog(null, "Phone is Required");
        }
        // else if (phone.length()!=9) {
        //     JOptionPane.showMessageDialog(null, "Phone-no must be of 10 digit");
        // }
         else{
          
            String query1 = "insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
            String query2 = "insert into login values('"+meter+"','','"+name+"','','')";

        try {
              conn c = new conn();
              c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            System.out.println("values inserted in customer table");
            System.out.println("values inserted in login table");
            JOptionPane.showMessageDialog(null,"Customer Details added successfully" );
            setVisible(false);
            new meterinfo(meter).setVisible(true);
            // new frame
        } catch (Exception e2) {
            e2.printStackTrace();
        }

            
        }
      } catch (Exception e1) {
        
      }
        

      }else if(e.getSource() == cancel) {
        setVisible(false);
      }else if(e.getSource() == otp){
        String email1 = tfemail.getText();
        String meter = met1.getText();
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        String a = ( " " + Math.abs(number));
        String subject = "OTP VERIFICATION FROM MAHARASHTRA STATE ELECTRICITY BOARD";
        // String to = email;
        String to = email1;
        String from = "noreplyukbank@gmail.com";

        sendEmail(subject,to,from,a,meter);
      }
    }
      
        private void sendEmail( String subject, String to, String from,String a,String meter) {
            // variable for gmail host = smtp.gmail.com
            String host ="smtp.gmail.com";
            // important hostname
    
            // gettting system properties
    
           Properties properties =  System.getProperties();
           System.out.println(properties);
    
        //    setting important information to properties object
    
        // host set
            properties.put("mail.smtp.host", host);
        // api will use key as mail.smtp.host and its value as smtp.gmail.com
    
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        // enabling ssl for security reason
    
        properties.put("mail.smtp.auth", "true");
    
        // step 1:to get the session object..
        Session session = Session.getInstance(properties, new Authenticator() {
            // this method will return session object
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                
               return new PasswordAuthentication("noreplyukbank@gmail.com", "xjymkibxmzyosiug");
            //    return new PasswordAuthentication("noreplyukbank@gmail.com")
            }
            // compose the message[text,attachment,multimedia];
    
    
    
    
            
            
        });
        session.setDebug(true);
        // to know if there is some error in session class
    
        MimeMessage m = new MimeMessage(session);
        // mimemessage is a child class of message class we can access message class directly because message class is an abstract class;
        
      
    
        try {
              // from email id
            m.setFrom(from);
            // adding recipient
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // sending mail to single receipient
            // for multiple receipient
        //   m.addRecipients(arg0, arg1);
    
        // adding subject to message
    
        m.setSubject(subject);
    
        // adding text to message
        String email = "noreplyindianrailwaysirctc@gmail.com";
        // m.setText("For more details E-Mail here :" + email);
    
        m.setText("Your OTP for verification for E-Mail is " + a + "\n" + "Dont share this email with anyone" + "\n" + "For more details E-Mail here :" + email );
    
        // m.setText("\n");
        // m.setText("Pin-number : " + " "+message1);
        // m.setText("Note : Please Dont share this cardnumber and pinnumber to anyone regards Uk bank policy");
        
        // m.setText("\n");
    
        // m.setText("Regards," + "\n" + "Uk Bank Of India Team");
    
        // m.setText("\n");
        
    
    
        // send 
        // step 3:send the message using transport class
    
        Transport.send(m);
    
        System.out.println("Send Successfully");

        try {
            conn c = new conn();
            String query = "insert into otpverify values('"+meter+"','"+to+"','"+a+"')";
            c.s.executeUpdate(query);
            System.out.println("value inserted in otpverify table");
        } catch (Exception e) {
           e.printStackTrace();
        }
        // JOptionPane.showConfirmDialog(null, "Check your Gmail..");
        JOptionPane.showConfirmDialog(null, "Enter OTP while signup");
       
        // new Transaction(formno, name, "", "", name);
    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cannot send the message");
            // to get the proper exception error with the help of e.printStackTrace.
           
        }
       

      }
        
    }

