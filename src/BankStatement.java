/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class BankStatement {
    private int idStatement;
    private int account;
    private String date;
    private String description;
    private int ref;
    private double withdrawal;
    private double deposit;
    private String DepositValidate;
    private double balance;
    
    
    public int getIdStatement() {
        return idStatement;
    }

    public void setIdStatement(int idStatement) {
        this.idStatement = idStatement;
    }
    
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

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getDepositValidate() {
        return DepositValidate;
    }

    public void setDepositValidate(String DepositValidate) {
        this.DepositValidate = DepositValidate;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public int displayBankStatementMenu(Screen screen, Keypad keypad){
        
        screen.displayMessageLine("\nHistory Menu:");
        screen.displayMessageLine("1 - View Bank Statement");
        screen.displayMessageLine("2 - View Transfer History");
        screen.displayMessageLine("3 - View Withdrawal History(Montly)");
        screen.displayMessageLine("0 - Cancel\n");
        screen.displayMessage("Enter a choice: ");
        int input = keypad.getInput(); 
        
        return input == 1 ? 6 : (input == 2 ? 7 : (input == 3 ? 8 : input)); // return user's selection
    
    }
}
