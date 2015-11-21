package gg675;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Stdev {
	double mean;
	double variance;
	double stDEV;
	static DecimalFormat df = new DecimalFormat("#.##");
	BlackScholes BS = new BlackScholes();

	public Stdev(ArrayList<Double> table) {
	
		for (int i =0; i < table.size(); i++){
			System.out.println(table.get(i));
		}
		mean(table);
		variance(table, mean);
		getStd(variance);
		BS.blacky(stDEV, table);

	}

	public void mean(ArrayList<Double> table) {
		double me = 0;
		for (int i = 0; i < table.size(); i++) {
			me = me + (double) table.get(i);
		}
		mean = me / table.size();
		System.out.println("Mean: " + df.format(mean));
	}

	public void variance(ArrayList<Double> table, double MEAN) {
		double var = 0;
		for (int i = 0; i < table.size(); i++) {
			double x = ((double) table.get(i) - MEAN);
			var = var + Math.pow(x, 2);
		}
		variance = var / table.size();
		System.out.println("Variance: " + df.format(variance));
	}

	public double getStd(double var) {
		stDEV = Math.sqrt(var);
		System.out.println("StDev " + df.format(stDEV));
		return stDEV;
	}

}
