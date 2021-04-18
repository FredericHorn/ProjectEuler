package projects;

public class problem2 {
	
	public static int sumOfEvenFib(int maxFib) {
		int sum = 0;
		
		int fib1 = 1;
		int fib2 = 2;
		
		while (fib2 <= maxFib) {
			if (fib2 % 2 == 0) 
				sum += fib2;
			
			fib2 = fib1 + fib2;
			fib1 = fib2 - fib1;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		
		int sum = sumOfEvenFib(4000000);
		
		System.out.println(Integer.toString(sum));

	}

}
