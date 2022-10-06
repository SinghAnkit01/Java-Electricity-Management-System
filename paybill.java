import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
// import java.util.function.Consumer;
public class paybill extends JFrame implements ActionListener {
    Choice metno1;
    String newmeter;
    JButton pay,back;
    paybill(String newmeter){
        this.newmeter=newmeter;
        setSize(900,600);
        setLocation(250,60);
        setLayout(null);

        JLabel heading = new JLabel("Electricity Bill");
        heading.setFont(new Font("Railway",Font.BOLD,24));
        heading.setBounds(330, 10,400 , 30);
        add(heading);
        // meterno
        JLabel meter = new JLabel("Meter Number :");
        meter.setFont(new Font("Railway",Font.BOLD,24));
        meter.setBounds(35,80 ,200 , 25);
        add(meter);
        JLabel meter1 = new JLabel("");
        meter1.setFont(new Font("Railway",Font.BOLD,24));
        meter1.setBounds(300,80 ,200 , 25);
        add(meter1);
        // name
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Railway",Font.BOLD,24));
        name.setBounds(35,140 ,200 , 25);
        add(name);
        JLabel name1 = new JLabel("");
        name1.setFont(new Font("Railway",Font.BOLD,24));
        name1.setBounds(300,140 ,200 , 25);
        add(name1);
        // month
        JLabel month = new JLabel("Month :");
        month.setFont(new Font("Railway",Font.BOLD,24));
        month.setBounds(35,200 ,200 , 25);
        add(month);
        // JLabel month1 = new JLabel("");
        // month1.setFont(new Font("Railway",Font.BOLD,24));
        // month1.setBounds(300,200 ,200 , 25);
        // add(month1);

        metno1 = new Choice();
        metno1.setBounds(300,200 ,200 ,20 );
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
        // units
        JLabel units = new JLabel("Units :");
        units.setFont(new Font("Railway",Font.BOLD,24));
        units.setBounds(35,260 ,200 , 25);
        add(units);
        JLabel units1 = new JLabel("");
        units1.setFont(new Font("Railway",Font.BOLD,24));
        units1.setBounds(300,260 ,200 , 25);
        add(units1);
           // totalbill
           JLabel tb = new JLabel("TotalBill :");
           tb.setFont(new Font("Railway",Font.BOLD,24));
           tb.setBounds(35,320 ,200 , 25);
           add(tb);
           JLabel tb1 = new JLabel("");
           tb1.setFont(new Font("Railway",Font.BOLD,24));
           tb1.setBounds(300,320 ,200 , 25);
           add(tb1);
           // bill status
           JLabel bs = new JLabel("Status :");
           bs.setFont(new Font("Railway",Font.BOLD,24));
           bs.setBounds(35,380 ,200 , 25);
           add(bs);
           JLabel bs1 = new JLabel("");
           bs1.setFont(new Font("Railway",Font.BOLD,24));
           bs1.setBounds(300,380 ,200 , 25);
           bs1.setForeground(Color.RED);
           add(bs1);
            // Consumer no
            JLabel cn = new JLabel("ConsumerNo :");
            cn.setFont(new Font("Railway",Font.BOLD,24));
            cn.setBounds(500,80 ,200 , 25);
            add(cn);
            JLabel cn1 = new JLabel("");
            cn1.setFont(new Font("Railway",Font.BOLD,24));
            cn1.setBounds(700,80 ,200 , 25);
           add(cn1);
           // bu no
           JLabel bu = new JLabel("BU-Number :");
           bu.setFont(new Font("Railway",Font.BOLD,24));
           bu.setBounds(500,140 ,200 , 25);
           add(bu);
           JLabel bu1 = new JLabel("44");
           bu1.setFont(new Font("Railway",Font.BOLD,24));
           bu1.setBounds(700,140 ,200 , 25);
          add(bu1);

          try {
            conn c = new conn();
            // taking meterno and name from customer table
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+newmeter+"' ");
            while (rs.next()) {
                meter1.setText(newmeter);
                name1.setText(rs.getString("name"));
            }
            ResultSet rs1 = c.s.executeQuery("select * from moremeter where meter_no = '"+newmeter+"' ");
            while (rs1.next()) {
                cn1.setText(rs1.getString("Consumer_no"));
                bu1.setText(rs1.getString("bu_no"));
            }
            // ResultSet rs2 = c.s.executeQuery("select * from bill where meter_no = '"+newmeter+"' and month = '"+metno1.getSelectedItem()+"' ");
            ResultSet rs2 = c.s.executeQuery("select * from bill where meter_no = '"+newmeter+"' and month = '"+metno1.getSelectedItem()+"' ");
            while (rs2.next()) {
                units1.setText(rs2.getString("units"));
                tb1.setText(rs2.getString("totalbill"));
                bs1.setText(rs2.getString("status"));
            }
          } catch (Exception e) {
           e.printStackTrace();
          }
        //   applying actionlistener to choice class if user wants to see his bill details according to month as far as when he changed the 
        // the month in the drop-down list a databse query will be hit again and again
          metno1.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    // taking meterno and name from customer table
                   
                  
                    // ResultSet rs2 = c.s.executeQuery("select * from bill where meter_no = '"+newmeter+"' and month = '"+metno1.getSelectedItem()+"' ");
                    ResultSet rs2 = c.s.executeQuery("select * from bill where meter_no = '"+newmeter+"' and month = '"+metno1.getSelectedItem()+"' ");
                    if (rs2.next()) {
                        units1.setText(rs2.getString("units"));
                        tb1.setText(rs2.getString("totalbill"));
                        bs1.setText(rs2.getString("status"));
                        // to check whether use has paid the bill or not  if paid pay button will disable or else enable. 
                        String vv = rs2.getString("status");
                        System.out.println(vv);
                        if(vv.equals("Not Paid")){
                            pay.setEnabled(true);
                        }else{
                            pay.setEnabled(false);
                        }

                        
                    }else{
                        units1.setText("Not-Generated");
                        tb1.setText("Not-Generated");
                        bs1.setText("Not-Generated");
                        // bs1.setForeground(Color.GREEN);
                    }
                  } catch (Exception e1) {
                   e1.printStackTrace();
                  }
                
            }
            
          });
          
        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setBounds(200, 450, 100, 25);
        add(pay);

          
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(400, 450, 100, 25);
        add(back);

        ImageIcon vcus = new ImageIcon(ClassLoader.getSystemResource("bill.png"));
        Image vcus1 = vcus.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon vcus2 = new ImageIcon(vcus1);
        JLabel image = new JLabel(vcus2);
        image.setBounds(400, 200, 600, 300);
        add(image);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public static void main(String[] args) {
        new paybill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == pay){
        try {
            conn c  = new conn();
            c.s.executeUpdate("update bill set status='Paid' where meter_no='"+newmeter+"' and month ='"+metno1.getSelectedItem()+"' ");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        setVisible(false);
        new paytm(newmeter);
       }else{
        setVisible(false);
       }
        
    }
}
