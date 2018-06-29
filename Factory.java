import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Factory{
	
	
	public static Classroom generateSimpleClass(int size, double initX, double effort1, double effort2){
		System.out.println("Making class");
		double[] efforts = getEfforts(size, initX, effort1, effort2);
		Strategy[] strategies = getStrategies(efforts);
		Student[] students= getStudents(strategies);
		Classroom classroom = new Classroom(students);
		return classroom;
	}
	
	public static Group[] makeGroups(Student[] students, int groupSize){
		System.out.println("Making groups");
		ArrayList<Student> studentList = new ArrayList<Student>(Arrays.asList(students));
		Collections.shuffle(studentList);
		int numGroups = students.length/groupSize;
		Group[] groups = new Group[numGroups];
		for(int i =0;i<numGroups;i++){
			Student[] studentsForGroup = new Student[groupSize];
			for(int j=0;j<groupSize;j++){
				studentsForGroup[j] = studentList.get(i*groupSize+j);
			}
			groups[i] = new Group(studentsForGroup);
		}
		return groups;
		
	}
	public static Student[] getStudents(Strategy[] strategies){
		int size = strategies.length;
		Student[] students = new Student[size];
		for (int i=0;i<size;i++){
			students[i] = new Student(strategies[i]);
		}
		return students;
	}
	
	public static Strategy[] getStrategies(double[] efforts){
		int size = efforts.length;
		Strategy[] strategies = new Strategy[size];
		for (int i=0;i<size;i++){
			strategies[i] = new SimpleStrat(efforts[i]);
		}
		return strategies;
	}
	
	public static double[] getEfforts(int size, double initX, double effort1, double effort2){
		int numE1 = (int)Math.ceil(size*initX);
		ArrayList<Double> efforts = new ArrayList<Double>();
		for(int i=0;i<numE1;i++)
			efforts.add(new Double(effort1));
		for(int i=numE1;i<size;i++)
			efforts.add(new Double(effort2));
		Collections.shuffle(efforts);
		double[] effortArray = new double[size];
		for(int i=0;i<size;i++){
			effortArray[i] = (double) efforts.get(i);
		}
		return effortArray;
		
	}
}