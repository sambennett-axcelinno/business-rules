package com.axcelinno.gav;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.rule.FactHandle;
import com.myspace.*;


public class rulesRun {
	
	public rulesRun() {
		
	}
	
	public  static void main(String[] args) {
		String groupID = "com.myspace.store";
		String artifactId = "Store-drools";
		String version = "1.0.7-SNAPSHOT";
		
		Map<String, Object> params = new HashMap<String, Object>();
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Customer customer = new Customer(1, 1, 400.00, 0.0, true, null, 62284457, 0.0, true);
		Shop shop = new Shop(false,  null,   null);
		params.put("c", customer);
		params.put("p",  product);
		params.put("s",  shop);
		
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId(groupID,  artifactId,  version);
		KieContainer kContainer = ks.newKieContainer(releaseId);
		KieSession kSession = kContainer.newKieSession();
		KieRuntime kRuntime = (KieRuntime) kSession;
		ProcessInstance processInstance = kRuntime.startProcess("Store-drools.shopProcess", params);
		//kSession.fireAllRules();
		System.out.println(customer.getBalance());
		System.out.println(customer.getJobStatus());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		
		System.out.println("works");
	}
	
	public void runMyRules(Customer c, Product p, Shop s) {
		String groupID = "com.myspace.store";
		String artifactId = "Store-drools";
		String version = "1.0.1-SNAPSHOT";
		
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId(groupID,  artifactId,  version);
		KieContainer kContainer = ks.newKieContainer(releaseId);
		KieSession kSession = kContainer.newKieSession();
		
		FactHandle factHandle;
		factHandle = kSession.insert(p);
		factHandle = kSession.insert(c);
		factHandle = kSession.insert(s);
		
		int num = kSession.fireAllRules();
		System.out.println(num);
	}

}
