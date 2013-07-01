package ch.tkuhn.cougaar.test;

public class Utils {

	private Utils() {}  // no instances allowed

	public static boolean areNear(Locatable l1, Locatable l2) {
		return Math.abs(l1.getPosX() - l2.getPosX()) < 2 && Math.abs(l1.getPosY() - l2.getPosY()) < 2;
	}

}
