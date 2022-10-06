// package com.ems.electricity_management_system;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class meterinfo extends JFrame implements ActionListener {
    String meterno;
    JLabel met1,ml,mt;
    Choice location,mtype,pctype,billt;
    JButton next;
    
    meterinfo(String meterno){
        this.meterno=meterno;
        // storing global variable into local variable.
        setSize(700,500);
        setLocation(400,100);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Railway",Font.PLAIN,24));
        p.add(heading);

        JLabel met = new JLabel("Meter Number           : ");
        met.setBounds(100, 80, 200, 20);
        met.setFont(new Font("Railway",Font.BOLD,16));
        p.add(met);
        met1 = new JLabel(meterno);
        met1.setBounds(290, 80, 100, 20);
        met1.setFont(new Font("Railway",Font.BOLD,16));
        p.add(met1);

        JLabel ml = new JLabel("Meter Location          : ");
        ml.setBounds(100, 120, 190, 20);
        ml.setFont(new Font("Railway",Font.BOLD,16));
        p.add(ml);
         location = new Choice();
         location.add("Select");   
         location.add("Inside");   
         location.add("Outside"); 
         location.setBounds(290, 120, 150, 25);
         location.setBackground(Color.WHITE);
         p.add(location);  

         JLabel mt = new JLabel("Meter Type                 : ");
        mt.setBounds(100, 160, 190, 20);
        mt.setFont(new Font("Railway",Font.BOLD,16));
        p.add(mt);
         mtype = new Choice();
         mtype.add("Select");   
         mtype.add("Electric Meter");   
         mtype.add("Solar Meter"); 
         mtype.add("Smart Meter"); 
         mtype.setBounds(290, 160, 150, 25);
         mtype.setBackground(Color.WHITE);
         p.add(mtype);  

         JLabel pc = new JLabel("Phase Code               : ");
         pc.setBounds(100, 200, 190, 20);
         pc.setFont(new Font("Railway",Font.BOLD,16));
         p.add(pc);
          pctype = new Choice();
          pctype.add("Select");   
          pctype.add("011");   
          pctype.add("022"); 
          pctype.add("033"); 
          pctype.add("044"); 
          pctype.add("055"); 
          pctype.add("066"); 
          pctype.add("077"); 
          pctype.add("088"); 
          pctype.add("099"); 
          pctype.setBounds(290, 200, 150, 25);
          pctype.setBackground(Color.WHITE);
          p.add(pctype);  

          JLabel bt = new JLabel("Bill Type                      : ");
          bt.setBounds(100, 240, 190, 20);
          bt.setFont(new Font("Railway",Font.BOLD,16));
          p.add(bt);
          billt = new Choice();
          billt.add("Select");   
          billt.add("Normal");   
          billt.add("Industrial"); 
         billt.setBounds(290, 240, 150, 25);
          billt.setBackground(Color.WHITE);
          p.add(billt);   

          JLabel days = new JLabel("Days                             : ");
          days.setBounds(100, 280, 190, 20);
          days.setFont(new Font("Railway",Font.BOLD,16));
          p.add(days);
          
          JLabel days1 = new JLabel("30 Days");
          days1.setBounds(290, 280, 190, 20);
          days1.setFont(new Font("Railway",Font.BOLD,16));
          p.add(days1);

          JLabel note = new JLabel("Note                             : ");
          note.setBounds(100, 320, 190, 20);
          note.setFont(new Font("Railway",Font.BOLD,16));
          p.add(note);
          
          JLabel note1 = new JLabel("By Default Bill is calculated for"+"\n"+" 30 days only.");
          note1.setBounds(270, 320, 390, 20);
          note1.setFont(new Font("Railway",Font.BOLD,12));
          p.add(note1);

          //  adding button       
          next = new JButton("Submit");
          next.setBounds(240, 390, 100, 25);
          next.setForeground(Color.WHITE);
          next.setBackground(Color.BLACK);
          next.addActionListener(this);
          p.add(next);   
          
             

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
        new meterinfo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next){
            String meter = meterno;
            String loc = location.getSelectedItem();
            String typ = mtype.getSelectedItem();
            String phase = pctype.getSelectedItem();
            String bill = billt.getSelectedItem();
            String days = "30";
    
            String query1 = "insert into meter_info values('"+meter+"','"+loc+"','"+typ+"','"+phase+"','"+bill+"','"+days+"')";
            

        try {
              conn c = new conn();
              c.s.executeUpdate(query1);
            System.out.println("values inserted in meter_info table");
            JOptionPane.showMessageDialog(null,"meter information added successfully" );

            setVisible(false);
            new moremeter(meter).setVisible(true);
            // new frame
        } catch (Exception e2) {
           
        
    }
}
}
}
