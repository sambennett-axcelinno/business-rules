package com.axcelinno.kie;

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
		runRules rules = new runRules();
		rules.fireRules(customer,  product,  shop);
		assertEquals(99,  product.getQuantity());
		assertEquals(430.0,  customer.getBalance(), 1e-8);
		assertTrue(customer.getJobStatus());
		assertEquals(105.0,  product.getPrice(), 1e-8);
	}
	
	@Test
	public void holiday() {
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Customer customer = new Customer(1, 1, 400.00, 0.0, false, null, 16, 0.0, true);
		Shop shop = new Shop(true,  null,   null);
		runRules rules = new runRules();
		rules.fireRules(customer,  product,  shop);
		assertTrue(shop.getIsHoliday());
		assertEquals(135.0,  product.getPrice(), 1e-8);
	}
	
	@Test
	public void TV() {
		Product product = new Product(3,  "tv", 4100.00, 100, true);
		Customer customer = new Customer(1, 1, 400.00, 0.0, true, null, 16, 0.0, true);
		Shop shop = new Shop(true,  null,   null);
		runRules rules = new runRules();
		rules.fireRules(customer,  product,  shop);
		assertEquals(4100.00,  product.getPrice(), 1e-8);
		assertTrue(customer.getJobStatus());
	}
	
	@Test
	public void noCheckout() {
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Customer customer = new Customer(1, 1, 400.00, 0.0, true, null, 62284457, 0.0, false);
		Shop shop = new Shop(false,  null,   null);
		runRules rules = new runRules();
		rules.fireRules(customer,  product,  shop);
		assertEquals(368.5,  customer.getBalance(), 1e-8);
		assertEquals(31.5, customer.getDiscountAmt(), 1e-8);
	}

}
