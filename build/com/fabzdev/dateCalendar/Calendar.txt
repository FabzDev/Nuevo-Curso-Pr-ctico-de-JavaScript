public class Calendar{
	
	int width=43;
	
	//Margen superior
	String fBasica = "+-----+-----+-----+-----+-----+-----+-----+";
	String fMes = "Agosto 2023";
	String fDias = "| Dom | Lun | Mar | Mie | Jue | Vie | Sab |";
	int acum;
	int acum2;

	int[] days = new int[31];
	 for (int i : days){
   	     days[acum] = acum+1;
   	     acum++;
	}

	char[] cdays = new char[42];
	 for (int c : cdays){
   	     cdays[acum2] = ' ';
   	     acum2++;
	}
	
	
	String calendar = "";


// int ndias = 0;

if (first_dayOF_Week = viernes && first_dayOF_Month = 31 ||
    first_dayOF_Week = sabado && first_dayOF_Month = 30)
	
	n=42;
else 
	n=35;

// definir tamaño de calendario
if ((primer_dia_mes  == viernes || primer_dia_mes  == sabado) 
	n=42;
else
	n=35;

//Dibujar calendario
for(int i=0; i<ndias; i++){
	if(i!=0 && i%7 == 0)
		calendar = calendar +"|\n";
	calendar = calendar + "|  " + cdays[0] + "  ";
	}
calendar = calendar + "|";


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
