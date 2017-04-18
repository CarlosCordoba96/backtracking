/*********************************************************************
*
* Class Name: Solucion
* Author/s name: Julián García Sánchez & Carlos Córdoba Ruiz
* Release/Creation date: 4/5/16
* Class version: 1
* Class description: This class is used to save here a vector of "Becas" in order to 
* create an object where the solution will be saved
*
**********************************************************************
*/ 
package backtracking;

public class Solucion {
	public  Beca[] becas;
	public int indice;
	
		

	public void setIndice(int indices) {
		indice = indices;
	}

		public Solucion(int dimension){
			becas=new Beca[dimension];
			indice=0;
		}
		
		public void add(Beca b){
			becas[indice]=b;
			indice++;
		}
		public void delete(){
			indice--;
		}
		
		/*********************************************************************
		*
		* Method name: solapado
		*
		* Name of the original author: Julián García Sánchez & Carlos Córdoba Ruiz
		*
		* Description of the Method:Calculate if a Object Beca can be solaped with the solution 
		* that we have, it goes toward the vector and see if all the Becas are not solaped.
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
		public boolean solapado(Beca b){
			boolean solapado=false;
			int i;
			for(i=0;i<indice && !solapado;i++){
				if((becas[i].solaped(b))){//Si se solapan entonces solapado es true
					solapado=true;
				}
			}
			
			return solapado;
		}
		
		/*********************************************************************
		*
		* Method name: total_solution
		*
		* Name of the original author: Julián García Sánchez & Carlos Córdoba Ruiz
		*
		* Description of the Method:Calculate the total amount you earn with the solution 
		* selected.
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
		public int totalsolution(){
			int total = 0;
			int i;
			for(i=0;i<indice;i++){
				total+=becas[i].total_scholarship();
			}
			return total;
		}
		
		/*********************************************************************
		*
		* Method name: copy
		*
		* Name of the original author: Julián García Sánchez & Carlos Córdoba Ruiz
		*
		* Description of the Method:Copy in your Becas array a solution, is used when a optimal solution 
		* is selected
		* 
		* Calling arguments: Object Solucion
		*
		* Return value: void
		*
		* Required Files: None
		*
		* List of Checked Exceptions: 
		*
		*********************************************************************/
		public void copy(Solucion sol){
			int i;
			
			for(i=0;i<sol.getIndice();i++){
				//System.out.println(sol.getIndice());
				this.becas[i]=(Beca) sol.getElement(i);
			}
			this.indice=sol.getIndice();
		}
		
		/*********************************************************************
		*
		* Method name: print
		*
		* Name of the original author: Julián García Sánchez & Carlos Córdoba Ruiz
		*
		* Description of the Method:Print the becas array
		* 
		* Calling arguments: None
		*
		* Return value: void
		*
		* Required Files: None
		*
		* List of Checked Exceptions: 
		*
		*********************************************************************/
		public void print(){
			int i;
			System.out.println("The solution of the problem is: " );
			for(i=0;i<indice;i++){
				System.out.println("The id of the " +i +" scholarship is: "+becas[i].getId()+" the start month is: "+becas[i].getstart_month()+
				" the end month is " +becas[i].getend_month()+ " with a monthly salary of "+becas[i].getscholarship());
				
			}
			System.out.println("With the total income of: "+totalsolution());
		}
		
		
		
		public int getIndice() {
			return indice;
		}
		
		
		/*********************************************************************
		*
		* Method name: get_element
		*
		* Name of the original author: Julián García Sánchez & Carlos Córdoba Ruiz
		*
		* Description of the Method:return the Beca at the position that is specified
		* 
		* Calling arguments: Integer i
		*
		* Return value: Integer 
		*
		* Required Files: None
		*
		* List of Checked Exceptions: 
		*
		*********************************************************************/
		public Beca getElement(int i){
			return becas[i];
		}

}
