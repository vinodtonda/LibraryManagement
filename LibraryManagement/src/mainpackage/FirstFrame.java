package mainpackage;

import java.awt.*;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import adminpackage.AdminLogin;

public class FirstFrame  extends Frame{

	//Frame f=new Frame();
	JFrame f;  
	JButton b;
	JButton b1;
	
	AdminLogin al;

	void Frame()
	{
				
		f=new JFrame();//creating instance of JFrame  
		          
		 b=new JButton("Admin");//creating instance of JButton  
		b.setBounds(130,100,100, 40);  
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
				al=new AdminLogin();
				al.adminLogin();
				
			}
		});
		          
		f.add(b);//adding button in JFrame  
		
		 b1=new JButton("click");//creating instance of JButton  
		b1.setBounds(130,150,100, 40);  
		          
		f.add(b1);//adding button in JFrame 
		          
		f.setSize(400,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		 
		
	}
	
	
	
	public void adminclick()
	{
			    
	      
	}
	public void btnlib() {
			
	}
		
}
