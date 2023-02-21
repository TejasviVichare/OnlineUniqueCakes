 package in.uc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.uc.pojo.Cake;
import in.uc.pojo.Cart;
import in.uc.pojo.Order;
import in.uc.utility.DBConnection;

public class OrderDao {

Connection conn=DBConnection.getConnect();
String sql=null;
PreparedStatement ps=null;
ResultSet rs=null;
int i=0;

public double getTotal(String email) {
	try {
	System.out.println("Inside order dao add method");
	
	sql="select sum(cakeprice*quantity) from cake c inner join cart c1 on c.cakeid=c1.cid where custemail=?";
	
	
	ps=conn.prepareStatement(sql);
	
	ps.setString(1, email);
	rs=ps.executeQuery();
	if(rs.next()) {
	return rs.getDouble(1);
	}
	
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return 0;
	}
	
	public Order placeOrder(String email) {
		Order o=new Order();
		try {
		Date d=new Date();
		double total=getTotal(email);
		System.out.println("Inside order dao add method");
		
		sql="insert into orders(custemail,orderdate,ordertotal)value(?,?,?)";
		
		
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, email);
		ps.setString(2, d.toString());
		ps.setDouble(3, total);
		i=ps.executeUpdate();
		if(i>0) {
		String sql1="select * from orders where custemail=? and orderdate=?";
		ps=conn.prepareStatement(sql1);
		
		ps.setString(1, email);
		ps.setString(2, d.toString());
		rs=ps.executeQuery();
		if(rs.next()) {
		o.setOrderid(rs.getInt(1));
		o.setOrderdate(rs.getString(3));
		o.setOrderstatus(rs.getString(4));
		o.setOrdertotal(rs.getDouble(5));
		}
		}
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return o;
		}
	
	public List<Order> showMyorderList(String custemail){
		List<Order>olist=new ArrayList<Order>();
		try {
		System.out.println("Inside order dao add method");

		sql="select cakeid,cakename,cakeimage,caketype,cakecategory,cakeflavour,cakeweight,cakeprice,quantity,orderdate,ordertotal,orderstatus from cake c inner join \n"
		+ "backupcart c1 on c.cakeid=c1.cid inner join orders  o on c1.custemail=o.custemail where o.custemail=?";



		ps=conn.prepareStatement(sql);

		ps.setString(1, custemail);
		rs=ps.executeQuery();
		if(rs.next()) {
		Order o=new Order();
		Cake c=new Cake();
		Cart c1=new Cart();
		c.setCakeid(rs.getInt(1));
		c.setCakename(rs.getString(2));
		c.setCakeimage(rs.getBinaryStream(3));
		c.setCaketype(rs.getString(4));
		c.setCakecategory(rs.getString(5));
		c.setCakeflavour(rs.getString(6));
		c.setCakeprice(rs.getDouble(8));
		c.setCakeweight(rs.getDouble(7));
		c1.setQuantity(rs.getInt(9));
		o.setOrdertotal(rs.getDouble(11));
		o.setOrderdate(rs.getString(10));
		o.setOrderstatus(rs.getString(12));
		o.setCake(c);
		o.setCart(c1);
		System.out.println("order-------->"+o);
		olist.add(o);
		}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return olist;
		}

	}
