package adminpackage;

import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

import librarianpackage.LibrarianBean;
import utility.ConnectionClass;

public class AdminSection {
	int choice;
	Scanner sc;

	public void selection() {
		
		
		do {
			System.out.println("******* Admin Section******");
			System.out.println("Enter your selection ");
			System.out.println("Select \n 1.Add Librarian \n 2.view Librarian \n 3. Delete Librarian \n 5.Go back \n");
			sc=new Scanner(System.in);
			choice=sc.nextInt();
			
			
			switch(choice) {
			case 1:
				addLibrarian();
				break;
			case 2:
				displayLibrarian();
				break;
			case 3: 
				System.out.println("delete case");
				deleteLibrarain();
				break;
			case 4:
				break;
				
			}
			
		}while(choice!=5);
	}
	
		public void deleteLibrarain()
		{
			System.out.println("in delete method");
			System.out.println("Enter contact no delete");
			String ph=sc.next();
			try {
				java.sql.PreparedStatement ps=ConnectionClass.dbconnection().prepareStatement("delete * from librarian where contactno=?");
				ps.setString(1, ph);
				int i=ps.executeUpdate();
				if(i>0) {
					System.out.println("successfully deleted");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		public void displayLibrarian() {
			sc=new Scanner(System.in);
			System.out.println("Enter phone number to display librarian");
			String ph=sc.next();
			//String ph=Integer.toString(contactno);
			
			try {
				java.sql.PreparedStatement ps=ConnectionClass.dbconnection().prepareStatement("select * from librarian where contactno=?");
				ps.setString(1, ph);
				ResultSet rs=ps.executeQuery();
				System.out.println("********* Librarian Details are *********");
				while(rs.next()) {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	public void addLibrarian()
	{
		LibrarianBean libbean=new LibrarianBean();
		
		sc=new Scanner(System.in);
		
		System.out.println("Enter Name:");
		String name=sc.next();
		libbean.setName(name);
		
		System.out.println("Enter password");
		String pass=sc.next();
		libbean.setPassword(pass);
		
		System.out.println("Enter email");
		String email=sc.next();
		libbean.setEmail(email);
		
		System.out.println("Enter address");
		String add=sc.nextLine();
		libbean.setAddress(add);
		
		System.out.println("Enter city");
		String city=sc.next();
		libbean.setCity(city);
		
		System.out.println("Enter Contact no:");
		String ph=sc.next();
		libbean.setContactno(ph);
		
		try {
			java.sql.PreparedStatement ps=ConnectionClass.dbconnection().prepareStatement("insert into librarian values(?,?,?,?,?,?)");
			ps.setString(1, libbean.getName());
			ps.setString(2, libbean.getPassword());
			ps.setString(3, libbean.getEmail());
			ps.setString(4, libbean.getAddress());
			ps.setString(5, libbean.getCity());
			ps.setString(6, libbean.getContactno());
			
			int success=ps.executeUpdate();
			if(success>0) {
				System.out.println("Librarian added succesfully");
			}
			else
			{
				System.out.println("*** error in adding please try later***");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
