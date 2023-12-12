package edu.fabzdev.txtFormat;

import java.util.Calendar;
import java.util.Date;

public class DateFormatter0{

	public static Date parseDate(String date){
		
		if(date == null || date.length() == 0)
			return null;

		int cp1 = date.indexOf("/");
		if (cp1 == -1)
			return null;	

		String temp = date.substring(0,cp1);
		int day = Integer.parseInt(temp);

		int cp2 = date.indexOf("/", (cp1+1));
		if (cp2 == -1)
			return null;	


		temp = date.substring((cp1+1),cp2);
		int month = Integer.parseInt(temp);

		temp = date.substring(cp2+1);
		int year = Integer.parseInt(temp);

	
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, day);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	
	
	}


	public static void main(String[] args){
		
	Date date = DateFormatter0.parseDate("13/02/2023");
	System.out.println(date);

	}

}