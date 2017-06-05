package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
public class InterestBean {
    private double amount, rate, interest;

    public InterestBean() {
        System.out.println("InterestBean()");
    }
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		System.out.println("setAmount()");
		this.amount = amount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}
    
    public void calculate(ActionEvent evt) {
    	System.out.println("calculate()");
    	interest = amount * rate / 100;
    }
    
    public void rateChanged(ValueChangeEvent evt ) {
    	System.out.println("Rate changed to " + evt.getNewValue());
    }
	
}
