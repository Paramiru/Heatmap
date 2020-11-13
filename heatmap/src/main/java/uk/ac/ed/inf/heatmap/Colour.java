package uk.ac.ed.inf.heatmap;

public class Colour {
	
	/**
	 * Control flow with else if to determine
	 * in which range the double is found.
	 * 
	 * @param n double
	 * @return corresponding colour as a String 
	 */
	public static String get_colour(double n) {
		if (n < 0 || n >= 256) return null;
		if (n < 32) {
			return "#00ff00";
		} else if (n < 64) {
			return "#40ff00";
		} else if (n < 96) {
			return "#80ff00";
		} else if (n < 128) {
			return "#c0ff00";
		} else if (n < 160) {
			return "#ffc000";
		} else if (n < 192) {
			return "#ff8000";
		} else if (n < 224) {
			return "#ff4000";
		} else {
			return "#ff0000";
		}
	}
}
