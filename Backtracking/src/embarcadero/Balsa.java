package embarcadero;
public class Balsa {
	private int id;
	private int cost;
	private Balsa next;
	
	public Balsa(int id){
		this.id = id;
		this.cost = 0; //we put cost = 0 because we have to calculate the maximum distance
		this.next = null;
	}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public int getCost() {return cost;}

	public void setCost(int cost) {this.cost = cost;}

	public Balsa getNext() {return next;}

	public void setNext(Balsa b) {this.next = b;}
	
	@Override
	public boolean equals(Object obj){
		boolean check = false;
		if(obj instanceof Balsa){
			Balsa c = (Balsa) obj;
			check = getId() == c.getId();
		}
		return check;
	}
	
	@Override
	public String toString(){
		return "Id: " + getId() + " Cost: " + getCost() + " Next Balsa is [ " + getNext() + " ]";
	}
	
}
