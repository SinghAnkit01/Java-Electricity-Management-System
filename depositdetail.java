// package com.ems.electricity_management_system;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class depositdetail extends JFrame implements ActionListener {

    Choice metno,metno1;
    JTable table;
    JButton search,print;
    depositdetail(){
        // we can search user through their meter-no to check whether user had paid the bill or not
        super("Deposit Detail");
        setSize(700,650);
        setLocation(400,60);

        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel meter = new JLabel("Search by meter Number");
        meter.setBounds(20,20,150 ,22);
        add(meter);
        metno = new Choice();
        metno.setBounds(180,20 ,150 ,20 );
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
        
        JLabel month1 = new JLabel("Search by Month");
        month1.setBounds(360,20,150 ,22);
        add(month1);
        metno1 = new Choice();
        metno1.setBounds(520,20 ,150 ,20 );
        metno1.add("Select");
        metno1.add("January");
        metno1.add("February");
        metno1.add("March");
        metno1.add("April");
        metno1.add("May");
        metno1.add("June");
        metno1.add("July");
        metno1.add("August");
        metno1.add("September");
        metno1.add("October");
        metno1.add("November");
        metno1.add("December");
        add(metno1);

        table = new JTable();
    //    inserting data into table
    try {
        conn c = new conn();
      ResultSet rs = c.s.executeQuery("select * from bill");
      table.setModel(DbUtils.resultSetToTableModel(rs));
    //   after using this method it make sure that table has been created



    } catch (Exception e) {
        e.printStackTrace();
    }
    //    adding scroll-bar to table
    JScrollPane sp = new JScrollPane(table);
    // passing object of JTable class.
    sp.setBounds(0, 100, 700, 600);
    add(sp);

    // adding button
    search = new JButton("Search");
    search.setBounds(20,70,80,20);
    search.addActionListener(this);
    add(search);

    print = new JButton("Print");
    print.setBounds(120,70,80,20);
    print.addActionListener(this);
    add(print);

        setVisible(true);

    }

    public static void main(String[] args) {
        new depositdetail();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == search){
        System.out.println("search");
        String query = "select * from bill where meter_no ='"+metno.getSelectedItem()+"' and month ='"+metno1.getSelectedItem()+"'  ";
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
