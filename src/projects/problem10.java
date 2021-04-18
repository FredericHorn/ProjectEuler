package projects;

public class problem10 {

	public static void main(String[] args) {
		
		System.out.println(Long.toString(sumOfPrimesBelow(2000000)));

	}
	
	private static long sumOfPrimesBelow(int max) {
		
		long p = 2;
		
		long sum = 0;

		while (p < max) {
			sum += p;
			
			p = nextPrime(p);
		}
		
		return sum;
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
