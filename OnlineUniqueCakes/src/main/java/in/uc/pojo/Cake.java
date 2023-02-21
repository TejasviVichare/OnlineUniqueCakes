package in.uc.pojo;

import java.io.InputStream;

public class Cake {

	private int cakeid;
	private String cakename;
	private String caketype;
	private String cakecategory;
	private String cakeflavour;
	private double cakeweight;
	private double cakeprice;
	private InputStream cakeimage;
	
	public Cake() {
		super();
	}
	

	public Cake(String cakename, String caketype, String cakecategory, String cakeflavour, double cakeweight,
			double cakeprice, InputStream cakeimage) {
		super();
		this.cakename = cakename;
		this.caketype = caketype;
		this.cakecategory = cakecategory;
		this.cakeflavour = cakeflavour;
		this.cakeweight = cakeweight;
		this.cakeprice = cakeprice;
		this.cakeimage = cakeimage;
	}


	public Cake(int cakeid, String cakename, String caketype, String cakecategory, String cakeflavour,
			double cakeweight, double cakeprice, InputStream cakeimage) {
		super();
		this.cakeid = cakeid;
		this.cakename = cakename;
		this.caketype = caketype;
		this.cakecategory = cakecategory;
		this.cakeflavour = cakeflavour;
		this.cakeweight = cakeweight;
		this.cakeprice = cakeprice;
		this.cakeimage = cakeimage;
	}


	public Cake(String cakename, String caketype, String cakecategory, String cakeflavour, double cakeweight,
			double cakeprice) {
		super();
		this.cakename = cakename;
		this.caketype = caketype;
		this.cakecategory = cakecategory;
		this.cakeflavour = cakeflavour;
		this.cakeweight = cakeweight;
		this.cakeprice = cakeprice;
	}


	public Cake(int cakeid, String cakename, String caketype, String cakecategory, String cakeflavour,
			double cakeweight, double cakeprice) {
		super();
		this.cakeid = cakeid;
		this.cakename = cakename;
		this.caketype = caketype;
		this.cakecategory = cakecategory;
		this.cakeflavour = cakeflavour;
		this.cakeweight = cakeweight;
		this.cakeprice = cakeprice;
	}
	public int getCakeid() {
		return cakeid;
	}
	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}
	public String getCakename() {
		return cakename;
	}
	public void setCakename(String cakename) {
		this.cakename = cakename;
	}
	public String getCaketype() {
		return caketype;
	}
	public void setCaketype(String caketype) {
		this.caketype = caketype;
	}
	public double getCakeweight() {
		return cakeweight;
	}
	public void setCakeweight(double cakeweight) {
		this.cakeweight = cakeweight;
	}
	public double getCakeprice() {
		return cakeprice;
	}
	public void setCakeprice(double cakeprice) {
		this.cakeprice = cakeprice;
	}
	
	public String getCakecategory() {
		return cakecategory;
	}
	public void setCakecategory(String cakecategory) {
		this.cakecategory = cakecategory;
	}
	public String getCakeflavour() {
		return cakeflavour;
	}
	public void setCakeflavour(String cakeflavour) {
		this.cakeflavour = cakeflavour;
	}


	public InputStream getCakeimage() {
		return cakeimage;
	}


	public void setCakeimage(InputStream cakeimage) {
		this.cakeimage = cakeimage;
	}


	@Override
	public String toString() {
		return "Cake [cakeid=" + cakeid + ", cakename=" + cakename + ", caketype=" + caketype + ", cakecategory="
				+ cakecategory + ", cakeflavour=" + cakeflavour + ", cakeweight=" + cakeweight + ", cakeprice="
				+ cakeprice + "]";
	}
	
	
	
	
}
