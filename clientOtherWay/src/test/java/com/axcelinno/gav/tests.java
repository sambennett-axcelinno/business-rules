package com.axcelinno.gav;

import static org.junit.Assert.*;

import org.junit.Test;

import com.myspace.Customer;
import com.myspace.Product;
import com.myspace.Shop;

public class tests {

	@Test
	public void test() {
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Customer customer = new Customer(1, 1, 400.00, 0.0, true, null, 62284457, 0.0, true);
		Shop shop = new Shop(false,  null,   null);
		rulesRun run = new rulesRun();
		run.runMyRules(customer,  product,  shop);
		assertEquals(99,  product.getQuantity());
		assertEquals(430.00,  customer.getBalance(), 1e-8);
	}

}
