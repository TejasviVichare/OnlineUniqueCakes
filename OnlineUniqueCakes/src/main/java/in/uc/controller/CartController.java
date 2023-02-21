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
import in.uc.dao.CartDao;
import in.uc.pojo.Cake;
import in.uc.pojo.Cart;


@WebServlet("/cartc")
public class CartController extends HttpServlet {
	 int cartid;
	 String custemail;
	 int quantity;
	 
	 List<Cake> clist=null;
	 CartDao cdao=new CartDao();
	 PrintWriter out=null;
	 RequestDispatcher rd=null;
	 HttpSession session=null;
	 String action=null;
	 Cake c=null;
	 Cart cart=null;
	 boolean result;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		session=request.getSession(false);
		action=request.getParameter("action");
		response.setContentType("text/html");
		String uname=(String)session.getAttribute("username");
		
		if(uname!=null) {
			if(action!=null && action.equals("addtocart")) {
				int cakeid=Integer.parseInt(request.getParameter("cid"));
				c=new Cake();
				c.setCakeid(cakeid); 
				cart=new Cart(uname, c);
				result=cdao.addToCart(cart);
				
			  if(result) {
				request.setAttribute("msg", "cake added to cart");
				List<Cart> cartlist=cdao.showMyCart(uname);
				session.setAttribute("clist", cartlist);
				rd=request.getRequestDispatcher("/jsp/cartlist.jsp");
				rd.forward(request, response);

			  }
			 else {
				request.setAttribute("msg", "cake not added to cart");
				List<Cart> cartlist=cdao.showMyCart(uname);
				rd=request.getRequestDispatcher("/jsp/cakelist.jsp");
				rd.forward(request, response);
			  }
			}
		
			if(action!=null && action.equals("mycart")) {
				List<Cart> cartlist=cdao.showMyCart(uname);
				
				if(cartlist.isEmpty()) {
				request.setAttribute("msg", "Cart is empty");
				rd=request.getRequestDispatcher("/jsp/cartlist.jsp");
				rd.include(request, response);
				}
				else {
					session.setAttribute("clist", cartlist);
					rd=request.getRequestDispatcher("/jsp/cartlist.jsp");
					rd.forward(request, response);
				}
			}
			if(action!=null && action.equals("deletefromcart")) {
				int cartid=Integer.parseInt(request.getParameter("cartid"));
				result=cdao.deleteMyCart(cartid);
				if(result) {
					List<Cart> cartlist=cdao.showMyCart(uname);
	                 
					if(cartlist.isEmpty()) {
						request.setAttribute("msg", "Cart is empty");
						rd=request.getRequestDispatcher("/jsp/cartlist.jsp");
						rd.include(request, response);
					}
					else {
						session.setAttribute("clist", cartlist);
						rd=request.getRequestDispatcher("/jsp/cartlist.jsp");
						rd.forward(request, response);
					}
				}
				else {
					List<Cart> cartlist=cdao.showMyCart(uname);
					session.setAttribute("clist", cartlist);
					request.setAttribute("msg", "Cake not deleted from cart");
					rd=request.getRequestDispatcher("/jsp/cartlist.jsp");
					rd.forward(request, response);
				}
			}		
		}		
		else {
			request.setAttribute("msg", "Please login first");
			rd=request.getRequestDispatcher("/jsp/login.jsp");
			rd.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
