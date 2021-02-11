//package com.homework.ecm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Student {

	private int id;

	private String name;

	private char gender;

	private double gpa;

	private StudentRecord[] records;

	public StudentRecord[] getRecords() {
		return records;
	}

	public void setRecords(StudentRecord[] records) {
		this.records = records;
	}

	public Student(String[] line) {
		this.id = Integer.parseInt(line[0]);
		this.name = line[1];
		this.gender = line[2].charAt(1);
	}

	public double getGpa() {
		/*
		 * This method calculates a student's GPA according to his/her final scores from each module.
		 */

		for (StudentRecord studentRecord : records) {
			gpa += studentRecord.getFinalScore();
		}
		return gpa / records.length;
	}

	public Student() {

	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public char getGender() {
		return this.gender;
	}

	public void setId(int newId) {
		this.id = newId;
	}

	public String printTranscript() {
		/*
		 * This method finds a student record of a student and then makes a transcript
		 * for him/her, it groups the records by their year.
		 */
		System.out.println("University of Knowledge - Official Transcript");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("ID: " + this.id);
		System.out.println("Name: " + this.name);
		System.out.println("GPA: " + Math.round(getGpa() * 100.0) / 100.0);
		System.out.println("\n");

		Map<Integer, List<StudentRecord>> groupby = new HashMap<>();
		for (StudentRecord studentRecord : records) {
			if (studentRecord != null) {
				List<StudentRecord> map = groupby.get(studentRecord.getModule().getYear());
				if (map != null) {
					map.add(studentRecord);
				} else {
					List<StudentRecord> sr = new ArrayList<>();
					sr.add(studentRecord);
					groupby.put(studentRecord.getModule().getYear(), sr);
				}
			}

		}
		for (Entry<Integer, List<StudentRecord>> s : groupby.entrySet()) {
			for (StudentRecord studentRecord : s.getValue()) {
				System.out.println(s.getKey() + " | " + studentRecord.getModule().getTerm() + " | "
						+ studentRecord.getModule().getModule().getCode() + " | "
						+ Math.round(studentRecord.getFinalScore()));

			}
			System.out.println("\n");

		}
		return "";
	}
}
