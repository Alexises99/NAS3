package Pinguinos;

import java.util.Scanner;

public class Tablero {

static Scanner S = new Scanner(System.in);

public static final int max = 8;



private String Tabla[][];

	public Tablero() {
		Tabla = new String [max][max];
	}

	public int generaNumero(int max,int min) {
		int numero = (int)(Math.random()*(max-min+min)+min);
		return numero;
	}
	
	public void  generarTableroAleatorio() {
		
		int contador = 0;
		int contador2 = 0;
		int contador3 = 0;
			
		for(int i = 0; i < 8; i++) {
			
			System.out.println("");
			
			for(int j = 0; j < 8; j++) {
		
				int numero = generaNumero(3,1);
				
				if(numero == 1) {
					if(contador < 21) {
						contador++;
						Tabla[i][j] = "1";
					}
					
					else if(contador2 <21) {
						contador2++;
						Tabla[i][j] = "2";
					}
					
					else if(contador3 < 22) {
						contador3++;
						Tabla[i][j] = "3";
					}
				}
				
				else if(numero == 2) {
					if(contador2 < 21) {
						contador2++;
						Tabla[i][j] = "2";
					}
					
					else if(contador < 21) {
						contador++;
						Tabla[i][j] = "1";
					}
					
					else if(contador3 < 22) {
						contador3++;
						Tabla[i][j] = "3";
					}
					
				}
				
				else if(numero == 3) {
					if(contador3 < 22) {
						contador3++;
						Tabla[i][j] = "3";
						}
						
					else if(contador < 21) {
						contador++;
						Tabla[i][j] = "1";
						}
						
					else if(contador2 < 21) {
						contador2++;
						Tabla[i][j] = "2";
						}
				}
				
			}
		
		}
	}
	
	public void mostrarTablero(){
		System.out.println("");
		for(int i = 0; i < 8; i++) {
			System.out.println("");
			for(int j = 0; j < 8; j++) {
				System.out.print(Tabla[i][j] + "  ");
			}
		}
	}
	
	public void setInicioJugador(Jugadores j1) {
		boolean res = false;
		j1 = new Jugadores(j1.getNombre(),j1.getLetra());
		int x = 0, y = 0;
		while(!res) {
			x = generaNumero(7,0);
			y = generaNumero(7,0);
			if(Tabla[x][y] == "1"){
				Tabla[x][y] = j1.getLetra();
				j1.setPuntuacion(1);
				res = true;
				
			}
			else {
				res = false;
			}

		}
	}
	
	public void quitarCasilla(Jugadores j1){
		int  getPos[] = new int [2];
		getPos = getPosJugador(j1);
		this.Tabla[getPos[0]][getPos[1]] = "0" ;
	}
	
	public void setPosJugador(Jugadores j1,Jugadores j2,int y,String direccion) {
		int getPosJ[] = getPosJugador(j1);
		int xj1 = getPosJ[1];
		int yj1 = getPosJ[0];
		
		if(direccion.equals("ARRIBA")) {
		int res = ComprobarMovArriba(j1,j2,y);
		quitarCasilla(j1);
		if(Tabla[res][xj1] == "1") {
			j1.setPuntuacion(1+j1.getPuntuacion());
		}
		if(Tabla[res][xj1] == "2") {
			j1.setPuntuacion(2+j1.getPuntuacion());
		}
		
		if(Tabla[res][xj1] == "3") {
			j1.setPuntuacion(3+j1.getPuntuacion());
		}
		Tabla[res][xj1] = j1.getLetra();
		}
		
		
		if(direccion.equals("ABAJO")) {
		int res = ComprobarMovAbajo(j1,j2,y);
		quitarCasilla(j1);
		
		if(Tabla[res][xj1] == "1") {
			j1.setPuntuacion(1+j1.getPuntuacion());
		}
		if(Tabla[res][xj1] == "2") {
			j1.setPuntuacion(2+j1.getPuntuacion());
		}
		
		if(Tabla[res][xj1] == "3") {
			j1.setPuntuacion(3+j1.getPuntuacion());
		}
		Tabla[res][xj1] = j1.getLetra();
		}
		
		if(direccion.equals("DERECHA")) {
		int res = ComprobarMovDerecha(j1,j2,y);
		quitarCasilla(j1);
		
		if(Tabla[yj1][res] == "1") {
			j1.setPuntuacion(1+j1.getPuntuacion());
		}
		if(Tabla[yj1][res] == "2") {
			j1.setPuntuacion(2+j1.getPuntuacion());
		}
		
		if(Tabla[yj1][res] == "3") {
			j1.setPuntuacion(3+j1.getPuntuacion());
		}
		Tabla[yj1][res] = j1.getLetra();
		}
		
		if(direccion.equals("IZQUIERDA")) {
		int res = ComprobarMovIzquierda(j1,j2,y);
		quitarCasilla(j1);
		if(Tabla[yj1][res] == "1") {
			j1.setPuntuacion(1+j1.getPuntuacion());
		}
		if(Tabla[yj1][res] == "2") {
			j1.setPuntuacion(2+j1.getPuntuacion());
		}
		
		if(Tabla[yj1][res] == "3") {
			j1.setPuntuacion(3+j1.getPuntuacion());
		}
		Tabla[yj1][res] = j1.getLetra();
		}
		
		
		
	}
	
	public int[]getPosJugador(Jugadores j1) {
		int x, y;
		int  getPos[] = new int [2];
		boolean res = false;
		while(!res){
		for(int i = 0; i < 8 && res == false; i++) {
			for(int j = 0; j <  8 && res == false; j++) {
				if(Tabla[i][j] == j1.getLetra()) {
					x = i;
					y = j;
					getPos[0] = x;
					getPos[1] = y;
					res = true;
				}
			}
		}
		}
		return getPos;
	}
	
	public void mostrarpos(Jugadores j1) {
		System.out.println("");
		System.out.println("");
		int lastPos[] = new int [2];
		lastPos = getPosJugador(j1);
		for(int i = 1 ; i  >= 0;i--) {
				System.out.print(lastPos[i] +"  ");
		}
	}
		
	
	public int FinPartida() {
		int contador = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(Tabla[i][j] == "0") {
					contador++;
				}
			}
		}
		return contador;
	}
	
	public int ComprobarMovArriba(Jugadores j1,Jugadores j2,int y) {
		int getPosJ[] = getPosJugador(j1);
		int getPosOtro[] = getPosJugador(j2);
		int posj1 = getPosJ[0];
		int posj2 = getPosOtro[0];
		int y1 = y;
		int xposj1 = getPosJ[1];
		int xposj2 = getPosOtro[1];
		boolean res = true;
		
		for(int i = posj1-1; i >= 0 && res == true; i--) {
			if(Tabla[i][xposj1] ==  "0") {
			y1 = i+1;
			res = false;
		}
		}
		
		if(xposj1 == xposj2) {
			if(posj1 < posj2) {
				if(y1 >= 0) {
				y1 = y1;
			}
			else {
				y1 = 0;
			}
		}
		
		else
			if(posj1 > posj2) {
			if(y1 <= posj2) {
				y1 = posj2+1;
			}
		
		}
		}
		else {
			if(y1 >= 0) {
				y1 = y1;
			}
			else {
				y1 = 0;
			}
		}

		return y1;
}
	
	public int ComprobarMovAbajo(Jugadores j1,Jugadores j2,int y) {
		int getPosJ[] = getPosJugador(j1);
		int getPosOtro[] = getPosJugador(j2);
		int posj1 = getPosJ[0];
		int posj2 = getPosOtro[0];
		int y1 = y;
		int xposj1 = getPosJ[1];
		int xposj2 = getPosOtro[1];
		boolean res = true;

		for(int i = posj1+1; i < 8 && res == true; i++) {
			if(Tabla[i][xposj1] ==  "0") {
			y1 = i-1;
			res = false;
			}
		}
		
		if(xposj1 == xposj2) {
			if(posj1 > posj2) {
				if(y1 < 8) {
				y1 = y1;
			}
			else {
				y1 = 7;
			}
		}
		
		else if(posj1 < posj2) {
			if(y1 >= posj2) {
				y1 = posj2-1;
			}
			}
		}
		else {
			if(y1 < 8) {
				y1 = y1;
			}
			else {
				y1 = 7;
			}
		}

		return y1;
}
	public int ComprobarMovDerecha(Jugadores j1,Jugadores j2,int y) {
		int getPosJ[] = getPosJugador(j1);
		int getPosOtro[] = getPosJugador(j2);
		int posj1 = getPosJ[0];
		int posj2 = getPosOtro[0];
		int y1 = y;
		int xposj1 = getPosJ[1];
		int xposj2 = getPosOtro[1];
		boolean res = true;

		for(int i = xposj1+1; i <= 7 && res == true; i++) {
			if(Tabla[posj1][i] ==  "0") {
			y1 = i-1;
			res = false;
			}
		}
		
		if(xposj1 == xposj2) {
			if(posj1 > posj2) {
				if(y1 < 8) {
				y1 = y1;
			}
			else {
				y1 = 7;
			}
		}
		
		else if(posj1 < posj2) {
			if(y1 >= posj2) {
				y1 = posj2-1;
			}
		
		}
		}
		else {
			if(y1 < 8) {
				y1 = y1;
			}
			else {
				y1 = 7;
			}

			
		}

		return y1;
}
	
	public int ComprobarMovIzquierda(Jugadores j1,Jugadores j2,int y) {
		int getPosJ[] = getPosJugador(j1);
		int getPosOtro[] = getPosJugador(j2);
		int posj1 = getPosJ[0];
		int posj2 = getPosOtro[0];
		int y1 = y;
		int xposj1 = getPosJ[1];
		int xposj2 = getPosOtro[1];
		boolean res = true;
		
		for(int i = xposj1-1; i >= 0 && res == true; i--) {
			if(Tabla[posj1][i] ==  "0") {
			y1 = i+1;
			res = false;
			}
		}
		
		if(xposj1 == xposj2) {
			if(posj1 < posj2) {
				if(y1 >= 0) {
				y1 = y1;
			}
			else {
				y1 = 0;
			}
		}
		
		else if(posj1 > posj2) {
			if(y1 <= posj2) {
				y1 = posj2+1;
			}
		
		}
		}
		else {
			if(y1 >= 0) {
				y1 = y1;
			}
			else {
				y1 = 0;
			}
		}

		return y1;
}
}

	

	
		
	



