
/**
 * Description:
 *
 * Date:
 * @author ahmadajinaufalali
 */

import java.util.Comparator;
import java.util.Scanner;

class SortDescendingByWithdrawalAmount implements Comparator<BankStatement> {

    @Override
    public int compare(BankStatement o1, BankStatement o2) {
        return (int)o2.getWithdrawal() - (int)o1.getWithdrawal();
    }
}
