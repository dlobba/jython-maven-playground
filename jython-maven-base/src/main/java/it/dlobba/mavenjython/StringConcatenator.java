package it.dlobba.mavenjython;

import java.util.ArrayList;

/**
 * Concat a variable number of strings.
 * 
 * @author Diego Lobba
 */
public class StringConcatenator {

	public StringConcatenator() {
	}

	public String concat(Object... objects) {
		ArrayList<String> stringObjects = new ArrayList<>();

		for (Object obj : objects) {
			if (obj instanceof String) {
				stringObjects.add((String) obj);
			} else if (obj instanceof Number) {
				stringObjects.add(((Number) obj).toString());
			} else {
				stringObjects.add(obj.toString());
			}
		}
		return String.join(", ", stringObjects);
	}
}
