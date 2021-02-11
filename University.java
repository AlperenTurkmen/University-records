//package com.homework.ecm; //This line was for eclipse, we don't need it as long as we don't run it in an IDE.

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class University {
//This is the main class which includes other classes.
	private ModuleDescriptor[] moduleDescriptors;
//A module's attributes' array.
	private Student[] students;
//A student's attributes' array.
	private Module[] modules;

//An array of a complex objects named modules.
	public University() {
		/*
		 * This method invokes other methods to read csv file and then assign the values
		 * to related objects.
		 */
		readStudents("students.csv");
		readModuleDescriptors("module_descriptors.csv");
		readModules("module.csv");
	}

	public ModuleDescriptor findModuleDescriptor(String code) {
		/*
		 * This module finds a description of a module out of all modules, works with a
		 * simple for loop, uses getCode method in it. If it can't find the related one,
		 * returns null.
		 */
		for (int i = 0; i < moduleDescriptors.length; i++) {
			System.out.println(moduleDescriptors[i]);
			if (code == moduleDescriptors[i].getCode()) {
				return moduleDescriptors[i];
			}
		}
		return null;
	}

	private void readStudents(String filename) {
		/*
		 * This method basically reads a csv file and converts each line to an array.
		 * This only works for students' attributes. It requires the filename and has a
		 * try-catch test technique in it.
		 */
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			String[] csv_line;
			String st;

			students = new Student[10];
			st = myReader.nextLine(); // This line is to skip the first line (header)
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

	private void readModuleDescriptors(String filename) {
		/*
		 * This method basically reads a csv file and converts each line to an array.
		 * This only works for modules' attributes. It requires the filename and has a
		 * try-catch test technique in it.
		 */
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			String[] csv_line;
			String st;

			moduleDescriptors = new ModuleDescriptor[6];
			st = myReader.nextLine(); // This line is to skip the first line (header)
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
		/*
		 * This method converts a string to a double, I use it in comma seperated arrays
		 * in csv's (CA Weights and student marks for example.)
		 */
		str = str.replace('[', ' ');
		str = str.replace(']', ' ');
		str = str.trim();
		return Double.parseDouble(str);
	}

	private void readModules(String filename) {
		/*
		 * This method basically reads a csv file and converts each line to an array.
		 * This only works for module type csv files. It requires the filename and has a
		 * try-catch test technique in it.
		 */
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			String[] csv_line;
			String st;

			modules = new Module[40];
			st = myReader.nextLine(); // This line is to skip the first line (header)
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
				i++; // To keep the loop valid
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private ModuleDescriptor findDescriptor(String code) {
		/*
		 * This method gives a module descriptor as an output when you give it the
		 * module code.
		 */
		for (ModuleDescriptor moduleDescriptor : this.moduleDescriptors) {
			if (moduleDescriptor.getCode().trim().equals(code.trim())) {
				return moduleDescriptor;
			}
		}
		return null;

	}

	private void addModuleStudentRecords(Module module, StudentRecord studentRecord) {
		/*
		 * This method
		 */
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
		/*
		 * This method gives a student object as an output when you give it the student
		 * ID.
		 */
		for (Student student : this.students) {
			if (student.getId() == studentId) {
				return student;
			}

		}
		return null;
	}

	public int getTotalNumberStudents() {
		/*
		 * This method returns the total number of students.
		 */
		return this.students.length;
	}

	public Student getBestStudent() {
		/*
		 * This methods finds the best student according to their GPAs and returns it.
		 */
		Student bestStudent;
		bestStudent = students[0];
		for (int i = 1; i < students.length; i++) {
			if (students[i].getGpa() > bestStudent.getGpa()) {
				bestStudent = students[i];
			}
		}
		return bestStudent;
	}

	public Module getBestModule() {
		/*
		 * This method finds the module with the highest final average grade and returns
		 * it.
		 */
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
		University universityOfKnowledge = new University();
		for (Student student : universityOfKnowledge.students) {
			System.out.println(student.printTranscript());

		}
	}

}
