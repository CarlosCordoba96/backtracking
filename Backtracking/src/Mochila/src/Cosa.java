package Mochila.src;

public class Cosa{
	int nombre;
	int vCapacidad;
	int valor;
	int pongo;//en la version forw es si se pone la Cosa o no. En la back si se pone el siguiente objeto o no
	Cosa vengo;
	Cosa(int n){
		nombre=n; vCapacidad=0; valor=0; pongo=0; vengo=null;
	}
	Cosa(int n,int cap,int val,int pon,Cosa v){
		nombre=n;vCapacidad=cap;valor=val;pongo=pon;vengo=v;
	}
	public int nombre(){
		return nombre;
		}
	public void vCapacidad(int c){
		vCapacidad=c;
		}
	public int vCapacidad()
	{return vCapacidad;
	}
	public void valor(int c){
		valor=c;
		}
	public int valor(){
		return valor;
		}
	public void pongo(int c){
		pongo=c;
		}
	public int pongo(){
		return pongo;
		}
	public void vengo(Cosa c){
		vengo=c;
		}
	public Cosa vengo(){
		return vengo;
		}
	public boolean equals(Object v){
		return v instanceof Cosa && nombre()==((Cosa)v).nombre() &&
		vCapacidad()==((Cosa)v).vCapacidad();
		}
		public String toString(){
		String s=nombre+" vCapacidad="+vCapacidad()+" valor="+valor()+" lo pongo="+pongo()+"//";
		if (vengo!=null && vengo.nombre()>=0)
			s=s+" viene de "+vengo();
		return s;
		}
		
}
