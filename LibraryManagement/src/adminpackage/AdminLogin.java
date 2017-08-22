package adminpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AdminLogin {

	Scanner s=new Scanner(System.in);
	AdminBean ab=new AdminBean();

	
	public boolean adminLogin()
	{
		boolean adminexist=false;
		System.out.println("Enter Admin username \n");
		String au=s.next();
		ab.setAdminuname(au);
		System.out.println("Enter admin password \n");
		String ap=s.next();
		ab.setAdminpass(ap);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","admin");
			Statement stmt=con.createStatement();
			String query="select * from admin where name='"+ab.getAdminuname()+"' and password='"+ab.getAdminpass()+"'";
			//System.out.println(query);
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				
				adminexist=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return adminexist;
		
	}
}
