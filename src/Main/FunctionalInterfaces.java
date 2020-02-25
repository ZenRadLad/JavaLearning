package Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfaces {

	/** Functional Interfaces : interfaces qui représentent des fonctionalités au lieu de données **/
	
	// Predicate : evalute one argument by using a test method and returns a boolean
		// interface Predicate<T> { boolean test(T t) }
	
	// Consumer :
		// accepts single arg with no return value
		// interface Consumer<T> { boolean accept(T t) }
	
	// Supplier : supplies a value without an input
		// interface Supplier<T> { T get() }
	
	// Function : (Consumer + Supplier ) transforms a value from one type to another
			// interface Function<T, R> { R apply(T t) }
		
	// BiFunction : represents  a function that accepts two args and produce a result
		// interface BiFunction<T, U, R>  
	
	
	// UnaryOperator :
		// single argument with a return value
	
	// BinaryOperator :
		// takes two arguments and returns one

	public static void main(String[] args) {
//		predicates();
		consumers();
//		functions();
//		suppliers();
//		binaryOperators();
//		unaryOperators();
	}

	private static void predicates() {
		Predicate<String> p1 = s -> s.length() < 10;
		System.out.println("Apples is less than 10 chars : " + p1.test("Apples"));

		Predicate<String> p2 = s -> s.contains("c");
		System.out.println("Contains c : " + p2.test("Apples"));

		Predicate<String> p3 = s -> s.contains("c");
		System.out.println("Starts with a : " + p3.test("Zapples"));
		
		Predicate<Integer> p = x -> x >= 18;
		
		List<Integer> ages = List.of(17, 14, 18, 19, 22, 23, 38);
        System.out.println(getOnlyAuthorized(ages, p));
	}
	
	private static List<Integer> getOnlyAuthorized(List<Integer> ages, Predicate<Integer> p){
		return ages.stream().filter(p).collect(Collectors.toList());
	}

	private static void consumers() {
		Consumer<String> consumerStr = s -> System.out.println(s.toLowerCase());
		consumerStr.accept("NOW LOWERCASED ! ");
		
		List<String> userNames = Arrays.asList("Holo", "Molo", "Marko", "Polo");
		userNames.forEach(u -> System.out.println("Hello : " + u));
		
		Map<String, Integer> userAges = new HashMap<>();
		userAges.put("Mark", 20);
		userAges.put("John", 22);
		userAges.put("James", 21);
		
		//BiConsumer
		userAges.forEach((n, a) -> System.out.println("User " + n + " is " + a + " years old.")); 
	}

	private static void functions() {
	}

	private static void suppliers() {
	}

	private static void unaryOperators() {
	}

	private static void binaryOperators() {
	}
}