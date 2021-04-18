package projects;

public class problem3 {

	public static void main(String[] args) {

		long primeFactor = largestPrimeFactor(600851475143l);
		
		System.out.println(Long.toString(primeFactor));

	}

	private static long largestPrimeFactor(long num) {
		
		long actPrime = 1;
		
		while(!isPrime(num)) {
			actPrime = nextPrime(actPrime);

			while (num % actPrime == 0) {
				num /= actPrime;
			}
		}
		
		return num;
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
		
		for (int i = 3; i * i < num; i += 2) {
			if (num % i == 0)
				return false;
		}
		
		return true;
	}

}
