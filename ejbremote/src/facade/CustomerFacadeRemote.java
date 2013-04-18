/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import dto.AccountDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Aks
 */
@Remote
public interface CustomerFacadeRemote {
    
    String purchaseOnCreditCard(String acctNum, double amount, String description);
    
    String paybackCreditCard(String acctNum, double amount, String description);

    String depositSavingsAccount(String acctNum, double amount);

    String withdrawSavingsAccount(String acctNum, double amount) throws NullPointerException;

    double getSavingsBalance(String acctNum);
    
    String transfer(String fromAcctNum, String toAcctNum, double amount);

    String createCreditRequest(String acctNum, double newCreditLimit);
    
    
    double add(double num1, double num2);

    String borrowHomeLoanAccount(String acctNum, double amount);

    String repayHomeLoan(String acctNum, double amount);

    List<AccountDTO> getAllAccounts(String custNum);

}
