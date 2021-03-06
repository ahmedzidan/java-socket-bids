package socketBids;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ahmedzidan
 */
public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9999;
    private static final int[] RANDOM_ARRAY = new int[]{100, 300, 500};

    private static int ALLOWED_BIDS_NUMBER = 20;
    private static int START_PRICE = 1000;

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Scanner input = new Scanner(new InputStreamReader(socket.getInputStream()));
        int startPrice = START_PRICE;
        int numBid = 0;
        do {
            startPrice = Integer.sum(startPrice, getRandom(RANDOM_ARRAY));
            output.println(startPrice);
            startPrice = input.nextInt();
            numBid++;
        } while (numBid < ALLOWED_BIDS_NUMBER);

        System.out.println(startPrice);
        socket.close();
        System.exit(0);
    }


    private static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

}
