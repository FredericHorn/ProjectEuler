package projects;

import java.util.ArrayList;

public class problem14 {

	public static void main(String[] args) {

		System.out.println(determinLongestCollatz(1000000));

	}

	private static int determinLongestCollatz(int n) {
		
		ArrayList<Integer> steps = new ArrayList<Integer>();
		
		steps.add(0);
		
		int maxst = 0;
		int max = 0;
		
		for (int i = 2; i < n; i++) {
			long z = i;
			
			int s = 0;
			
			while (z != 1) {
				s+=1;
				if (z % 2 == 0) {
					z /= 2;
					if (z < i) {
						s+=steps.get((int) (z-1));
						steps.add(s);
						if(s>maxst) {
							maxst = s;
							max = i;
						}
						break;
					}
				}
				else
					z = 3*z +1;
			}
				
		}
		
		return max;
		
	}

}
