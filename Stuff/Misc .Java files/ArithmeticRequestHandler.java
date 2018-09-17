import java.net.Socket;
import java.util.Scanner;

/**
 * A request handler for a server that performs simple arithmetic operations.
 *
 * <p>CS18000 -- Spring 2018 -- External Communication -- Homework</p>
 */
public final class ArithmeticRequestHandler implements Runnable {
    /**
     * The client socket of this request handler.
     */
    private Socket clientSocket;

    /*
     * Error message constants.
     */

    private static final String ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE;

    private static final String ILLEGAL_OPERATION_NAME_ERROR_MESSAGE;

    private static final String ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE;

    private static final String ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE;

    static {
        ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE = String.format("%s: requests must include an operation name, and two operands all separated by spaces\n", ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_OPERATION_NAME_ERROR_MESSAGE = String.format("%s: the operation name must be part of the protocol\n", ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE = String.format("%s: the first operand must be a valid integer\n", ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE = String.format("%s: the second operand must be a valid integer\n", ArithmeticProtocol.ILLEGAL_REQUEST);
    } //static

    /**
     * Constructs a newly allocated {@code ArithmeticRequestHandler} object with the specified client socket.
     *
     * @param clientSocket the client socket of this request handler
     * @throws IllegalArgumentException if the {@code clientSocket} argument is {@code null}
     */
    public ArithmeticRequestHandler(Socket clientSocket) throws IllegalArgumentException {
        if (clientSocket == null) {
            throw new IllegalArgumentException("clientSocket argument is null");
        } else {
            this.clientSocket = clientSocket;
        } //end if
    } //ArithmeticRequestHandler

    /**
     * Communicates with the client, and processes their requests until they disconnect.
     */
    public void run()
    {
    	Scanner s = new Scanner( System.in );
    	String str = s.nextLine();
    	
    	System.out.println(str);
    	
    	
    } //run
}



















