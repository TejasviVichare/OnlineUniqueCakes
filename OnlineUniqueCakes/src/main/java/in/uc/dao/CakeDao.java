package in.uc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.uc.pojo.Cake;
import in.uc.utility.DBConnection;

public class CakeDao {
	
	Connection conn=DBConnection.getConnect();
	 String sql=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 int i=0;
	public boolean addCake(Cake c) {
	 
	 
		try {
			System.out.println("inside cakedoa add method");
			
			sql="insert into cake(cakename,caketype,cakecategory,cakeflavour,cakeweight,cakeprice,cakeimage)values(?,?,?,?,?,?,?)";
		    ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCakename());
			ps.setString(2, c.getCaketype());
			ps.setString(3, c.getCakecategory());
			ps.setString(4, c.getCakeflavour());
			ps.setDouble(5, c.getCakeweight());
			ps.setDouble(6, c.getCakeprice());
			ps.setBinaryStream(7, c.getCakeimage());
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
	public boolean updateCake(Cake c) {

		try {
			System.out.println("inside cakedoa updateCake method");
			
			sql="update cake set cakename=?,caketype=?,cakecategory=?,cakeflavour=?, cakeweight=?,cakeprice=?,cakeimage=? where cakeid=?";
		    ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCakename());
			ps.setString(2, c.getCaketype());
			ps.setString(3, c.getCakecategory());
			ps.setString(4, c.getCakeflavour());
			ps.setDouble(5, c.getCakeweight());
			ps.setDouble(6, c.getCakeprice());
			ps.setBinaryStream(7, c.getCakeimage());
			ps.setInt(8, c.getCakeid());
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
	public boolean deleteCake(int cakeid) {
		try {
			System.out.println("inside cakedoa deleteCake method");	
			sql="delete from cake where cakeid=?";
		    ps=conn.prepareStatement(sql);	
		    ps.setInt(1, cakeid);
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
	
	public List<Cake> showCakeList(){
		List<Cake> cakelist = new ArrayList<Cake>();
		try {
		
			System.out.println("Inside cakedou cake list method");
			sql="select *from cake";
		    ps=conn.prepareStatement(sql);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Cake c= new Cake();
		    	c.setCakeid(rs.getInt(1));
		    	c.setCakename(rs.getString(2));
		    	c.setCaketype(rs.getString(3));
		    	c.setCakecategory(rs.getString(4));
		    	c.setCakeflavour(rs.getString(5));
		    	c.setCakeweight(rs.getDouble(6));
		    	c.setCakeprice(rs.getDouble(7));
		    	c.setCakeimage(rs.getBinaryStream(8));
		    	cakelist.add(c);
		    }
		    return cakelist;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    return cakelist;

	}
	
	public Cake searchCakeById(int cakeid) {
		Cake c=null;
		try {
			System.out.println("inside cakedoa searchCake by id method");
			
			sql="select *from cake where cakeid=?";
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1, cakeid);
		    rs=ps.executeQuery();
		    if(rs.next()){
		    	c= new Cake();
		    	c.setCakeid(rs.getInt(1));
		    	c.setCakename(rs.getString(2));
		    	c.setCaketype(rs.getString(3));
		    	c.setCakecategory(rs.getString(4));
		    	c.setCakeflavour(rs.getString(5));
		    	c.setCakeweight(rs.getDouble(6));
		    	c.setCakeprice(rs.getDouble(7));
		    	c.setCakeimage(rs.getBinaryStream(8));

		    	
		    }
		    return c;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    return c;

	}
	
	public List<Cake> searchCakeByType(String caketype){
		List<Cake> cakelist = new ArrayList<Cake>();
		try {
			
			System.out.println("Inside cakedou searchCakeByType method");
			sql="select *from cake where caketype=?";
		    ps=conn.prepareStatement(sql);
		    ps.setString(1, caketype);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Cake c= new Cake();
		    	c.setCakeid(rs.getInt(1));
		    	c.setCakename(rs.getString(2));
		    	c.setCaketype(rs.getString(3));
		    	c.setCakecategory(rs.getString(4));
		    	c.setCakeflavour(rs.getString(5));
		    	c.setCakeweight(rs.getDouble(6));
		    	c.setCakeprice(rs.getDouble(7));
		    	c.setCakeimage(rs.getBinaryStream(8));

		    	cakelist.add(c);
		    }
		    return cakelist;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    return cakelist;
	}
	public List<Cake> searchCakeByName(String cakename){
		List<Cake> cakelist = new ArrayList<Cake>();
		try {
			
			System.out.println("Inside cakedou searchCakeByName method");
			sql="select *from cake where cakename=?";
		    ps=conn.prepareStatement(sql);
		    ps.setString(1, cakename);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	Cake c= new Cake();
		    	c.setCakeid(rs.getInt(1));
		    	c.setCakename(rs.getString(2));
		    	c.setCaketype(rs.getString(3));
		    	c.setCakecategory(rs.getString(4));
		    	c.setCakeflavour(rs.getString(5));
		    	c.setCakeweight(rs.getDouble(6));
		    	c.setCakeprice(rs.getDouble(7));
		    	c.setCakeimage(rs.getBinaryStream(8));

		    	cakelist.add(c);
		    }
		    return cakelist;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	    return cakelist;
	}


}
