package com.fabzdev.txtFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class StringFormatter1 {

    static int lineWidth = 50;

    static String str = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no hace mucho tiempo "
            + "que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y "
            + "galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, "
            + "duelos y quebrantos los sábados, lantejas los viernes, algún palomino de añadidura "
            + "los domingos, consumían las tres cuartas partes de su hacienda. El resto della "
            + "concluían sayo de velarte, calzas de velludo para las fiestas, con sus pantuflos "
            + "de lo mesmo, y los días de entresemana se honraba con su vellorí de lo más fino. "
            + "Tenía en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba "
            + "a los veinte, y un mozo de campo y plaza, que así ensillaba el rocín como tomaba "
            + "la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta años; era de "
            + "complexión recia, seco de carnes, enjuto de rostro, gran madrugador y amigo de "
            + "la caza. Quieren decir que tenía el sobrenombre de Quijada, o Quesada, que en "
            + "esto hay alguna diferencia en los autores que deste caso escriben; aunque, por "
            + "conjeturas verosímiles, se deja entender que se llamaba Quejana. Pero esto importa "
            + "poco a nuestro cuento; basta que en la narración dél no se salga un punto de la "
            + "verdad.";

    public static void dibujarRegla() {

        // dibjujando reglilla: decenas
        for (int i = 1; i <= lineWidth; i++) {
            if (i % 10 == 0) {
                System.out.print(i / 10);
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();

        // dibjujando reglilla: unidades
        for (int i = 1; i <= lineWidth; i++) {
            System.out.print(i % 10);
        }
        System.out.println();

        // dibjujando reglilla: linea separadora
        for (int i = 0; i < lineWidth; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double cantCols = 2;
        double conteoFilas = 0;

        StringTokenizer st = new StringTokenizer(str);

        int charCount = 0;
        StringBuilder line = new StringBuilder();
        List lines = new ArrayList();

        dibujarRegla();

        while (st.hasMoreTokens()) {
            String word = st.nextToken() + " ";
            charCount += word.length();

            if (charCount < lineWidth) {
                line.append(word);
                if (!st.hasMoreTokens()) {
                    lines.add(line.toString());
                    conteoFilas++;
                }
            } else {
                for (int i = line.length(); i <= lineWidth; i++) {
                    line.append(" ");
                }
                lines.add(line.toString());
                line.setLength(0);
                line.append(word);
                charCount = word.length();
                conteoFilas++;
            }

        }
    
        int n = (int) Math.ceil(conteoFilas / cantCols);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cantCols; j++) {
                if(i + (j*n) < lines.size()){
                System.out.print(lines.get(i + (j*n)));
                System.out.print("    ");
                }
            }
            System.out.println();
        }

    }
}
