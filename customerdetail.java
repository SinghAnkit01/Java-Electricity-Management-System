

// package com.ems.electricity_management_system;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.lang.reflect.Method;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class customerdetail extends JFrame implements ActionListener {

    Choice metno,metno1;
    JTable table;
    JButton search,print;
    customerdetail(){
        // we can search user through their meter-no to check whether user had paid the bill or not
        super("Customer Detail");
        setSize(1200,650);
        setLocation(120,50);
        setLayout(null);

        JLabel meter = new JLabel("Search customer by meter Number");
        meter.setBounds(290,20,220 ,22);
        add(meter);
        metno = new Choice();
        metno.setBounds(510,20 ,150 ,20 );
        add(metno);
        metno.add("select");

        // accessing all the meter no from customer table
        try {
            conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from customer");
           while (rs.next()) {
           metno.add(rs.getString("meter_no"));
            // this will return string and we can store it into choice class using add method
           }
            
        } catch (Exception e) {
          e.printStackTrace();
        }

        
    table = new JTable();
    //    inserting data into table
    try {
        conn c = new conn();
      ResultSet rs = c.s.executeQuery("select * from customer");
      table.setModel(DbUtils.resultSetToTableModel(rs));

    //   after using this method it make sure that table has been created



    } catch (Exception e) {
        e.printStackTrace();
    }
    //    adding scroll-bar to table
    JScrollPane sp = new JScrollPane(table);
    // passing object of JTable class.
    sp.setBounds(0, 50, 1200, 650);
    // setBounds() will not work because we have deleted seLayout() Method 
    add(sp);
    // by default scrollpane will be at center 

    // adding button
    print = new JButton("Print");
    print.addActionListener(this);
    // we have deleted seLayout() Method it means bydefault layout will be border layout so place it at south direction.
    print.setBounds(20,20,80,20);
    // add(print,"South");
    add(print);

    search = new JButton("Search");
    search.setBounds(700,20,80,20);
    search.addActionListener(this);
    add(search);


        setVisible(true);

    }

    public static void main(String[] args) {
        new customerdetail();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == search){
        System.out.println("search");
        String query = "select * from customer where meter_no ='"+metno.getSelectedItem()+"'  ";
        try {
            conn c = new conn();
            ResultSet rs1 = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs1));
        } catch (Exception e5) {
          e5.printStackTrace();
        }
       }else{
        System.out.println("print");
        try {
            // adding commands of printer
            table.print();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
       }
        
    }
}

