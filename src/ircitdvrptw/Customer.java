package ircitdvrptw;

public class Customer {
	
	private int id;
	private double start_time,end_time,service_time;
	private int demand;
	private Junction junction;
	
	public double getStart_time() {
		return start_time;
	}
	public void setStart_time(double start_time) {
		this.start_time = start_time;
	}
	public double getEnd_time() {
		return end_time;
	}
	public void setEnd_time(double end_time) {
		this.end_time = end_time;
	}
	public double getService_time() {
		return service_time;
	}
	public void setService_time(double service_time) {
		this.service_time = service_time;
	}
	public int getDemand() {
		return demand;
	}
	public void setDemand(int demand) {
		this.demand = demand;
	}
	public Junction getJunction() {
		return junction;
	}
	public void setJ(Junction junction) {
		this.junction = junction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
