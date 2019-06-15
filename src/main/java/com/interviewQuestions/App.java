package com.demo.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author rasmiranjan
 * @since 1.0.0
 *
 */
public class App {
	public static void main(String[] args) {

		List<String> los = Arrays.asList("Street", "score", "Grabage", "firstName", "fullName", "HolderName");
		String name = los.stream().filter(s -> s.contains("Name")).findFirst().get();

		System.out.println(name);

		List<Integer> loi = Arrays.asList(7, 8, 85, 2, 5, 2, 58, 2, 58, 2, 8, 2, 58, 12, 5, 2, 5, 12, 5, 2, 8, 48, 3, 3,
				8, 1, 9, 3, 8, 3, 9, 5, 2, 68, 2, 38);

		long count = loi.stream().filter(i -> i.equals(2)).count();
		System.out.println(count);
		System.out.println(loi.stream().filter(i -> i % 2 == 0).count());
		System.out.println(loi.stream().filter(i -> i > 20).map(i -> i * 2).reduce(0, (n1, n2) -> n1 + n2));
		loi.stream().distinct().forEach(n -> System.out.println(n));
		Stream<String> stream = Stream.of("hey");
		stream.forEach(System.out::print);

		Stream.iterate(1, n -> n + 1).limit(20).filter(n -> n % 2 == 0).forEach(System.out::println);

		List<Integer> number = Arrays.asList(2, 3, 4, 5);
		List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square);

	}
}
