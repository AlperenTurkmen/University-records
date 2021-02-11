package com.homework.ecm;

public class Module {

	private int year;

	private byte term;

	private ModuleDescriptor module;

	private StudentRecord[] records;

	private double finalAverageGrade;

	public Module(String[] line) {
		module = new ModuleDescriptor();
		this.module.setCode(line[1]);
		this.year = Integer.parseInt(line[2].trim());
		this.term = Byte.parseByte(line[3].trim());
		// this.module = UoK.findModuleDescriptor(line[1]);

		// System.out.print(dMarks[s-4] +" " );
	}
	// System.out.println(":");

	// records = new StudentRecord[400];
	// records[0].setMarks(dMarks);
	public String getModuleCode() {
		return this.module.getCode();
	}

	/*
	 * public String getStudentId(){ return this.module==null? null:
	 * this.module.getId();
	 *
	 * }
	 */
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
		finalAverageGrade = 0;
		int count = 0;
		for (StudentRecord studentRecord : records) {
			if (studentRecord != null) {
				// for (double mark : studentRecord.getRecords()) {
				finalAverageGrade += studentRecord.getFinalScore();
				count++;
			}
			// }
			return finalAverageGrade / count;
		}
		return finalAverageGrade;

	}
}
