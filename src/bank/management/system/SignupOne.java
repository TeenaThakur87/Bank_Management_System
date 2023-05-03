package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, pinTextField,addressTextField,cityTextField,stateTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male,female,married,unmarried,other;
    
       public SignupOne(){
        setLayout(null);
        
        Random ran=new Random();
         random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raieway", Font.BOLD,33));
        formno.setBounds(150, 10, 700, 30);
        add(formno);
        
        JLabel personalDetails=new JLabel("Page 1: Personal Details ");
       personalDetails.setFont(new Font("Raieway", Font.BOLD,22));
        personalDetails.setBounds(290, 60, 300, 20);
        add(personalDetails);
        
         JLabel name=new JLabel("Name: ");
       name.setFont(new Font("Raieway", Font.BOLD,20));
       name.setBounds(100, 120, 80, 20);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raieway",Font.BOLD,14));
        nameTextField.setBounds(300, 120, 300, 25);
        add(nameTextField);
        
        JLabel fname=new JLabel("Fathers Name: ");
       fname.setFont(new Font("Raieway", Font.BOLD,20));
       fname.setBounds(100, 160, 180, 20);
        add(fname);
        
         fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raieway",Font.BOLD,14));
        fnameTextField.setBounds(300, 160, 300, 25);
        add(fnameTextField);


        
        JLabel dob=new JLabel("Date Of Birth: ");
       dob.setFont(new Font("Raieway", Font.BOLD,20));
       dob.setBounds(100, 200, 280, 20);
               add(dob);
        
         dateChooser=new JDateChooser();
        dateChooser.setBounds(300,200,180,25);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
              
        JLabel gender=new JLabel("Gender: ");
       gender.setFont(new Font("Raieway", Font.BOLD,20));
       gender.setBounds(100, 240, 200, 25);
        add(gender);
        
         male=new JRadioButton("Male");
        male.setBounds(300,240,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
             female=new JRadioButton("Female");
            female.setBounds(450,240,120,30);
            female.setBackground(Color.WHITE);

        add(female);
        
            other=new JRadioButton("Other");
            other.setBounds(630,240,100,30);
            other.setBackground(Color.WHITE);
            add(other);
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel email=new JLabel("Email Address: ");
       email.setFont(new Font("Raieway", Font.BOLD,20));
       email.setBounds(100, 290, 180, 25);
        add(email);
        
         emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raieway",Font.BOLD,14));
        emailTextField.setBounds(300, 290, 400, 25);
        add(emailTextField);

        
        JLabel marital=new JLabel("Marital Status:  ");
       marital.setFont(new Font("Raieway", Font.BOLD,20));
       marital.setBounds(100, 340, 180, 25);
        add(marital);
        
          married=new JRadioButton("Married");
        married.setBounds(300,340,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
             unmarried=new JRadioButton("Unmaried");
            unmarried.setBounds(450,340,100,30);
            unmarried.setBackground(Color.WHITE);
            add(unmarried);
        
          
        
        ButtonGroup martialrgroup=new ButtonGroup();
        martialrgroup.add(married);
        martialrgroup.add(unmarried);
       

        
         JLabel address=new JLabel("Address:  ");
       address.setFont(new Font("Raieway", Font.BOLD,20));
       address.setBounds(100, 390, 180, 25);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raieway",Font.BOLD,14));
        addressTextField.setBounds(300, 390, 400, 25);
        add(addressTextField);

        
        
        JLabel city =new JLabel("city:  ");
       city.setFont(new Font("Raieway", Font.BOLD,20));
       city.setBounds(100, 440, 200, 25);
        add(city);    
        
         cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raieway",Font.BOLD,14));
        cityTextField.setBounds(300, 440, 400, 25);
        add(cityTextField);

        JLabel state=new JLabel("State:  ");
       state.setFont(new Font("Raieway", Font.BOLD,20));
       state.setBounds(100, 490, 200, 25);
        add(state);
        
         stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raieway",Font.BOLD,14));
        stateTextField.setBounds(300, 490, 400,25);
        add(stateTextField);

        
        JLabel pincode=new JLabel("Pin Code:  ");
       pincode.setFont(new Font("Raieway", Font.BOLD,20));
       pincode.setBounds(100, 540, 200, 25);
        add(pincode);
        
         pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raieway",Font.BOLD,14));
        pinTextField.setBounds(300, 540, 400, 25);
        add(pinTextField);
        
         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raieway",Font.BOLD,14));
        next.setBounds(660,590,80,30);
        next.addActionListener(this);
        add(next);

          
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(220,10);
        setVisible(true);
        
    }
    
   public void actionPerformed(ActionEvent ae){
        String formno=""+random;//long
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
       String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
            
        }
        else if(female.isSelected()){
                gender="Female";
            }
        else{
            gender="Other";
        }
        
       String email=emailTextField.getText();
       String martial=null;
       if(married.isSelected()){
           martial="Married";
       }
       else if(unmarried.isSelected()){
           martial="Unmarried";
       }
       String address=addressTextField.getText();
      String city=cityTextField.getText();
      String state=stateTextField.getText();
      String pin=pinTextField.getText();

      try{
          if(name.equals("")){
              JOptionPane.showMessageDialog(null,"Name is required");
          }
          else{
              Conn c=new Conn();
              String query="insert into signupdetail values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+martial+"','"+state+"','"+city+"','"+pin+"')";
              c.s.executeUpdate(query);
              setVisible(false);
              new SignupTwo(formno).setVisible(true);
          }
      }catch(Exception e){
          System.out.println(e);
      }
   }   
    public static void main(String[] args) {
        new SignupOne();
    }
    

}