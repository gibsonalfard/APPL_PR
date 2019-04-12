/*
 * Copyright April - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Bill {

    private int clientAccountNumber;
    private double amount;
    private int collectorAccountNumber;

    public Bill(int client, double amount, int collector) {
        this.clientAccountNumber = client;
        this.amount = amount;
        this.collectorAccountNumber = collector;
    }
    
    public int getClientAccountNumber() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(int clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCollectorAccountNumber() {
        return collectorAccountNumber;
    }

    public void setCollectorAccountNumber(int collectorAccountNumber) {
        this.collectorAccountNumber = collectorAccountNumber;
    }
}
