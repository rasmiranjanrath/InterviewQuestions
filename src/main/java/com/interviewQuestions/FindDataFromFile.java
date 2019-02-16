package com.interviewQuestions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindDataFromFile {

	private static Scanner sc;

	@SuppressWarnings("all")
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Map<String, Employee> m = new HashMap<String, Employee>();
		try {
			FileInputStream fis = new FileInputStream(new File(
					"/home/rasmiranjan/portal/com.interviewQuestions/src/main/java/com/interviewQuestions/db.txt"));
			int i;
			StringBuilder sentensefromfile = new StringBuilder();
			while ((i = fis.read()) != -1) {
				sentensefromfile.append((char) i);
			}
			String[] words = sentensefromfile.toString().split("\\s+");
			// printDatArray(words);
			insertDataToMap(words, m);
			boolean searchflag = false;
			do {
				System.out.println("Enter Empid");
				Integer empId = Integer.parseInt(sc.nextLine());
				Employee e = m.get(empId.toString());
				System.out.println("name= " + e.getName() + " and Date of joining is" + e.getDoj());
				System.out.println("enter 'y' to continue");
				sc = new Scanner(System.in);
				searchflag = sc.nextLine().equalsIgnoreCase("y") ? true : false;
			} while (searchflag);

		} catch (NumberFormatException e) {
			System.err.println("Enter Valid Id");
		} catch (FileNotFoundException e) {
			System.err.println("Invalid File path");
		} catch (Exception e) {
			System.err.println("Unknown Error");
		}

	}

	private static void insertDataToMap(String[] words, Map<String, Employee> m) {
		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals("emp_id") && !words[i].equals("name") && !words[i].equals("doj")) {
				m.put(words[i], new Employee(words[i + 1], words[i + 2]));
				i = i + 2;
			}
		}

	}

	private static void printDatArray(String[] words) {
		for (int i = 0; i < words.length; i++) {

			System.out.println("for index " + i + "the word is " + words[i]);
		}

	}

}

class Employee {
	String name;
	String doj;

	public Employee(String name, String doj) {
		this.name = name;
		this.doj = doj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

}
