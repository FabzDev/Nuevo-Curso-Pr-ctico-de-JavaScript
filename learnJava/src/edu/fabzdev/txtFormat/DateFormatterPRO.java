package edu.fabzdev.txtFormat;

import java.util.Calendar;
import java.util.Date;

public class DateFormatterPRO {

	static int[] d = { 0, 0 };
	static int[] m = { 0, 0 };
	static int[] y = { 0, 0, 0, 0 };
	static String sDay = "";
	static String sMonth = "";
	static String sYear = "";
	static int day;
	static int month;
	static int year;

	public static Date parseDate(String date, String format) {
		for (int i = 0; i < format.length() - 1; i++) {

			char x = format.charAt(i);
			char x2 = format.charAt(i + 1);
			boolean evYear = false;

			if (x == 'd' && x2 == 'd') {
				d[0] = i;
				d[1] = i + 1;
			}

			if (x == 'm' && x2 == 'm') {
				m[0] = i;
				m[1] = i + 1;
			}

			if (x == 'y' && x2 == 'y' && !evYear) {
				boolean y4 = (i + 3 < format.length()) ? true : false;
				if (y4) {
					if (format.charAt(i + 2) == 'y' && format.charAt(i + 3) == 'y') {
						y[0] = i;
						y[1] = i + 1;
						y[2] = i + 2;
						y[3] = i + 3;
					} else {
						y[2] = i;
						y[3] = i + 1;
					}
				} else {
					y[2] = i;
					y[3] = i + 1;
				}
			}
		}

		// metodo obtener dia
		for (int i : d) {
			sDay = sDay + date.charAt(i);
		}
		day = Integer.parseInt(sDay);

		// metodo obtener mes
		for (int i : m) {
			sMonth = sMonth + date.charAt(i);
		}
		month = Integer.parseInt(sMonth);

		// metodo obtener year
		if (y[0] == 0 && y[1] == 0) {
			for (int k = 2; k < 4; k++) {
				int value = y[k];
				sYear = sYear + date.charAt(value);
			}
		} else {
			for (int j : y) {
				sYear = sYear + date.charAt(j);
			}
		}
		year = Integer.parseInt(sYear);

		// Obtener fecha
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, day);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();

	}

	public static void main(String[] args) {

		Date date = DateFormatterPRO.parseDate("23.02.13", "yy-mm-dd");
		System.out.println("d = " + date);

	}

}