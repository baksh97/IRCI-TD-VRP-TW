package ircitdvrptw;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	
	public static void main(String args[]) {
		
	}
	
	void routeConstruction(Data d, List<List<Double>> parameters) {
/*		2 Input initial search space D
		3 for each D e D
		4 Call route construction algorithm for the set of unrouted customers C
		5 Set depot as the initial customer i
		6 do
		7 Select a set of customer candidates J to follow i, JeC
		8 Call the auxiliary routing algorithm for each pair (i, j) where jeJ
		9 Find pair (i, j) with least cost solution and route i
		10 Update best solution Z if there was an improvement
		11 Update initial customer, i j, remove i from C
		12 while J – {}
		13 Return best solution found Z⁄ and corresponding D
		14 end for
		Output:
		Best solution found Z⁄and corresponding D*/
		
//		List<Integer> l = new ArrayList<Integer>();
	}
	
	List<List<Integer>> auxiliaryRouting(Customer initial, double departure_time, List<Customer> unrouted_customers, List<List<Integer>> routes, List<Integer> currentRoute) {
//		double cost;
		
		if(unrouted_customers.isEmpty())
			return routes;
		
		Customer min_cost_customer = null;
		double min_cost = Double.POSITIVE_INFINITY;
		double time_for_edge_travel_of_min_cost_customer = 0;
		for(Customer c: unrouted_customers) {
			double temp_cost = getCostFromC2C(initial, c, departure_time);
			if(temp_cost < min_cost) {
				double time_to_travel_edge = getTimeFromJ2J(initial.getJunction(), c.getJunction());
				if(departure_time + time_to_travel_edge  < c.getEnd_time()) {			//check feasibility
					min_cost = temp_cost;
					min_cost_customer = c;
					time_for_edge_travel_of_min_cost_customer = time_to_travel_edge;
				}
			}
		}
		
		if(min_cost_customer!=null) {
			unrouted_customers.remove(min_cost_customer);
			currentRoute.add(min_cost_customer.getId());
			return auxiliaryRouting(min_cost_customer, departure_time + time_for_edge_travel_of_min_cost_customer, unrouted_customers, routes, currentRoute);
		}
		else {					//no feasible customer for same vehicle, take new vehicle
			double min_and_feasible_cost = Double.POSITIVE_INFINITY;
			Customer min_cost_and_feasible_customer = null;
			double time_for_min_cost_customer_edge = 0;
			
			for(Customer c: unrouted_customers) {
				double time_for_D_2_J = getTimeFromD2J(c.getJunction());
				if(time_for_D_2_J + departure_time < c.getEnd_time()) {
					double temp_cost = getCostFromD2C(c);
					if(temp_cost < min_and_feasible_cost) {
						min_and_feasible_cost = temp_cost;
						min_cost_and_feasible_customer = c;
						time_for_min_cost_customer_edge = time_for_D_2_J;
					}
				}
			}
			
			
			if(min_cost_and_feasible_customer == null) {
				System.err.println("Solution not found by auxiliary algo!!");
				return null;
			}
			else {
				List<Integer> route = new ArrayList<>();
				route.add(min_cost_and_feasible_customer.getId());
				routes.add(route);
				return auxiliaryRouting(min_cost_and_feasible_customer, Math.max(time_for_edge_travel_of_min_cost_customer,  min_cost_and_feasible_customer.getStart_time()),unrouted_customers, routes, route);
			}
			
		}
		
	}
	
	
	double getCostFromC2C(Customer c1, Customer c2, double departure_time) {
		double cost=0;
		return cost;
	}
	
	double getTimeFromJ2J(Junction j1, Junction j2) {
		double time = 0;
		return time;
	}
	
	double getTimeFromD2J(Junction j) {
		double time = 0;
		return time;
	}
	
	double getCostFromD2C(Customer c) {
		double cost = 0;
		return cost;
	}

}
