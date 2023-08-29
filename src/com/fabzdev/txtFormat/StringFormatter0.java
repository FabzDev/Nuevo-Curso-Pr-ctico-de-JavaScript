package com.fabzdev.txtFormat;

import java.util.StringTokenizer;


public class StringFormatter0{

	public static void main(String[] args) {

        String str = "No cabe duda que la parte más importante de cualquier lenguaje de programación es saber cómo manejar las variables alfanumericas, porque finalmente, cualquier programa realiza una acción para un usuario, y como tal hay que comunicarse, y si no hubiera mensajes de texto, cómo te comunicarías?.";

        StringTokenizer st = new StringTokenizer(str);

        int lineWidth = 40;
        boolean space = false;
        int charCount = 0;
        int totalCount = 0;

        System.out.println();

	for (int i=1; i<=lineWidth; i++){
            if(i%10==0)
		System.out.print(i/10);
		else 
		System.out.print(" ");
	
	}

        System.out.println();

        for (int i=1; i<=lineWidth; i++)
            System.out.print(i % 10);
        System.out.println();

        for (int i=0; i<lineWidth; i++)
            System.out.print("-");
        System.out.println();

        while (st.hasMoreTokens()) {
            String word = st.nextToken() + " ";
            charCount = charCount + word.length();
            if (charCount < lineWidth)
                System.out.print(word);
            else {
                System.out.println();
                System.out.print(word + " ");
                charCount = word.length();
            }
        }

        System.out.println();

    }
}
