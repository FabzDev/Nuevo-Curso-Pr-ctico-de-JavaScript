package edu.fabzdev.others;

public class toString{

    public static void main(String[] args) {
        System.out.println(toInt("2020"));
    }

    public static int toInt(String string){
        int acum=0;
        boolean negative = false;
        for (int i = 0; i < string.length(); i++){
            if(i==0 && string.charAt(i)=='-'){
                negative = true;
                continue;
            }
            int c = string.charAt(i) - '0';
            acum = acum*10 + c;
        }
        return negative?(acum*-1):acum;
    }
}