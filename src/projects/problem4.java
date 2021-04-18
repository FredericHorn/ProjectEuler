package projects;

import java.util.Arrays;

public class problem4 {
	
	public static boolean isPalindromic(int n) {
		
		if (n < 10)
			return true;
		else {
			int len = (int) Math.floor(Math.log10(n));
						
			char[] numbers = new char[len+1];
			
			for (int i = len; i >= 0; i--) {
				numbers[len-i] = Character.forDigit((int) (n / Math.pow(10, i)),10);
				n -= ((int) (n / Math.pow(10, i))) * Math.pow(10, i);
			}
			
			return isPalindromic(numbers);
		}
		
	}
	
	private static boolean isPalindromic(char[] numbers) {
				
		int len = numbers.length;
		
		if (len<2)
			return true;
		
		if (numbers[0] != numbers[len-1])
			return false;
		else {
			return isPalindromic(Arrays.copyOfRange(numbers, 1, len-1));
		}
	}

	public static int largest3digitPalindrome() {
		int ibest = 0;
		int jbest = 0;
		int pal = 0;
		
		for (int i = 100; i<1000; i++) {
			for (int j = 100; j<1000; j++) {
				if (isPalindromic(i*j) && i*j>pal) {
					pal = i*j;
					ibest = i;
					jbest = j;
					
					System.out.println(Integer.toString(ibest) + " * " + Integer.toString(jbest) + " = " + Integer.toString(pal));
				}
			}
		}
		
		
		return pal;
	}

	public static void main(String[] args) {
	
		System.out.println(Boolean.toString(isPalindromic(7)));
		System.out.println(Boolean.toString(isPalindromic(10)));
		System.out.println(Boolean.toString(isPalindromic(101)));
		System.out.println(Boolean.toString(isPalindromic(24321)));
		System.out.println(Boolean.toString(isPalindromic(123321)));
		
		System.out.println(Integer.toString(largest3digitPalindrome()));

	}

}
