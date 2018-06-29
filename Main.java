import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main{
	
	static Classroom classroom;
	static Group[] groups;
	
	public static void run(int numCourses){
		classroom = Factory.generateSimpleClass(Params.numGroups * Params.groupSize, Params.initX, Params.H, Params.L);
        for(int i=0;i<numCourses;i++){
        	groups = Factory.makeGroups(classroom.students, Params.groupSize);
            assignMarks(groups);
            SimpleStrat H = new SimpleStrat(Params.H);
            SimpleStrat L = new SimpleStrat(Params.L);
            //System.out.println("H:"+ classroom.getConcentration(H));
            //System.out.println("L:"+classroom.getConcentration(L));
            classroom.updateStrategies();
            
            //System.out.println("H:"+ classroom.getConcentration(H));
            //System.out.println("L:"+classroom.getConcentration(L));
            
        }
	}
	
	public static void assignMarks(Group[] groups){
		double marks;
		double effort;
		double groupSize;
		for(int i=0;i<groups.length;i++){
			effort = groups[i].getEffort();
			groupSize = groups[i].students.length;
			marks= effort/groupSize;
			groups[i].assignMarks(marks);
		}
	}
	
	public static void main(String args[]) throws IOException{
		FileOutputStream f = new FileOutputStream("logs.txt");

	    System.setOut(new PrintStream(f));
		ArrayList<Double> xs = new ArrayList<Double>();
		double x;
		for(int i=1;i<2;i+=1){
			System.out.print(i+",");
			for(int j=0;j<2;j++){
				run(i);
				SimpleStrat S = new SimpleStrat(Params.H);
				x = classroom.getConcentration(S);
				xs.add(new Double(x));
				//System.out.print(x+",");
		    }
			//System.out.println("");
		}
		
	}
	
}