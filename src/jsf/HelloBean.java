package jsf;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloBean {

	 // message property
	 public String getMessage() {
		 return "Hello World From Mojarra";
	 }
	 
	 public String getToday() {
		 return new Date().toString();
	 }
}
