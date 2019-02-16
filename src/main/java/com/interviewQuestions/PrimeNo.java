package com.interviewQuestions;

import java.util.Scanner;

public class PrimeNo {

	private static Scanner sc;

	public static void main(String[] args) {
		System.out.println("Enter a number");
		sc = new Scanner(System.in);
		int number = sc.nextInt();

		for (int i = 1; i < number; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				System.out.print(i + " ");
		}

	}

}
