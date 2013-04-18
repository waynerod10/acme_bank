package beans.accounts;

import beans.accounts.exceptions.SavingsAccountException;
import beans.crud.SavingsAccountCRUD;
import beans.crud.SavingsAccountTrnsactionCRUD;
import model.SavingsAccount;
import model.SavingsAccountTransaction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class SavingsAccountBean {
    private static final int OVERDRAW_LIMIT = 0;
    private static final int INITIAL_MIN_BALANCE = 50;

    @EJB
    private SavingsAccountCRUD savingsAccountCRUD;
    
    @EJB
    private SavingsAccountTrnsactionCRUD savingsAccountTransactionCRUD;
    
    private static final Logger logger = Logger.getLogger(SavingsAccountBean.class.getName());
    
    public void withdraw(String accNum, double amount) throws SavingsAccountException
    {
        //TODO: remove
        System.err.println("Acctnumber "+ accNum + "has deposits: " + savingsAccountTransactionCRUD.getDepositsByAccount(accNum));
        
        savingsAccountCRUD.findByAccNum(accNum);
        SavingsAccount sa = (SavingsAccount) savingsAccountCRUD.findByAccNum(accNum);
        if (sa.isActive())
        {
            if ((sa.getBalance() - amount) >= OVERDRAW_LIMIT)
            {
                SavingsAccountTransaction sat= new SavingsAccountTransaction();
                sat.setAccNum(accNum);
                sat.setAmount(-amount);
                savingsAccountTransactionCRUD.create(sat);
                sa.setBalance(sa.getBalance() - amount);
                savingsAccountCRUD.edit(sa);
            } 
            else
            {
                logger.log(Level.WARNING, "Account can't overdraw");
                throw new SavingsAccountException("Account can't overdraw");
            }
        } 
        else 
        {
            logger.log(Level.WARNING, "Account not active");
            throw new SavingsAccountException("Account not active");
        }
    }

    public void deposit(String accNum, double amount)
    {
        SavingsAccount sa = (SavingsAccount) savingsAccountCRUD.findByAccNum(accNum);
        sa.setBalance(sa.getBalance() + amount);
        if(sa.getBalance() >= INITIAL_MIN_BALANCE && !sa.isActive()) sa.setActive(true);
        
        SavingsAccountTransaction sat= new SavingsAccountTransaction();
        sat.setAccNum(accNum);
        sat.setAmount(amount);
        savingsAccountTransactionCRUD.create(sat);
        savingsAccountCRUD.edit(sa);
    }

    public double fetchBalance(String accNum) {
        SavingsAccount sa = (SavingsAccount) savingsAccountCRUD.findByAccNum(accNum);
        return sa.getBalance();
    }

    public boolean isActive(String accNum) {
        SavingsAccount sa = (SavingsAccount) savingsAccountCRUD.findByAccNum(accNum);
        return sa.isActive();
    }

    public void setActive(String accNum, boolean activity) {
        SavingsAccount sa = (SavingsAccount) savingsAccountCRUD.findByAccNum(accNum);
        sa.setActive(activity);
        savingsAccountCRUD.edit(sa);
    }

    public void transferTo(String fromAcctNum, String toAcctNum, double amount) {
        this.deposit(toAcctNum, amount);
    }

    public void transferFrom(String fromAcctNum, String toAcctNum, double amount) throws SavingsAccountException
    {
        this.withdraw(fromAcctNum, amount);
    }
}
