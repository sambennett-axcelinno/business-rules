package com.axcelinno.client;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import com.myspace.*;

public class myConfig {
	public static void main(String[] args) {
		try {
			KieServices kieServices = KieServices.Factory.get();
			KieContainer kContainer = kieServices.getKieClasspathContainer();
			
			KieSession kSession = kContainer.newKieSession("session-rules");
			
			Product product = new Product(1,  "laptop", 150.00, 100, true);
			Customer customer  = new Customer(1,  1,   400.00,  0.0,  false,  null,  62284457, 0.0, true);
			Shop shop = new Shop(false,  null,   null);
			
			FactHandle factHandle;
			factHandle = kSession.insert(product);
			factHandle = kSession.insert(customer);
			factHandle = kSession.insert(shop);
			
			kSession.fireAllRules();
			System.out.println("Employee rule check");
			System.out.println(product.getName() + " has " + product.getQuantity() + " left");
			System.out.println("passes");
			
		} catch (Throwable t) {
			// TODO: handle exception
			t.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
