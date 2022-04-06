package com.cg.exception;
/**
 * 
 * @author Aniket
 *
 */
public class CourseNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param message
	 */

	public CourseNotFoundException(final String message) {
		super(message);
	}

}
