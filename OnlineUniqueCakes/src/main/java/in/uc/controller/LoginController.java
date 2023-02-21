package in.uc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.uc.dao.LoginDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginc")
public class LoginController extends HttpServlet {
	PrintWriter out=null;
	 HttpSession session=null;
	 RequestDispatcher rd=null;
	 boolean result;
	 LoginDao logindao=new LoginDao();
	 String action=null;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		session=request.getSession(false);
		response.setContentType("text/html");
		action=request.getParameter("action");
		if(session!=null) {
			session.invalidate();
			rd=request.getRequestDispatcher("/jsp/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		session=request.getSession();
		response.setContentType("text/html");
		action=request.getParameter("action");

		String utype=request.getParameter("usertype");
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");

		//Admin
		if(utype!=null && utype.equals("admin")) {
			result=logindao.isAdmin(username, userpass);
			if(result) {
				session.setAttribute("utype", utype);
				session.setAttribute("username", username);
				rd=request.getRequestDispatcher("/jsp/index.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Invalid User !! Please try again");
				rd=request.getRequestDispatcher("/jsp/login.jsp");
				rd.include(request, response);
			}
		}
		
		//customer
		if(utype!=null && utype.equals("customer")) {
			result=logindao.isCustomer(username, userpass);
			if(result) {
				session.setAttribute("utype", utype);
				session.setAttribute("username", username);
				session.setAttribute("userpass", userpass);
				rd=request.getRequestDispatcher("/jsp/index.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Invalid User !! Please try again");
				rd=request.getRequestDispatcher("/jsp/login.jsp");
				rd.include(request, response);
			}
		}
		
		//forgot password
		if(action!=null && action.equals("updatepass")) {
			
			result=logindao.forgetpassword(username, userpass);
			System.out.println(result);
			if(result) {
				request.setAttribute("msg", "Password updated");
				rd=request.getRequestDispatcher("/jsp/login.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Password not updated");
				rd=request.getRequestDispatcher("/jsp/forgotpassword.jsp");
				rd.include(request, response);
			}
		}
	}

}
