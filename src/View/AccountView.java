/*
 * Copyright April - 2019
 * JTK POLBAN.
 * Made in Ciwaruga.
 */
package View;

import ControllerView.Keypad;
import ControllerView.Screen;

/**
 *
 * @author ASUS
 */
public class AccountView {

    private Screen screen;
    private Keypad keypad;

    public AccountView(Screen screen, Keypad keypad) {
        this.screen = screen;
        this.keypad = keypad;
    }

    public int displayMainMenu() {
        screen.displayMessageLine("\nMain menu:");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Transfer");
        screen.displayMessageLine("5 - Change PIN");
        screen.displayMessageLine("6 - Bank Statement");
        screen.displayMessageLine("7 - Payment");
        screen.displayMessageLine("0 - Exit\n");
        screen.displayMessage("Enter a choice: ");
        int input = keypad.getInput();

        return input == 4 ? 5 : (input == 5 ? 6 : input); // return user's selection
    }

}
