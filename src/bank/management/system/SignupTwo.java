package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField  pan,adhar;
    JButton next;
    JComboBox Occupation , religion,education,Category,salary;
    JRadioButton eno,eyes,syes,sno;
    String formno;

    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("New Account Application Form-Page 2:");       
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details:  ");
       additionalDetails.setFont(new Font("Raieway", Font.BOLD,22));
        additionalDetails.setBounds(290, 60, 400, 30);
        add(additionalDetails);
        
         JLabel name=new JLabel("Religion: ");
       name.setFont(new Font("Raieway", Font.BOLD,20));
       name.setBounds(100, 130, 100, 25);
        add(name);
        
        
        String valReligion[]={"Hindu","Sikh","Muslim","Christian","Other"};
        religion=new JComboBox(valReligion);  
       religion.setBounds(300, 130, 400, 25);
       religion.setBackground(Color.WHITE);

        add(religion);

       
        JLabel fname=new JLabel("Category: ");
       fname.setFont(new Font("Raieway", Font.BOLD,20));
       fname.setBounds(100, 170, 180, 25);
        add(fname);
        
         String valCategory[]={"General","OBC","SC","ST","Other"};
        Category=new JComboBox(valCategory);  
       Category.setBounds(300, 170, 400, 25);
       Category.setBackground(Color.WHITE);

        add(Category);



        
        JLabel dob=new JLabel("Income: ");
       dob.setFont(new Font("Raieway", Font.BOLD,20));
       dob.setBounds(100, 210, 300, 20);
               add(dob);
        
               
         String salaryCategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        salary=new JComboBox(salaryCategory);  
       salary.setBounds(300, 210, 400, 25);
       salary.setBackground(Color.WHITE);

        add(salary);


                 
              
        JLabel gender=new JLabel("Educational ");
       gender.setFont(new Font("Raieway", Font.BOLD,20));
       gender.setBounds(100, 255, 180, 20);
        add(gender);
        
        JLabel email=new JLabel("Qualifiction: ");
       email.setFont(new Font("Raieway", Font.BOLD,20));
       email.setBounds(100, 280, 1700, 20);
        add(email);
        
          String edu[]={"Graduate","Under Graduate","Other","Non"};
        education=new JComboBox(edu);  
       education.setBounds(300, 260, 400, 25);
       education.setBackground(Color.WHITE);

        add(education);

        
       
        
        JLabel marital=new JLabel("Occupation:  ");
       marital.setFont(new Font("Raieway", Font.BOLD,20));
       marital.setBounds(100, 320, 180, 25);
        add(marital);
        
          String OccupationVal[]={"Salaried","Bussiness","Student","Other"};
        Occupation=new JComboBox(OccupationVal);  
       Occupation.setBounds(300, 320, 400, 25);
       Occupation.setBackground(Color.WHITE);
       add(Occupation);


       

        
         JLabel address=new JLabel("Pan Number:  ");
       address.setFont(new Font("Raieway", Font.BOLD,20));
       address.setBounds(100, 370, 180, 25);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raieway",Font.BOLD,14));
        pan.setBounds(300, 370, 400, 25);
        add(pan);

        
        
        JLabel city =new JLabel("Adhar Number:  ");
       city.setFont(new Font("Raieway", Font.BOLD,20));
       city.setBounds(100, 420, 200, 25);
        add(city);    
        
         adhar=new JTextField();
        adhar.setFont(new Font("Raieway",Font.BOLD,14));
        adhar.setBounds(300, 420, 400, 25);
        add(adhar);

        JLabel state=new JLabel("Senior Citizen:  ");
       state.setFont(new Font("Raieway", Font.BOLD,20));
       state.setBounds(100, 470, 200, 25);
        add(state);
        
        syes=new JRadioButton("YES");
       syes.setBounds(300, 470, 50, 25);
       add(syes);
       
        sno=new JRadioButton("NO");
       sno.setBounds(500, 470, 50, 25);
       add(sno);
       
       ButtonGroup senior=new ButtonGroup();
       senior.add(syes);
       senior.add(sno);
       

        JLabel pincode=new JLabel("Existing Account:  ");
       pincode.setFont(new Font("Raieway", Font.BOLD,20));
       pincode.setBounds(100, 520, 200, 25);
        add(pincode);
        
           eyes=new JRadioButton("YES");
       eyes.setBounds(300, 520, 50, 25);
       add(eyes);
       
        eno=new JRadioButton("NO");
       eno.setBounds(500, 520, 50, 25);
       add(eno);
       
       ButtonGroup exist=new ButtonGroup();
       exist.add(syes);
       exist.add(sno);
       
        
         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raieway",Font.BOLD,14));
        next.setBounds(630,570,80,30);
        next.addActionListener(this);
        add(next);

          
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(220,10);
        setVisible(true);
        
    }
    
   public void actionPerformed(ActionEvent ae){
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)Category.getSelectedItem();
        String sincome=(String)salary.getSelectedItem();
        String soccupation=(String)Occupation.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        
        String seniorCitizen=null;
        if(syes.isSelected()){
            seniorCitizen="Yes";
        }
        else{
            seniorCitizen="No";

        }
        
        String existingAc =null;
        if(eyes.isSelected()){
            existingAc="Yes";
        }
        else{
            existingAc="No";

        }
        String span=pan.getText();
        String sadhar=adhar.getText();
        

            
        

      try{
                        Conn c=new Conn();
              String query="insert into signupdetail2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorCitizen+"','"+existingAc+"')";
              c.s.executeUpdate(query);
              setVisible(false);
              new SignupThree(formno).setVisible(true);
      }catch(Exception e){
          System.out.println(e);
      }
   }   
    public static void main(String[] args) {
        new SignupTwo("");
    }
    

}