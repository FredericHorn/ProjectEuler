package projects;

public class problem9 {

	public static void main(String[] args) {

		System.out.println(Integer.toString(pythagorean()));

	}

	private static int pythagorean() {
		
		for (int a = 1; a < 334; a++) {
			for (int b = a+1; b<(1000-a)/2;b++) {
				if (a*a+b*b == (1000-a-b)*(1000-a-b)) {
					System.out.println(Integer.toString(a) + "^2 + " + Integer.toString(b) + "^2 = " + Integer.toString(1000-a-b) + "^2");
					return a*b*(1000-a-b);
				}
			}
		}
		
		return 0;
	}

}
