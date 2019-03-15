
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Fadly
 */
public class Transfer extends Transaction {

    private double amount; // amount to transfer
    private int accountTrans; // account number for transfer
    private Keypad keypad = new Keypad(); // reference to keypad
    private int processTransfer; //actually boolean for confirm the prosese
    private final static int CANCELED = 0; // constant for cancel option

    BankDatabase bankDatabase = getBankDatabase();

    private Tanggal date;


    public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase,
            Keypad atmKeypad) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        keypad = atmKeypad;
    }

    @Override
    public void execute() {

        Screen screen = getScreen(); // get reference to screen

        processTransfer = 1;
        accountTrans = 1;
        amount = 1;
        while (amount != 0 && accountTrans != 0) {
            accountTrans = getAccountForTransfer();
            amount = getAmountForTransfer();
            if (bankDatabase.seekAccountNumber(accountTrans) && amount != 0 && super.getAccountNumber() != accountTrans) {
                screen.displayMessage("\nAccount number : " + accountTrans);
                screen.displayMessage("\nAmount : " + amount);
                screen.displayMessage("\n\nProcess the transfer " + "(1 for yes, 0 for no) : ");
                processTransfer = keypad.getInput();
                if (processTransfer == 1) {
                    screen.displayMessage("\nProcessing Transfer......\n");

                    promptTransfer(accountTrans,amount);
                    //System.out.println(amount);
                    bankDatabase.setBankStatement(getAccountNumber(), "Transfer", accountTrans,(int)amount,0,null); //set sender bank statement 
                    bankDatabase.setBankStatement(accountTrans, "Transfer", getAccountNumber(),0, (int)amount,null); //set receiver bank statement 
                    amount = 0;//for cancelling the transfer
                } else {
                    screen.displayMessage("\nCanceling Transfer.....\n");
                    amount = 0; //for canceling the transfer
                }
            } else {
                if (super.getAccountNumber() == accountTrans) {
                    screen.displayMessage("\nYou can't transfer to yourself!");
                    screen.displayMessage("\nCanceling Transfer.....\n");
                    amount = 0; //for canceling the transfer

                }else if(amount != 0){
                        screen.displayMessage("\nSorry we can't find the account number");
                        screen.displayMessage("\nCanceling Transfer.....\n");
                        amount = 0; //for canceling the transfer
                    } else {
                        screen.displayMessage("\nCanceling Transfer.....\n");
                        amount = 0; //for canceling the transfer
                    }
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
        Screen screen = getScreen(); // get reference to screen
        
        if (bankDatabase.getAccountType(super.getAccountNumber()).equals("Deposito") && bankDatabase.getAvailableBalance(super.getAccountNumber())>=amount && bankDatabase.getTransferToday(super.getAccountNumber())+amount<=Deposito.MAXTRANSFER){
                bankDatabase.credit(super.getAccountNumber(), (amount + (amount*(1.5/100)))); //decrease the money of transfer user
                bankDatabase.transfer(accountTrans, amount);//increase the money of receiveramount you transfer is more than your available balance"
                bankDatabase.setTransferToday(super.getAccountNumber(), amount);
                screen.displayMessage("\nDone!\n");
        }else if (bankDatabase.getAccountType(super.getAccountNumber()).equals("Business") && bankDatabase.getAvailableBalance(super.getAccountNumber())>=amount && bankDatabase.getTransferToday(super.getAccountNumber())+amount<=Business.MAXTRANSFER){
                bankDatabase.credit(super.getAccountNumber(), amount); //decrease the money of transfer user
                bankDatabase.transfer(accountTrans, amount);//increase the money of receiver
                bankDatabase.setTransferToday(super.getAccountNumber(), amount);
                screen.displayMessage("\nDone!\n");
        }else if ((bankDatabase.getAccountType(super.getAccountNumber()).equals("Deposito") && bankDatabase.getTransferToday(super.getAccountNumber())>=Deposito.MAXTRANSFER && bankDatabase.getAvailableBalance(super.getAccountNumber())>=amount)||(bankDatabase.getAccountType(super.getAccountNumber()).equals("Business") && bankDatabase.getTransferToday(super.getAccountNumber())>=Business.MAXTRANSFER && bankDatabase.getAvailableBalance(super.getAccountNumber())>=amount)){
            screen.displayMessage("\nYou Exceeded Your Transfer Limit For Today.");
            screen.displayMessage("\nCanceling Transfer.....\n");
        }else if ((bankDatabase.getAccountType(super.getAccountNumber()).equals("Deposito") && bankDatabase.getTransferToday(super.getAccountNumber())+amount>=Deposito.MAXTRANSFER && bankDatabase.getAvailableBalance(super.getAccountNumber())>=amount)||(bankDatabase.getAccountType(super.getAccountNumber()).equals("Business") && bankDatabase.getTransferToday(super.getAccountNumber())+amount>=Business.MAXTRANSFER && bankDatabase.getAvailableBalance(super.getAccountNumber())>=amount)){
            screen.displayMessage("\nThe amount you transfer is more than your transfer limit for a day");
            screen.displayMessage("\nCanceling Transfer.....\n");
        }else{
            screen.displayMessage("\nThe amount you transfer is more than your available balance");
            screen.displayMessage("\nCanceling Transfer.....\n");
        }
        
    }

    public void displayTransferHistory() throws IOException {
        List<BankStatement> list = bankDatabase.getList();
        Tanggal tgl = new Tanggal();
        String tanggal = tgl.dateNow();
        
        if (!list.isEmpty()) {
            int size;

            size = list.size();

            System.out.println();
            System.out.println("=========================================================================================================");
            System.out.println("Date\t\tDescription\tRef\tWithdrawal\tDeposit\t\tBalance");
            System.out.println("=========================================================================================================");

            for (int i = 0; i < size; i++) {
                
                if (list.get(i).getDescription().equals("Transfer") && list.get(i).getDate().equals(tanggal) && list.get(i).getAccount() == super.getAccountNumber()) {
//               System.out.print(list.get(i).getIdStatement()+"\t"); 
                    System.out.print(list.get(i).getDate() + "\t");
                    System.out.print(list.get(i).getDescription() + "\t");

                    int Ref = list.get(i).getRef();
                    if (Ref != 0) {
                        System.out.print(Ref);
                    } else {
                        System.out.print("\t");
                    }

                    double Withdrawal = list.get(i).getWithdrawal();
                    if (Withdrawal != 0) {
                        System.out.print(Withdrawal + "\t\t");
                    } else {
                        System.out.print("\t\t\t");
                    }

                    double Deposit = list.get(i).getDeposit();
                    if (Deposit != 0) {
                        System.out.print(Deposit + "\t\t");
                    } else {
                        System.out.print("\t\t");
                    }

                    String depVal = list.get(i).getDepositValidate();
                    if (depVal != null) {
                        System.out.print(depVal + "\t\t");
                    } else {
                        System.out.print("\t\t");
                    }

                    System.out.print(list.get(i).getBalance());
                    System.out.println();
                }

            }
        }
    }
    
}
