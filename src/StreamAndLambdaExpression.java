import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamAndLambdaExpression {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Mayank");
		names.add("Alaska");
		names.add("Ajay");
		names.add("Rama");
		
		Long count = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("Name strats with A count :" + count);

		System.out.println("serch name where lenth>4 and print all the valus----");
		names.stream().filter(s -> s.length() > 4).forEach(b -> System.out.println(b));

		System.out.println("serch name where lenth>3 and print only two elements from them----");
		names.stream().filter(a -> a.length() > 3).limit(2).forEach(c -> System.out.println(c));

		System.out.println("Print name in uppercaps which have last letter as 'A'----");
		names.stream().filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		System.out.println("Print name in uppercaps  and shorted order which have first letter as 'A'----");
		names.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).sorted()
				.forEach(s -> System.out.println(s));

		// merging two diffrent list
		System.out.println("Merging two List and print ----");
		List<String> ls1 = Arrays.asList("Shalini", "Smita", "Swati", "Priti", "Nidhi");
		List<String> ls2 = Arrays.asList("Shini", "Shivani", "Priya", "Palak", "Annnya");
		Stream<String> ls3 = Stream.concat(ls1.stream(), ls2.stream());
		ls3.sorted().forEach(s -> System.out.println(s));

		// string match with list element or not ----
		System.out.println("String match with list element or not ----");
		boolean flag = ls2.stream().anyMatch(s -> s.equalsIgnoreCase("Shini"));
		System.out.println(flag);
		Assert.assertTrue(flag);

		// Use Collect -> perform operation and put values in list
		System.out.println("find names in list which starts with 'S', conver it in upper case and copy in another list ----");
		List<String> ls4 = ls1.stream().filter(s -> s.startsWith("S")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		//List<String> ls4 = ls1.stream().filter(s -> s.startsWith("S")).map(s -> s.toUpperCase()).sorted().collect(Collectors.toList());
		System.out.println(ls4);
		
		
		List<Integer> num = Arrays.asList(3,2,2,7,5,1,9,7,8,2);

		System.out.println("Print unique number from List -----");
		num.stream().distinct().forEach(s->System.out.println(s));
		
		System.out.println("Print unique number and in shorted order from List -----");
		num.stream().distinct().sorted().forEach(s->System.out.println(s));
		
		System.out.println("find unique number and in shorted order from List and print only second index value-----");
		List<Integer> shortedLst  = num.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(shortedLst.get(2));
		
		
	/*	 Long c = Stream.of("Abhijeet","Rahul","Anil","Aman","Sail").filter(s-> 
		 { 
			 s.endsWith("t"); 
			 return true; 
			 }).count(); 
		 System.out.println(c);*/
		 

	}

}
