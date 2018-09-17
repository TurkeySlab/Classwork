/**
 * A protocol for a server that performs simple arithmetic operations.
 *
 * <p>CS18000 -- Spring 2018 -- External Communication -- Homework</p>
 */
public enum ArithmeticProtocol {
    /**
     * The constant representing the addition operation.
     */
    ADD,

    /**
     * The constant representing the subtraction operation.
     */
    SUBTRACT,

    /**
     * The constant representing the multiplication operation.
     */
    MULTIPLY,

    /**
     * The constant representing the division operation.
     */
    DIVIDE,

    /**
     * The constant representing an illegal request.
     */
    ILLEGAL_REQUEST
}