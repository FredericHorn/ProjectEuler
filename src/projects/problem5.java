package projects;

import java.util.ArrayList;
import java.util.Collections;

public class problem5 {

	public static void main(String[] args) {

		System.out.println(Long.toString(evenlyDivisibleUpTo(20)));

	}

	private static long evenlyDivisibleUpTo(int upto) {
		
		ArrayList<Long> primeFactors = new ArrayList<Long>();
		
		for (int i = 2; i <= upto; i++) {
			System.out.println(primeFactors);
			
			ArrayList<Long> primeFactorsAct = allPrimeFactor(i);
			
			System.out.println(primeFactorsAct);
			
			while (!primeFactorsAct.isEmpty()) {
				long factor = primeFactorsAct.get(0);
				int howManyShouldBe = howManyEnrtiesSortedList(primeFactorsAct,factor);
				int howManyAre = howManyEnrtiesSortedList(primeFactors,factor);
				
				for (int j = 0; j < howManyShouldBe - howManyAre; j++) {
					primeFactors.add(factor);
				}
				for (int j = 0; j < howManyShouldBe; j++) {
					primeFactorsAct.remove(factor);
				}
				
				Collections.sort(primeFactors);
			}
			
		}
		
		long prod = 1;
		
		for (long el : primeFactors) {
			prod *= el;
		}
		
		return prod;
	}
	
	private static int howManyEnrtiesSortedList (ArrayList<Long> list, long el) {
		int firstIndex = list.indexOf(el);
		int maxIndex = firstIndex;
		while(maxIndex >= 0 && maxIndex < list.size() && list.get(maxIndex) == el) {
			maxIndex += 1;
		}
		
		return maxIndex - firstIndex + 1;
	}
	
	private static ArrayList<Long> allPrimeFactor(long num) {
		
		ArrayList<Long> primeFactors = new ArrayList<Long>();
		
		long actPrime = 1;
		
		while(!isPrime(num)) {
			actPrime = nextPrime(actPrime);

			while (num % actPrime == 0) {
				num /= actPrime;
				primeFactors.add(actPrime);
			}
		}
		
		if (num != 1)
			primeFactors.add(num);
		return primeFactors;
	}

	private static long nextPrime(long z) {
		
		if (z == 1)
			return 2;
		else if (z == 2)
			return 3;
		else {
			z += 2;
			while (!isPrime(z)) {
				z += 2;
			}
		}
		
		return z;
	}
	
	private static boolean isPrime(long num) {
		
		if (num % 2 == 0) 
			return false;
		
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0)
				return false;
		}
		
		return true;
	}

}
