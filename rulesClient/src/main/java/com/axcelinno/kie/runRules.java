package com.axcelinno.kie;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import com.myspace.*;

public class runRules {
	
	public runRules() {
		
	}
	
	public static void main(String[] args) {
		try {
			KieServices kieServices = KieServices.Factory.get();
			KieContainer kContainer = kieServices.getKieClasspathContainer();
			
			KieSession kSession = kContainer.newKieSession("session-rules");
			
			Product product = new Product(1,  "laptop", 150.00, 100, true);
			Customer customer = new Customer(1, 1, 400.00, 0.0, true, null, 62284457, 0.0, true);
			Shop shop = new Shop(false,  null,   null);
			
			FactHandle factHandle;
			factHandle = kSession.insert(product);
			factHandle = kSession.insert(customer);
			factHandle = kSession.insert(shop);
			
			kSession.fireAllRules();
			System.out.println("Employee rule check");
			System.out.println(product.getName() + " has " + product.getQuantity() + " left");
			System.out.println("Customer spent: " + customer.getBalance());
			System.out.println("Employeed status:  " + customer.getJobStatus());
			System.out.println("Product price after employee discount: " + product.getPrice());
			
		} catch (Throwable t) {
			// TODO: handle exception
			t.printStackTrace();
		}
		try {
			KieServices kieServices = KieServices.Factory.get();
			KieContainer kContainer = kieServices.getKieClasspathContainer();
			
			KieSession kSession = kContainer.newKieSession("session-rules");
			
			Product product = new Product(1,  "laptop", 150.00, 100, true);
			Customer customer2 = new Customer(2, 4, 650.0, 0.0, false, null, 45, 0.0, true);
			Shop shop = new Shop(true,  null,   null);
			
			FactHandle factHandle;
			factHandle = kSession.insert(product);
			factHandle = kSession.insert(customer2);
			factHandle = kSession.insert(shop);
			
			kSession.fireAllRules();
			System.out.println("Adding non-employeed customer");
			System.out.println(product.getName() + " has " + product.getQuantity() + " left");
			System.out.println("Customer spent: " + customer2.getBalance());
			System.out.println("Employeed status: " + customer2.getJobStatus());
			System.out.println("Product price after holiday discount: " + product.getPrice());
			
		} catch (Throwable t) {
			// TODO: handle exception
			t.printStackTrace();
		}
		try {
			KieServices kieServices = KieServices.Factory.get();
			KieContainer kContainer = kieServices.getKieClasspathContainer();
			
			KieSession kSession = kContainer.newKieSession("session-rules");
			
			Product product = new Product(3,  "tv", 4100.00, 100, true);
			Customer customer2 = new Customer(2, 4, 4300.00, 0.0, true, null, 62284457, 0.0, true);
			Shop shop = new Shop(false,  null,   null);
			
			FactHandle factHandle;
			factHandle = kSession.insert(product);
			factHandle = kSession.insert(customer2);
			factHandle = kSession.insert(shop);
			
			kSession.fireAllRules();
			System.out.println("Employee, but product id is for TV");
			System.out.println(product.getName() + " has " + product.getQuantity() + " left");
			System.out.println("Customer spent: " + customer2.getBalance());
			System.out.println("Employeed status: " + customer2.getJobStatus());
			System.out.println("Product price after employee, but not discount not allowed for tv: " + product.getPrice());
			
		} catch (Throwable t) {
			// TODO: handle exception
			t.printStackTrace();
		}
		
	}
	public void fireRules(Customer c, Product p, Shop s) {
		try {
			KieServices kieServices = KieServices.Factory.get();
			KieContainer kContainer = kieServices.getKieClasspathContainer();
			
			KieSession kSession = kContainer.newKieSession("session-rules");
			
			FactHandle factHandle;
			factHandle = kSession.insert(p);
			factHandle = kSession.insert(c);
			factHandle = kSession.insert(s);
			
			kSession.fireAllRules();
		} catch (Throwable  t) {
			t.printStackTrace();
		}
	}
}
