package mainpackage;

import java.util.Scanner;

import adminpackage.AdminBean;
import adminpackage.AdminLogin;
import adminpackage.AdminSection;

public class LibraryStarter {
	
	public static void main(String...args) {
		Scanner s=new Scanner(System.in);
		AdminBean ab=new AdminBean();
		AdminLogin adminlogin=new AdminLogin();
		AdminSection adminsection=new AdminSection();
		System.out.println("Enter your choice \n 1.Admin Login \n 2.Librarian Login \n");
		int choice=s.nextInt();
		switch(choice) {
		case 1:
			boolean success=adminlogin.adminLogin();
			if(success) {
				adminsection.selection();
			}
			break;
		case 2:
			break;
		}
	}
}
