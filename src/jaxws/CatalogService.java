package jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CatalogService {

	@WebMethod 
	public Product getTodayDeal() {
		return new Product("iPad Air 2",40000);
	}
}
