package in.uc.pojo;

public class Cart {

	private int cartid;
	private String custemail;
	private int quantity;
	private Cake cake;
	
	public Cart() {
		super();
	}

	public Cart(String custemail, Cake cake) {
		super();
		this.custemail = custemail;
		this.cake = cake;
	}

	public Cart(int cartid, String custemail, int quantity, Cake cake) {
		super();
		this.cartid = cartid;
		this.custemail = custemail;
		this.quantity = quantity;
		this.cake = cake;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public String getCustemail() {
		return custemail;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cake getCake() {
		return cake;
	}

	public void setCake(Cake cake) {
		this.cake = cake;
	}

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", custemail=" + custemail + ", quantity=" + quantity + ", cake=" + cake
				+ "]";
	}
	
	
	
}
