package in.uc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.uc.utility.DBConnection;

public class LoginDao {
	Connection conn=DBConnection.getConnect();
	 String sql=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 int i=0;
	 
	 public boolean isAdmin(String email,String pass) {
		 try {
			 sql="select adminemail,adminpass from admin where adminemail=? and adminpass=?";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, email);
			 ps.setString(2, pass);
			 System.out.println("Querey:"+ps);
			 rs=ps.executeQuery();
			 if(rs.next())
				 return true;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	 }
	   
	 public boolean isCustomer(String email,String pass) {
		 try {
			 sql="select custemail,custpass from customer where custemail=? and custpass=?";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, email);
			 ps.setString(2, pass);
			 System.out.println("Querey:"+ps);
			 rs=ps.executeQuery();
			 if(rs.next())
				 return true;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	 }
 
	 public boolean forgetpassword(String email,String Pass) {
		 try {
			sql="update customer set custpass=? where custemail=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, Pass);
			ps.setString(2, email);
			System.out.println("Query :"+ps);
			i=ps.executeUpdate();
			if(i>0)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	 }
}
