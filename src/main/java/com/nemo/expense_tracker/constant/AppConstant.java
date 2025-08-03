package com.nemo.expense_tracker.constant;

public class AppConstant {
	
	//API Path
	public static final String EXPENSE_BASE_PATH = "/api/expenses";
	public static final String CATEGORY_BASE_PATH = "/api/categories";
	
	
	//Formats, Validation and etc....
	public static final String EXPENSE_DESC_REQUIRED = "Description is required";
	public static final String EXPENSE_DESC_MAX_LENGTH = "Description must be at most 255 characters";
	public static final String EXPENSE_AMT_REQUIRED = "Amount is required";
	public static final String EXPENSE_AMT_MIN = "0.01";
	public static final String EXPENSE_AMT_MIN_MSG = "Amount must be greater than 0";
	public static final String EXPENSE_DATE_REQUIRED = "Date is required";
	public static final String EXPENSE_DATE_FUTURE = "Date cannot be in the future";
	public static final String EXPENSE_CAT_ID_REQUIRED = "Category ID must not be null";
	public static final String EXPENSE_CAT_ID_EMPTY = "At least one category ID must be provided";
	public static final String CAT_NAME_REQUIRED="Category name is required";
	public static final String CAT_NAME_MAX_LENGTH_MSG = "Category name must be at most 100 characters";
	public static final int	CAT_NAME_MAX_LENGTH = 100;
	
	
	//Exceptions and Messages
	public static final String CATEGORY_NOT_FOUND = "Category not found";
	public static final String CATEGORY_NAME_EXIST = "Category name already exists:";
	public static final String EXPENSE_NOT_FOUND = "Expense not found";
	public static final String EXPENSE_ID_NOT_VALID = "Expense ID must be greater than 0";
	public static final String CATEGORY_ID_NOT_VALID = "Category ID must be greater than 0";
}
