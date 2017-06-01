package rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/hello")
public class Hello {

	 @GET 
	 public String getHello() {
		 return "Hello From Rest";
	 }
	 
	 @POST
	 public void postData() {
		 System.out.println("Post request made");
	 }
	 
	 
}
