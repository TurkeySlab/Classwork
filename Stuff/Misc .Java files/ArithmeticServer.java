import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A server that performs simple arithmetic operations.
 *
 * <p>CS18000 -- Spring 2018 -- External Communication -- Homework</p>
 */
public final class ArithmeticServer {
    /**
     * The server socket of this server.
     */
    private ServerSocket serverSocket;

    /**
     * Constructs a newly allocated {@code ArithmeticServer} object at the specified port.
     *
     * @param port the port of this server
     * @throws IOException if an I/O error occurs during initialization
     */
    public ArithmeticServer(int port) throws IllegalArgumentException, IOException {
        if (port < 0) {
            throw new IllegalArgumentException("port argument is negative");
        } else {
            this.serverSocket = new ServerSocket(port);
        } //end if
    } //ArithmeticServer

    /**
     * Servers the clients of this server.
     */
    public void serveClients() {
        Socket clientSocket;
        ArithmeticRequestHandler requestHandler;

        System.out.println("<Starting the server>");

        while (true) {
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                System.out.println("<An unexpected exception occurred>");

                System.out.printf("<Exception message: %s>\n", e.getMessage());

                System.out.println("<Stopping the server>");

                try {
                    this.serverSocket.close();
                } catch (IOException i) {
                    i.printStackTrace();
                } //end try catch

                return;
            } //end try catch

            System.out.println("<Connected to a client>");

            requestHandler = new ArithmeticRequestHandler(clientSocket);

            new Thread(requestHandler).start();
        } //end while
    } //serveClients

    /**
     * Creates an instance of {@code ArithmeticServer}, which serves its clients.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArithmeticServer server;

        try {
            server = new ArithmeticServer(50000);
        } catch (IOException e) {
            System.out.println("<An unexpected exception occurred>");

            System.out.printf("<Exception message: %s>\n", e.getMessage());

            System.out.println("<Stopping the server>");

            return;
        } //end try catch

        server.serveClients();
    } //main
}