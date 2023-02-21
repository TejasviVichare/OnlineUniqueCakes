package in.uc.pojo;

public class Order {

private int orderid;
private String custemail;
private double ordertotal;
private String orderstatus;
private Cake cake;
private Cart cart;
private int quantity;
private String orderdate;


	public Cart getCart() {
	return cart;
	}
	
	public void setCart(Cart cart) {
	this.cart = cart;
	}
	
	public Order(int orderid, String custemail, double ordertotal, String orderstatus, Cake cake, Cart cart,
	int quantity, String orderdate) {
	super();
	this.orderid = orderid;
	this.custemail = custemail;
	this.ordertotal = ordertotal;
	this.orderstatus = orderstatus;
	this.cake = cake;
	this.cart = cart;
	this.quantity = quantity;
	this.orderdate = orderdate;
	}
	
	public String getOrderdate() {
	return orderdate;
	}
	
	public void setOrderdate(String orderdate) {
	this.orderdate = orderdate;
	}
	
	public Order() {
	super();
	}
	
	public Order(String custemail, double ordertotal, String orderstatus, Cake cake, int quantity) {
	super();
	this.custemail = custemail;
	this.ordertotal = ordertotal;
	this.orderstatus = orderstatus;
	this.cake = cake;
	this.quantity = quantity;
	}
	
	public Order(int orderid, String custemail, double ordertotal, String orderstatus,Cake food, int quantity) {
	super();
	this.orderid = orderid;
	this.custemail = custemail;
	this.ordertotal = ordertotal;
	this.orderstatus = orderstatus;
	this.cake = food;
	this.quantity = quantity;
	}
	
	public int getOrderid() {
	return orderid;
	}
	
	public void setOrderid(int orderid) {
	this.orderid = orderid;
	}
	
	public String getCustemail() {
	return custemail;
	}
	
	public void setCustemail(String custemail) {
	this.custemail = custemail;
	}
	
	public double getOrdertotal() {
	return ordertotal;
	}
	
	public void setOrdertotal(double ordertotal) {
	this.ordertotal = ordertotal;
	}
	
	public String getOrderstatus() {
	return orderstatus;
	}
	
	public void setOrderstatus(String orderstatus) {
	this.orderstatus = orderstatus;
	}
	
	
	
	public Cake getCake() {
	return cake;
	}
	
	public void setCake(Cake cake) {
	this.cake = cake;
	}
	
	public int getQuantity() {
	return quantity;
	}
	
	public void setQuantity(int quantity) {
	this.quantity = quantity;
	}
	
	@Override
	public String toString() {
	return "Order [orderid=" + orderid + ", custemail=" + custemail + ", ordertotal=" + ordertotal
	+ ", orderstatus=" + orderstatus + ", food=" + cake + ", cart=" + cart + ", quantity=" + quantity
	+ ", orderdate=" + orderdate + "]";
	}
	
	}
	



