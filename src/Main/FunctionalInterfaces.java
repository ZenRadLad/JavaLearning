package Main;

import java.util.function.Predicate;

public class FunctionalInterfaces {

	// Predicate : evalute one argument by using a test method and returns a boolean
		// in -> 1Arg
		// out -> bool
	// Consumer :
		// accepts single arg with no return value
	// Function : transforms a value from one type to another
		// in -> 1arg
		// out -> a res
	// Supplier : supplies a value without an input
		// represents a supplier of results
	// UnaryOperator :
		// single argument with a return value
	// BinaryOperator :
		// takes two arguments and returns one

	public static void main(String[] args) {
		predicates();
		consumers();
		functions();
		suppliers();
		binaryOperators();
		unaryOperators();
	}

	private static void predicates() {
		Predicate<String> p1 = (s) -> s.length() < 10;
		System.out.println("Apples is less than 10 chars : " + p1.test("Apples"));

		Predicate<String> p2 = (s) -> s.contains("c");
		System.out.println("Contains c : " + p2.test("Apples"));

		Predicate<String> p3 = (s) -> s.contains("c");
		System.out.println("Starts with : " + p3.test("Zapples"));
	}

	private static void consumers() {
		// TODO Auto-generated method stub
	}

	private static void functions() {
		// TODO Auto-generated method stub
	}

	private static void suppliers() {
		// TODO Auto-generated method stub
	}

	private static void unaryOperators() {
		// TODO Auto-generated method stub
	}

	private static void binaryOperators() {
		// TODO Auto-generated method stub
	}
}