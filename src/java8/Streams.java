package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {

		// Lambdas
		Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		System.out.println(comparator.compare("yow", "yow"));
		System.out.println(comparator.compare("yow", "yorrw"));

		Runnable r = () -> {
			int i = 0;
			while (i++ < 10) {
				System.out.println("hello : " + i);
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

		List<Integer> ints = List.of(1, 2, 3, 4, 5);
		ints.stream().forEach(System.out::println);

		List<User> users = new ArrayList<>();
		users.add(new User("Pythagoras", 16));
		users.add(new User("Leonhard Euler", 17));
		users.add(new User("Grigori Perelman", 22));
		users.add(new User("Carl Friedrich Gauss ", 33));
		users.add(new User("Henri Poincar�", 27));

		// Terminal vs Intermediate call
			// Terminal operation (like forEach) must be called to trigger the
				// processing of a stream
			// Intermediate call (like peek) = no data is ever processed (returns a stream)

		// Get user ages older than 18
		users.stream().map(User::getAge).peek(System.out::println).filter(age -> age > 18).forEach(System.out::println);

		// Get users older than 18
		users.stream().filter(user -> user.getAge() > 18);

		// Skip() and Limit() and then apply filter
		users.stream().skip(1).limit(3).filter(u -> u.getAge() > 18).forEach(u -> System.out.println(u.getName()));

		// FindFirst FindAny reductions
		Optional<User> firstUser = users.stream().findFirst();
		System.out
				.println("First user : " + firstUser.get().getName() + ", he is " + firstUser.get().getAge() + " old");

		Optional<User> anyUser = users.stream().findAny();
		System.out.println("Any user : " + anyUser.get().getName() + ", he is " + anyUser.get().getAge() + " old");

		// Matchers anyMatch, allMatch, noneMatch
		boolean anyMatch = users.stream().anyMatch(u -> u.getAge() > 18);
		boolean allMatch = users.stream().allMatch(u -> u.getAge() > 18);
		boolean noneMatch = users.stream().noneMatch(u -> u.getAge() == 30);

		System.out.println("anyMatch users older than 18 : " + anyMatch);
		System.out.println("noneMatch no user is 30 years old : " + noneMatch);
		System.out.println("allMatch all users older than 18 : " + allMatch);

		// Optional (Wrapper Type that can be empty)
		User user = new User("NameOfUser", 31);
		Optional<User> optionalUser = Optional.ofNullable(user);
		System.out.println("User isEmpty : " + optionalUser.isEmpty());
		System.out.println("User isPresent : " + optionalUser.isPresent());

		Optional<User> emptyUser = Optional.empty();
		System.out.println("EmptyUser isEmpty : " + emptyUser.isEmpty());
		System.out.println("EmptyUser isPresent : " + emptyUser.isPresent());

		// flatMap (flatten list items)
		List<List<String>> listOfLists = Arrays.asList(Arrays.asList("Yo"), Arrays.asList("Shawty"),
				Arrays.asList("it's my birthday"));

		System.out.println("listOfLists: " + listOfLists);

		System.out.println("flattened using flatMap() =  "
				+ listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList()));

		// Sorting collections
		List<String> cities = Arrays.asList("Milan", "london", "San Francisco", "Tokyo", "New Delhi", "Casablanca");
		System.out.println("Unsorted : " + cities);

		// Alphabetical sort
		cities.sort(Comparator.naturalOrder());
		System.out.println("Natural Order (capital letters first) : " + cities);

		cities.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println("Case insensitive order : " + cities);

		// Field sort
		List<User> usersToSort = new ArrayList<>();
		usersToSort.add(new User("Pythagoras", 16));
		usersToSort.add(new User("Leonhard Euler", 17));
		usersToSort.add(new User("Grigori Perelman", 22));
		usersToSort.add(new User("Carl Friedrich Gauss ", 33));
		usersToSort.add(new User("Henri Poincar�", 27));

		usersToSort.sort(
				Comparator.comparing(User::getName).reversed().thenComparing(Comparator.comparingInt(User::getAge)));
		usersToSort.forEach(u -> System.out.println(u.getName() + " " + u.getAge()));

		// Splits elements into those that satisfy a Predicate and those that do not
		Map<Boolean, List<String>> citiesOfEqualLength = cities.stream()
				.collect(Collectors.partitioningBy(c -> c.length() > 5));

		citiesOfEqualLength.forEach((key, value) -> System.out.printf("%5s: %s%n", key, value));
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
