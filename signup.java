// package com.ems.electricity_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

// import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class signup extends JFrame implements ActionListener,Runnable {
    JButton back,create;
    Choice accounttype;
    JTextField metno;
    JTextField user1,name1,pass1,otp;
    signup(){
        // Thread t;
        // 1 method to create frame
        setSize(700,450);
        setLocation(450,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // 1) create account as
        JPanel panel = new JPanel();
        panel.setBounds(20, 30, 650, 350);
        panel.setBorder(new TitledBorder(new LineBorder(Color.BLUE),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,(Color.BLUE)));
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        // panel.setBounds(x, y, width, height);
        add(panel);

        JLabel heading = new JLabel("Create Account As : ");
        heading.setBounds(100, 50, 170, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Railway",Font.BOLD,16));
        // for addding to panel
        panel.add(heading);
         accounttype = new Choice();
         accounttype.add("Select");
        accounttype.add("Admin");
        accounttype.add("Customer");
        accounttype.setBounds(270, 50, 150, 25);
        accounttype.addItemListener(new ItemListener(){
           
           
            @Override
            public void itemStateChanged(ItemEvent e)
             {
                String atype = accounttype.getSelectedItem();
                if(atype.equals("Admin")){
                    JOptionPane.showMessageDialog(null,"You can't create account as an Admin");
                    metno.setEnabled(false);
                    user1.setEnabled(false);
                    name1.setEnabled(false);
                    pass1.setEnabled(false);
                   
                }
                else
                {
                    metno.setEnabled(true);
                    user1.setEnabled(true);
                    name1.setEnabled(true);
                    pass1.setEnabled(true); 
                    name1.setEditable(false);
                }
                
            }

            
        });
       
        panel.add(accounttype); 
       
        // 2)  meter no.

        JLabel meter = new JLabel("Meter Number          :");
        meter.setBounds(100, 90, 170, 20);
        meter.setForeground(Color.GRAY);
        meter.setFont(new Font("Railway",Font.BOLD,16));
        // for addding to panel
        panel.add(meter);
        metno = new JTextField();
        metno.setBounds(270, 90, 150, 25);
        metno.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               
               String met1 = metno.getText();
                char[] chars = met1.toCharArray();
                for (char c : chars) {
                    if ( (!Character.isWhitespace(c) && (!Character.isDigit(c)))) {
                        JOptionPane.showMessageDialog(null, "Only  Digit are allowed");
                        metno.setText("");
                    }
                     // // int l = value.length();
                

                }
                if (met1.length() > 6) {
                    JOptionPane.showMessageDialog(null, "Meter number is of 6 digit");
                    metno.setText("");
                    
                }
            }
      });

            // applying focuslistener for name autofill from database after name field below after name textfield
           
        panel.add(metno);

         // 3)  username

         JLabel user = new JLabel("Username                 :");
         user.setBounds(100, 130, 170, 20);
         user.setForeground(Color.GRAY);
         user.setFont(new Font("Railway",Font.BOLD,16));
         // for addding to panel
         panel.add(user);
         user1 = new JTextField();
         user1.setBounds(270, 130, 150, 25);
         user1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                
                // try {
                //     conn c = new conn();
                //     ResultSet rs1 = c.s.executeQuery("select meter_no from login");
                    
                //     while (rs1.next()) {
                //         String customer = rs1.getString("meter_no");
                //         String meterverify = metno.getText();
                //         if(meterverify.equals(customer))
                //         {
                //         JOptionPane.showMessageDialog(null, "Meter exist");
                //        }
                //        else if(!meterverify.equals(customer)){
                //         JOptionPane.showMessageDialog(null, "MeterNo not exist");
                //         // new login();
                //        }
                        
                //     }
                //   } catch (Exception e1) {
                //     e1.printStackTrace();
                //   }
                    

                String name3 = user1.getText();
                char[] chars = name3.toCharArray();
                for (char c : chars) {
                    if ((!Character.isLetter(c)) && (!Character.isWhitespace(c) && (!Character.isDigit(c) && (!Character.isUpperCase(c) && (!Character.isLowerCase(c)))))) {
                        JOptionPane.showMessageDialog(null, "username must contain uppercase lowercase and digit not special symbol");
                        user1.setText("");
                    }
                     // // int l = value.length();
                   

                }
                if (name3.length() > 15) {
                    JOptionPane.showMessageDialog(null, "Maximum 15 digits are allowed");
                    user1.setText("");
                    
                }
            }
            });
                // if
         panel.add(user1);

           // 4)  name

           JLabel name = new JLabel("name                          :");
           name.setBounds(100, 170, 170, 20);
           name.setForeground(Color.GRAY);
           name.setFont(new Font("Railway",Font.BOLD,16));
           // for addding to panel
           panel.add(name);
            name1 = new JTextField();
           name1.setBounds(270, 170, 150, 25);

           name1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String name2 = name1.getText();
                char[] chars = name2.toCharArray();
                for (char c : chars) {
                    if ((!Character.isLetter(c)) && (!Character.isWhitespace(c))) {
                        JOptionPane.showMessageDialog(null, "Only Characters are allowed");
                        name1.setText("");
                    }
                    

                }
                // if (!(name2.matches("[a-zA-Z]+"))) {
                // JOptionPane.showMessageDialog(null, "only charecter are allowed");
                // textfield1.setText("");
                // }
                // // int l = value.length();
                if (name2.length() > 25) {
                    JOptionPane.showMessageDialog(null, "Maximum 25 digits for name");
                    name1.setText("");
                }
            }
        });
        // applying focuslistener to meter textfield
        metno.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                
                
            }
            @Override
            public void focusLost(FocusEvent e) {
                JOptionPane.showMessageDialog(null, "If you dont get your name autofill just give a space and write your meter number");
              try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from login where meter_no ='"+metno.getText()+"'  ");
                
                while (rs.next()) {
                    // if i hit this query i will get all the values of that row but which row i have to print i have to print ("name") column data into textfield.
                   
                    name1.setText(rs.getString("name"));
                  
                    // System.out.println(name3);
                    // if(metno.equals("")){
                    //     name1.setText("");
                    // }
                }
              } catch (Exception e6) {
                e6.printStackTrace();
              }
            
            }
            
        });

           panel.add(name1);

            // 5)  password

            JLabel pass = new JLabel("password                  :");
            pass.setBounds(100, 210, 170, 20);
            pass.setForeground(Color.GRAY);
            pass.setFont(new Font("Railway",Font.BOLD,16));
            // for addding to panel
            panel.add(pass);
             pass1 = new JTextField();
            pass1.setBounds(270, 210, 150, 25);
            pass1.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    String name4 = pass1.getText();
                    char[] chars = name4.toCharArray();
                    for (char c : chars) {
                        if ((!Character.isLetter(c)) && (!Character.isWhitespace(c) && (!Character.isDigit(c)))) {
                            JOptionPane.showMessageDialog(null, "Only Characters and Digit are allowed");
                            pass1.setText("");
                        }
                         // // int l = value.length();
                       }
                    if (name4.length() > 15) {
                        JOptionPane.showMessageDialog(null, "Maximum 12 digits are allowed");
                        pass1.setText("");
                    }
                }
                });
            panel.add(pass1);

            JLabel otp1 = new JLabel("Enter OTP                 :");
            otp1.setBounds(100, 250, 170, 20);
            otp1.setForeground(Color.GRAY);

            
            otp1.setFont(new Font("Railway",Font.BOLD,16));
            // for addding to panel
            panel.add(otp1);
            otp = new JTextField();
            otp.setBounds(270, 250, 150, 25);
            // otp.setCaretPosition(1);
            otp.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                   
                   String ot = otp.getText();
                    char[] chars = ot.toCharArray();
                    for (char c : chars) {
                        if ( (!Character.isWhitespace(c) && (!Character.isDigit(c)))) {
                            JOptionPane.showMessageDialog(null, "Only  Digit are allowed");
                            otp.setText("");
                        }
                     
                        
                          }
                    if (ot.length() > 6) {
                        JOptionPane.showMessageDialog(null, "OTP is of is of 6 digit");
                        otp.setText("");
                        
                    }
                   
                }
          });
           
        //   otp.requestFocus();
        //   String current = otp.getText();
        //   String newtext = current.substring(1 );

          panel.add(otp);

            // button
            // create 
             create = new JButton("Create");
            create.setBounds(150,300,100,25);
            create.setBackground(Color.BLACK);
            create.setForeground(Color.WHITE);
            create.addActionListener(this);
            panel.add(create);
            
            // back button
             back = new JButton("Back");
            back.setBounds(280,300,100,25);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            panel.add(back);

            ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("signupImage.png"));
            Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            JLabel image = new JLabel(i9);
            image.setBounds(420, 30, 250, 250);
            panel.add(image);
           
         setVisible(true);
        // 2 method to create frame
        // setBounds(450, 150, 700, 400);

        

    }

    public static void main(String[] args) {
        new signup();
    }

    
    int clicks = 0;
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == create){
            System.out.println("create clicked");
            String atype = accounttype.getSelectedItem();
            String suser = user1.getText();
            String sname = name1.getText();
            String spass = pass1.getText();
            String met = metno.getText();
            String otpno = otp.getText();
            // System.out.println("hello");
            
                
            conn c = new conn(); 
            String query1 = "select * from otpverify where meter_no='"+metno.getText()+"' and  otp='"+otp.getText()+"'  ";
            try {
                ResultSet rs = c.s.executeQuery(query1);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "OTP verified Successfully");

          
              
                try {
                if (atype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account-Type is Required");
                    // this method is use to pop-up dialog box in windows
                } else if (met.equals("")) {
                    JOptionPane.showMessageDialog(null, "Meter-No is Required");
                }else if (suser.equals("")) {
                    JOptionPane.showMessageDialog(null, "username is Required");
                } else if (sname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required");
                }  else if (spass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Password is Required");
                } else if (otpno.equals("")) {
                    JOptionPane.showMessageDialog(null, "otp is Required");
                }  
                //   else if (met.equals("")) {
                //     JOptionPane.showMessageDialog(null, "Meter-No is Required");
                // }
                else{
                    try {
                        conn c1 = new conn();

                        String query = null;
                        if(atype.equals("Customer"))
                        {

                        //  query = "insert into login(meter_no,username,name,password,user)values('" + met +"','" + suser +"','" + sname +"','" + spass +"','" + atype +"')";

                        query = "update login set username ='"+suser+"',password='"+spass+"',user='"+atype+"',name='"+sname+"' where meter_no='"+met+"'  ";

                       
                        // System.out.println("hello");
                        // varchar datatype accept values in the form of string("") for concatenate we have use('')
                       
                        c1.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Account updated Successfully.");
                        System.out.println("hello");
                        setVisible(false);
                        new login();
                        System.out.println("Data Inserted in login table");
                        // ddl
                        }else{
                            JOptionPane.showMessageDialog(null, "You are not an Admin");
                        }
                    } catch (Exception e1) {
                    //    System.out.println(e1);
                         e1.printStackTrace();
                    }
                }
            }catch(Exception e2){
                // System.out.println(e2);
                e2.printStackTrace();
                // try {
                //     conn c = new conn();
                //     String query = "insert into login( meter_no,username,name,password,user)values('" + met +"','" + suser +"','" + sname +"','" + spass +"','" + atype +"')";
                //     System.out.println("hello");
                //     // varchar datatype accept values in the form of string("") for concatenate we have use('')
                //     c.s.executeUpdate(query);
                //     JOptionPane.showMessageDialog(null, "Account Created Successfully.");
                //     System.out.println("hello");
                //     setVisible(false);
                //     new login();
                //     System.out.println("Data Inserted in login table");
                //     // ddl
                // } catch (Exception e1) {
                // //    System.out.println(e1);
                //      e1.printStackTrace();
                // }
            }

            // conn c = new conn(); 
            // String query1 = "select * from otpverify where meter_no='"+metno.getText()+"' and  otp='"+otp.getText()+"'  ";
            // try {
            //     ResultSet rs = c.s.executeQuery(query1);
            //     if(rs.next()){
            //         JOptionPane.showMessageDialog(null, "OTP verified Successfully");

        }else{
            clicks++;
            if(clicks>2){
                Thread t;
                otp.setEnabled(false);
                JOptionPane.showMessageDialog(null, "OTP Verification Exceeds wait for 20 seconds");
                t = new Thread(this);
                t.start();
            }else{
            JOptionPane.showMessageDialog(null, "Invalid OTP");
            otp.setText("");
            JOptionPane.showMessageDialog(null, "Just give a space and write OTP in box");
            }
        }
      
    } catch (Exception e) {
       e.printStackTrace();
    }


            // mysql is an external entity exception must be occured thats why try-catch block
            // try {
            //     conn c = new conn();
            //     String query = "insert into login values('" + met +"','" + suser +"','" + sname +"','" + spass +"','" + atype +"')";
            //     System.out.println("hello");
            //     // varchar datatype accept values in the form of string("") for concatenate we have use('')
            //     c.s.executeUpdate(query);
            //     JOptionPane.showMessageDialog(null, "Account Created Successfully.");
            //     System.out.println("hello");
            //     setVisible(false);
            //     new login();
            //     System.out.println("Data Inserted in login table");
            //     // ddl
            // } catch (Exception e1) {
            // //    System.out.println(e1);
            //      e1.printStackTrace();
            // }
            
            

        }else if(ae.getSource() == back){
            setVisible(false);
            new login().setVisible(true);
        }
        
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20000);
            otp.setEnabled(true);
           } catch (Exception e) {
           e.printStackTrace();
           }
    }
}
