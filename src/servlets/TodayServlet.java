package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/today")
public class TodayServlet extends HttpServlet {
	int count = 1; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
		 pw.println("<h2>" + new Date().toString() + "</h2>");
		 String title = getServletConfig().getInitParameter("title");
		 pw.println("<hr/>");
		 pw.println("<h4>" + title  + "</h4>");
		 pw.println("<h3>" + count + "</h3");
		 count ++;
	}

}
