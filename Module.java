public class Module {

	private int year;

	private byte term;

	private ModuleDescriptor module;

	private StudentRecord[] records;

	private double finalAverageGrade;


	public Module (String[] line) {
		//this.id = line[0];
		//this.code = line[1];
		module = new ModuleDescriptor();
		records = new StudentRecord[40];
		this.year = Integer.parseInt(line[2].trim());
		this.term = Byte.parseByte(line[3].trim());
		this.module.setCode(line[1]);

		String marksString = "";
		String[] marks;
    for (int s = 4;s < line.length; s++){
				marksString += line[s]+ ",";
		}
		int j;
		marksString = marksString.replace('[',' ');
		marksString = marksString.replace(']',' ');
		marks = marksString.split(",");
		for (j=0; j<marks.length; j++){
			this.records[j].student.setId(marks[j]);
		}

		System.out.println(marks[0]);

		//this.records.students.setId(line[0]);
	}
	public String getModuleCode(){
		return this.module.getCode();
	}
/*	public String getStudentId(){
		return this.module==null? null: this.module.getId();

	} */

	public Integer getYear(){
		return this.year ;
	}
	public byte getTerm(){
		return this.term ;
	}


}
