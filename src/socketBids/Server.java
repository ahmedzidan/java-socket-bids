package socketBids;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ahmedzidan
 */
public class Server {

    private static final int PORT = 9999;

    private static ExecutorService pool = Executors.newCachedThreadPool();

    private static OutputData outputData = new OutputData();

    private static int START_PRICE = 1000;
    private static int START_SUCCESS_BIDS = 0;
    private static int START_SUCCESS_DEALERS = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(PORT);
        outputData.setFinalPrice(START_PRICE);
        outputData.setNumSuccessBids(START_SUCCESS_BIDS);
        outputData.setNumSuccessDealers(START_SUCCESS_DEALERS);

        try {
            while (true) {
                Socket clientSocket = listener.accept();
                Scanner input = new Scanner(clientSocket.getInputStream());
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                ClientHandler clientThread = new ClientHandler(clientSocket, out, input, outputData);
                pool.execute(clientThread);
            }
        } catch (IOException e) {
            listener.close();
            e.getStackTrace();
        } finally {
            listener.close();

        }

    }

    public static void showOutputData() {
        System.out.println("Final Price = " + outputData.getFinalPrice());
        System.out.println("count of accepted bids = " + outputData.getNumSuccessBids());
        System.out.println("Count of dealers = " + outputData.getNumSuccessDealers());
    }
}
