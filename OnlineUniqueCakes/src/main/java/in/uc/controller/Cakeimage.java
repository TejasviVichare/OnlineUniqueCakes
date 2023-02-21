package in.uc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.uc.dao.CakeDao;
import in.uc.pojo.Cake;


@WebServlet("/Cakeimage")
public class Cakeimage extends HttpServlet {
	
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/*");
		int cakeid=Integer.parseInt(request.getParameter("cakeid"));
		CakeDao cdao=new CakeDao();
		Cake c=cdao.searchCakeById(cakeid);
		InputStream in=c.getCakeimage();
		OutputStream out=response.getOutputStream();
		
		int i=0;
		
		while(i!=-1) {
			i=in.read();
			if(i!=-1) {
				out.write(i);
			}
		}
		in.close();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
