/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketBids;

import java.io.IOException;
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

    public ClientHandler(
            Socket clientSocket,
            PrintWriter outPrintWriter,
            Scanner inputScanner,
            OutputData outputData
    ) throws IOException {
        this.client = clientSocket;
        this.output = outPrintWriter;
        this.input = inputScanner;
        this.outputData = outputData;
    }


    @Override
    public void run() {
        int numPid = 0;
        int numberOfDealers = 0;
        boolean isDealerSuccessPids = false;
        try {
            do {
                int finalPrice = outputData.getFinalPrice();
                int price = input.nextInt();
                if (finalPrice < price) {
                    updateOutputData(price);
                    isDealerSuccessPids = true;
                }
                output.println(finalPrice);
                numPid++;
            } while (numPid < 20);
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        } finally {
            if (isDealerSuccessPids) {
                outputData.setNumSuccessDealers(outputData.getNumSuccessDealers() + 1);
            }
            output.close();
            input.close();
            Server.showOutputData();
        }
    }

    public void updateOutputData(int price) {
        outputData.setFinalPrice(price);
        outputData.setNumSuccessPids(outputData.getNumSuccessPids() + 1);
    }
}
