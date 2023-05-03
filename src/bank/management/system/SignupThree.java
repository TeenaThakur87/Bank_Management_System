package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3: Account details");
        l1.setFont(new Font("Raeiway",Font.BOLD,22));
        l1.setBounds(280,20,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raeiway",Font.BOLD,22));
        type.setBounds(100,70,200,40);
        add(type);
        
        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Raeiway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,120,200,20);
        add(r1);
        
         r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raeiway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,120,200,20);
        add(r2);
        
         r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raeiway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,150,200,20);
        add(r3);
        
         r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raeiway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,150,250,20);
        add(r4);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raeiway",Font.BOLD,22));
        card.setBounds(100,200,150,30);
        add(card);
        
         JLabel number=new JLabel(" XXXX-XXXX-XXXX-5518");
          number.setFont(new Font("Raeiway",Font.BOLD,18));
        number.setBounds(340,200,300,30);
        add(number);
        
         JLabel carddetail=new JLabel("Your 16 Digit Card Number");
          carddetail.setFont(new Font("Raeiway",Font.BOLD,12));
        carddetail.setBounds(100,230,300,15);
        add(carddetail);

        
        JLabel pin=new JLabel("Pin :");
        pin.setFont(new Font("Raeiway",Font.BOLD,22));
        pin.setBounds(100,270,150,30);
        add(pin);
        
         JLabel pnumber=new JLabel(" XXXX");
          pnumber.setFont(new Font("Raeiway",Font.BOLD,18));
         pnumber.setBounds(340,270,300,30);
        add(pnumber);

         JLabel pindetail=new JLabel("Your 4 Digit Pinr");
          pindetail.setFont(new Font("Raeiway",Font.BOLD,12));
        pindetail.setBounds(100,300,300,15);
        add(pindetail);

        
        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raeiway",Font.BOLD,22));
        services.setBounds(100,350,200,30);
        add(services);
        
        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raeiway",Font.BOLD,16));
        c1.setBounds(100,400,200,30);
        add(c1);
        
        c2=new JCheckBox(" Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raeiway",Font.BOLD,16));
        c2.setBounds(350,400,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raeiway",Font.BOLD,16));
        c3.setBounds(100,450,200,30);
        add(c3);
        
        c4=new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raeiway",Font.BOLD,16));
        c4.setBounds(350,450,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raeiway",Font.BOLD,16));
        c5.setBounds(100,500,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raeiway",Font.BOLD,16));
        c6.setBounds(350,500,200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raeiway",Font.BOLD,16));
        c7.setBounds(100,550,690,20);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raeiway",Font.BOLD,16));
        submit.setBounds(450,595,100,25 );
        submit.addActionListener(this);
         add(submit);
         
          cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raeiway",Font.BOLD,16));
        cancel.setBounds(250,595,100,25 );
        cancel.addActionListener(this);
         add(cancel);
        
         getContentPane().setBackground(Color.WHITE);
         
        setSize(900,680);
        setLocation(250,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accounttype=null;
            if(r1.isSelected()){
                accounttype="Saving Account";
            }
           else if(r2.isSelected()){
                accounttype="Fixed Deposit ";
            }
           else if(r3.isSelected()){
                accounttype="Current Account";
            }
           else if(r4.isSelected()){
                accounttype="Reccuring Deposit Account";
            }
            Random random=new Random();
            String cardnumber=""+Math.abs(random.nextLong()%90000000L+504093600000000L);
            String pinnumber=""+Math.abs(random.nextLong()%9000L+1000L);
            String facility="";
            if(c1.isSelected()){
                facility+="ATM Card";
            }
                 
             if(c2.isSelected()){
                facility+="Internet Banking";
            }
              if(c3.isSelected()){
                facility+="Mobile Banking";
            }
             if(c4.isSelected()){
                facility+="Email & SMS Alerts";
            }
            if(c5.isSelected()){
                facility+="Cheque Book";
            }
            if(c6.isSelected()){
                facility+="E-Statement";
            }

        
        try{
            if(accounttype.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is required");
            }
            else{
                Conn conn=new Conn();
                
               String query1="insert into signupdetail3 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
               conn.s.executeUpdate(query1);
               conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n Pin: "+pinnumber);
                setVisible(false);
                new Deposit(pinnumber).setVisible(false);
            }
            
        }catch(Exception e){
           System.out.println(e);
        }
      }
        else if(ae.getSource()==cancel){
        setVisible(false);
        new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
