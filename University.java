import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class University {

	private ModuleDescriptor[] moduleDescriptors;

	private Student[] students;

	private Module[] modules;

	public University(){
		readStudents("students.csv");
		readModuleDescriptors("module_descriptors.csv");
		readModules("module.csv");

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

			ModuleDescriptor[] moduledescriptors = new ModuleDescriptor[7] ;
			st=myReader.nextLine(); //skip first line header
			while (myReader.hasNextLine()) {
				st=myReader.nextLine();
				csv_line = st.split(",");
				moduledescriptors[i] =new ModuleDescriptor(csv_line) ;
					i++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void readModules(String filename) {
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			String[] csv_line;
			String st;

			Module[] modules = new Module[40] ;
			st=myReader.nextLine(); //skip first line header
			while (myReader.hasNextLine()) {
				st=myReader.nextLine();
				csv_line = st.split(",");
				modules[i] =new Module(csv_line);
					//System.out.println(modules[i].getModuleCode());
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
