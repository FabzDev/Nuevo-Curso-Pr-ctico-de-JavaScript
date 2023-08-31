public class CalendarTxt{

	String calendar = "";

	//Método para llenar arreglos que contienen la información del calendario.
	public void llenarCalendario(){
	Calendar cal = Calendar.getInstance();
		
	int aDay = cal.get(Calendar.DAY_OF_MONTH);
	int aMonth = cal.get(Calendar.MONTH + 1);
	int aYear = cal.get(Calendar.YEAR);
	int nDays = nDiasMes(aMonth);
	int nCDays = 0;	

	String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", 				"Noviembre", "Diciembre");
	
	String fBasica = "+-----+-----+-----+-----+-----+-----+-----+"; 
	String fMes = meses[aMonth] + " " + aYear; 			
	String fDias = "| Dom | Lun | Mar | Mie | Jue | Vie | Sab |";	
	int acum=0;							
	int acum2=0;							
	
	Calendar calDay1 = getInstance();
	calDay1.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);

	
	//Definiendo el tamaño del calendario
	if (calDay1.get(Calendar.DAY_OF_WEEK) == 6 && diasMes() == 31 || 						 	calDay1.get(Calendar.DAY_OF_WEEK) == 7 && diasMes(aMonth+1)==30)
		nCDays=42;
	else 
		nCDays=35;
	
	int[] days = new int[nDiasMes(aMonth);
	int[] cdays = new int[nCDays];

	 for (int i : days){
   	     days[acum] = acum+1;
   	     acum++;
	}

	 for (int c : cdays){
   	     cdays[acum2] = ' ';
   	     acum2++;
	}


	for(int i=0; i<nCDays; i++){
		if(i!=0 && i%7 == 0)
			calendar = calendar +"|\n";
		calendar = calendar + "|  " + cdays[0] + "  ";
		}
		calendar = calendar + "|";
	}
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
	                Date anioActual=new Date();
	                if(esBisiesto(1900 + anioActual.getYear())){
        	            numeroDias=29;
                	}else{
	                    numeroDias=28;
        	        }
                	break;
        	}

	    return numeroDias;
	}


	//Método main
	public static void main(String[] args){
	
	CalendarTxt calTxt = new CalendarTxt();
	
	
	
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
