package com.homework.ecm;

public class ModuleDescriptor {

	private String code;

	private String name;

	private double[] continuousAssignmentWeights;

	public ModuleDescriptor() {

	}

	public ModuleDescriptor(String[] line) {
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
		// continuousAssignmentWeights[] = new continuousAssignmentWeights;
		double[] continuousAssignmentWeights = new double[weights.length];
		// continuousAssignmentWeights.copyOf(continuousAssignmentWeights,
		// weights.length);
		for (int s = 0; s < weights.length; s++) {
			continuousAssignmentWeights[s] = Double.parseDouble(weights[s]);
			// System.out.println(continuousAssignmentWeights[s]);
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
