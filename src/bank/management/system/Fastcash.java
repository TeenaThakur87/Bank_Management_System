package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,pinchange,fastcash,exit,balanceenquiry,ministatement;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        //this.pinnumber=pinnumber;
                setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800, 670,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,670);
        add(image);
        
        JLabel text=new JLabel("Select withdrawl amount");
        text.setBounds(190,210,500,30);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);
        
         deposit=new JButton("Rs 100");
        deposit.setBounds(140,310,120,20);
       // deposit.setBackground(Color.BLACK);
       // deposit.setForeground(Color.white);
        deposit.addActionListener(this);

        image.add(deposit);
        
         withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(320,310,140,20);
//        withdrawl.setBackground(Color.BLACK);
//        withdrawl.setForeground(Color.white);
 withdrawl.addActionListener(this);

        image.add(withdrawl);
        
         ministatement=new JButton("Rs 1000");
        ministatement.setBounds(320,335,140,20);
//        withdrawl.setBackground(Color.BLACK);
//        withdrawl.setForeground(Color.white);
 ministatement.addActionListener(this);

        image.add(ministatement);

        
         fastcash=new JButton("Rs 2000");
        fastcash.setBounds(140,335,120,20);
        //fastcash.setBackground(Color.BLACK);
      //  fastcash.setForeground(Color.white);
       fastcash.addActionListener(this);

        image.add(fastcash);
        
         pinchange=new JButton("5000");
        pinchange.setBounds(140,360,120,20);
         pinchange.addActionListener(this);

        //fastcash.setBackground(Color.BLACK);
      //  fastcash.setForeground(Color.white);
        image.add(pinchange);
        
          balanceenquiry=new JButton("Rs 10,000");
        balanceenquiry.setBounds(320,360,140,20);
         balanceenquiry.addActionListener(this);

//        withdrawl.setBackground(Color.BLACK);
//        withdrawl.setForeground(Color.white);
        image.add(balanceenquiry);
        
          exit=new JButton("Back");
        exit.setBounds(320,385,140,20);
        exit.addActionListener(this);
//        withdrawl.setBackground(Color.BLACK);
//        withdrawl.setForeground(Color.white);
        image.add(exit);
        



        
    setSize(800,690);
    setLocation(200,0);
    setUndecorated(true);
    setVisible(true);
            
   }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
       }
        else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn conn=new Conn();
            try{
            ResultSet rs=conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            int balance=0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                balance+=Integer.parseInt(rs.getString("amount"));
                
            }
            else{
                    balance-=Integer.parseInt(rs.getString("amount"));

                    }
            }
            if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
            JOptionPane.showMessageDialog(null,"Insufficient Balance");
            return;

            }
            Date date=new Date();
            String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
            conn.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited successfully");
             setVisible(false);
             new Transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        

    }
    public static void main(String[] args) {
        new Fastcash("");
    }
}
