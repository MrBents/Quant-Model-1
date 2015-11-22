package gg675;

import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

	
	ArrayList<Double> table = new ArrayList<Double>();
	static DecimalFormat df = new DecimalFormat("#.##");
	static int numOfRow = 0;
	private Scanner input;

	public void connect(String link) {
		try {

			URL yhoofin = new URL(link);
			URLConnection data = yhoofin.openConnection();
			input = new Scanner(data.getInputStream());
			String line = input.nextLine();
			while (input.hasNextLine()) {
				numOfRow++;
				for (int i = 0; i < numOfRow; i++) {
					line = input.nextLine();
					String[] breakline = line.split("\\,");
					table.add(Double.parseDouble(breakline[4]));

				}
			}
		} catch (Exception e) {

		}

		Stdev ST = new Stdev(table);
	}
}
