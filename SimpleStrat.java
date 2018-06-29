public class SimpleStrat extends Strategy {

	double effort;

	public SimpleStrat(double effort) {
		this.effort = effort;
	}

	public double getEffort() {
		return effort;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof SimpleStrat)) {
			return false;
		}

		SimpleStrat c = (SimpleStrat) o;

		return Double.compare(effort, c.effort) == 0;
	}
}