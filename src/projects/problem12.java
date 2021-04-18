package projects;

import java.util.ArrayList;

public class problem12 {

	public static void main(String[] args) {

		System.out.println(amountDivisorsOver(500));

	}
	
	
	
	private static long amountDivisorsOver(int n) {
		
		long tria = 0;
		
		for (int i = 1; i < 1000000; i++) {
			tria += i;
			
			if (amountDivisors(tria) > n)
				return tria;
		}
		
		return 0;
	}



	private static int amountDivisors(long n) {

		ArrayList<Long> pF = allPrimeFactor(n);
		
		//System.out.println(pF);
		
		ArrayList<Integer> amPF = new ArrayList<Integer>();

		
		while (!pF.isEmpty()) {
			long factor = pF.get(0);
			
			int k = howManyEnrtiesSortedList(pF, factor);
			
			amPF.add(k);
			
			for (int i = 0; i < k; i++) {
				pF.remove(factor);
			}
		}
		
		//System.out.println(amPF);
		
		int amount = 1;
		
		for (int el : amPF) {
			amount *= el;
		}
		
		return amount;
	
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
