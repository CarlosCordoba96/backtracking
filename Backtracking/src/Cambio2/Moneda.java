package Cambio2;

import java.util.Queue;

public class Moneda {
	private int nombre;
	private int cantidad;
	private int valor;
	private int numero;
	private Moneda vengo;
	
	public Moneda(int n,int c,int v,int num, Moneda mo){
		nombre=n;
		cantidad=c;
		valor=v;
		vengo=mo;
		numero=num;
	}
	public int getNombre() {
		return nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public Moneda getvengo() {
		return vengo;
	}
	public void setvengo(Moneda vengo) {
		this.vengo = vengo;
	}
	public Moneda  vengo() {
		// TODO Auto-generated method stub
		return vengo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int contarmonedas(){
		int num=0;
		if(vengo!=null){
			num= numero+vengo.contarmonedas();
		}else{
			if(numero==Integer.MAX_VALUE){
				num=0;
			}else{
				num= numero;
			}
			
		}
		return num;
	}
	@Override
	public String toString() {
		return "Moneda [nombre=" + nombre + ", cantidad=" + cantidad + ", valor=" + valor + ", numero=" + numero
				+ ", vengo="+vengo ;
	}

}
