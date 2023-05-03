package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,pinchange,fastcash,exit,balanceenquiry,ministatement;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        this.pinnumber=pinnumber;
                setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 670,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,670);
        add(image);
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(190,210,500,30);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
        
         deposit=new JButton("Deposit");
        deposit.setBounds(140,310,120,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(320,310,140,20);
       withdrawl.addActionListener(this);
       image.add(withdrawl);
        
        
        
         fastcash=new JButton("Fast Cash");
        fastcash.setBounds(140,335,120,20);
       fastcash.addActionListener(this);

        image.add(fastcash);
        
         pinchange=new JButton("Pin Chnage");
        pinchange.setBounds(140,360,120,20);
         pinchange.addActionListener(this);
        image.add(pinchange);
        
          balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(320,335,140,20);
         balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
          exit=new JButton("Exit");
        exit.setBounds(320,360,140,20);
        exit.addActionListener(this);
        image.add(exit);
        



        
    setSize(800,690);
    setLocation(200,0);
    setUndecorated(true);
    setVisible(true);
            
   }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
           System.exit(0);
       }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
         else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);


        }
         else if(ae.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
}
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);


        }


            }
    public static void main(String[] args) {
        new Transaction("");
    }
}
