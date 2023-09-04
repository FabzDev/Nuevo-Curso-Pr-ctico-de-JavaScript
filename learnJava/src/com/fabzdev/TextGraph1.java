package com.fabzdev;

public class TextGraph1 {
	private char canvas[][];

	// Constructor
	public TextGraph1(int cols, int rows) {
		canvas = new char[rows][cols];
		clear();
	}

	// Llenar matriz con espacios vacios
	public void clear() {
		for (int row = 0; row < canvas.length; row++) {
			for (int col = 0; col < canvas[row].length; col++) {
				canvas[row][col] = ' ';
			}
		}
	}

	// Imprimir el canvas en consola
	public void printCanvas() {
		for (int row = 0; row < canvas.length; row++) 
			System.out.println(canvas[row]);
		System.out.println();
	}

	// Llenar el canvas con ceros
	public void fillCanvas() {
		for (int row = 0; row < canvas.length; row++) {
			for (int col = 0; col < canvas[row].length; col++) {
				canvas[row][col] = '0';
			}
		}
	}

	// Insertar un caracter "value" en la fila "rowN" y la columna "colN"
	public void setChar(int rowN, int colN, char value) {
		if ((rowN < 0) || (rowN > canvas.length) || (colN < 0) || (colN > canvas[rowN].length)) {
			return;
		}
		canvas[rowN][colN] = value;
	}

	// Dibujar rectangulo
	public void drawSquare(int xi, int yi, int ancho, int alto) {
		for (int row = yi; row < yi + alto -2; row++) {
			setChar(row, xi-1, '|');
			setChar(row, xi-2 + ancho, '|');
		}
		for (int col = xi; col < (xi + ancho -2); col++) {
			setChar(yi-1, col, '-');
			setChar(yi+alto-2, col, '-');
		}
		setChar(yi-1, xi-1, '+');
		setChar(yi-1, xi+ancho-2, '+');
		setChar(yi+alto-2, xi-1, '+');
		setChar(yi+alto-2, xi+ancho-2, '+');

		// for (int row = yi; row <= yi + alto; row++) {
		// if (row == yi || row == yi + alto) {
		// setChar(row, xi, '+');
		// for (int col = xi + 1; col <= xi + ancho - 1; col++) {
		// setChar(row, col, '-');
		// }
		// setChar(row, xi + ancho, '+');
		// } else {
		// for (int col = xi; col <= xi + ancho; col++) {
		// if (col == xi || col == xi + ancho)
		// setChar(row, col, '|');
		// }
		// }
		// }
	}

	// main method (dentro de la clase)
	public static void main(String[] args) {
		TextGraph1 tg1 = new TextGraph1(100, 30);

		tg1.drawSquare(1, 1, 100, 30);
		for(int i=1; i<100; i++){
			double value = (Math.sin(Math.toRadians(2*360/100*i)))*12;
			tg1.setChar((14-(int)value), i, 'x');
		}
		tg1.printCanvas();
	}
}
