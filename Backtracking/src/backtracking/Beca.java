/*********************************************************************
*
* Class Name: Beca
* Author/s name: Julián García Sánchez & Carlos Córdoba Ruiz
* Release/Creation date: 4/5/16
* Class version: 1
* Class description: This is the "beca" class that is used to create the structure of a scholarship 
* and let us working with them
*
**********************************************************************
*/ 
package backtracking;

public class Beca {
private  int id;
private int start_month;
private int end_month;
private int scholarship;
private boolean visited;
public Beca(int id,int start_month,int end_month,int scholarship){
	this.id=id;
	this.start_month=start_month;
	this.end_month=end_month;
	this.scholarship=scholarship;
	visited=false;
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getstart_month() {
	return start_month;
}
public void setstart_month(int start_month) {
	this.start_month = start_month;
}
public int getend_month() {
	return end_month;
}
public void setend_month(int end_month) {
	this.end_month = end_month;
}
public int getscholarship() {
	return scholarship;
}
public void setscholarship(int scholarship) {
	this.scholarship = scholarship;
}
public boolean isvisited() {
	return visited;
}
public void setvisited(boolean visited) {
	this.visited = visited;
}

/*********************************************************************
*
* Method name: total_scholarship
*
* Name of the original author: Julián García Sánchez & Carlos Córdoba Ruiz
*
* Description of the Method:Calculate the total amount you can earn if you select that
* scholarship
* 
* Calling arguments: None
*
* Return value: Integer 
*
* Required Files: None
*
* List of Checked Exceptions: 
*
*********************************************************************/ 
public int total_scholarship(){
	int total=((end_month-start_month)+1)*scholarship;
	return total;
}


/*********************************************************************
*
* Method name: solaped
*
* Name of the original author: Julián García Sánchez & Carlos Córdoba Ruiz
*
* Description of the Method:Calculate if a object beca can be solaped with another 
* object beca
* 
* Calling arguments: Object Beca
*
* Return value: boolean 
*
* Required Files: None
*
* List of Checked Exceptions: 
*
*********************************************************************/
public boolean solaped(Beca b){
	boolean solapado=true;
	if((b.getstart_month()>end_month || b.getend_month()<start_month)){
		solapado=false;
	}
	
	return solapado;
}

public String toString() {
	return "Beca [id=" + id + ", start_month=" + start_month + ", end_month=" + end_month + ", scholarship="
			+ scholarship + ", visited=" + visited + "]";
}

}
