//package com.homework.ecm;

public class ModuleDescriptor {

	private String code;

	private String name;

	private double[] continuousAssignmentWeights;

	public ModuleDescriptor() {
/*
 * I created this empty constructor because it caused a trouble when I was coding without and IDE.
 */
	}

	public ModuleDescriptor(String[] line) {
		/*
		 * This method assigns the values of method descriptors.
		 * Converts the weights array to a string and then assigns them respectively.
		 * It also gets rid of unwanted characters with replace and split methods.
		 */
		this.name = line[0];
		this.code = line[1];
		int sum;
		String w = "";
		String[] weights;
		for (int s = 2; s < line.length; s++) {
			w += line[s] + ",";
		}
		w = w.replace('[', ' ');
		w = w.replace(']', ' ');
		weights = w.split(",");

		double[] continuousAssignmentWeights = new double[weights.length];
		for (int s = 0; s < weights.length; s++) {
			continuousAssignmentWeights[s] = Double.parseDouble(weights[s]);
		}

		this.continuousAssignmentWeights = continuousAssignmentWeights;
	}

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}

	public double[] getContinuousAssignmentWeights() {
		return this.continuousAssignmentWeights;
	}

	public void setCode(String newCode) {
		this.code = newCode;
	}
}
