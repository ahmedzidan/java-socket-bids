package socketBids;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ahmedzidan
 */
public class ClientHandler implements Runnable {

    private Socket client;
    private PrintWriter output;
    private Scanner input;
    private static OutputData outputData = new OutputData();

    private static int ALLOWED_BIDS_NUMBER = 20;

    public ClientHandler(
            Socket clientSocket,
            PrintWriter outPrintWriter,
            Scanner inputScanner,
            OutputData outputData
    ) {
        this.client = clientSocket;
        this.output = outPrintWriter;
        this.input = inputScanner;
        this.outputData = outputData;
    }


    @Override
    public void run() {
        int numBid = 0;
        boolean isDealerSuccessBids = false;
        try {
            do {
                int finalPrice = outputData.getFinalPrice();
                int price = input.nextInt();
                if (finalPrice < price) {
                    updateOutputData(price);
                    isDealerSuccessBids = true;
                }
                output.println(finalPrice);
                numBid++;
            } while (numBid < ALLOWED_BIDS_NUMBER);
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        } finally {
            if (isDealerSuccessBids) {
                outputData.setNumSuccessDealers(outputData.getNumSuccessDealers() + 1);
            }
            output.close();
            input.close();
            Server.showOutputData();
        }
    }

    public void updateOutputData(int price) {
        outputData.setFinalPrice(price);
        outputData.setNumSuccessBids(outputData.getNumSuccessBids() + 1);
    }
}
