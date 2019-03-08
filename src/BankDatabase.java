
public class BankDatabase {

    private Account[] accounts; // array of Accounts
    private int accAmount;

    public BankDatabase() {
        accAmount = 4;
        accounts = new Account[10]; // just 2 accounts for testing
        accounts[0] = new Account(1234, 4321, 1000.0, 1200.0);
        accounts[1] = new Student(8765, 5678, 200.0, 200.0);
        accounts[2] = new Business(6665, 1234, 700.0, 900.0);
        accounts[3] = new Deposito(6666, 1234, 1700.0, 1900.0);
        accounts[4] = new Admin(00000, 00000, 0.0, 0.0);
    }

    private Account getAccount(int accountNumber) {
        int ak;
        for (ak = 0; ak < accAmount; ak++) {
            if (accountNumber == accounts[ak].getAccountNumber()) {
                return accounts[ak];
            }
        }
        return null;
    }

    public boolean checkAvail(int accountNumber) {
        int ak;
        for (ak = 0; ak < accAmount; ak++) {
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
            return (userAccount.validatePIN(userPIN) && userAccount.getClass().toString() == "Admin");
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

    public void incAccount(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
        accounts[accAmount] = new Admin(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
        accAmount++;
    }

    public double getTransferToday(int theAccountNumber) {
        return getAccount(theAccountNumber).getTransferToday();
    }

    public double getWithdrawalToday(int theAccountNumber) {
        return getAccount(theAccountNumber).getWithdrawToday();
    }
    
}
