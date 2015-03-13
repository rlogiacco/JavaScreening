package org.agileware.screening;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Implement a class that given two arrays, will find the starting position of
 * the second array in the first array. i.e. [2,3,4,5] and [4,5] should return
 * 2. Explain your solution. Write some tests for this. Leave solution in your
 * GitHub/BitBucket account (public repo). Provide link.
 * 
 * @author rlogiacco
 *
 */
public class AlgorithmTest {

	private Integer[] integers = new Integer[] { 2, 3, 4, 5 };
	private String[] strings = new String[] { "local", "foo", "bar", "exist" };

	@Test
	public void testMatchFound() {
		long index = Algorithm.indexOf(new Integer[] { 4, 5 }, integers);
		assertEquals(2, index);
	}

	@Test
	public void testNoMatchFound() {
		long index = Algorithm.indexOf(new Integer[] { 0 }, integers);
		assertEquals(-1, index);
	}

	@Test
	public void testEmptyMatchFound() {
		long index = Algorithm.indexOf(new Integer[] {}, integers);
		assertEquals(0, index);
	}

	@Test
	public void testStringMatchFound() {
		long index = Algorithm.indexOf(new String[] { "foo", "bar" }, strings);
		assertEquals(1, index);
	}

	@Test
	public void testStringNoMatchFound() {
		long index = Algorithm.indexOf(new String[] { "non exisistent" },
				strings);
		assertEquals(-1, index);
	}

	@Test
	public void testStringEmptyMatchFound() {
		long index = Algorithm.indexOf(new String[] {}, strings);
		assertEquals(0, index);
	}

	@Test
	public void testNullStringMatchFound() {
		long index = Algorithm.indexOf(new String[] { "foo", null }, strings);
		assertEquals(-1, index);
	}

}
