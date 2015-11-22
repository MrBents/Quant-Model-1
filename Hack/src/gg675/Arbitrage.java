package gg675;

public class Arbitrage {

	
	public void arbi (double strike, double stock, double call, double put){
		double left = stock + put;
		double right = (strike + (strike * 0.0011)) + call;
		
		if (left / right == 1){
			System.out.println("No arbitrage");
		}
		
		else if (left / right != 1){
			System.out.println("Arbitrage oportunity");
			System.out.println(left - right);
		}
		
	}
	
}
