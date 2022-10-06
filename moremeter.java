import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class moremeter extends JFrame implements ActionListener {
    String newmeter;
    // String meterno;
    JLabel met1,con,con1,bu,bu1;
    Choice location;
    JButton next;
     moremeter(String newmeter){
        this.newmeter=newmeter;
        setSize(700,500);
        setLocation(400,100);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        JLabel heading = new JLabel("Additional Meter Information");
        heading.setBounds(150, 10, 400, 25);
        heading.setFont(new Font("Railway",Font.PLAIN,24));
        p.add(heading);

        JLabel met = new JLabel("Meter Number                 : ");
        met.setBounds(100, 80, 200, 20);
        met.setFont(new Font("Railway",Font.BOLD,16));
        p.add(met);
        met1 = new JLabel(newmeter);
        met1.setBounds(290, 80, 100, 20);
        met1.setFont(new Font("Railway",Font.BOLD,16));
        p.add(met1);

        JLabel con = new JLabel("Consumer Number        : ");
        con.setBounds(100, 130, 200, 20);
        con.setFont(new Font("Railway",Font.BOLD,16));
        p.add(con);
        con1 = new JLabel("");
        con1.setBounds(290, 130, 100, 20);
        con1.setFont(new Font("Railway",Font.BOLD,16));
        p.add(con1);
        Random ran = new Random();
        long number = ran.nextLong() % 1000000000;
        con1.setText( " " + Math.abs(number));

        JLabel bu = new JLabel("Bu Number                      : ");
        bu.setBounds(100, 180, 200, 20);
        bu.setFont(new Font("Railway",Font.BOLD,16));
        p.add(bu);
        bu1 = new JLabel("");
        bu1.setBounds(290, 180, 100, 20);
        bu1.setFont(new Font("Railway",Font.BOLD,16));
        p.add(bu1);
        Random ran1 = new Random();
        long number1 = ran1.nextLong() % 1000000000;
        bu1.setText( " " + Math.abs(number1));


        JLabel ml = new JLabel("Area-Id                              : ");
        ml.setBounds(100, 230, 190, 20);
        ml.setFont(new Font("Railway",Font.BOLD,16));
        p.add(ml);
         location = new Choice();
         location.add("Select");   
         location.add("101");   
         location.add("102");   
         location.add("103"); 
         location.setBounds(290, 230, 150, 25);
         location.setBackground(Color.WHITE);
         p.add(location);  

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
        
        // button
        next = new JButton("Submit");
        next.setBounds(220, 290, 100, 30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        p.add(next);  
  
  
          setVisible(true);
     }

    public static void main(String[] args) {
        new moremeter("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == next){
        String meter1 = met1.getText();
        String area = location.getSelectedItem();
        String consumer = con1.getText();
        String buno = bu1.getText();
        String query2 = "insert into moremeter values('"+meter1+"','"+consumer+"','"+buno+"','"+area+"')";
        
        try {
            conn c  = new conn();
            c.s.executeUpdate(query2);
            System.out.println("values inserted in moremeter table");
            JOptionPane.showMessageDialog(null,"meter information added successfully" );
        } catch (Exception e1) {
            e1.printStackTrace();
        }
       }
        
    }
}
