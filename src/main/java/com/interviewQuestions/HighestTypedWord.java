package com.interviewQuestions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class HighestTypedWord {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int i = 0;
		String word = null;
		System.out.println("Enter a sentense to detect repeated words");
		String sentense = sc.nextLine();
		String[] words = sentense.split("\\s+");
		Map<String, Integer> result = detectRepeatedWords(words);
		Set<Entry<String, Integer>> entry = result.entrySet();
		Iterator<Entry<String, Integer>> iterator = entry.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> e = iterator.next();
			if (e.getValue() > i) {
				i = e.getValue();
				word=e.getKey();
			}

		}
		if(i>1)
		System.out.println("you have typed " + word+ " word "+i+" number of times");
		else
		System.out.println("there is no repeated word in your sentense");

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
