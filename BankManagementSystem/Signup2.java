package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
   
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String formno;
    
    Signup2(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionDetails=new JLabel("page 2: Additional Details");
        additionDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionDetails.setBounds(290,80,400,30);
        add( additionDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,20);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category=new JComboBox(valCategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300,190,400,30);
        add(category);
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomeCategory[] =  {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        income=new JComboBox(incomeCategory);
        income.setBackground(Color.WHITE);
        income.setBounds(300,240,400,30);
        add(income);
        
          
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationvalues[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        education=new JComboBox( educationvalues);
        education.setBackground(Color.WHITE);
        education.setBounds(300,315,400,30);
        add(education);
        
        JLabel martial=new JLabel("Occupation:");
        martial.setFont(new Font("Raleway", Font.BOLD,22));
        martial.setBounds(100,390,200,30);
        add(martial);
        
        String occupationvalues[] ={"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupation=new JComboBox(occupationvalues);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300,390,400,30);
        add(occupation);
        
        JLabel address=new JLabel("Pan Number:");
        address.setFont(new Font("Raleway", Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Arial", Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan); 
        
        JLabel city=new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Arial", Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar); 
        
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
       
        ButtonGroup emaritalgroup=new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
          
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible (true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){ 
            seniorcitizen= "Yes";
        }else if(sno.isSelected()){ 
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){ 
            existingaccount= "Yes";
        }else if(eno.isSelected()){ 
            existingaccount ="No";
        }
        
       String span = pan.getText();
       String saadhar = aadhar.getText();
       
       try {
           Conn c = new Conn();
           String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
           c.s.executeUpdate(query);
           
           setVisible(false);
           new Signup3(formno).setVisible(true);
           } catch (Exception e){
           System.out.println(e);
       
       }
    
    }
        
    public static void main (String[] args){
   
        new Signup2("");
    }
}


