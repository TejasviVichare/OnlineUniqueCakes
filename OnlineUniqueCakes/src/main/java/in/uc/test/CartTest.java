package in.uc.test;

import java.util.List;
import java.util.Scanner;

import in.uc.dao.CartDao;
import in.uc.pojo.Cake;
import in.uc.pojo.Cart;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int cartid;
		 String custemail;
		 int quantity;
		 Cake cake=new Cake();
		 Cart c=null;
		 Scanner sc=new Scanner(System.in);
		 boolean result;
		 int choice;
		 CartDao cdao=new CartDao();
		 
		 System.out.println(".........Unique cakes.......");
		 System.out.println(".............................");
		 System.out.println("1.Add To Cart");
		 System.out.println("2.Show My Cart");
		 System.out.println("3.Delete My Cart");
		 
		 System.out.println("Enter Your Choice");
		 choice=sc.nextInt();
		 
		 switch(choice) {
		 case 1:
			 System.out.println(".......Add To Cart......");
			 System.out.println("Enter your Email");
			 custemail=sc.next();
			 System.out.println("Enter cake id");
			 int cakeid=sc.nextInt();
			 cake.setCakeid(cakeid);
			 c=new Cart(custemail, cake);
			 result=cdao.addToCart(c);
			 if(result)
				 System.out.println("Cake added to cart");
			 else
				 System.out.println("Cake not added to cart");
			 break;
		
		 case 2:
			 System.out.println(".....Show My Cart.....");
			 System.out.println("Enter your email");
			 custemail=sc.next();
			 List<Cart> clist=cdao.showMyCart(custemail);
			 if(clist.isEmpty()) {
				 System.out.println("cart is empty");
			 }
			 else {
				 System.out.println("=======Cart Details=====");
				 
				 for(Cart c1:clist) {
					 System.out.println(c1);
				 }
			 }
			 break;
			 
		 case 3:
			 System.out.println("========deleting Cart=====");
			 System.out.println("Enter cart id:");
			 cartid=sc.nextInt();
			 result=cdao.deleteMyCart(cartid);
			 if(result)
				 System.out.println("Cart deleted");
			 else
				 System.out.println("Cart not deleted");
			 break;
		 }
		 
			 
	}

}
