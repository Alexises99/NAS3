package Pinguinos;

import java.util.Scanner;

public class Pruebecitasyawey {
	
	static Scanner S = new Scanner(System.in);

	public static void main(String[]args) {
		
		Tablero t1= new Tablero();
		
		Jugadores j1 = new Jugadores("Laura","A");
		Jugadores j2 = new Jugadores("Alex","B");
		
		
		t1.generarTableroAleatorio();
		t1.mostrarTablero();
		t1.setInicioJugador(j1);
		t1.setInicioJugador(j2);
		
		t1.mostrarTablero();
		boolean res = false;
		do {
			System.out.println("");
			System.out.println("");
			System.out.print("Introduce la direccion: ");
			String s = S.next().trim().toUpperCase();
			if(s.equals("ARRIBA")) {
				System.out.print("Introduce el valor de y: ");
				int y = S.nextInt();
				res = t1.finalJ(j1,j2,y,s);
				t1.mostrarTablero();
				
			}
			else if(s.equals("ABAJO")) {
				System.out.print("Introduce el valor de y: ");
				int y = S.nextInt();
				 res =t1.finalJ(j1,j2,y,s);
				t1.mostrarTablero();
			}
			else if(s.equals("DERECHA")) {
				System.out.print("Introduce el valor de x: ");
				int y = S.nextInt();
				res = t1.finalJ(j1,j2,y,s);
				t1.mostrarTablero();
			}
			else if(s.equals("IZQUIERDA")) {
				System.out.print("Introduce el valor de x: ");
				int y = S.nextInt();
				res = t1.finalJ(j1,j2,y,s);
				t1.mostrarTablero();
			}
			System.out.println("");
			System.out.print("Introduce la direccion: ");
			String s1 = S.next().toUpperCase();
			if(s1.equals("ARRIBA")) {
				System.out.print("Introduce el valor de y: ");
				int y = S.nextInt();
				t1.setPosJugador(j2,j1,y,s1);
				t1.mostrarTablero();
			}
			else if(s1.equals("ABAJO")) {
				System.out.print("Introduce el valor de y: ");
				int y = S.nextInt();
				t1.setPosJugador(j2,j1,y,s1);
				t1.mostrarTablero();
			}
			else if(s1.equals("DERECHA")) {
				System.out.print("Introduce el valor de x: ");
				int y = S.nextInt();
				t1.setPosJugador(j2,j1,y,s1);
				t1.mostrarTablero();
			}
			else if(s1.equals("IZQUIERDA")) {
				System.out.print("Introduce el valor de x: ");
				int y = S.nextInt();
				t1.setPosJugador(j2,j1,y,s1);
				t1.mostrarTablero();
			}
		}while(!res);
	}
}
