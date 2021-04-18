package projects;

public class problem7 {

	public static void main(String[] args) {
		
		System.out.println(Long.toString(nthPrime(10001)));

	}
	
	
	
	private static long nthPrime(long n) {
		
		long pr = 1;
		
		for (int i = 0; i < n; i++) {
			pr = nextPrime(pr);
		}
		
		return pr;
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
