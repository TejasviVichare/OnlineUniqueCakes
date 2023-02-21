package in.uc.test;

import java.util.List;
import java.util.Scanner;

import in.uc.dao.CakeDao;
import in.uc.dao.CustomerDao;
import in.uc.pojo.Cake;
import in.uc.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		 int custid;
		 String custname;
		 String custemail;
		 String custcontact;
		 String custaddress;
		 String custpassword;
		 
		 Scanner sc=new Scanner(System.in);
		 boolean result;
		 int choice;
		 Customer c1 =null;
		 CustomerDao cdao=new CustomerDao();
		 System.out.println("========Unique Cakes======");
		 System.out.println(("========================="));
		 System.out.println("1.Add Customer");
		 System.out.println("2.Update Customer");
		 System.out.println("3.Delete Customer");
		 System.out.println("4.Show Customer list");
		 System.out.println("5.Search Customer by id");
		 System.out.println("6.Search Customer by email");
		 System.out.println("........................");
		 System.out.println("Enter Your Choice");
		 choice=sc.nextInt();
		 
		 switch(choice) {
		 case 1:
			 System.out.println(".......Adding Customer.......");
			 System.out.println("Enter Customer Name :");
			 custname=sc.next();
			 System.out.println("Enter Customer email :");
			 custemail=sc.next();
			 System.out.println("Enter Customer contact :");
			 custcontact=sc.next();
			 System.out.println("Enter Customer Address :");
			 custaddress=sc.next();
			 System.out.println("Enter Customer Password :");
			 custpassword =sc.next();
			 c1=new Customer(custname,custemail,custcontact,custaddress,custpassword);
			 result=cdao.addCustomer(c1);
			 if(result)
				 System.out.println("Customer added");
			 else
				 System.out.println("Customer not added");
			 break;
		
		 case 2:
			 System.out.println(".......Updating Customer.......");
			 System.out.println("Enter Customer id :");
			 custid =sc.nextInt();
			 System.out.println("Enter Customer Name :");
			 custname=sc.next();
			 System.out.println("Enter Customer email :");
			 custemail=sc.next();
			 System.out.println("Enter Customer contact :");
			 custcontact=sc.next();
			 System.out.println("Enter Customer Address :");
			 custaddress=sc.next();
			 System.out.println("Enter Customer Password :");
			 custpassword =sc.next();
			 
			 c1=new Customer(custid,custname,custemail,custcontact,custaddress,custpassword);
			 result=cdao.updateCustomer(c1);
			 if(result)
				 System.out.println("Customer updated");
			 else
				 System.out.println("Customer not updated");
			 break;
		 
		 case 3:
			 System.out.println("========deleting Customer=====");
			 System.out.println("Enter customer id:");
			 custid=sc.nextInt();
			 result=cdao.deleteCustomer(custid);
			 if(result)
				 System.out.println("Customer deleted");
			 else
				 System.out.println("customer not deleted");
			 break;
       
		 case 4:	 
			 List<Customer> clist=cdao.showCustomerlist();
			 if(clist.isEmpty()) {
				 System.out.println("cake list is empty");
			 }
			 else {
				 System.out.println("=======Cake List=====");
				 
				 for(Customer c2:clist) {
					 System.out.println(c2);
				 }
			 }
			 break;
			 
		 case 5:
			 System.out.println("====Search Customer by id====");
			 System.out.println("Enter customer id");
			 custid=sc.nextInt();
			 c1=cdao.searchById(custid);
			 if(c1==null)
				 System.out.println("customer not found");
			 else
				 System.out.println(c1);
			 break;
			 
		 case 6:
			 System.out.println("====Search Customer by email====");
			 System.out.println("Enter customer email");
			 custemail=sc.next();
			 c1=cdao.searchCustomerByEmail(custemail);
			 if(c1==null)
				 System.out.println("customer not found");
			 else
				 System.out.println(c1);
			 break;
		 }
	}

}
