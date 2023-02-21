package in.uc.test;

import java.util.Scanner;
import in.uc.dao.CakeDao;
import in.uc.dao.OrderDao;
import in.uc.pojo.Cake;
import in.uc.pojo.Order;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int orderid;
		 String custemail;
		 int orderprice;
		 String orderdate;
		 String orderstatus;
		 Cake cake = null;
		 
		 Scanner sc=new Scanner(System.in);
		 boolean result;
		 int choice;
		 Order o=null;
		 OrderDao odao=new OrderDao();
		 System.out.println("========Unique Cakes======");
		 System.out.println(("========================="));
		 System.out.println("1.Add Cake");
		 System.out.println("2.Update Order");
		 System.out.println("3.Delete Order");
		 System.out.println("........................");
		 System.out.println("Enter Your Choice");
		 choice=sc.nextInt();
		 
		 switch(choice) {
		 case 1:
			 System.out.println(".......Add Order.......");
			 System.out.println("Enter Custemail :");
			 custemail=sc.next();
			 System.out.println("Enter Order Price :");
			 orderprice=sc.nextInt();
			 System.out.println("Enter Order Date :");
			 orderdate=sc.next();
			 System.out.println("Enter Order Status :");
			 orderstatus=sc.next();
			 
			 o=new Order(custemail, orderprice, orderdate, orderstatus, cake);
			 result=odao.addordercake(o);
			 if(result)
				 System.out.println("Order added");
			 else
				 System.out.println("Order not added");
			 break;
		
		 case 2:
			 System.out.println(".......Updating Order.......");
			 System.out.println("Enter Custemail :");
			 custemail=sc.next();
			 System.out.println("Enter Order Price :");
			 orderprice=sc.nextInt();
			 System.out.println("Enter Order Date :");
			 orderdate=sc.next();
			 System.out.println("Enter Order Status :");
			 orderstatus=sc.next();

			 o=new Order(custemail, orderprice, orderdate, orderstatus, cake);
			 result=odao.addordercake(o);
			 if(result)
					System.out.println("Order updated");
			  else
				    System.out.println("Order not updated");
			  break;
			
		 case 3:
			 System.out.println("========deleting Cake=====");
			 System.out.println("Enter order id:");
			 orderid=sc.nextInt();
			 result=odao.deleteOrder(orderid);
			 if(result)
				 System.out.println("Order deleted");
			 else
				 System.out.println("Order not deleted");
			 break;
			
		 }
	}

}