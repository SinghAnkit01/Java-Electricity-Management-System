import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class generatebill extends JFrame implements ActionListener {
    String newmeter;
    JButton bill,print;
    Choice month;
    JTextArea area;
    generatebill(String newmeter){
        this.newmeter=newmeter;
        setSize(500,700);

        setLocation(450,30);
        // setUndecorated(true);
        setLayout(new BorderLayout());
        JPanel p = new JPanel();
        JLabel heading = new JLabel("Generate Bill For :");
        heading.setFont(new Font("Railway",Font.BOLD,20));
        JLabel meterno = new JLabel(newmeter);
        // JLabel meterno = new JLabel("123232  ");
        meterno.setFont(new Font("Railway",Font.BOLD,20));
         month = new Choice();
        // month.setBounds(520,20 ,150 ,20 );
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
        // adding month on panel    
         area = new JTextArea(50,15);
        area.setText("\n\n\t -----------Click on the-------------\n\t  Generate Bill Button to get the \n\t bill of the Selected Month.");  
        area.setFont(new Font("Railway",Font.BOLD,16));
         // \n for new row and \t for space works as tab 
        JScrollPane js = new JScrollPane(area);
         bill = new JButton("Click here to generate Bill");
        bill.setBackground(Color.BLACK);
        bill.setForeground(Color.WHITE);
        bill.addActionListener(this);
        // adding all the items on panel
        p.add(heading);
        p.add(meterno);
        p.add(month);
        // now adding panel onto the frame
        add(p,"North");
        // adding textare onto panel but Jscrollpane contains textarea
        add(js,"Center");
        // adding button on south
        add(bill,"South");

        // print = new JButton("Print");
        // // print.setBackground(Color.BLACK);
        // // print.setForeground(Color.WHITE);
        // print.addActionListener(this);
        // print.setBounds(0, ABORT, WIDTH, HEIGHT);
        
        print = new JButton("Print");
        // print.setBackground(Color.BLACK);
        // print.setForeground(Color.WHITE);
        print.addActionListener(this);
        print.setBounds(190, 540, 100, 30);
        area.add(print);




        setVisible(true);
    }

    public static void main(String[] args) {
        new generatebill("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bill){
            System.out.println("Bill generated");

            try {
                conn c = new conn();
                String month1 = month.getSelectedItem();
                 // heading
                area.setText("\tMaharashtra Power Limited\n      ELECTRICITY BILL GENERATED FOR THE MONTH OF\n\t          " + month1 + " , 2022\n\n");
                ResultSet rs = c.s.executeQuery("select * from customer where meter_no ='"+newmeter+"'  ");
                // ResultSet rs = c.s.executeQuery("select * from customer where meter_no = 791191  ");
                if(rs.next()){
                    area.append("\n          Customer Name : "+ rs.getString("name"));
                    area.append("\n          Meter Number     : "+ rs.getString("meter_no"));
                    area.append("\n          Address                : "+ rs.getString("address"));
                    area.append("\n          State                      : "+ rs.getString("state"));
                    area.append("\n          City                        : "+ rs.getString("city"));
                    String email = rs.getString("email");
                    String email1 = email.substring(3, 14);
                    String email2 = email.replaceFirst(email1,"XXXXXXXXXXX");
                    area.append("\n          Email-Id                : "+ email2);

                    String phone = rs.getString("phone");
                    String firstsevenchar = phone.substring(0,7);
                    String newphone = phone.replaceFirst(firstsevenchar, "XXXXXXX");
                    area.append("\n          Phone                   : "+ newphone);
                    area.append("\n---------------------------------------------------------------------- ");

           
                }else{
                    System.out.println("no records");
                }
                 rs = c.s.executeQuery("select * from moremeter where meter_no ='"+newmeter+"'  ");
                if(rs.next()){
                    area.append("\n          Consumer Number : "+ rs.getString("consumer_no"));
                    area.append("\n          Bu Number               : "+ rs.getString("bu_no"));
                    
           
                }else{
                    System.out.println("no records");
                }
                rs = c.s.executeQuery("select * from meter_info where meter_no ='"+newmeter+"' ");
                if(rs.next()){
                    area.append("\n          Meter Location         : "+ rs.getString("meter_location"));
                    area.append("\n          Meter Type                : "+ rs.getString("meter_type"));
                    area.append("\n          Phase Code              : "+ rs.getString("phase_code"));
                    area.append("\n          Bill Type                    : "+ rs.getString("bill_type"));
                    area.append("\n          Days                           : "+ rs.getString("days"));
                    area.append("\n---------------------------------------------------------------------- ");
                    
           
                }else{
                    System.out.println("no records");
                }

                rs = c.s.executeQuery("select * from tax");
                if(rs.next()){
                    area.append("\n          Cost Per Unit                : "+ rs.getString("cost_per_unit"));
                    area.append("\n          Meter Rent                     : "+ rs.getString("meter_rent"));
                    area.append("\n          Service Charge            : "+ rs.getString("service_charge"));
                    area.append("\n          Swacch Bharat Cess  : "+ rs.getString("swacch_bharat_cess"));
                    area.append("\n          Fixed Tax                      : "+ rs.getString("fixed_tax"));
                    area.append("\n---------------------------------------------------------------------- ");
                    
           
                }else{
                    System.out.println("no records");
                }
                rs = c.s.executeQuery("select * from bill where meter_no='"+newmeter+"' and month='"+month.getSelectedItem()+"'  ");
                if(rs.next()){
                    area.append("\n          Current Month                : "+ rs.getString("month"));
                    area.append("\n          Units Consumed            : "+ rs.getString("units"));
                    // int a = 10;
                    area.append("\n          Total Charges                 : "+ rs.getString("totalbill"));
                    int a = Integer.parseInt(rs.getString("totalbill"));
                    int b = a+10;
                    area.append("\n---------------------------------------------------------------------- ");
                    area.append("\n          Total Payable Bill           : "+b + "(10rs For Additional Charges)");
                    
                    
           
                }else{
                   JOptionPane.showMessageDialog(null, "No records Found");
                   area.append("\n  Bill not generated yet.");
                }
                
               
                
               

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }else if(e.getSource() == print){
            System.out.println("print");
            try {
                area.print();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
         
        }
        
    }
}
