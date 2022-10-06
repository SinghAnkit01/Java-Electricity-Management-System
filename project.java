// package com.ems.electricity_management_system;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.*;
// import org.springframework.context.ApplicationListener;

// import javafx.scene.input.KeyEvent;

import java.awt.*;


public class project extends JFrame implements ActionListener {
    String suser,user1,newmeter;
    project(String suser,String user1,String newmeter){
      this.user1=user1;
      this.newmeter=newmeter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // JOptionPane.showMessageDialog(null, "Welcome-Admin " + suser);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1360, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        // adding menubar
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        setLayout(new FlowLayout());
        // flowlayout comes under awt package
        
        // adding menuitem
        JMenu master = new JMenu("Master");
        // jmenu comes uunder swing package
        master.setForeground(Color.BLUE);
        master.setFont(new Font("Railway",Font.BOLD,14));
        // mb.add(master);
        
        // new customer
        JMenuItem newcus = new JMenuItem("New Customer"); 
        newcus.setFont(new Font("Railway",Font.PLAIN,14));
        newcus.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon1.png"));
        Image icon2 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcus.setIcon(new ImageIcon(icon2));
        // this is use to set icon on menuitem
        newcus.setMnemonic('N');
        newcus.addActionListener(this);
        newcus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK ));
        master.add(newcus);

        // customer detail
        JMenuItem cd = new JMenuItem("Customer Details"); 
        cd.setFont(new Font("Railway",Font.PLAIN,14));
        cd.setBackground(Color.WHITE);
        ImageIcon cd1 = new ImageIcon(ClassLoader.getSystemResource("icon2.png"));
        Image cd2 = cd1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        cd.setIcon(new ImageIcon(cd2));
        // this is use to set icon on menuitem
        cd.setMnemonic('D');
        cd.addActionListener(this);
        cd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK ));
        master.add(cd);

        // Deposit detail
        JMenuItem dd = new JMenuItem("Deposit Details"); 
        dd.setFont(new Font("Railway",Font.PLAIN,14));
        dd.setBackground(Color.WHITE);
        ImageIcon dd1 = new ImageIcon(ClassLoader.getSystemResource("icon3.png"));
        Image dd2 = dd1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        dd.setIcon(new ImageIcon(dd2));
        // this is use to set icon on menuitem
        dd.setMnemonic('P');
        dd.addActionListener(this);
        dd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK ));
        master.add(dd);

        // Calculate bill
        JMenuItem cb = new JMenuItem("Calculate Bill"); 
        cb.setFont(new Font("Railway",Font.PLAIN,14));
        cb.setBackground(Color.WHITE);
        ImageIcon cb1 = new ImageIcon(ClassLoader.getSystemResource("icon4.png"));
        Image cb2 = cb1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        cb.setIcon(new ImageIcon(cb2));
        // this is use to set icon on menuitem
        cb.setMnemonic('B');
        cb.addActionListener(this);
        cb.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK ));
        master.add(cb);

        

        // 2nd menu item
        JMenu info = new JMenu("Information");
        // jmenu comes uunder swing package
        info.setForeground(Color.RED);
        info.setFont(new Font("Railway",Font.BOLD,14));
        // mb.add(info);

        // update info
        JMenuItem update = new JMenuItem("Update Information"); 
        update.setFont(new Font("Railway",Font.PLAIN,14));
        update.setBackground(Color.WHITE);
        ImageIcon u1 = new ImageIcon(ClassLoader.getSystemResource("icon5.png"));
        Image u2 = u1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        update.setIcon(new ImageIcon(u2));
        update.addActionListener(this);
        // this is use to set icon on menuitem
        update.setMnemonic('U');
        update.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK ));
        info.add(update);

        // view info

        JMenuItem view = new JMenuItem("View Information"); 
        view.setFont(new Font("Railway",Font.PLAIN,14));
        view.setBackground(Color.WHITE);
        ImageIcon v1 = new ImageIcon(ClassLoader.getSystemResource("icon6.png"));
        Image v2 = v1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        view.setIcon(new ImageIcon(v2));
        view.addActionListener(this);
        // this is use to set icon on menuitem
        view.setMnemonic('V');
        view.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK ));
        info.add(view);

        // 3rd menu item
        JMenu user = new JMenu("User");
        // jmenu comes uunder swing package
        user.setForeground(Color.BLUE);
        user.setFont(new Font("Railway",Font.BOLD,14));
        // mb.add(user);

        JMenuItem pb = new JMenuItem("Pay Bill"); 
        pb.setFont(new Font("Railway",Font.PLAIN,14));
        pb.setBackground(Color.WHITE);
        ImageIcon pb1 = new ImageIcon(ClassLoader.getSystemResource("icon7.png"));
        Image pb2 = pb1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        pb.setIcon(new ImageIcon(pb2));
        pb.addActionListener(this);
        // this is use to set icon on menuitem
        pb.setMnemonic('A');
        pb.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK ));
        user.add(pb);

        JMenuItem bde1 = new JMenuItem("Bill Details"); 
        bde1.setFont(new Font("Railway",Font.PLAIN,14));
        bde1.setBackground(Color.WHITE);
        ImageIcon bd1 = new ImageIcon(ClassLoader.getSystemResource("icon8.png"));
        Image bd2 = bd1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        bde1.addActionListener(this);
        bde1.setIcon(new ImageIcon(bd2));
        // this is use to set icon on menuitem
        bde1.setMnemonic('G');
        bde1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK ));
        user.add(bde1);

        // 4th menu item
        JMenu re = new JMenu("Report");
        // jmenu comes uunder swing package
        re.setForeground(Color.RED);
        re.setFont(new Font("Railway",Font.BOLD,14));
        // mb.add(re);

        JMenuItem gb = new JMenuItem("Generate Bill"); 
        gb.setFont(new Font("Railway",Font.PLAIN,14));
        gb.setBackground(Color.WHITE);
        ImageIcon gb1 = new ImageIcon(ClassLoader.getSystemResource("icon7.png"));
        Image gb2 = gb1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        gb.setIcon(new ImageIcon(gb2));
        gb.addActionListener(this);
        // this is use to set icon on menuitem
        gb.setMnemonic('R');
        gb.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK ));
        re.add(gb);

         // 5th menu item
         JMenu uti = new JMenu("Utility");
         // jmenu comes uunder swing package
         uti.setForeground(Color.BLUE);
         uti.setFont(new Font("Railway",Font.BOLD,14));
        //  mb.add(uti);
 
         JMenuItem note = new JMenuItem("Notepad"); 
         note.setFont(new Font("Railway",Font.PLAIN,14));
         note.setBackground(Color.WHITE);
         ImageIcon note1 = new ImageIcon(ClassLoader.getSystemResource("icon12.png"));
         Image note2 = note1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         note.setIcon(new ImageIcon(note2));
         // this is use to set icon on menuitem
         note.addActionListener(this);
         note.setMnemonic('L');
         note.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK ));
        uti.add(note);

        JMenuItem cal1 = new JMenuItem("Calculator"); 
        cal1.setFont(new Font("Railway",Font.PLAIN,14));
        cal1.setBackground(Color.WHITE);
        ImageIcon note11 = new ImageIcon(ClassLoader.getSystemResource("icon9.png"));
        Image note12 = note11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        cal1.setIcon(new ImageIcon(note12));
        cal1.addActionListener(this);
        // this is use to set icon on menuitem
        cal1.setMnemonic('C');
        cal1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK ));
       uti.add(cal1);

        // 6th menu item
        JMenu exit = new JMenu("Exit                                                                                                                                          ");
        // jmenu comes uunder swing package
        exit.setForeground(Color.RED);
        exit.setFont(new Font("Railway",Font.BOLD,14));
        // mb.add(exit);

        JMenuItem ex1 = new JMenuItem("Exit"); 
        ex1.setFont(new Font("Railway",Font.PLAIN,14));
        ex1.setBackground(Color.WHITE);
        ImageIcon ex = new ImageIcon(ClassLoader.getSystemResource("icon11.png"));
        Image ex2 = ex.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ex1.setIcon(new ImageIcon(ex2));
        // this is use to set icon on menuitem
        ex1.addActionListener(this);
        ex1.setMnemonic('W');
        ex1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK ));
       exit.add(ex1);


      

        // // 7th menu item
        // JMenu admin = new JMenu("Admin : " + suser);
        // // jmenu comes uunder swing package
        // admin.setForeground(Color.BLACK);
        // admin.setFont(new Font("Railway",Font.BOLD,14));
        // admin.setLocation(200,0);
        // // admin.add(Box.createHorizontalGlue());
        // admin.revalidate();
        // admin.add(Box.createHorizontalGlue());
        // // by default alignment of menu is on left side for placing it on right side add Box.createHorizontalGlue()
        // // Box class comes under swing package
        // mb.add(admin);

        // to verify for customer and admin

        if(user1.equals("Admin"))
        {
          JOptionPane.showMessageDialog(null, "Welcome-Admin " + suser);
          mb.add(master);
            
        
        }else{
          JOptionPane.showMessageDialog(null, "Welcome-Customer " + suser);
          mb.add(info);
          mb.add(user);
          mb.add(re);
          
       
        }
         mb.add(uti);
          mb.add(exit);
        

         try {
          if(user1.equals("Admin")){
             // 7th menu item
        JMenu admin = new JMenu("Admin : " + suser);
        // jmenu comes uunder swing package
        admin.setForeground(Color.BLACK);
        admin.setFont(new Font("Railway",Font.BOLD,14));
        admin.setLocation(200,0);
        // admin.add(Box.createHorizontalGlue());
        admin.revalidate();
        admin.add(Box.createHorizontalGlue());
        // by default alignment of menu is on left side for placing it on right side add Box.createHorizontalGlue()
        // Box class comes under swing package
        mb.add(admin);
        }else{
                // 8th menu item
        JMenu customer = new JMenu("Customer : " + suser);
        // jmenu comes uunder swing package
        customer.setForeground(Color.BLACK);
        customer.setFont(new Font("Railway",Font.BOLD,14));
        customer.setLocation(200,0);
        // admin.add(Box.createHorizontalGlue());
        customer.revalidate();
        customer.add(Box.createHorizontalGlue());
        // by default alignment of menu is on left side for placing it on right side add Box.createHorizontalGlue()
        // Box class comes under swing package
        mb.add(customer);
        }
         } catch (Exception e) {
          e.printStackTrace();
         }

        //   // 7th menu item
        // JMenu admin = new JMenu("Admin : " + suser);
        // // jmenu comes uunder swing package
        // admin.setForeground(Color.BLACK);
        // admin.setFont(new Font("Railway",Font.BOLD,14));
        // admin.setLocation(200,0);
        // // admin.add(Box.createHorizontalGlue());
        // admin.revalidate();
        // admin.add(Box.createHorizontalGlue());
        // // by default alignment of menu is on left side for placing it on right side add Box.createHorizontalGlue()
        // // Box class comes under swing package
        // mb.add(admin);

         
        

         

      

        setVisible(true);
    }

    public static void main(String[] args) {
        new project("","","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      String msg = e.getActionCommand();
      if(msg.equals("New Customer")){
        // setVisible(false);
        new newcustomer();
      }else if(msg.equals("Customer Details")){
        new customerdetail();
      }else if(msg.equals("Deposit Details")){
        new depositdetail();

      }else if(msg.equals("Calculate Bill")){
        new calculatebill();
      }else if(msg.equals("View Information")){
        new viewinformation(newmeter);
        // new updateinformation(newmeter);
      }else if(msg.equals("Update Information")){
        new updateinformation(newmeter);
       
      }else if(msg.equals("Bill Details")){
        new billdetails(newmeter);
      }else if(msg.equals("Notepad")){
       try {
        // to check whether notepad exist or not
        Runtime.getRuntime().exec("notepad.exe");
       } catch (Exception e5) {
        e5.printStackTrace();
       }
      }else if(msg.equals("Calculator")){
        try {
          // to check whether notepad exist or not
          Runtime.getRuntime().exec("calc.exe");
         } catch (Exception e5) {
          e5.printStackTrace();
         }
      }else if(msg.equals("Exit")){
        setVisible(false);
        new login().setVisible(true);
      }else if(msg.equals("Pay Bill")){
        new paybill(newmeter);
      }else if(msg.equals("Generate Bill")){
        new generatebill(newmeter);
      }
        
    }
}
