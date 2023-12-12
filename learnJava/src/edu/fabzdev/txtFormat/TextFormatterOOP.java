package edu.fabzdev.txtFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TextFormatterOOP {

    int lineWidth;
    int columns;

    double conteoFilas = 0;
    List<String> lines = new ArrayList<>();
    List<String> linesFormatted = new ArrayList<>();

    public TextFormatterOOP(String str, int lineWidth, int columns, boolean format) {

        setFormat(lineWidth, columns);
        drawRule();
        formatText(str, format);
    }

    public void setFormat(int lineWidth, int columns) {
        this.lineWidth = lineWidth;
        this.columns = columns;
    }

    public void formatText(String str, boolean format) {
        StringTokenizer st = new StringTokenizer(str);
        int charCount = 0;
        StringBuilder line = new StringBuilder();
        boolean space = false;

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            charCount += word.length();

            if (charCount < lineWidth) {
                if (space) {
                    line.append(" ");
                    charCount++;
                }
                line.append(word);
                space = true;
                if (!st.hasMoreTokens()) {
                    lines.add(line.toString());
                    conteoFilas++;
                }
            } else {
                lines.add(line.toString());
                line.setLength(0);
                line.append(word);
                charCount = word.length();
                conteoFilas++;
            }
        }

        if (format) {
            justifyText();
            printText(linesFormatted);
        } else {
            printText(lines);
        }
    }

    public void justifyText() {
        for (String s : lines) {
            StringBuilder sb = new StringBuilder();

            sb.append(s);

            // para una fila
            int separadores = 0;

            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ' ') {
                    separadores++;
                }
            }

            int espaciosTotales = lineWidth - sb.length() + separadores;
            int mod = espaciosTotales % separadores;
            int espacio1 = espaciosTotales / separadores;
            int espacio2 = mod + (separadores - 1) / separadores;
            int pos = 0;

            for (int i = 0; i < separadores; i++) {
                pos = sb.indexOf(" ", pos);

                int espacioF = mod > espacio2 ? espacio2 : mod;
                mod -= espacioF;
                int espaciosI = espacio1 + espacioF - 1;

                for (int j = 0; j < espaciosI; j++) {
                    sb.insert(pos, " ");
                }
                pos += espaciosI + 1;
            }
            linesFormatted.add(sb.toString());
        }

    }

    public void drawRule() {
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

    public void printText(List lines) {
        int renglones = (int) Math.ceil(conteoFilas / columns);
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columns; j++) {
                if (i + (j * renglones) < lines.size()) {
                    String l = (String) lines.get(i + (j * renglones));
                    int espacios = lineWidth - l.length();
                    System.out.print(l);
                    for (int k = 0; k < espacios; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no hace mucho tiempo "
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

        int columns = 5;
        int lineWidth = 22;
        boolean format = true;

        TextFormatterOOP formatter = new TextFormatterOOP(str, lineWidth, columns, format);
    }
}
