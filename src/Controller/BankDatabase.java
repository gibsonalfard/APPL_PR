package Controller;

import Controller.Nasabah.BankStatement;
import Model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankDatabase {

    private Account[] accounts; // array of Accounts  
    private int accAmount;
    private List<BankStatement> BankStatementlist = new ArrayList<>();
    private List<Bill> BillList = new ArrayList<>();

    public BankDatabase() {

        accounts = new Account[20]; // just 20 accounts maxx for testing
        accounts[0] = new Business(1234, 4321, 1000.0, 1200.0);
        accounts[1] = new Student(8765, 5678, 200.0, 200.0);
        accounts[2] = new Business(6665, 1234, 111700.0, 111900.0);
        accounts[3] = new Deposito(6666, 1234, 1700.0, 1900.0);
        accounts[4] = new Admin(00000, 00000, 0.0, 0.0);
        accAmount = 5;
    }

    public Account getAccount(int accountNumber) {
        int ak;
        for (ak = 0; ak < accAmount; ak++) {
            if (accounts[ak] == null) {
                break;
            }
            if (accountNumber == accounts[ak].getAccountNumber()) {
                return accounts[ak];
            }
        }
        return null;
    }

    public Account getSpecificAccount(int userAccountNumber, int userPIN) {
        Account userAccount = getAccount(userAccountNumber);

        if (userAccount != null && userAccount.validatePIN(userPIN) && !userAccount.isUserBlocked()) {
            return userAccount;
        } else {
            return null; // account number not found, so return false
        }
    }

    public boolean checkAvail(int accountNumber) {
        int ak;
        for (ak = 0; ak < accAmount - 1; ak++) {
            if (accountNumber == accounts[ak].getAccountNumber()) {
                return false;
            }
        }
        return true;
    }

    public boolean authenticateAdmin(int userAccountNumber, int userPIN) {
        // attempt to retrieve the account with the account number
        Account userAccount = getAccount(userAccountNumber);

//      if account exists, return result of Account method validatePIN
        if (userAccount != null) {
            return (userAccount.validatePIN(userPIN) && getAccount(userAccountNumber).getAccountType().equals("Model.Admin"));
        } else {
            return false; // account number not found, so return false
        }
    }

    public boolean authenticateUser(int userAccountNumber, int userPIN) {
        // attempt to retrieve the account with the account number
        Account userAccount = getAccount(userAccountNumber);

//      if account exists, return result of Account method validatePIN
        if (userAccount != null && !userAccount.isUserBlocked()) {
            return userAccount.validatePIN(userPIN);
        } else {
            return false; // account number not found, so return false
        }
    }

    public boolean seekAccountNumber(int accountNumber) {
        for (Account ak : accounts) {
            if (accountNumber == ak.getAccountNumber()) {
                return true;
            }
        }
        return false;
    }

    public double getAvailableBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getAvailableBalance();
    }

    public double getTotalBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getTotalBalance();
    }

    public void transfer(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).transfer(amount);
        getAccount(userAccountNumber).setTransferToday(amount);
    }

    public void credit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).credit(amount);
        getAccount(userAccountNumber).setWithdrawToday(amount);
    }

    public void debit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).debit(amount);
    }

    public void changeAccountPIN(int userAccountNumber, int curPIN, int newPIN) {
        if (authenticateUser(userAccountNumber, curPIN)) {
            getAccount(userAccountNumber).changePIN(newPIN);
        } else {
            System.out.println("Sorry, Can't Change PIN");
        }
    }

    public void blockAccount(int userAccountNumber) {
        getAccount(userAccountNumber).blockUser();
    }

    public void unblockAccount(int userAccountNumber) {
        getAccount(userAccountNumber).unblockUser();
    }

    public boolean isAccountBlocked(int userAccountNumber) {
        if (getAccount(userAccountNumber) != null) {
            return getAccount(userAccountNumber).isUserBlocked();
        } else {
            return false;
        }
    }

    public boolean isUserExist(int userAccountNumber) {
        return getAccount(userAccountNumber) != null;
    }

    public void incAccount(int typeAccount, int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
        switch (typeAccount) {
            case 0:
                accounts[accAmount] = new Admin(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
                break; //admin
            case 1:
                accounts[accAmount] = new Student(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
                break; //student
            case 2:
                accounts[accAmount] = new Business(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
                break; //business
            case 3:
                accounts[accAmount] = new Deposito(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
                break; //deposito
        }
        accAmount++;
    }

    public double getTransferToday(int theAccountNumber) {
        return getAccount(theAccountNumber).getTransferToday();
    }

    public double getWithdrawalToday(int theAccountNumber) {
        return getAccount(theAccountNumber).getWithdrawToday();
    }

    public List<BankStatement> getList() throws IOException {
        if (this.BankStatementlist.isEmpty()) {
            return null;
        }
        return this.BankStatementlist;
    }

    private int generateIdStatement() {
        int size = this.BankStatementlist.size();
        if (size != 0) {
            return size;
        } else {
            return 0;
        }
    }

    public void setBankStatement(int account, String description, int ref, double withdrawal, double deposit, String depVal) {
        BankStatement tr = new BankStatement();
        Tanggal tgl = new Tanggal();
        tr.setIdStatement(generateIdStatement());
        tr.setAccount(account);
        tr.setDate(tgl.dateNow());
        tr.setDeposit(deposit);
        tr.setDepositValidate(depVal);
        tr.setDescription(description);
        tr.setRef(ref);
        tr.setWithdrawal(withdrawal);
        tr.setBalance(getAccount(account).getAvailableBalance());
        this.BankStatementlist.add(tr);
    }

    public void updateDepVal(int idStatement) {
        BankStatement tr = new BankStatement();

        tr.setIdStatement(idStatement);
        tr.setAccount(this.BankStatementlist.get(idStatement).getAccount());
        tr.setDate(this.BankStatementlist.get(idStatement).getDate());
        tr.setDescription(this.BankStatementlist.get(idStatement).getDescription());
        tr.setRef(this.BankStatementlist.get(idStatement).getRef());
        tr.setWithdrawal(this.BankStatementlist.get(idStatement).getWithdrawal());
        tr.setDeposit(this.BankStatementlist.get(idStatement).getDeposit());
        tr.setDepositValidate("Yes");
        tr.setBalance(getTotalBalance(this.BankStatementlist.get(idStatement).getAccount()));

        /* TODO : add ke avail balance */
        getAccount(this.BankStatementlist.get(idStatement).getAccount()).setAvailableBalance(this.BankStatementlist.get(idStatement).getDeposit());
        this.BankStatementlist.set(idStatement, tr);
    }

    public void displayBankStatement(int accountNumber) {

        if (!BankStatementlist.isEmpty()) {
            int size;

            size = BankStatementlist.size();

            System.out.println();
            System.out.println("=========================================================================================================");
            System.out.println("Date\t\tDescription\tRef\tWithdrawal\tDeposit \tDeposit Valid\tBalance");
            System.out.println("=========================================================================================================");

            for (int i = 0; i < size; i++) {
                if (BankStatementlist.get(i).getAccount() == accountNumber) {
//               System.out.print(list.get(i).getIdStatement()+"\t");
                    System.out.print(BankStatementlist.get(i).getDate() + "\t");
                    System.out.print(BankStatementlist.get(i).getDescription() + "\t");

                    int Ref = BankStatementlist.get(i).getRef();
                    if (Ref != 0) {
                        System.out.print(Ref);
                    } else {
                        System.out.print("\t");
                    }

                    double Withdrawal = BankStatementlist.get(i).getWithdrawal();
                    if (Withdrawal != 0) {
                        System.out.print(Withdrawal + "\t\t");
                    } else {
                        System.out.print("\t\t\t");
                    }

                    double Deposit = BankStatementlist.get(i).getDeposit();
                    if (Deposit != 0) {
                        System.out.print(Deposit + "\t\t");
                    } else {
                        System.out.print("\t\t");
                    }

                    String depVal = BankStatementlist.get(i).getDepositValidate();
                    if (depVal != null) {
                        System.out.print(depVal + "\t\t");
                    } else {
                        System.out.print("\t\t");
                    }

                    System.out.print(BankStatementlist.get(i).getBalance());
                    System.out.println();
                }
            }

        }

    }

    public boolean isAvailableWithdraw(int theAccountNumber, double amount) {
        return getAccount(theAccountNumber).isAvailableForWithdraw(amount);
    }

    public void monthlyTax() {
        int ak;
        for (ak = 0; ak < (accAmount - 1); ak++) {
            if (accounts[ak] == null) {
                break;
            }

            if (!"Student".equals(accounts[ak].getAccountType())) {
                accounts[ak].payTax();
            }
        }
    }

    public int getWithdrawal(int userAccountNumber) {
        Account userAccount = getAccount(userAccountNumber);
        return userAccount.displayWithdrawalMenu();
    }

    public void resetLimit() {
        int ak;
        for (ak = 0; ak < (accAmount - 1); ak++) {
            if (accounts[ak] != null) {
                accounts[ak].setWithdrawToday((-1 * accounts[ak].getWithdrawToday()));
                accounts[ak].setTransferToday((-1 * accounts[ak].getTransferToday()));
            } else {
                break;
            }
        }
    }

    public String getAccountType(int userAccountNumber) {
        Account userAccount = getAccount(userAccountNumber);
        return userAccount.getAccountType();
    }

    public void setTransferToday(int userAccountNumber, double transferToday) {
        Account userAccount = getAccount(userAccountNumber);
        userAccount.setTransferToday(transferToday);
    }

    public List<Bill> getBillList() {
        return BillList;
    }

    public void showBillList() {
        System.out.println("==============================================================================");
        System.out.println("Client Number" + "\t" + "Amount" + "\t" + "Collector Number");
        System.out.println("==============================================================================");

        for (Bill b : BillList) {
            System.out.println(b.getClientAccountNumber() + "\t" + b.getAmount() + "\t" + b.getCollectorAccountNumber());
        }
    }

    public boolean addBill(int client, double amount, int collector) {
        try {
            for (Bill b : BillList) {
                if (b.getClientAccountNumber() == client && b.getCollectorAccountNumber() == collector) {
                    b.setAmount(b.getAmount() + amount);
                }
                return true;
            }
            Bill bill = new Bill(client, amount, collector);
            BillList.add(bill);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void payBill(int client, double amount, int collector) {
        for (Bill b : BillList) {
            if (b.getClientAccountNumber() == client && b.getCollectorAccountNumber() == collector) {
                b.setAmount(b.getAmount() + amount);
            }
        }
    }
    
    public List<Bill> getBill(int client){
        List<Bill> AccountBillList = new ArrayList<>();
        for(Bill b : BillList){
            if(b.getClientAccountNumber() == client){
                AccountBillList.add(b);
            }
        }
        return AccountBillList;
    }
}
