//package com.homework.ecm;

public class StudentRecord {

	private Student student;

	private Module module;

	private double[] marks;

	private double finalScore;

	private Boolean isAboveAverage;

	public StudentRecord() {

	}

	public StudentRecord(Student student, Module module, double[] marks) {
		super();
		this.student = student;
		this.module = module;
		this.marks = marks;

	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public double getFinalScore() {
		/*
		 * This method calculates a student's final score from a module. It does this by
		 * multiplying weights with marks respectively.
		 */
		finalScore = 0;
		for (double mark : marks) {
			if (this.module.getModule() != null) {
				for (double weight : this.module.getModule().getContinuousAssignmentWeights()) {
					finalScore += mark * weight * 10;
				}
			}

		}

		return finalScore / this.module.getModule().getContinuousAssignmentWeights().length;
	}

	public Boolean getIsAboveAverage() {
		/*
		 * To see if a student is above or below average.
		 */
		return this.finalScore > this.module.getFinalAverageGrade();
	}

	public Student getStudent() {
		return student;
	}

	public double[] getMarks() {
		return marks;
	}

	public void setStudent(Student newStudent) {
		this.student = newStudent;
	}

	public void setMarks(double[] newMarks) {
		this.marks = (newMarks == null ? null : newMarks);
	}
}
