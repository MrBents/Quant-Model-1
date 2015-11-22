package gg675;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BlackScholes {

	static DecimalFormat df = new DecimalFormat("#.###");
	ArrayList<Double> table = new ArrayList<Double>();
	Arbitrage ar = new Arbitrage();
	int days;
	double std;
	double T;
	double r;
	double v;
	double S;
	double X;

	public void blacky(double stdev, ArrayList tble) {

		std = stdev;
		this.table = tble;
		days = table.size();
		T = (days / 365.0);
		r = 0.0008;
		S = (double) table.get(0);
		v = std / S;
		X = S + (std / 2);
		for (int i = 0; i < table.size(); i++) {
			int temp = table.size() - i;
			S = (double) table.get(temp - 1);

			T = (days-- / 365.0);
			
			ar.arbi(X, S, callPrice(), putPrice());
			//System.out.println("Call Price: " + df.format(callPrice()));
			//System.out.println("Put Price: " + df.format(putPrice()));
			//System.out.println("Strike Price " + df.format(X));
			//System.out.println("Stock Price " + df.format(S));
		}

	}

	/*
	 * S = stock price X = exercise price r = risk free interest rate T = time
	 * to expiration v = standard deviation of log returns
	 */
	public double callPrice() {

		double d1, d2;
		d1 = (Math.log(S / X) + ((r + Math.pow(v, 2) / 2) * T))
				/ (v * Math.sqrt(T));
		d2 = (Math.log(S / X) + ((r - Math.pow(v, 2) / 2) * T))
				/ (v * Math.sqrt(T));

		return (S * cum(d1) - X * Math.exp(-r * T) * cum(d2));

	}

	public double putPrice() {

		double d1, d2;
		d1 = (Math.log(S / X) + ((r + Math.pow(v, 2) / 2) * T))
				/ (v * Math.sqrt(T));
		d2 = (Math.log(S / X) + ((r - Math.pow(v, 2) / 2) * T))
				/ (v * Math.sqrt(T));
		return (X * Math.exp(-r * T) * cum(-d2) - S * cum(-d1));

	}

	public double cum(double data) {
		double L, K, w;
		double a1 = 0.31938153, a2 = -0.356563782, a3 = 1.781477937, a4 = -1.821255978, a5 = 1.330274429;

		L = Math.abs(data);
		K = 1.0 / (1.0 + 0.2316419 * L);
		w = 1.0
				- 1.0
				/ Math.sqrt(2.0 * Math.PI)
				* Math.exp(-L * L / 2)
				* (a1 * K + a2 * K * K + a3 * Math.pow(K, 3) + a4
						* Math.pow(K, 4) + a5 * Math.pow(K, 5));

		if (data < 0.0) {
			w = 1.0 - w;
		}
		return w;
	}

}
