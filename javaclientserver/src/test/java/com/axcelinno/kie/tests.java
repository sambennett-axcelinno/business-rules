package com.axcelinno.kie;

import static org.junit.Assert.*;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import com.myspace.*;

import org.junit.Test;
import org.junit.rules.RunRules;

import com.myspace.Customer;
import com.myspace.Product;
import com.myspace.Shop;

public class tests {

	@Test
	public void test() {
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Customer customer = new Customer(1, 1, 400.00, 0.0, true, null, 62284457, 0.0, true);
		Shop shop = new Shop(false,  null,   null);
		
	}

}
