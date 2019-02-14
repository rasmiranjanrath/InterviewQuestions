package com.interviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatedChars {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter a String to detect repeated characters !!!");
		String chars = sc.nextLine();
		Map<Character, Integer> result = detectRepeats(chars);
		System.out.println(result);

	}

	private static Map<Character, Integer> detectRepeats(String chars) {
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		for (int i = 0; i < chars.length(); i++) {

			if (result.containsKey(chars.charAt(i))) {
				result.put(chars.charAt(i), result.get(chars.charAt(i)) + 1);
			} else {
				result.put(chars.charAt(i), 1);
			}

		}
		return result;
	}

}
