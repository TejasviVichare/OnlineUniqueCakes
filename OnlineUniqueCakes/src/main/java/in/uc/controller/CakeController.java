package in.uc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import in.uc.dao.CakeDao;
import in.uc.pojo.Cake;

@MultipartConfig
@WebServlet("/cakec")
public class CakeController extends HttpServlet {
	int cakeid;
	 String cakename;
	 String caketype;
	 String cakecategory;
	 String cakeflavour;
	 double cakeweight;
	 double cakeprice;	
	 InputStream cakeimage;
	 boolean result;
	 String action=null;
	 Cake c=null;
	 List<Cake> clist=null;
	 CakeDao cdao=new CakeDao();
	 PrintWriter out=null;
	 HttpSession session=null;
	 RequestDispatcher rd=null;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		session=request.getSession();
		action=request.getParameter("action");
		response.setContentType("text/html");
		
		if(action!=null && action.equals("delete")) {
			cakeid=Integer.parseInt(request.getParameter("cid"));
			result=cdao.deleteCake(cakeid);
			if(result) {
				request.setAttribute("msg", "cake deleted");
				clist=cdao.showCakeList();
				session.setAttribute("clist",clist);
				rd=request.getRequestDispatcher("/jsp/cakelist.jsp");
				rd.forward(request, response);
			}
		
				else {
					request.setAttribute("msg", "cake not deleted");

				clist=cdao.showCakeList();
				session.setAttribute("clist",clist);
				rd=request.getRequestDispatcher("/jsp/cakelist.jsp");
				rd.forward(request, response);
				}
			
		}//delete close
		if(action!=null && action.equals("edit")) {
			cakeid=Integer.parseInt(request.getParameter("cid"));
			c=cdao.searchCakeById(cakeid);
			session.setAttribute("cake", c);
			rd=request.getRequestDispatcher("/jsp/updatecake.jsp");
			rd.forward(request, response);
		}
		else {

		clist=cdao.showCakeList();
		session.setAttribute("clist",clist);
		rd=request.getRequestDispatcher("/jsp/cakelist.jsp");
		rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		session=request.getSession();
		response.setContentType("text/html");
		action=request.getParameter("action");
		
		//save .....Add Method
		if(action!=null && action.equals("addcake")) {
			cakename=request.getParameter("cakename");
			caketype=request.getParameter("caketype");
			cakecategory=request.getParameter("cakecategory");
			Part part=request.getPart("cakeimage");
			cakeimage=part.getInputStream();
			cakeflavour=request.getParameter("cakeflavour");
			cakeweight=Double.parseDouble(request.getParameter("cakeweight"));
			cakeprice=Double.parseDouble(request.getParameter("cakeprice"));
			c=new Cake(cakename, caketype, cakecategory, cakeflavour, cakeweight, cakeprice,cakeimage);
			result=cdao.addCake(c);
			System.out.println(result);
			
			if(result) {
				System.out.println("cake added");
				clist=cdao.showCakeList();
				session.setAttribute("clist",clist);
				rd=request.getRequestDispatcher("/jsp/cakelist.jsp");
				rd.include(request, response);

				
			}
			else {
				System.out.println("cake not added");
			}
		}//Add cake close

		//Update Cake
		
		if(action!=null && action.equals("updatecake")) {
			cakename=request.getParameter("cakename");
			caketype=request.getParameter("caketype");
			cakecategory=request.getParameter("cakecategory");
			cakeflavour=request.getParameter("cakeflavour");
			cakeweight=Double.parseDouble(request.getParameter("cakeweight"));
			cakeprice=Double.parseDouble(request.getParameter("cakeprice"));
			Part part=request.getPart("cakeimage");
			cakeimage=part.getInputStream();
			cakeid=Integer.parseInt(request.getParameter("cakeid"));
			c=new Cake(cakeid, cakename, caketype, cakecategory, cakeflavour, cakeweight, cakeprice,cakeimage);
			result=cdao.updateCake(c);
			if(result) {
				clist=cdao.showCakeList();
				session.setAttribute("clist",clist);
				rd=request.getRequestDispatcher("/jsp/cakelist.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Cake not updated");
				rd=request.getRequestDispatcher("/jsp/updatecake.jsp");
				rd.include(request, response);
			}
		}

	}

}
