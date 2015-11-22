package gg675;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Skelleton {

	GregorianCalendar end = new GregorianCalendar(2015, 10, 9);
	GregorianCalendar start = new GregorianCalendar(2015, 7, 10);
	Data data = new Data();
	String Url;

	public Skelleton(String symbol) {

		String url = "http://real-chart.finance.yahoo.com/table.csv?s="
				+ symbol + "&d=" + end.get(Calendar.MONTH) + "&e="
				+ end.get(Calendar.DAY_OF_MONTH) + "&f="
				+ end.get(Calendar.YEAR) + "&g=d" + "&a="
				+ start.get(Calendar.MONTH) + "&b="
				+ start.get(Calendar.DAY_OF_MONTH) + "&c="
				+ start.get(Calendar.YEAR) + "&ignore=.csv";

		Url = url;
		data.connect(Url);

	}

}
