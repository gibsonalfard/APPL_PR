/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tio
 */
public class BankStatement {
    private String deskripsi;
    private int ref;
    private double withdrawals;
    private double deposit;
    private boolean depVal;
    private double availBalance;
    
    public BankStatement(String desc, int ref, double withdrawal, double deposit, boolean validate, double availableBal) {
        this.deskripsi = desc;
        this.ref = ref;
        this.withdrawals = withdrawal;
        this.deposit = deposit;
        this.depVal = validate;
        this.availBalance = availableBal;
    }    
}
