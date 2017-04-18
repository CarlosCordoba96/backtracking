/*********************************************************************
*
* Class Name: Scholar
* Author/s name: Julián García Sánchez & Carlos Córdoba Ruiz
* Release/Creation date: 4/5/16
* Class version: 1
* Class description: This is the "main" class of the program, where the object Scholar is created
* and the program starts and make the backtracking method
*
**********************************************************************
*/ 


package backtracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Scholar {
	public Scholar(){
		start();
	}
	public static void main(String[] args) {
		new Scholar();

	}
	/*********************************************************************
	*
	* Method name: read_file
	*
	* Name of the original author: Julián García Sánchez & Carlos Córdoba Ruiz
	*
	* Description of the Method:Read the Scholarships from a file
	* 
	* Calling arguments: None
	*
	* Return value: Vector of Becas
	*
	* Required Files: None
	*
	* List of Checked Exceptions: Openning the file
	*
	*********************************************************************/
	public Beca[]  read_file(){
		//Lectura de fichero para generar las gas_station
		int start_month,end_month,money;
		int j=0;
		Scanner sc = null;
		try {
			sc = new Scanner(new File ("Fellowships1.dat"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int n=sc.nextInt();
		
		Beca [] data=new Beca[n];
		while(sc.hasNext()){
			sc.nextInt();
			start_month= sc.nextInt();
			end_month= sc.nextInt();
			money=sc.nextInt();
			data[j]=new Beca(j,start_month,end_month,money);
			j++;
			}
		return data;
	}

	public void start(){
		Beca[] data=read_file();
		Solucion sol=new Solucion(data.length);
		Solucion soloptimal=new Solucion(data.length);
		recursive(0,data,sol,soloptimal);
		soloptimal.print();
	}
	
	public void recursive(int stage,Beca [] data,Solucion sol, Solucion soloptimal){
		int i;
		if(stage == data.length){ //Base case, all solutions read
			if(	soloptimal.totalsolution()  <  sol.totalsolution()	){		//Better solution of all
				
				soloptimal.copy(sol);//copy the optimal solution
			}
		}else{
			for(i=0;i<data.length;i++){
				if(!data[i].isvisited()) { //We don´t need it but with it we make the program to compare less scholarships
					if (!sol.solapado(data[i])) {					
						data[i].setvisited(true);
						sol.add(data[i]);
						recursive(stage+1,data,sol,soloptimal);
						data[i].setvisited(false);
						sol.delete();
					}
				}
				else {//If we don´t select a scholarship we have to go with the next stage
					recursive(stage+1,data,sol,soloptimal);
				}				
			}				
		}
	}
	
	
}
