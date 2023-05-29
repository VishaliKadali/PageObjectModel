package org.testleaf.testcases;

public class LearnExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 0;

		int[] arr = { 2, 3, 5 };

		try {
			System.out.println(x/y);
			System.out.println("Within try block");// This line will not be executed
			System.out.println(arr[4]);
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println(e);
			if (y == 0) {
				System.out.println(x / 1);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			System.out.println(" Iam in final block");
			//Take the screenshot
		}
		// System.out.println("End of Program");
	}

}
