package com.homework.ecm;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class University {

	private ModuleDescriptor[] moduleDescriptors;

	private Student[] students;

	private Module[] modules;

	public University() {
		/*
		 * This method invokes other methods to read csv file and then...
		 */
		readStudents("students.csv");
		readModuleDescriptors("module_descriptors.csv");

		readModules("module.csv");

	}

	public ModuleDescriptor findModuleDescriptor(String code) {
		for (int i = 0; i < moduleDescriptors.length; i++) {
			System.out.println(moduleDescriptors[i]);
			if (code == moduleDescriptors[i].getCode()) {
				return moduleDescriptors[i];
			}
		}
		return null;
	}

	private void readStudents(String filename) {
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			String[] csv_line;
			String st;

			students = new Student[10];
			st = myReader.nextLine(); // skip first line header
			while (myReader.hasNextLine()) {
				st = myReader.nextLine();
				csv_line = st.split(",");
				students[i] = new Student(csv_line);
				i++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	private void readModuleDescriptors(String filename) {
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			String[] csv_line;
			String st;

			moduleDescriptors = new ModuleDescriptor[6];
			st = myReader.nextLine(); // skip first line header
			while (myReader.hasNextLine()) {
				st = myReader.nextLine();
				csv_line = st.split(",");
				moduleDescriptors[i] = new ModuleDescriptor(csv_line);
				i++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public double str2Double(String str) {
		str = str.replace('[', ' ');
		str = str.replace(']', ' ');
		str = str.trim();
		return Double.parseDouble(str);
	}

	private void readModules(String filename) {
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			String[] csv_line;
			String st;

			modules = new Module[40];
			st = myReader.nextLine(); // skip first line header
			while (myReader.hasNextLine()) {
				st = myReader.nextLine();
				csv_line = st.split(",");
				modules[i] = new Module(csv_line);
				Student student = findStudent(Integer.parseInt(csv_line[0]));
				double[] dMarks = new double[csv_line.length - 4];
				for (int s = 4; s < csv_line.length; s++) {
					dMarks[s - 4] = str2Double(csv_line[s]);
				}
				StudentRecord studentRecord = new StudentRecord(student, modules[i], dMarks);
				addModuleStudentRecords(modules[i], studentRecord);
				addStudentRecords(student, studentRecord);

				ModuleDescriptor moduleDescriptor = findDescriptor(csv_line[1]);
				modules[i].setModule(moduleDescriptor);

				// System.out.println(modules[i].getModuleCode());
				i++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private ModuleDescriptor findDescriptor(String code) {
		for (ModuleDescriptor moduleDescriptor : this.moduleDescriptors) {
			if (moduleDescriptor.getCode().trim().equals(code.trim())) {
				return moduleDescriptor;
			}
		}
		return null;

	}

	private void addModuleStudentRecords(Module module, StudentRecord studentRecord) {
		if (module.getRecords() == null) {
			module.setRecords(new StudentRecord[4]);
		}
		for (int i = 0; i < module.getRecords().length; i++) {
			if (module.getRecords()[i] == null) {
				module.getRecords()[i] = studentRecord;
				break;
			}

		}
	}

	private void addStudentRecords(Student student, StudentRecord studentRecord) {
		if (student.getRecords() == null) {
			student.setRecords(new StudentRecord[4]);
		}
		for (int i = 0; i < student.getRecords().length; i++) {
			if (student.getRecords()[i] == null) {
				student.getRecords()[i] = studentRecord;
				break;
			}

		}
	}

	private Student findStudent(int studentId) {
		for (Student student : this.students) {
			if (student.getId() == studentId) {
				return student;
			}

		}
		return null;
	}

	/**
	 * @return The number of students registered in the system.
	 */
	public int getTotalNumberStudents() {
		return this.students.length;
	}

	/**
	 * @return The student with the highest GPA.
	 */
	public Student getBestStudent() {
		Student bestStudent;
		bestStudent = students[0];
		for (int i = 1; i < students.length; i++) {
			if (students[i].getGpa() > bestStudent.getGpa()) {
				bestStudent = students[i];
			}
		}
		return bestStudent;
	}

	/**
	 * @return The module with the highest average score.
	 */
	public Module getBestModule() {
		Module bestModule;
		bestModule = modules[0];
		for (int i = 1; i < modules.length; i++) {
			if (modules[i].getFinalAverageGrade() > bestModule.getFinalAverageGrade()) {
				bestModule = modules[i];
			}
		}
		return bestModule;
	}

	public static void main(String[] args) {
		// TODO - needs to be implemented
		University universityOfKnowledge = new University();
		for (Student student : universityOfKnowledge.students) {
			System.out.println(student.printTranscript());

		}
	}

}
