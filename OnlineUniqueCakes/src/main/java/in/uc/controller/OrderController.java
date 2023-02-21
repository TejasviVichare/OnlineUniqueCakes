package in.uc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.uc.dao.CakeDao;
import in.uc.dao.OrderDao;
import in.uc.pojo.Cake;
import in.uc.pojo.Order;


@WebServlet("/orderc")
public class OrderController extends HttpServlet {
	
	 Cake c=null;
	 List<Cake> clist=null;
	 CakeDao cdao=new CakeDao();
	 PrintWriter out=null;
	 HttpSession session=null;
	 RequestDispatcher rd=null;
	 boolean result;
	 String action=null;
	 OrderDao odao= new OrderDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		out=response.getWriter();
		session=request.getSession();
		action=request.getParameter("action");
		response.setContentType("text/html");
		String uname=(String)session.getAttribute("username");
		
		if(action!=null && action.equals("placeorder")) {
			Order o=odao.placeOrder(uname);
			System.out.println("order o:"+o);
			if(o!=null) {
				System.out.println("order has been placed");
				request.setAttribute("msg", "Order Placed");
				session.setAttribute("order", o);
				rd=request.getRequestDispatcher("/jsp/myorder.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("Order not placed");
				request.setAttribute("msg", "Order not Placed");
				session.setAttribute("order", o);
				rd=request.getRequestDispatcher("/jsp/cartlist.jsp");
				rd.forward(request, response);
			}
		}
		
		if(action!=null && action.equals("myorders")) {
			List<Order>olist=odao.showMyorderList(uname);
			System.out.println("order list:"+olist);
			session.setAttribute("olist", olist);
			rd=request.getRequestDispatcher("/jsp/MyOrderlist.jsp");
			rd.forward(request, response);
			
		}


		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
