package ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/employee")
public class EmployeeWebSocket {
	
	  @OnOpen
	  public void receiveConnection(Session session)
	  {
		 System.out.println("Connection opened");
	  }

	  @OnMessage
	  public void processMessage(Session session, String empid) {
		    System.out.println("Processing : " + empid);
  		    //   get details of employee and send JSON with details 
		    // connect to oracle using thin driver
		    try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery("select first_name, salary from employees where employee_id = " + empid);
		    JsonObjectBuilder builder = Json.createObjectBuilder();
		    if (rs.next()) { // found
		        builder.add("name", rs.getString("first_name"));
		        builder.add("salary", rs.getInt("salary"));
		    } else {
		        builder.add("error", "Employee Not Found");
		    }
		    
		    String result = builder.build().toString();
		    session.getBasicRemote().sendText(result);
		    System.out.println(result);
		    rs.close();
		    st.close();
		    con.close();
		    
		    }
		    catch(Exception ex) {
		    	System.out.println(ex);
		    }
	  }
}
