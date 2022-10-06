
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

// swing package comes from javaextended

public class splash extends JFrame implements Runnable{
    splash(){
        Thread t;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        // image.setBounds(0, 0,730, 550);
        add(image);

        setVisible(true);


            int x=1;
            for(int i = 2; i<590; i+=4,x+=1){
                // for increasing speed we can add 2*i in width will increase faster than height.
                setSize(i + x,i);
                // this will enable jframe to open from (width=1,height=1) to (width=500,height=500).
                setLocation(700-((i + x)/2),400-(i/2));
                // location will decrease faster than size anf frame will open at all the direction
                // if i dont specify -(i/2) frame will open at upper side to open at middele we need to decrease its height.
                // size will increase and location will decrease.
                // setLocation(700-(i = x/2),400-(i/2));
                // after giving this length will decrease and open slowly.
            }   

            // try-catch of sleep()

            try {
                // speed to open image
                Thread.sleep(30);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            t = new Thread(this);
            t.start();


            // creating frame using JFrame class

            // setLayout(null);
			// setUndecorated(true);
            setVisible(true);
			
            // setsize and setlocation are static we cant change them at runtime if we want to make them dynamic if we 
            // want to change them duaing run-time we need to create threads(multi-threading) 
    }
        public static void main(String[] args) {
           new splash();
        //creating anonymous object as mention above
        // splash s = new splash();
        // if we want to use object of class in any case thaats why we create like this  
        }
        @Override
        public void run() {
        //    we need to pause our execution for 7 seconds
        try {
            Thread.sleep(5000);    
            // 7000ms is equlvalent to 7sec
            setVisible(false);
            // login frame
            new login();
        } catch (Exception e) { 
            e.printStackTrace();
        }
            
        }
}
