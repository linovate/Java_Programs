package exception;

import Adapter.ProxyAutomobile;

public class Fix1To100 {

	protected void fix1(int errno){
		System.out.println("Model Name is Missing.");
		ProxyAutomobile.getAutomobile().setName("Unknown");
	}
	
	protected void fix2(int errno){
		System.out.println("Base Price is Missing.");	
		ProxyAutomobile.getAutomobile().setBasePrice(-9999999f);
	}
	
}
