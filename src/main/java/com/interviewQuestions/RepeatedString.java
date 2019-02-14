package com.interviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatedString {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter a sentense to detect repeated words");
		String sentense = sc.nextLine();
		String[] words = sentense.split("\\s+");
		Map<String, Integer> result = detectRepeatedWords(words);
		System.out.println(result);

	}

	private static Map<String, Integer> detectRepeatedWords(String[] words) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			if (result.containsKey(words[i])) {
				result.put(words[i], result.get(words[i]) + 1);
			} else {
				result.put(words[i], 1);
			}

		}
		return result;
	}

}
