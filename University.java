import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class University {

	private ModuleDescriptor[] moduleDescriptors;

	private Student[] students;

	private Module[] modules;

	public University(){
		String f = "students.csv";
		ReadFile(f);
	}

	private void ReadFile(String filename) {
    try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
			int i = 0;
			String t_id;
			String st="";
      while (myReader.hasNextLine()) {
				st=myReader.nextLine();
				t_id = st.split(",");
				students[0].setId(Integer.parseInt(t_id));
	      System.out.println(t_id);
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
