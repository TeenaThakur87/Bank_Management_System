package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount ;
    JButton withdrawl , back;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 690, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,690);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to withdraw:");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(150,220,500,20);
        image.add(text);
        
         amount=new JTextField();
        amount.setFont(new Font("Raieway",Font.BOLD,22));
        amount.setBounds(150,250,300,22);
        image.add(amount);
        
         withdrawl=new JButton("Withdraw");
        withdrawl.setBounds(320,365,130,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
          back=new JButton("Back");
        back.setBounds(320,392,130,25);
       back.addActionListener(this);

        image.add(back);

        setSize(800,690);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
           }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawl){
            String number=amount.getText();
            Date date=new Date();
            if(number==""){
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            }
            else{
                try{
                Conn conn=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
              
                JOptionPane.showMessageDialog(null, "Rs "+number+" deposit successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            }   
            catch(Exception e){
                System.out.println(e);
                    }
            }
        }   else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
