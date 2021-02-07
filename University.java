import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class University {

	private ModuleDescriptor[] moduleDescriptors;

	private Student[] students;

	private Module[] modules;

	public University(){
		String f_student = "students.csv";
		readStudents(f_student);

		String f_moduledescrıptor = "module_descriptors.csv";
		readModuleDescriptors(f_moduledescrıptor);

	}

	private void readStudents(String filename) {
    try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
			int i = 0;
			String[] csv_line;
			String st;

			Student[] students = new Student[10] ;
			st=myReader.nextLine(); //skip first line header
      while (myReader.hasNextLine()) {
				st=myReader.nextLine();
				csv_line = st.split(",");
				students[i] =new Student(csv_line) ;

	      /*System.out.println(students[i].getId());
				System.out.println(students[i].getName());
				System.out.println(students[i].getGender());
				*/
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

			ModuleDescriptor[] moduledescriptors = new ModuleDescriptor[40] ;
			st=myReader.nextLine(); //skip first line header
			while (myReader.hasNextLine()) {
				st=myReader.nextLine();
				csv_line = st.split(",");
				//System.out.println("Lıne 2 :" + csv_line[2]);
				moduledescriptors[i] =new ModuleDescriptor(csv_line) ;

				/*
				System.out.println(moduledescriptors[i].getName());
				System.out.println(moduledescriptors[i].getCode());
				System.out.println(moduledescriptors[i].getContinuousAssignmentWeights());
				*/
					i++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	/**
	 * @return The number of students registered in the system.
	 */
	public int getTotalNumberStudents() {
		// TODO - needs to be implemented
		return 0;
	}

	/**
	 * @return The student with the highest GPA.
	 */
	public Student getBestStudent() {
		// TODO - needs to be implemented
		return null;
	}

	/**
	 * @return The module with the highest average score.
	 */
	public Module getBestModule() {
		// TODO - needs to be implemented
		return null;
	}

	public static void main(String[] args) {
		// TODO - needs to be implemented
		University UoK = new University();
	}


}
