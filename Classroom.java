import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Classroom{
	
	Student[] students;
	
	public Classroom(Student[] students){
		this.students = students;
	}

	public void updateStrategies(){
		
		ArrayList<Student> opponents = new ArrayList<Student>(Arrays.asList(students));
		Student opponent;
		int count=0;
		for(int i=0;i<students.length;i++){
			Collections.shuffle(opponents);
			opponent = opponents.get(0);
			if(students[i].updateStrategy(opponent.payOff, opponent.strategy))
				count++;
			
		}
		System.out.println(count+"/"+students.length +"strategies updated.");
	}
	
	public double getConcentration(Strategy S){
		double count=0;
		for(int i=0;i<students.length;i++){
			if(S.equals(students[i].strategy))
				count++;
		}
		return (double)count/(double)students.length;
	}
}