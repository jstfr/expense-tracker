package com.nemo.expense_tracker.exception;

public abstract class CategoryExceptionHandler extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6000298436409182971L;

	public CategoryExceptionHandler(String message) {
		super(message);
	}
	
	// Thrown when category not found
    public static class NotFound extends CategoryExceptionHandler {
        /**
		 * 
		 */
		private static final long serialVersionUID = 4908237234345360135L;

		public NotFound(String message) {
            super(message);
        }
    }

    // Thrown when category name already exists
    public static class AlreadyExists extends CategoryExceptionHandler {
        /**
		 * 
		 */
		private static final long serialVersionUID = 3809936016444721618L;

		public AlreadyExists(String message) {
            super(message);
        }
    }
}
