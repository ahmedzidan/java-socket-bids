package socketBids;

/**
 * @author ahmedzidan
 */
public class OutputData {

    private int finalPrice;

    private int numSuccessPids;

    private int numSuccessDealers;

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int price) {
        this.finalPrice = price;
    }

    public int getNumSuccessPids() {
        return numSuccessPids;
    }

    public void setNumSuccessPids(int numPids) {
        this.numSuccessPids = numPids;
    }

    public int getNumSuccessDealers() {
        return numSuccessDealers;
    }

    public void setNumSuccessDealers(int numSuccessDealers) {
        this.numSuccessDealers = numSuccessDealers;
    }

}
