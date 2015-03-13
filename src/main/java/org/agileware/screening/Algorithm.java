package org.agileware.screening;

public class Algorithm {

	/**
	 * Finds the first occurrence of the search array sequence within the
	 * collection array.
	 * 
	 * @param search
	 *            the sequence of elements to match
	 * @param collection
	 *            the array against which the search is performed
	 * @return the index within the collection array where the matching sequence
	 *         starts or <code>-1</code> if no match occurred
	 */
	public static long indexOf(Object[] search, Object[] collection) {
		for (int i = 0; i < collection.length; i++) {
			boolean found = true;
			for (int j = 0; j < search.length; j++) {
				if ((search[j] == null && collection[j + i] != null) || !search[j].equals(collection[j + i])) {
					found = false;
					break;
				}
			}
			if (found) {
				return i;
			}
		}
		return -1;
	}

}
