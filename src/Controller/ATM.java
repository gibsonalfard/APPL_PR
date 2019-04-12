package Controller;

import Controller.Nasabah.Transfer;
import Controller.Nasabah.Withdrawal;
import Controller.Nasabah.BalanceInquiry;
import Controller.Nasabah.Transaction;
import Controller.Nasabah.Deposit;
import Controller.Admin.AdminController;
import ControllerView.Keypad;
import ControllerView.Screen;
import static Model.Constants.*;

public class ATM {
    private boolean userAuthenticated; // whether user is authenticated
    private boolean adminAuthenticated;//whether user is admin
    private boolean userExited;
    private int currentAccountNumber; // current user's account number
    private int currentPIN;
    private Screen screen; // ATM's screen
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser
    private DepositSlot depositSlot;
    private BankDatabase bankDatabase; // account information database
    private int loginAttempt = 0;
    private int curPin, newPin;
    private AdminController admin;
    
    
    Tanggal tanggal = new Tanggal();

    // no-argument ATM constructor initializes instance variables
    public ATM() {
        userAuthenticated = false; // user is not authenticated to start
        adminAuthenticated = false; // user is not admin to start
        currentAccountNumber = 0; // no current account number to start
        screen = new Screen(); // create screen
        keypad = new Keypad(); // create keypad
        cashDispenser = new CashDispenser(); // create cash dispenser
        bankDatabase = new BankDatabase(); // create acct info database
    }

    // start ATM 
    public void run() {
        // welcome and authenticate user; perform transactions
        while (true) {
            screen.displayMessageLine("\nWelcome!");
            // loop while user is not yet authenticated
            while ((!userAuthenticated && loginAttempt < 3) && !adminAuthenticated) {
                authenticateUser(); // authenticate user
            }
            if (adminAuthenticated) {
                admin = new AdminController(bankDatabase, cashDispenser, screen, keypad, tanggal);
                admin.performAdmins();
            } else {
                if (loginAttempt == 3) {
                    screen.displayMessageLine("Your account has been blocked, please contact the bank");
                    bankDatabase.blockAccount(currentAccountNumber); //blokir acconut
                } else {
                    performTransactions(); // user is now authenticated
                    userAuthenticated = false; // reset before next ATM session
                }
                currentAccountNumber = 0; // reset before next ATM session
            }
            userAuthenticated = false;
            adminAuthenticated = false; // reset before next ATM session
            screen.displayMessageLine("\nThank you! Goodbye!");
            loginAttempt = 0;
        }
    }

    // attempts to authenticate user against database
    private void authenticateUser() {
        screen.displayMessage("\nPlease enter your account number: ");
        int accountNumber = keypad.getInput(); // input account number
        screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
        int pin = keypad.getInput(); // input PIN

        currentAccountNumber = accountNumber;
        currentPIN = pin;
        
        // set userAuthenticated to boolean value returned by database
        adminAuthenticated
                = bankDatabase.authenticateAdmin(accountNumber, pin);
        userAuthenticated
                = bankDatabase.authenticateUser(accountNumber, pin);

        // check whether authentication succeeded
        if (userAuthenticated) {
            currentAccountNumber = accountNumber; // save user's account #
            loginAttempt = 0;
            depositSlot = new DepositSlot(currentAccountNumber, 0, false);
//        } else if (adminAuthenticated){
//            performAdmins();
        } else if (bankDatabase.isAccountBlocked(accountNumber) && !isAdmin(accountNumber)) {
            screen.displayMessageLine("Your Account has been blocked, please contact the bank.");
        } else if (!bankDatabase.isUserExist(accountNumber) && !isAdmin(accountNumber)) {
            screen.displayMessageLine("Invalid user Account Number");
            loginAttempt = 0;
        } else if (!isAdmin(accountNumber)) {
            if (loginAttempt < 2) {
                screen.displayMessageLine(
                        "Invalid PIN. Please try again. You have " + (2 - loginAttempt) + " attempt(s) remaining.");
            }
            loginAttempt++;
        } else if (isAdmin(accountNumber)) {
            screen.displayMessageLine("Invalid PIN");
        }
    }

    private boolean isAdmin(int adminAccountNumber) {
        return adminAccountNumber == 0;
    }

    // display the main menu and perform transactions
    private void performTransactions() {
        // local variable to store transaction currently being processed
        Transaction currentTransaction;

        boolean userExited = false; // user has not chosen to exit

        // loop while user has not chosen option to exit system
        while (!userExited) {
            // show main menu and get user selection
            int mainMenuSelection = bankDatabase.getSpecificAccount(currentAccountNumber, currentPIN)
                    .displayMainMenu(screen, keypad);

            // decide how to proceed based on user's menu selection
            switch (mainMenuSelection) {
                // user chose to perform one of three transaction types
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                case TRANSFER:
                    // initialize as new object of chosen type
                    currentTransaction
                            = createTransaction(mainMenuSelection);
                    
                    currentTransaction.execute(); // execute transaction
                    break;
                case PASSWORD:
                    screen.displayMessage("\nPlease Enter Your Current Pin: ");
                    curPin = keypad.getInput(); // input account number
                    screen.displayMessage("\nPlease Enter Your New Pin: ");
                    newPin = keypad.getInput(); // input account number

                    bankDatabase.changeAccountPIN(currentAccountNumber, curPin, newPin);

                    break;
                case BANK_STATEMENT:
                    bankDatabase.displayBankStatement(currentAccountNumber);
                    break;
                case EXIT: // user chose to terminate session
                    screen.displayMessageLine("\nExiting the system...");
                    userExited = true; // this ATM session should end
                    break;
                default: // 
                    screen.displayMessageLine(
                            "\nYou did not enter a valid selection. Try again.");
                    break;
            }
        }
    }

    

    private Transaction createTransaction(int type) {
        Transaction temp = null;

        switch (type) {
            case BALANCE_INQUIRY:
                temp = new BalanceInquiry(
                        currentAccountNumber, screen, bankDatabase);
                break;
            case WITHDRAWAL:
                temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
                break;
            case DEPOSIT:
                temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
                break;
                
            case TRANSFER:
                temp = new Transfer(currentAccountNumber, screen, bankDatabase, keypad);
                break;
            case PASSWORD:
                bankDatabase.changeAccountPIN(currentAccountNumber, curPin, newPin);
                break;
            case EXIT: // user chose to terminate session
                screen.displayMessageLine("\nExiting the system...");
                userExited = true; // this ATM session should end
                break;
            default: // 
                screen.displayMessageLine(
                        "\nYou did not enter a valid selection. Try again.");
                break;
         }
        return temp;
   }
}
