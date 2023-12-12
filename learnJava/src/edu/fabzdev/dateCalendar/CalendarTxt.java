package edu.fabzdev.dateCalendar;

import java.util.Calendar;

public class CalendarTxt{

	String calendar = "";

	//Método para llenar arreglos que contienen la información del calendario.
	public void llenarCalendario(){
		Calendar cal = Calendar.getInstance();
		
		//INSERTA LA FECHA DESEADA
		//cal.set(Calendar.DAY_OF_MONTH, 12);
		//cal.set(Calendar.MONTH, 10);
		//cal.set(Calendar.YEAR, 2019);
		
		int aDay = cal.get(Calendar.DAY_OF_MONTH);
		int aMonth = cal.get(Calendar.MONTH)+1;
		int aYear = cal.get(Calendar.YEAR);
		
		int nDays = diasMes(aMonth);
		int nCDays = 0;	

		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", 				"Noviembre", "Diciembre"};
	
		String fBasica = "+------+------+------+------+------+------+------+"; 
		String sFMes = meses[aMonth-1] + " " + aYear;
		String fMes = "";
		String fDias = "| Dom  | Lun  | Mar  | Mie  | Jue  | Vie  | Sab  |";	
		int acum=0;						
		int acum2=0;							
	
		Calendar calDay1 = Calendar.getInstance();
		calDay1.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);

		//Creando fMes definitiva
		for(int i=0; i < fBasica.length(); i++){
			if(i==0 || i==(fBasica.length()-1)){
				fMes= fMes + "|";
			} else if (i == (fBasica.length()/2 - sFMes.length()/2)){
				fMes= fMes + sFMes;
				i = i + (sFMes.length()-1);
			} else {  
				fMes= fMes + " ";
			}
		}
	
		//Definiendo el tamaño del calendario
		int primerDia = calDay1.get(Calendar.DAY_OF_WEEK);
		if (primerDia == 6 && nDays == 31 || primerDia == 7 && nDays==30)
			nCDays=42;
		else 
			nCDays=35;
	
		
		String[] cdays = new String[nCDays];

		
		

		for (int j = 0; j < nCDays; j++){
		
			if(j > (nDays - 1) + (primerDia - 1) || j < primerDia -1)
				cdays[j] = "  ";
			else if ((j - primerDia + 1) < 9)
				cdays[j] = "0" + (j - primerDia +2);
	   	     	else
				cdays[j] = "" + (j - primerDia +2);
		}

		
		//Creando string del calendario
		calendar = fBasica + "\n" + fMes + "\n" + fBasica+ "\n" + fDias + "\n"+ fBasica+ "\n";
		for(int i=0; i<nCDays; i++){
			if(i!=0 && i%7 == 0)
				calendar = calendar +"|\n";
			if(i == aDay -1 + primerDia -1)
				calendar = calendar + "| [" + cdays[i] + "] ";
			else
				calendar = calendar + "|  " + cdays[i] + "  ";
			}
		calendar = calendar + "|" + "\n" + fBasica + "\n";

		System.out.print(calendar);
	
	}


	//Método para obtener el número de dias que tiene un mes
	public static int diasMes(int mes){
	    int numeroDias=-1;
        	switch(mes){
	            case 1:
        	    case 3:
	            case 5:
	            case 7:
        	    case 8:
	            case 10:
        	    case 12:
	                numeroDias=31;
        	        break;
	            case 4:
        	    case 6:
   	            case 9:
        	    case 11:
	                numeroDias=30;
        	        break;
	            case 2:
	                numeroDias=28;
        	        break;
        	}

	    return numeroDias;
	}


	//Método main
	public static void main(String[] args){
	
		CalendarTxt calTxt = new CalendarTxt();
		calTxt.llenarCalendario();
	
	}

}


/*
+-----+-----+-----+-----+-----+-----+-----+
|             Agosto 2023                 |
+-----+-----+-----+-----+-----+-----+-----+
| Dom | Lun | Mar | Mie | Jue | Vie | Sab |
+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |     |     |     |
|     |     |     |     |     |     |     |
|     |     |     |     |     |     |     |
|     |     |     |     |     |     |     |
|     |     |     |     |     |     |     |
|     |     |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+
*/
