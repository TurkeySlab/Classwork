/**
 * AddToCourseException
 *
 * Exception thrown for invalid add operations involving the Course class.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class AddToCourseException extends Exception {
    public AddToCourseException() {
    	/*
         * Constructs an AddToCourseException with the default message.
         */
    	super();
    }
    public AddToCourseException(String message) 
    {
    	/**
         * Constructs an AddToCourseException with the provided message.
         *
         * @param message Message to be provided to the user in case of exception
         */
    	super(message);
    }
}
