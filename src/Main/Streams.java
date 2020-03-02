package Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
	
		// Lambdas
		Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length()); 
		System.out.println(comparator.compare("yow","yow"));
		System.out.println(comparator.compare("yow","yorrw"));
		
		Runnable r = () -> {
			int i = 0;
			while( i++ < 10) {
				System.out.println("hello : " +  i);
			}
		};
		r.run();

		// Stream :
			// doesn't hold any data, it pulls data form a source to process it
			// doesn't modify data it processes

		// Generate Stream
		Stream.empty();
		Stream.of("one", "two");
		Stream.generate(() -> "one");

		List<Integer> ints = List.of(1,2,3,4,5);
		ints.stream().forEach(System.out::println);

		List<User> users = new ArrayList<>();
		users.add(new User("Pythagoras", 16));
		users.add(new User("Leonhard Euler", 17));
		users.add(new User("Grigori Perelman", 22));
		users.add(new User("Carl Friedrich Gauss ", 33));
		users.add(new User("Henri Poincaré", 27));

		//Terminal vs Intermediate call
			//Terminal operation (like forEach) must be called to trigger the
				//processing of a stream
			//Intermediate call (like peek) = no data is ever processed (returns a stream)
		
		// Get user ages older than 18
		users.stream()
			.map(User::getAge)
			.peek(System.out::println)
			.filter(age -> age > 18)
			.forEach(System.out::println);
		
		
		// Get users older than 18
		users.stream()
		.filter(user -> user.getAge() > 18);
		
		//Skip() and Limit() and then apply filter
		users.stream()
			.skip(1)
			.limit(3)
			.filter(u -> u.getAge() > 18)
			.forEach(u -> System.out.println(u.getName()));
		
		//Finder Reductions
		Optional<User> firstUser = users.stream().findFirst();
		System.out.println("First user : " + firstUser.get().getName() + ", he is " + firstUser.get().getAge() + " old");
			
		Optional<User> anyUser = users.stream().findAny();
		System.out.println("Any user : " + anyUser.get().getName() + ", he is " + anyUser.get().getAge() + " old");
		
		//Matchers anyMatch, allMatch, noneMatch
		boolean anyMatch = users.stream().anyMatch(u -> u.getAge() > 18);
		boolean allMatch = users.stream().allMatch(u -> u.getAge() > 18);
		boolean noneMatch = users.stream().noneMatch(u -> u.getAge() == 30);
		
		System.out.println("anyMatch users older than 18 : " + anyMatch);
		System.out.println("noneMatch no user is 30 years old : " + noneMatch);
		System.out.println("allMatch all users older than 18 : " + allMatch);
		
		
		//Optional
		User user = new User("NameOfUser", 31);
		Optional<User> optionalUser = Optional.ofNullable(user);
		System.out.println("User isEmpty : "+ optionalUser.isEmpty());
		System.out.println("User isPresent : "+ optionalUser.isPresent());
		
		Optional<User> emptyUser = Optional.empty();
		System.out.println("EmptyUser isEmpty : "+ emptyUser.isEmpty());
		System.out.println("EmptyUser isPresent : "+ emptyUser.isPresent());
		
		// flatmap()
		// Sorting collections
		// Collect and group/partition data using Collectors class
	}

	public static class User {
		private String name;
		private int age;

		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	};
}
