

public class Group{
	
	Student[] students;
	public Group(Student[] students){
		this.students = students;
	}
	
	public double getEffort(){
		double effort=0;
		for(int i=0;i<students.length;i++){
			effort=effort+students[i].getEffort();
		}
		return effort;
	}
	
	public void assignMarks(double marks){
		for(int i=0;i<students.length;i++){
			students[i].assignMarks(marks);
		}
		System.out.println("Assigning "+marks+" marks to all students in group");
	}
}