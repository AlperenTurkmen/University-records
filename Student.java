public class Student {

	private int id;

	private String name;

	private char gender;

	private double gpa;

	private StudentRecord[] records;

	public Student (String[] line) {
		this.id = Integer.parseInt(line[0]);
		this.name = line[1];
		this.gender = line[2].charAt(1);
	}

	public void setId(int newId){
		this.id = newId;
	}
	public int getId(){
		return this.id ;
	}

	public String getName(){
		return this.name ;
	}
	public char getGender(){
		return this.gender ;
	}
	public String printTranscript() {
		// do something
		return "";
	}
}
