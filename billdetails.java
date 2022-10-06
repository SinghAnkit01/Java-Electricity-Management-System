import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class billdetails extends JFrame implements ActionListener {
    JButton log3;
    JTable table;
    String newmeter;
    billdetails(String newmeter){
        this.newmeter=newmeter;
        setSize(700,650);
        setLocation(400,60);
        setLayout(null);

        // creating table
         table = new JTable();
        try {
            conn c = new conn();
            String query = "select * from bill where meter_no = '"+newmeter+"' ";
            ResultSet rs = c.s.executeQuery(query);

            // putting rows on table using
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // adding scrollbar to table means setBounds()
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 50, 700, 650);
        add(js);

         log3 = new JButton("Print");
        log3.setBounds(520,15,100,25);
        log3.addActionListener(this);
        add(log3);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public static void main(String[] args) {
        new billdetails("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == log3){
        try {
            table.print();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
       
       }
        
    }
}
