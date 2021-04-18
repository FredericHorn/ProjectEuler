package projects;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class project1 {
	
	public static int theSimpleMethod(int n) {
		int sum = 0;
		
		for (int i = 1; i<n; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
	
	
	public static int streamFilter(int n) {
		List<Integer> list = IntStream.range(1, n)
			    .boxed().collect(Collectors.toList());
		
		Stream<Integer> intRange = list.stream();
		
		Stream<Integer> divBy3and5 = intRange
				.filter(i -> i %3 == 0 || i % 5== 0);
		
		return divBy3and5.reduce(0, Integer::sum);
	}
	

	public static void main(String[] args) {
		
		// int sum = theSimpleMethod(1000);
		
		int sum = streamFilter(1000);
		
		System.out.println(Integer.toString(sum));
	}

}



    
