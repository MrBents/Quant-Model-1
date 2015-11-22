package gg675;

import java.text.DecimalFormat;

public class Arbitrage {
	static DecimalFormat df = new DecimalFormat("#.###");
	
	public void arbi (double strike, double stock, double call, double put){
		double left = stock + put;
		double right = strike + call;
		
		if (left - right < 0){
			System.out.println("No arbitrage");
			System.out.println(df.format(stock) + " " + "+" + " " + df.format(put)+ " " + "=" + " " + df.format(strike) + " " + "+" + " " + df.format(call));
			System.out.println(df.format(left) + " " + "=" + " " + df.format(right));
		}
		
		else if (left - right > 0){
			System.out.println("Arbitrage oportunity");
			System.out.println(df.format(left) + " " + "=" + " " + df.format(right));
		}
		
	}
	
}
