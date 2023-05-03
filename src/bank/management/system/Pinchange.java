package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    JPasswordField pin,rpin;
    JButton change , back;
    String pinnumber;
    Pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        
        
         setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 670,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,670);
        add(image);
        setBounds(0,0,800,670);
        add(image);
        
        JLabel text=new JLabel("Change your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(220,210,500,30);
        image.add(text);
        
        JLabel pintext=new JLabel("New Pin : ");
        pintext.setForeground(Color.WHITE);
       pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(150,250,300,25);
        image.add(pintext);
        
         pin=new JPasswordField();
        pin.setFont(new Font("System",Font.BOLD,20));
         pin.setBounds(280,250,150,20);
         image.add(pin);


        
        JLabel retext=new JLabel("Re-enter Pin : ");
        retext.setForeground(Color.WHITE);
        retext.setFont(new Font("System",Font.BOLD,16));
        retext.setBounds(150,270,510,30);
        image.add(retext);

          rpin=new JPasswordField();
        rpin.setFont(new Font("System",Font.BOLD,20));
         rpin.setBounds(280,280,150,20);
           image.add(rpin);
           
            change=new JButton("Change");
            change.setFont(new Font("System",Font.BOLD,20));
         change.setBounds(330,350,120,20);
         change.addActionListener(this);
           image.add(change);

        
         
            back=new JButton("Back");
            back.setFont(new Font("System",Font.BOLD,20));
         back.setBounds(330,380,120,20);
         back.addActionListener(this);
           image.add(back);


        
        setSize(800,670);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String newpin=pin.getText();
            String rnewpin=rpin.getText();
            
            if(!rnewpin.equals(newpin)){
                JOptionPane.showMessageDialog(null, "Entered pin doed't match");
                return;
            }
             if(rnewpin.equals("")){
                JOptionPane.showMessageDialog(null, "please enter the pin");
                return;
            }
              if(newpin.equals("")){
                JOptionPane.showMessageDialog(null, "please re-enter the pin");
                return;
            }
              Conn conn =new Conn();
              String query1="update bank set pin='"+rnewpin+"' where pin='"+pinnumber+"'";
              String query2="update login set pin='"+rnewpin+"' where pin='"+pinnumber+"'";
              String query3="update signupdetail3 set pin='"+rnewpin+"' where pin='"+pinnumber+"'";

              conn.s.executeUpdate(query1);
              conn.s.executeUpdate(query2);
              conn.s.executeUpdate(query3);
               JOptionPane.showMessageDialog(null, "Pin change successfully");
               setVisible(false);
               new Transaction(rnewpin).setVisible(true);

              
        }catch(Exception e){
            System.out.println(e);
        }
    }
        else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
       new Pinchange("").setVisible(true);
    }
    
}
