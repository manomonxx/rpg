package status;

public class Slow implements Status<Double> {
	private Double time; //tempo de lentid�o
	private Double slowRate; //porcentagem de lentid�o
	
	public Slow(Double time, Double slowRate) {
		this.time = time;
		this.slowRate = slowRate;
	}
	
	@Override
	public Double getStatusTime() {
		return time;
	}

	@Override
	public Double getEffect() {
		return slowRate;
	}
}
