package socketBids;

/**
 * @author ahmedzidan
 */
public class OutputData {

    private int finalPrice;

    private int numSuccessBids;

    private int numSuccessDealers;

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int price) {
        this.finalPrice = price;
    }

    public int getNumSuccessBids() {
        return numSuccessBids;
    }

    public void setNumSuccessBids(int numBids) {
        this.numSuccessBids = numBids;
    }

    public int getNumSuccessDealers() {
        return numSuccessDealers;
    }

    public void setNumSuccessDealers(int numSuccessDealers) {
        this.numSuccessDealers = numSuccessDealers;
    }

}
