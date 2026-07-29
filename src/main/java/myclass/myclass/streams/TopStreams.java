package myclass.myclass.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopStreams {
	
	
	public static void main(String[] args) {
		List<Integer> nm = List.of(1,2,3,4,4);
//		nm.stream().distinct().sorted(Comparator.reverseOrder()).forEach(c -> System.out.print(c));
//		nm.stream().filter( n -> n%2 ==1).map( n -> n*n).forEach(n -> System.out.println(n));
//		nm.stream().skip(1).limit(2).forEach(n -> System.out.println(n));
//		nm.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1).forEach(n -> System.out.println(n));
//		Map<Boolean, List<Integer>>  mm =nm.stream().collect(Collectors.partitioningBy( n -> n%2 ==0));
//		System.out.println(mm);
		List<String> nmm = List.of("Sai","Ram","Peddi","Sai");
//		nmm.stream().sorted(Comparator.comparingInt(String :: length).reversed()).limit(1).forEach(System.out :: print);
//		Map<String,Long> cc =nmm.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		System.out.println(cc);
		
		
	
	}

}
