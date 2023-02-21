package in.uc.pojo;

public class Customer {

		private int custid;
		private String custname;
		private String custemail;
		private String custcontact;
		private String custaddress;
		private String custpassword;
		
		public Customer() {
			super();
		}
		public Customer(String custname, String custemail, String custcontact, String custaddress,
				String custpassword) {
			super();
			this.custname = custname;
			this.custemail = custemail;
			this.custcontact = custcontact;
			this.custaddress = custaddress;
			this.custpassword = custpassword;
		}
		public Customer(int custid, String custname, String custemail, String custcontact, String custaddress,
				String custpassword) {
			super();
			this.custid = custid;
			this.custname = custname;
			this.custemail = custemail;
			this.custcontact = custcontact;
			this.custaddress = custaddress;
			this.custpassword = custpassword;
		}
		public int getCustid() {
			return custid;
		}
		public void setCustid(int custid) {
			this.custid = custid;
		}
		public String getCustname() {
			return custname;
		}
		public void setCustname(String custname) {
			this.custname = custname;
		}
		public String getCustemail() {
			return custemail;
		}
		public void setCustemail(String custemail) {
			this.custemail = custemail;
		}
		public String getCustcontact() {
			return custcontact;
		}
		public void setCustcontact(String custcontact) {
			this.custcontact = custcontact;
		}
		public String getCustaddress() {
			return custaddress;
		}
		public void setCustaddress(String custaddress) {
			this.custaddress = custaddress;
		}
		public String getCustpassword() {
			return custpassword;
		}
		public void setCustpassword(String custpassword) {
			this.custpassword = custpassword;
		}
		
		@Override
		public String toString() {
			return "Customer [custid=" + custid + ", custname=" + custname + ", custemail=" + custemail
					+ ", custcontact=" + custcontact + ", custaddress=" + custaddress + ", custpassword=" + custpassword
					+ "]";
		}
		
		
}
