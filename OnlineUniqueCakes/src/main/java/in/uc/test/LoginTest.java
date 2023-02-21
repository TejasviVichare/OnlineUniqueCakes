package in.uc.test;

import java.util.Scanner;

import in.uc.dao.LoginDao;
import in.uc.pojo.Cake;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String adminemail;
		String adminpass;
		String custemail;
		String custpass ;
		String newpass;
		int choice;
		boolean ans;
		Scanner sc=new Scanner(System.in);
		LoginDao dao=new LoginDao();
		
		System.out.println(".......LogIn.......");
		System.out.println("1.Admin");
		System.out.println("2.Customer");
		System.out.println("3.Forget Password");
		System.out.println("Enter your Choice ");
		choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println(".....Admin LogIn.....");
			System.out.println("Enter email :");
			adminemail=sc.next();
			System.out.println("Enter pass :");
			adminpass=sc.next();
			ans=dao.isAdmin(adminemail, adminpass);
			if(ans)
				System.out.println("Welcome Admin");
			else
				System.out.println("Invalid User");
			break;
			
		case 2:
			System.out.println("....Customer Login....");
			System.out.println("Enter Email :");
			custemail=sc.next();
			System.out.println("Enter pass :");
			custpass=sc.next();
			ans=dao.isCustomer(custemail, custpass);
			if(ans)
				System.out.println("Welcome Customer");
			else
				System.out.println("Invalid User");
			break;
			
		case 3:
			System.out.println("......Forget Password......");
			System.out.println("Enter Email :");
			custemail=sc.next();
			System.out.println("Enter New Passord");
			custpass=sc.next();
			ans=dao.forgetpassword(custemail, custpass);
			if(ans)
				System.out.println("Pasword Changed");
			else
				System.out.println("Invalid User");
			break;
		}
	}

}
