public class Square extends Shapes {
	public Square(double x, double y, double r) {
		super(x,y,r);
	}	

	// Customize the println response string
	public String toString() {
		return String.format("Square at (%.2f,%.2f) with radius %.2f.  %.2f from origin.", x, y, r, getDistFromCtr());
	}
}
