/**
 * DropFromCourseException
 *
 * Exception thrown for invalid drop operations involving the Course class.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class DropFromCourseException extends Exception {
    
    public DropFromCourseException() 
    {
    	/**
         * Constructs a DropFromCourseException with the default message.
         */
    	super();
    }
    public DropFromCourseException(String message) 
    {
    	/**
         * Constructs a DropFromCourseException with the provided message.
         *
         * @param message Message to be provided to the user in case of exception
         */
    	super(message);
    }
}
