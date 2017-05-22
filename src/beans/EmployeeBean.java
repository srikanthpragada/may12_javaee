package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeBean {
   
	private int id, salary;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void updateSalary() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			PreparedStatement ps = con.prepareStatement("update employees set salary = ? where employee_id = ?");

			ps.setInt(1, salary);
			ps.setInt(2, id);

			int count = ps.executeUpdate();
			if (count == 1)
				message = "Succesfully updated!";
			else
				message = "Sorry! Employee Id Not Found!";
		}
		catch(Exception ex) {
			System.out.println(ex);
			message = "Sorry! Could not update due to error!";
		}
	}
}
