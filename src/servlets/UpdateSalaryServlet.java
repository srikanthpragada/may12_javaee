package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateSalary")
public class UpdateSalaryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doPost(request,response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read data from client - html form

		String empid = request.getParameter("empid");
		String salary = request.getParameter("salary");

		int id = Integer.parseInt(empid);
		int newsalary = Integer.parseInt(salary);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
				PreparedStatement ps = con.prepareStatement("update employees set salary = ? where employee_id = ?");

				ps.setInt(1, newsalary);
				ps.setInt(2, id);

				int count = ps.executeUpdate();

				if (count == 1)
					pw.println("Successly Updated!");
				else
					pw.println("Sorry! Employee not found!");
			}

		} catch (Exception ex) {
			pw.println("Sorry! Could not update due to some error!");
			System.out.println(ex);
		}
	}

}
