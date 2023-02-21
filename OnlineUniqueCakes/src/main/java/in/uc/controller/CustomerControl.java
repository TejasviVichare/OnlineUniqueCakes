package in.uc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.uc.dao.CustomerDao;
import in.uc.pojo.Customer;


@WebServlet("/custc")
public class CustomerControl extends HttpServlet {
	 int custid;
	 String custname;
	 String custemail;
	 String custcontact;
	 String custaddress;
	 String custpassword; 
	 Scanner sc=new Scanner(System.in);
	 boolean result;
	 Customer c1 =null;
	 CustomerDao cdao=new CustomerDao();
	 PrintWriter out=null;
	 HttpSession session=null;
	 RequestDispatcher rd=null;
	 String action=null;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		out=response.getWriter();
		session=request.getSession();
		action=request.getParameter("action");
		
		
		
		if(action!=null && action.equals("addcustomer")) {
			custname=request.getParameter("custname");
			custemail=request.getParameter("custemail");
			custcontact=request.getParameter("custcontact");
			custaddress=request.getParameter("custaddress");
			custpassword=request.getParameter("custpassword");
			c1 =new Customer(custname, custemail, custcontact, custaddress, custpassword);
			result=cdao.addCustomer(c1);
			
			if(result) {
				rd=request.getRequestDispatcher("/jsp/login.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Registration failed!!Please try again");
				rd=request.getRequestDispatcher("/jsp/register.jsp");
				rd.include(request, response);
			}
		}
		
	}

}
