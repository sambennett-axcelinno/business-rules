package verification;

public class people {
	private int i;
	private boolean b;
	private double d;
	private int test;
	private int test2;
	
	public people() {
		
	}
	
	public people(int i, boolean b, double d, int test, int test2)  {
		this.i = i;
		this.b = b;
		this.d  = d;
		this.test = test;
		this.test2 = test2;
	}
	
	public int getTest2() {
		return test2;
	}

	public void setTest2(int test2) {
		this.test2 = test2;
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
