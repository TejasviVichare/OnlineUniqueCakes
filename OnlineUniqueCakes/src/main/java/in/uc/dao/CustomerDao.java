package in.uc.dao;

import java.sql.Connection;
import in.uc.utility.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.uc.pojo.*;
public class CustomerDao {

	Connection conn=DBConnection.getConnect();
	 String sql=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 int i=0;
	 
	 public boolean addCustomer(Customer c1) {
		 
		  try {
			System.out.println("Inside customerDao add method");
			sql="insert into Customer(custname,custemail,custcontact,custaddress,custpassword)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, c1.getCustname());
			ps.setString(2, c1.getCustemail());
			ps.setString(3, c1.getCustcontact());
			ps.setString(4, c1.getCustaddress());
			ps.setString(5, c1.getCustpassword());

			System.out.println("query :"+ps);
		    i=ps.executeUpdate();
			
			if(i>0)
				return true;					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	 }
	 public boolean updateCustomer(Customer c1) {

			try {
				System.out.println("inside update customerdao method");
				
				sql="update Customer set custname=?,custemail=?,custcontact=?,custaddress=?,custpassword=? where custid=? ";
			    ps=conn.prepareStatement(sql);
			    ps.setString(1, c1.getCustname());
				ps.setString(2, c1.getCustemail());
				ps.setString(3, c1.getCustcontact());
				ps.setString(4, c1.getCustaddress());
				ps.setString(5, c1.getCustpassword());
				ps.setInt(6, c1.getCustid());
				System.out.println("query :"+ps);
			    i=ps.executeUpdate();
				
				if(i>0)
					return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
	 
	 public boolean deleteCustomer(int custid) {
		 try {
				System.out.println("inside deleteCustomer method");			
				sql="delete from Customer where custid=?";
			    ps=conn.prepareStatement(sql);		   
				ps.setInt(1,custid);
				System.out.println("query :"+ps);
			    i=ps.executeUpdate();
				
				if(i>0)
					return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	 }
	 
	 public List<Customer> showCustomerlist(){
		List<Customer> clist = new ArrayList<Customer>();
		try {
			System.out.println("inside showCustomerlist method");
			sql ="select *from Customer";
		    ps=conn.prepareStatement(sql);
		    rs=ps.executeQuery();
		    while(rs.next()) {
		    	Customer c1=new Customer();
		    	c1.setCustid(rs.getInt(1));
		    	c1.setCustname(rs.getString(2));
		    	c1.setCustemail(rs.getString(3));
		    	c1.setCustcontact(rs.getString(4));
		    	c1.setCustaddress(rs.getString(5));
		    	c1.setCustpassword(rs.getString(6));
		    	
		    	clist.add(c1);
		    }
			return clist;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
	 }
	 public Customer searchById(int custid) {
		 Customer c1=null;
		 try {
				System.out.println("inside searchById method");
				
				sql="select *from Customer where custid=?";
			    ps=conn.prepareStatement(sql);
			    ps.setInt(1, custid);
			    rs=ps.executeQuery();
			    if(rs.next()) {
			    	c1=new Customer();
			    	c1.setCustid(rs.getInt(1));
			    	c1.setCustname(rs.getString(2));
			    	c1.setCustemail(rs.getString(3));
			    	c1.setCustcontact(rs.getString(4));
			    	c1.setCustaddress(rs.getString(5));
			    	c1.setCustpassword(rs.getString(6));
			    }
			    return c1;
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c1;
		 }
	 
	 public Customer searchCustomerByEmail(String custemail) {
		 Customer c1=null;
		 try {
				System.out.println("inside searchCustomerByEmail method");
				
				sql="select *from Customer where custemail=?";
			    ps=conn.prepareStatement(sql);
			    ps.setString(1, custemail);
			    rs=ps.executeQuery();
			    if(rs.next()) {
			    	c1=new Customer();
			    	c1.setCustid(rs.getInt(1));
			    	c1.setCustname(rs.getString(2));
			    	c1.setCustemail(rs.getString(3));
			    	c1.setCustcontact(rs.getString(4));
			    	c1.setCustaddress(rs.getString(5));
			    	c1.setCustpassword(rs.getString(6));
			    }
			    return c1;
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c1;
	 }
	

	 
}
