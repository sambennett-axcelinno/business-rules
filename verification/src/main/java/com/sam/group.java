package com.sam;

public class group {
	
	private int i;
	private boolean b;
	private double d;
	private int test;
	
	public group() {
		
	}
	
	public group(int i, boolean b, double d, int test)  {
		this.i = i;
		this.b = b;
		this.d  = d;
		this.test = test;
	}
	
	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

}
