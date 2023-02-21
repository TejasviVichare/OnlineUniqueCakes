package in.uc.test;

import java.util.List;
import java.util.Scanner;

import in.uc.dao.CakeDao;
import in.uc.pojo.Cake;

public class CakeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int cakeid;
		 String cakename;
		 String caketype;
		 double cakeweight;
		 double cakeprice;
		 
		 Scanner sc=new Scanner(System.in);
		 boolean result;
		 int choice;
		 Cake c=null;
		 CakeDao cdao=new CakeDao();
		 System.out.println("========Unique Cakes======");
		 System.out.println(("========================="));
		 System.out.println("1.Add Cake");
		 System.out.println("2.Update Cake");
		 System.out.println("3.Delete cake");
		 System.out.println("4.Show cake list");
		 System.out.println("5.Search cake by id");
		 System.out.println("6.Search cake by type");
		 System.out.println("7.Search cake by name");
		 System.out.println("........................");
		 System.out.println("Enter Your Choice");
		 choice=sc.nextInt();
		 
		 switch(choice) {
		 case 1:
			 System.out.println(".......Adding Cake.......");
			 System.out.println("Enter Cake Name :");
			 cakename=sc.next();
			 System.out.println("Enter Cake Type :");
			 caketype=sc.next();
			 System.out.println("Enter cake weight :");
			 cakeweight=sc.nextDouble();
			 System.out.println("Enter cake price :");
			 cakeprice=sc.nextDouble();
			 
			 c=new Cake(cakename,caketype,cakeweight,cakeprice);
			 result=cdao.addCake(c);
			 if(result)
				 System.out.println("cake added");
			 else
				 System.out.println("Cake not added");
			 break;
		 case 2:
			 System.out.println(".......Updating Cake.......");
			 System.out.println("EnterCake id");
			 cakeid=sc.nextInt();
			 System.out.println("Enter Cake Name :");
			 cakename=sc.next();
			 System.out.println("Enter Cake Type :");
			 caketype=sc.next();
			 System.out.println("Enter cake weight :");
			 cakeweight=sc.nextDouble();
			 System.out.println("Enter cake price :");
			 cakeprice=sc.nextDouble();
			 c=new Cake(cakeid,cakename,caketype,cakeweight,cakeprice);
			 result=cdao.updateCake(c);
			 if(result)
				 System.out.println("cake Updated");
			 else
				 System.out.println("Cake not Updated");
			 break;
		 case 4:
			 
			 List<Cake> clist=cdao.showCakeList();
			 if(clist.isEmpty()) {
				 System.out.println("cake list is empty");
			 }
			 else {
				 System.out.println("=======Cake List=====");
				 
				 for(Cake c1:clist) {
					 System.out.println(c1);
				 }
			 }
			 break;
		
		 case 3:
			 System.out.println("========deleting Cake=====");
			 System.out.println("Entercake id:");
			 cakeid=sc.nextInt();
			 result=cdao.deleteCake(cakeid);
			 if(result)
				 System.out.println("Cake deleted");
			 else
				 System.out.println("cale not deleted");
			 break;
			 
		 case 5:
			 System.out.println("====Search cake by id====");
			 System.out.println("Enter cake id");
			 cakeid=sc.nextInt();
			 c=cdao.searchCakeById(cakeid);
			 if(c==null)
				 System.out.println("cake not found");
			 else
				 System.out.println(c);
			 break;
		
		 case 6:
			 System.out.println("Enter cake type :");
			 caketype=sc.next();
			 clist=cdao.searchCakeByType(caketype);
			 if(clist.isEmpty()) {
				 System.out.println("Cake list is empty");
			 }
			 else
				 System.out.println("=====Cake list=====");
			 for(Cake c1:clist) {
				 System.out.println(c1);
			 }
			
		 case 7:
			 System.out.println("Enter cake name :");
			 cakename=sc.next();
			 clist=cdao.searchCakeByName(cakename);
			 if(clist.isEmpty()) {
				 System.out.println("Cake list is empty");
			 }
			 else
				 System.out.println("=====Cake list=====");
			 for(Cake c1:clist) {
				 System.out.println(c1);
			 }
			
		 }
	}

}
