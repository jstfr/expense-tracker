package com.nemo.expense_tracker.exception;

public class ExpenseExceptionHandler extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3655131261898903766L;

	public ExpenseExceptionHandler(String message) {
		super(message);
	}

	// Thrown when expense not found
	public static class NotFound extends ExpenseExceptionHandler {
		/**
		 * 
		 */
		private static final long serialVersionUID = -7399531010052550385L;

		public NotFound(String message) {
			super(message);
		}
	}

}
