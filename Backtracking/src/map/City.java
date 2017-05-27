package map;

public class City {
	private int id;
	private int cost;
	private City next;
	
	public City(int id){
		this.id = id;
		this.cost = 0; //we put cost = 0 because we have to calculate the maximum distance
		this.next = null;
	}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public int getCost() {return cost;}

	public void setCost(int cost) {this.cost = cost;}

	public City getNext() {return next;}

	public void setNext(City next) {this.next = next;}
	
	@Override
	public boolean equals(Object obj){
		boolean check = false;
		if(obj instanceof City){
			City c = (City) obj;
			check = getId() == c.getId();
		}
		return check;
	}
	
	@Override
	public String toString(){
		return "Id: " + getId() + " Cost: " + getCost() + " Next city is [ " + getNext() + " ]";
	}
}
