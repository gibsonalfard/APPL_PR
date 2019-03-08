/**
 *
 * @author Fadly
 */
public class Transfer extends Transaction{
    private double amount; // amount to transfer
    private int accountTrans; // account number for transfer
    private Keypad keypad; // reference to keypad
    private int processTransfer; //actually boolean for confirm the prosese
    private final static int CANCELED = 0; // constant for cancel option

    public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase,
            Keypad atmKeypad) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        keypad = atmKeypad;
    }

    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen(); // get reference to screen
  
        processTransfer = 1;
        amount = 1;
        while(amount!=0){
            accountTrans = getAccountForTransfer();
            amount = getAmountForTransfer();
            if(bankDatabase.seekAccountNumber(accountTrans)){
                screen.displayMessage("\nAccount number : "+accountTrans);
                screen.displayMessage("\nAmount : "+amount);
                screen.displayMessage("\n\nProcess the transfer " + "(1 for yes, 0 for no) : ");
                processTransfer = keypad.getInput(); 
                if (processTransfer==1){
                    screen.displayMessage("\nProcessing Transfer......");
                    promptTransfer(accountTrans,amount);
                    amount=0;//for cancelling the transfer
                }else{
                    screen.displayMessage("\nCanceling Transfer.....");
                    amount=0; //for canceling the transfer
                }
            }else {
                screen.displayMessage("\nSorry we can't find the account number");
                screen.displayMessage("Canceling Transfer.....");
                amount = 0; //for canceling the transfer
            }
        }
    }
    
    private double getAmountForTransfer(){
      Screen screen = getScreen(); // get reference to screen

      // display the prompt
      screen.displayMessage("\nPlease enter a transfer amount in " + 
         "CENTS (or 0 to cancel): ");
      // receive input of transfer amount
      int input = keypad.getInput(); // receive input of amount
      // check whether the user canceled or entered a valid amount
      if (input == CANCELED) {
         return CANCELED;
      }
      else {
         return (double) input / 100; // return dollar amount
      }
    }

    private int getAccountForTransfer() {
        Screen screen = getScreen(); // get reference to screen

        screen.displayMessage("\nPlease enter the account number : ");
        int input = keypad.getInput(); // receive input of account number
            if (input == CANCELED) {
            return CANCELED;
        } else {
            return input; //return the accountNumber
      }
    }

    private void promptTransfer(int accountTrans, double amount) {
        BankDatabase bankDatabase = getBankDatabase();
        bankDatabase.credit(super.getAccountNumber(), amount); //decrease the money of transfer user
        bankDatabase.transfer(accountTrans, amount);//increase the money of receiver
    }
    
}