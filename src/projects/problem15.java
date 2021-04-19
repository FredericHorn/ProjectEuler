package projects;

import java.math.BigInteger;

public class problem15 {

	public static void main(String[] args) {
		System.out.println(amountOfRoutesIn(20));

	}

	private static BigInteger amountOfRoutesIn(int gridsize) {
		
		// using combinatorics we know that we have to go exactly
		// 20 steps down and 20 to the right, just the order in
		// which it happens can differ. So it´s just the permutation
		// of 40 steps, but with 2 times 20 identical steps (their 
		// order does not matter), so the formula is 40!/(20!*20!)
		
		BigInteger  prod = new BigInteger ("1");
		
		for (int i = gridsize+1; i <=gridsize*2; i++) {
			BigInteger fac = BigInteger.valueOf(i);
			prod = prod.multiply(fac);
			
		}
		
		for (int i = 1; i<=gridsize; i++) {
			BigInteger fac = BigInteger.valueOf(i);
			prod = prod.divide(fac);
		}
		
		
		return prod;
	}

}
