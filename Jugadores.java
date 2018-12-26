package Pinguinos;

public class Jugadores {

	private String Nombre;
	private int puntuacion;
	private String letra;
	
	public Jugadores() {
		Nombre = "";
		puntuacion = 0;
		letra = "";
	}
	
	public Jugadores(String Nombre, String letra) {
		this.Nombre = Nombre;
		this.puntuacion = 0;
		this.letra = letra;
	}
	
	public String getNombre() {
		return this.Nombre;
	}
	
	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	public String getLetra() {
		return this.letra;
	}
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public void setLetra(String letra) {
		this.letra = letra;
	}
}

