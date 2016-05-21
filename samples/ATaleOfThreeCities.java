import java.lang.Math;

public class ATaleOfThreeCities {
	public double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy) {
		double shortest1 = connections(ax, ay, bx, by);
		double shortest2 = connections(ax, ay, cx, cy);
		double shortest3 = connections(bx, by, cx, cy);

		double shortest = 0;
		if( shortest1 < shortest2 ) {
			shortest += shortest1;
			shortest += shortest2 < shortest3 ? shortest2 : shortest3;
		} else {
			shortest += shortest2;
			shortest += shortest1 < shortest3 ? shortest1 : shortest3;
		}

		return shortest;
	}

	private double connections(int[] x1, int[] y1, int[] x2, int[] y2) {
		double shortest = Double.MAX_VALUE;

		for( int i = 0; i < x1.length; i++ ) {
			for( int j = 0; j < x2.length; j++ ) {
				double a = Math.pow((x1[i] - x2[j]), 2);
				double b = Math.pow((y1[i] - y2[j]), 2);

				double c = Math.sqrt(a + b);

				shortest = c < shortest ? c : shortest;
			}
		}

		return shortest;
	}
}