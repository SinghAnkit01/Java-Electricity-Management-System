import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.sql.ResultSet;
public class paytm extends JFrame implements ActionListener {
    String newmeter;
    JButton back;
    paytm(String newmeter){
        this.newmeter=newmeter;
        // calling paytm website
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        try {
            // j.setPage("https://paytm.com/");
                j.setPage("https://paytm.com/online-payments");
        } catch (Exception e) {
           j.setContentType("text/html");
           j.setText("<html>Could not load</html>");
        }
        
        JScrollPane pane = new JScrollPane(j);
        add(pane);

         back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(640, 20, 100, 30);
        j.add(back);
        
        setSize(800,600);
        setLocation(300,80);
        // setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new paytm("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new paybill(newmeter);
        
    }
}
