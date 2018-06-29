
public class Student{
	
	Strategy strategy;
	double marks;
	double payOff;
	
	public Student(Strategy strategy){
		this.strategy = strategy;
	}
	
	public double getEffort(){
		return strategy.getEffort();
	}
	
	public void assignMarks(double marks){
		this.marks=marks;
		this.payOff = marks - (Params.a * getEffort());
		System.out.println("Payoff assigned :"+payOff);
	}
	
	public boolean updateStrategy(double oppPayOff, Strategy oppStrategy){
		Strategy oldStrat=strategy;
		double prob = (oppPayOff -payOff);
		double rand = Math.random();
		strategy=(prob>0 && prob>rand)?oppStrategy:strategy;
		System.out.println("Old strategy:" + oldStrat.getEffort());
		System.out.println("New strategy:" + strategy.getEffort());
		return !(oldStrat.equals(strategy));
		
	}
	
}