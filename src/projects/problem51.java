package projects;

import java.util.ArrayList;

public class problem51 {

	public static void main(String[] args) {
		System.out.println(firstPrimeFamilyofSize(8));

	}
	
	private static long firstPrimeFamilyofSize(int size) {
		
		long prime = 1;
		
		while (true) {
			prime = nextPrime(prime);
			//System.out.println(prime);
			String primeStr = Long.toUnsignedString(prime);
			for (int i = 1; i < Math.pow(2, Math.floor(Math.log10(prime))+1); i++) {
				String bin = Integer.toBinaryString(i);
				
				// System.out.println(bin);
				
				while (bin.length() <= Math.floor(Math.log10(prime)))
					bin = "0" + bin;
						
				// redundancies will happen, because I´m not checking
				// whether the chosen positions are holding the same number
				
				int howLargeFamily = 0;
				long smallesPrime = 0;
				
				ArrayList<Long> family = new ArrayList<Long>();
				
				int startOfManipul = 0;
				
				// to avoid the replacement of the first digit to a 0 
				// causing a shrinking in digits of the number
				if (bin.charAt(0) == '1')
					startOfManipul = 1;
				
				for (int j = startOfManipul; j< 10; j++) {
					String newNum = "";
					
					for (int pos = 0; pos <= Math.floor(Math.log10(prime)); pos++) {
						if (bin.charAt(pos) == '1')
							newNum += Integer.toString(j);
						else
							newNum += primeStr.charAt(pos);
					}
					
					//System.out.println(newNum);
					
					long newLongPrime = Long.valueOf(newNum);
					
					if (isPrime(newLongPrime)) {
						if (smallesPrime == 0)
							smallesPrime = newLongPrime;
						howLargeFamily++;
						family.add(newLongPrime);
					}
				}
				
				
				if (howLargeFamily>=size) {
					System.out.println(family.toString());
					return prime;
				}
			}
		}
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
		
		if (num < 2)
			return false;
		
		if (num % 2 == 0) 
			return false;
		
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0)
				return false;
		}
		
		return true;
	}

}
