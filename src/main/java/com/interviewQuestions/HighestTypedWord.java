package com.interviewQuestions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class HighestTypedWord {
	private static Scanner sc;
	private static int i = 0;
	private static String word = null;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(System.in);
		int choice = 0;
		boolean repeatflag = false;
		do {
			System.out.println("Enter your choice 1 for file 0 for sentense");
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("enter valid choice");
			}

			switch (choice) {
			case 0:
				System.out.println("Enter a sentense to detect repeated words");
				sc = new Scanner(System.in);
				String sentense = sc.nextLine();
				findRepeatsForSentense(sentense);
				break;
			case 1:
				System.out.println("please enter path to your file");
				sc = new Scanner(System.in);
				FileInputStream fif = null;
				String path = sc.nextLine();
				try {
					fif = new FileInputStream(new File(path));
					int i = 0;
					StringBuilder sentensefromfile = new StringBuilder();
					while ((i = fif.read()) != -1) {
						sentensefromfile.append((char) i);
					}
					findRepeatsForSentense(sentensefromfile.toString());
				} catch (FileNotFoundException ex) {
					System.out.println("Invalid file path");
				}

				break;
			default:
				System.out.println("invalid choice");
			}
			sc=new Scanner(System.in);
			System.out.println("Enter 'Y' or 'y' to continue");
			repeatflag=sc.nextLine().equalsIgnoreCase("Y")?true:false;
		} while (repeatflag);

		// System.out.println("Enter a sentense to detect repeated words");
		// String sentense = sc.nextLine();

	}

	private static void findRepeatsForSentense(String sentense) {
		String[] words = sentense.split("\\s+");
		Map<String, Integer> result = detectRepeatedWords(words);
		Set<Entry<String, Integer>> entry = result.entrySet();
		Iterator<Entry<String, Integer>> iterator = entry.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> e = iterator.next();
			if (e.getValue() > i) {
				i = e.getValue();
				word = e.getKey();
			}
		}
		if (i > 1)
			System.out.println("you have typed " + word + " word " + i + " number of times");
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
