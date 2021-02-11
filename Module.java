//package com.homework.ecm;

public class Module {

	private int year;

	private byte term;

	private ModuleDescriptor module;

	private StudentRecord[] records;

	private double finalAverageGrade;

	public Module(String[] line) {
		/*
		 * This method assigns values to objects' attributes. it uses trim() method to
		 * get rid of unwanted characters (Whitespace).
		 */
		module = new ModuleDescriptor();
		this.module.setCode(line[1]);
		this.year = Integer.parseInt(line[2].trim());
		this.term = Byte.parseByte(line[3].trim());
	}

	public String getModuleCode() {
		return this.module.getCode();
	}

	public Module() {

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public byte getTerm() {
		return term;
	}

	public void setTerm(byte term) {
		this.term = term;
	}

	public ModuleDescriptor getModule() {
		return module;
	}

	public void setModule(ModuleDescriptor module) {
		this.module = module;
	}

	public StudentRecord[] getRecords() {
		return records;
	}

	public void setRecords(StudentRecord[] records) {
		this.records = records;
	}

	public double getFinalAverageGrade() {
		/*
		 * This method finds the average grade of a module by looping all students and
		 * looking at their final scores.
		 */
		finalAverageGrade = 0;
		int count = 0;
		for (StudentRecord studentRecord : records) {
			if (studentRecord != null) {
				finalAverageGrade += studentRecord.getFinalScore();
				count++;
			}
			return finalAverageGrade / count; // final scores / student count.
		}
		return finalAverageGrade;

	}
}
