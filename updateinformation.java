import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class updateinformation extends JFrame implements ActionListener,Runnable {

    JButton update,cancel;
    String newmeter;
    JTextField address1,city1,state1,email1,phone1;
    JLabel name1;
    updateinformation(String newmeter){
        this.newmeter=newmeter;
        setBounds(250, 100, 950, 520);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(150, 20, 500, 40);
        heading.setFont(new Font("Railway",Font.BOLD,20));
        add(heading);

        // name
        JLabel name = new JLabel("Name : ");
        name.setBounds(70, 80, 100, 20);
        name.setFont(new Font("Railway",Font.PLAIN,16));
        add(name);

         name1 = new JLabel("");
        name1.setBounds(220, 80, 180, 25);
        name1.setFont(new Font("Railway",Font.PLAIN,16));
        add(name1);

        // meter-no
        JLabel meter = new JLabel("Meter-No : ");
        meter.setBounds(70, 120, 100, 20);
        meter.setFont(new Font("Railway",Font.PLAIN,16));
        add(meter);

        JLabel meter1 = new JLabel("");
        meter1.setBounds(220, 120, 180, 25);
        meter1.setFont(new Font("Railway",Font.PLAIN,16));
        add(meter1);

        // address
        
        JLabel address = new JLabel("Address : ");
        address.setBounds(70, 160, 100, 20);
        address.setFont(new Font("Railway",Font.PLAIN,16));
        add(address);

         address1 = new JTextField("");
        address1.setBounds(220, 160, 180, 25);
        address1.setFont(new Font("Railway",Font.PLAIN,16));
        add(address1);

        // state

        
        JLabel state = new JLabel("State : ");
        state.setBounds(70, 200, 100, 20);
        state.setFont(new Font("Railway",Font.PLAIN,16));
        add(state);

         state1 = new JTextField("");
        state1.setBounds(220, 200, 180, 25);
        state1.setFont(new Font("Railway",Font.PLAIN,16));
        state1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
        String name3 = state1.getText();
        char[] chars = name3.toCharArray();
        for (char c : chars) {
            if ((!Character.isLetter(c)) && (!Character.isWhitespace(c) && (!Character.isUpperCase(c) ))) {
                JOptionPane.showMessageDialog(null, "state name dont contain any digit");
                state1.setText("");
            }
             // // int l = value.length();
           

        }
        if (name3.length() > 15) {
            JOptionPane.showMessageDialog(null, "Maximum 15 digits are allowed fot city");
            state1.setText("");
            
        }
    }
});
        add(state1);


        // city

        
        JLabel city = new JLabel("City : ");
        city.setBounds(70, 240, 100, 20);
        city.setFont(new Font("Railway",Font.PLAIN,16));
        add(city);

         city1 = new JTextField("");
        city1.setBounds(220,240, 180, 25);
        city1.setFont(new Font("Railway",Font.PLAIN,16));
        city1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
        String name3 = city1.getText();
        char[] chars = name3.toCharArray();
        for (char c : chars) {
            if ((!Character.isLetter(c)) && (!Character.isWhitespace(c) && (!Character.isUpperCase(c) ))) {
                JOptionPane.showMessageDialog(null, "City name dont contain any digit");
                city1.setText("");
            }
             // // int l = value.length();
           

        }
        if (name3.length() > 15) {
            JOptionPane.showMessageDialog(null, "Maximum 15 digits are allowed fot city");
            city1.setText("");
            
        }
    }
});
        add(city1);
        
        // email

        JLabel email = new JLabel("EMail-Id : ");
        email.setBounds(70, 280, 100, 20);
        email.setFont(new Font("Railway",Font.PLAIN,16));
        add(email);

         email1 = new JTextField("");
        email1.setBounds(220,280, 180, 25);
        email1.setFont(new Font("Railway",Font.PLAIN,16));
        email1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String email = email1.getText();
                if (email.length() > 35) {
                    JOptionPane.showMessageDialog(null, "Maximum 35 characters are allowed");
                    email1.setText("");
                }
            }
        });
          
        email1.addMouseListener(new MouseListener(){
            String email = email1.getText();
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
        add(email1);

        // phone

        JLabel phone = new JLabel("Phone-No : ");
        phone.setBounds(70, 320, 100, 20);
        phone.setFont(new Font("Railway",Font.PLAIN,16));
        add(phone);

         phone1 = new JTextField("");
        phone1.setBounds(220,320, 180, 25);
        phone1.setFont(new Font("Railway",Font.PLAIN,16));
        phone1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               
               String ot = phone1.getText();
                char[] chars = ot.toCharArray();
                for (char c : chars) {
                    if ( (!Character.isWhitespace(c) && (!Character.isDigit(c)))) {
                        JOptionPane.showMessageDialog(null, "Only  Digit are allowed");
                        phone1.setText("");
                    }
                 
                    
                      }
                if (ot.length() > 9) {
                    JOptionPane.showMessageDialog(null, "Enter valid phone-no");
                    phone1.setText("");
                    
                }
               
            }
      });
       
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
            // JOptionPane.showMessageDialog(null, "No records found");
           }
        } catch (Exception e) 
        {
           e.printStackTrace();
        }
        
        update = new JButton("Update");
        update.setBounds(100, 390, 120, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(300, 390, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon vcus = new ImageIcon(ClassLoader.getSystemResource("update.jpg"));
        Image vcus1 = vcus.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon vcus2 = new ImageIcon(vcus1);
        JLabel image = new JLabel(vcus2);
        image.setBounds(370, 100, 600, 300);
        add(image);


      

        setVisible(true);
       
    }

    public static void main(String[] args) {
        new updateinformation("");
    }
    int clicks=0;
    @Override
    public void actionPerformed(ActionEvent e) {
      
     if(e.getSource() == update){
        System.out.println("update clicked");
        // clicks++;
      
        String lbladdress = address1.getText();
        String lblstate = state1.getText();
        String lblcity = city1.getText();
        String lblemail = email1.getText();
        String lblphone = phone1.getText();

        // now updating values using update query;
        
        try {

            if (lbladdress.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required");
                // this method is use to pop-up dialog box in windows
            } else if (lblstate.equals("")) {
                JOptionPane.showMessageDialog(null, "State is Required");
            }else if (lblcity.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required");
            } else if (lblemail.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is Required");
            }  else if (lblphone.equals("") || lblphone.length()<9) {
                JOptionPane.showMessageDialog(null, "Valid Phone-no is Required");
            } else{

            conn c = new conn();
            c.s.executeUpdate("update customer set address='"+lbladdress+"',city='"+lblcity+"',state='"+lblstate+"',email='"+lblemail+"',phone='"+lblphone+"' where meter_no='"+newmeter+"'  ");
            JOptionPane.showMessageDialog(null, "Wait your records are being updated");
            Thread t;
            t = new Thread(this);
            clicks++;
            t.start();
            // JOptionPane.showMessageDialog(null, "User information updated successfully");
            // setVisible(false);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        
     }else{
        setVisible(false);
     }
        
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            JOptionPane.showMessageDialog(null, "User information updated successfully");
            if(clicks==2){
                JOptionPane.showMessageDialog(null,"Only 1 limits are pending");
            }
            if(clicks>2){
                JOptionPane.showMessageDialog(null, "Update Limit Exceeds");
                update.setEnabled(false);
                JOptionPane.showMessageDialog(null, "wait for 5 seconds");
                Thread.sleep(10000);
                update.setEnabled(true);
               
                // setVisible(false);
            }
            // setVisible(false);
        } catch (Exception e) {
        e.printStackTrace();
        }
        
    }
}
