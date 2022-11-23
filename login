package sample;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;  
import javax.swing.*;
  
public class login {  
public static void main(String[] args) {  
    JFrame f=new JFrame("HOME PAGE");  
    JLabel l=new JLabel("NIRK HOSPITAL, SALEM");
    l.setFont(new Font("Segoe Script",Font.BOLD,20));
    l.setForeground(Color.DARK_GRAY);
    l.setBounds(120,100, 450, 30);
    JLabel l2=new JLabel("LOGIN PAGE");
    l2.setFont(new Font("poppins",Font.BOLD,20));
    l2.setForeground(new Color(220,20,60));
    l2.setBounds(100,120, 450, 30);
    
    f.getContentPane().setBackground(new Color(245, 183, 177));
    l.setBounds(50,50, 350, 30);
    //l.setFont(new Font("Comic Sans MS",Font.BOLD,28));
   //l.setForeground(Color.black);
    //final JTextField tf=new JTextField();
    //tf.setBounds(50,50, 150,20); 
    JButton b1=new JButton("DOCTOR");  
    b1.setBounds(50,200,95,30);  
    JButton b2=new JButton("PATIENT");  
    b2.setBounds(200,200,95,30); 
    b1.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
	loginDoctor p=new loginDoctor(); 
        }  
    });  
    b2.addActionListener(new ActionListener(){  
    	public void actionPerformed(ActionEvent e){  
    		patientHealth q=new patientHealth(); 
    	        }  
    	    });  
    f.add(b1);
    f.add(b2);
    //f.add(tf);  
    f.add(l);
    f.add(l2);
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}
