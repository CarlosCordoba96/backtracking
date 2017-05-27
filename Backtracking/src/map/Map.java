package map;

import java.util.ArrayList;

public class Map {
	private int[][] distances;
	private ArrayList<City> cities;
	
	public Map(int[][] distances){
		this.distances = distances;
		cities = putCities();
	}
	
	public int[][] getDistances() {return distances;}

	public void setDistances(int[][] distances) {this.distances = distances.clone();}

	public ArrayList<City> getCities() {return cities;}

	public void setCities(ArrayList<City> cities) {this.cities = (ArrayList<City>) cities.clone();}
	
	public int sizeDistances(){return distances.length;}
	
	/**
	 * This method calculates the maximum distance between initial vertex and final vertex
	 * @param init
	 * @return the distance between initial vertex and final vertex
	 */
	public String backwardSolution(int init){
		String s = "The maximum distance between " + init + " and " + (sizeDistances() - 1) + " is: ";
		return s + backward(init).getCost();
	}
	
	/**
	 * This method carries out the process of backward
	 * @param v
	 * @return City
	 */
	private City backward(int v){
		City c = getCities().get(v);
		if(c.getCost() == 0){
			ArrayList<City> adjacents = adjacents(c);
			for(int i = 0; i < adjacents.size(); i++){
				City aux = backward(adjacents.get(i).getId());
				if(c.getCost() == 0 || aux.getCost() + distances[v][aux.getId()] > c.getCost()){
					c.setCost(aux.getCost() + distances[v][aux.getId()]);
					c.setNext(aux);
				}
			}
		}
		return c;
	}
	
	/**
	 * This method calculates the maximum distance between initial vertex and final vertex
	 * @return the distance between initial vertex and final vertex
	 */
	public String forwardSolution(){
		String s = "The maximum distance between " + 1 + " and " + (sizeDistances() - 1) + " is: ";
		return s + forward().getCost();
	}
	
	/**
	 * This method carries out the process of forward
	 * @return City
	 */
	private City forward(){
		clean(); //limpiamos los objetos Ciudades
		int x = 0;
		while(x < sizeDistances()){
			City c = getCities().get(x);
			ArrayList<City> cities = adjacents(c);
			for(int i = 0; i < cities.size(); i++){
				City aux = cities.get(i);
				if(aux.getCost() == 0 || c.getCost() + distances[c.getId()][aux.getId()] > aux.getCost()){
					aux.setCost(c.getCost() + distances[c.getId()][aux.getId()]);
					aux.setNext(c);
				}
			}
			x++;
		}
		return getCities().get(sizeDistances() - 1);
	}

	private ArrayList<City> putCities(){
		ArrayList<City> cities = new ArrayList<City>();
		for(int i = 0; i < sizeDistances(); i++){
			cities.add(new City(i));
		}
		
		return cities;
	}
	
	private ArrayList<City> adjacents(City c){
		ArrayList<City> adjacents = new ArrayList<City>();
		for(int i = 0; i < sizeDistances(); i++){
			if(distances[c.getId()][i] > 0)
				adjacents.add(cities.get(i));
		}
		return adjacents;
	}
	
	private void clean(){
		ArrayList<City> aux = getCities();
		for(int i = 0; i < aux.size(); i++){
			aux.get(i).setCost(0);
			aux.get(i).setNext(null);
		}
	}
}
