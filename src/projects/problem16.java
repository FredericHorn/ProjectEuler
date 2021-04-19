package projects;

import java.math.BigInteger;

public class problem16 {

	public static void main(String[] args) {

		System.out.println(digitSumOf2Power(1000));

	}

	private static long digitSumOf2Power(int n) {
		
		BigInteger zwei = new BigInteger("2");
		
		BigInteger p = zwei.pow(n);
				
		System.out.println(p);
		
		String digitSum = p.toString(10);
		
		long dS = 0;
		
		for (char ch : digitSum.toCharArray()) {
			dS+=Character.getNumericValue(ch);
		}
		
		return dS;
	}

}
