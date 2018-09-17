import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * A client that connects to a server that performs simple arithmetic operations.
 *
 * <p>CS18000 -- Spring 2018 -- External Communication -- Homework</p>
 */
public final class ArithmeticClient {
    public static void main(String[] args) {
        Socket serverConnection = null;
        Scanner inUser = new Scanner(System.in);
        Scanner inServer = null;
        PrintWriter outServer;
        String response;

        try {
            serverConnection = new Socket("localhost", 50000);

            inServer = new Scanner(serverConnection.getInputStream());

            outServer = new PrintWriter(serverConnection.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("<An unexpected exception occurred>");

            System.out.printf("<Exception message: %s>\n", e.getMessage());

            if (inServer != null) {
                inServer.close();
            } //end if

            if (serverConnection != null) {
                try {
                    serverConnection.close();
                } catch (IOException i) {
                    i.printStackTrace();
                } //end try catch
            } //end if

            return;
        } //end try catch

        System.out.println("<Connected to the server>");

        System.out.print("Enter the message to be sent to the server: ");

        while (inUser.hasNextLine()) {
            outServer.println(inUser.nextLine());

            if (inServer.hasNextLine()) {
                response = inServer.nextLine();
            } else {
                System.out.println("<Lost the connection with the server>");

                return;
            } //end if

            System.out.printf("Response from the server: %s\n", response);

            System.out.print("Enter the message to be sent to the server: ");
        } //end while

        inUser.close();

        inServer.close();

        outServer.close();

        try {
            serverConnection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } //end try catch
    } //main
}