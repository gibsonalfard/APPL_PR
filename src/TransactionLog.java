/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class TransactionLog {
    private int account;
    private String date;
    private String description;
    private int ref;
    private int withdrawal;
    private int deposit;
    private double balance;
    
    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(int withdrawal) {
        this.withdrawal = withdrawal;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
