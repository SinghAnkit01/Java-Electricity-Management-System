// package com.ems.electricity_management_system;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class calculatebill extends JFrame implements ActionListener {

    JLabel note1,days1;
    Choice mno, month;
    JButton next, cancel;
    JTextField consume;

    calculatebill() {

        // storing global variable into local variable.
        setSize(700, 500);
        setLocation(400, 100);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(150, 10, 400, 25);
        heading.setFont(new Font("Railway", Font.PLAIN, 24));
        p.add(heading);

        JLabel met = new JLabel("Meter Number                : ");
        met.setBounds(80, 80, 200, 20);
        met.setFont(new Font("Railway", Font.BOLD, 16));
        p.add(met);
        mno = new Choice();
        mno.add("select");

        // accessing all the meter no from customer table
        try {
            conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from customer");
           while (rs.next()) {
           mno.add(rs.getString("meter_no"));
            // this will return string and we can store it into choice class using add method
           }
            
        } catch (Exception e) {
          
        }
        
        mno.setBounds(290, 80, 150, 25);
        mno.setBackground(Color.WHITE);
        p.add(mno);

        JLabel days = new JLabel("Address                           : ");
        days.setBounds(80, 180, 190, 20);
        days.setFont(new Font("Railway", Font.BOLD, 16));
        p.add(days);

        JLabel days1 = new JLabel();
        days1.setBounds(290, 180, 590, 20);
        days1.setFont(new Font("Railway", Font.BOLD, 12));
        p.add(days1);

         JLabel note = new JLabel("Name                                : ");
        note.setBounds(80, 130, 190, 20);
        note.setFont(new Font("Railway", Font.BOLD, 16));
        p.add(note);

        JLabel note1 = new JLabel();
        note1.setBounds(290, 130, 390, 20);
        note1.setFont(new Font("Railway", Font.BOLD, 12));
        p.add(note1);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+mno.getSelectedItem()+"' ");
            while (rs.next()) {
                days1.setText(rs.getString("address"));
                note1.setText(rs.getString("name"));
                // System.out.println(days1);
                // System.out.println(note1);
                // fetching values from database and printing it into the label using setText() method
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // adding ItemListener() to choice class
        mno.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                // String select = mno.getSelectedItem();
                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+mno.getSelectedItem()+"' ");
                    while (rs.next()) {
                        days1.setText(rs.getString("address"));
                        note1.setText(rs.getString("name"));
                        // System.out.println(days1);
                        // System.out.println(note1);
                        // fetching values from database and printing it into the label using setText() method
                        // if(select == select){
                        //     days1.setText("");
                        //     note1.setText("");
                        // }
                        
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                
            }
            
        });
       
        JLabel uc = new JLabel("Unit Consumed             : ");
        uc.setBounds(80, 230, 210, 20);
        uc.setFont(new Font("Railway", Font.BOLD, 16));
        p.add(uc);

        consume = new JTextField();
        consume.setBounds(290, 230, 150, 25);
        p.add(consume);

        JLabel ml = new JLabel("Month                               : ");
        ml.setBounds(80, 280, 210, 20);
        ml.setFont(new Font("Railway", Font.BOLD, 16));
        p.add(ml);
        month = new Choice();
        month.add("Select");
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        month.setBounds(290, 280, 150, 25);
        month.setBackground(Color.WHITE);
        p.add(month);

        // adding button
        next = new JButton("Submit");
        next.setBounds(150, 350, 100, 25);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        p.add(next);

        // adding button
        cancel = new JButton("Cancel");
        cancel.setBounds(300, 350, 100, 25);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        p.add(cancel);

        // bydefault layoyt is border-layout for changing into another layout
        setLayout(new BorderLayout());
        add(p, "Center");
        // adding panel at center to border-layout;
        // if we will comment given codes we dont receive any error
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hicon2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        // add(image);
        // this will add image at center of frame
        add(image, "West");
        // border-layout works as border like east,west,north,south
        getContentPane().setBackground(Color.white);

        setVisible(true);

    }

    public static void main(String[] args) {
        new calculatebill();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            System.out.println("submit");
            String meter = mno.getSelectedItem();
            // String nm = note1.getText();
            // String add = days1.getText(); 
            String ucon = consume.getText();
            String mon1 = month.getSelectedItem();

           int totalbill = 0;
           int unit_consume = Integer.parseInt(ucon);
        //    converting string into an int value
           try {
            conn c = new conn();
            String query = "select * from tax ";
            ResultSet rs = c.s.executeQuery(query);
            // ddl command
            while (rs.next()) {
              totalbill += unit_consume * Integer.parseInt(rs.getString("cost_per_unit"));
            //   converting a resultset string value into an integer. 
            totalbill +=Integer.parseInt(rs.getString("meter_rent"));
            totalbill +=Integer.parseInt(rs.getString("service_charge"));
            totalbill +=Integer.parseInt(rs.getString("service_tax"));
            totalbill +=Integer.parseInt(rs.getString("swacch_bharat_cess"));
            totalbill +=Integer.parseInt(rs.getString("fixed_tax"));
            System.out.println(totalbill);

            }
           }catch(Exception ae){
            ae.printStackTrace();
           }

            // if(meter.equals("select")){
            //    consume.setEnabled(false);
            // }else{
            //     consume.setEnabled(true);
            // }
            // System.out.println(meter);

            // sending data into bill table
            String query2= "insert into bill values('"+meter+"','"+mon1+"','"+ucon+"','"+totalbill+"','Not Paid')";
            try {
                conn c = new conn();
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Customer Bill Generated Successfully");
                System.out.println("Data inserted in bill table successfully");
            } catch (Exception e4) {
               e4.printStackTrace();
            }

        } else {
            System.out.println("cancel");
            setVisible(false);
        }
    }
}
