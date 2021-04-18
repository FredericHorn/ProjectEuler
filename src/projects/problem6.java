package projects;

public class problem6 {

	public static void main(String[] args) {

		System.out.println(Integer.toString(differenceSumSquare(100)));

	}

	private static int differenceSumSquare(int n) {
		
		return (n*(n+1)/2)*(n*(n+1)/2)-n*(n+1)*(2*n+1)/6;
	}

}
