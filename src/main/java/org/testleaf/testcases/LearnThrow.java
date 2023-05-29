package org.testleaf.testcases;

public class LearnThrow {

	public void divide(int num1, int num2) {
		
		
		if(num1>num2) {
			System.out.println(num1/num2);
		}
		else {
			//throw keyword throws the new
			throw new RuntimeException("Invalid input given");
			//throw new ArithmeticException("Invalid input- num1 is lessthan num2");
		}
	}
	
	public void sleep(int mSecs) {
		
		try {
			Thread.sleep(mSecs);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		LearnThrow lt=new LearnThrow();
		lt.divide(2,5);
		lt.sleep(2000);
	}

}
