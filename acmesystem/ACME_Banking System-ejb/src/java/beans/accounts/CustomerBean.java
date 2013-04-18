/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accounts;

import beans.accounts.exceptions.CreditCardException;
import beans.accounts.exceptions.CustomerException;
import beans.accounts.exceptions.HomeLoanAccountException;
import beans.accounts.exceptions.SavingsAccountException;
import beans.crud.CreditCardAccountCRUD;
import beans.crud.CustomerCRUD;
import beans.crud.HomeLoanAccountCRUD;
import beans.crud.SavingsAccountCRUD;
import beans.crud.SavingsAccountTrnsactionCRUD;
import model.SavingsAccount;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.Account;
import model.CreditCardAccount;
import model.Customer;
import model.HomeLoanAccount;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class CustomerBean {

    private static final int INITIAL_CREDIT_LIMIT = 2000;
    private static final double INITIAL_CREDIT = 0.0;
    private static final int MAX_ACCOUNTS = 5;
    private static final Logger logger = Logger.getLogger(CustomerBean.class.getName());
    public static final int MIN_DEPOSITS = 3;
    @EJB
    private CreditCardAccountCRUD creditCardAccountCRUD;
    @EJB
    private SavingsAccountCRUD savingsAccountCRUD;
    @EJB
    private SavingsAccountBean savingsAccountBean;
    @EJB
    private SavingsAccountTrnsactionCRUD savingsAccountTransactionCRUD;
    @EJB
    private HomeLoanAccountCRUD homeLoanAccountCRUD;
    @EJB
    private CustomerCRUD cCRUD;

    public void createSavingsAccount(Customer c, String acctNum, double initialBalance) throws SavingsAccountException {
//        Customer c = customerCRUD.findByCustNum(custNum);
        if (isWithinAccountLimit(c)) {
            SavingsAccount sa = new SavingsAccount();
            sa.setAccNum(acctNum);
            sa.setcId(c);
            savingsAccountCRUD.create(sa);
            savingsAccountBean.deposit(acctNum, initialBalance);
        } else {
            throw new SavingsAccountException("Too many accounts of customer");
        }
    }

    private boolean isWithinAccountLimit(Customer c) {
        List<Account> accounts = cCRUD.findAccounts(c);
        if (accounts != null) {
            if (accounts.size() >= MAX_ACCOUNTS) {
                return false;
            }
        }
        return true;
    }

    private boolean passedAccountCreationRules(Customer c) {
        //Atleast One savings account
        //Savings account has to be active
        //Only one cc account allowed
        //Only one home loan account allowed

        List<Account> accounts = cCRUD.findAccounts(c);

        if (accounts == null) {
            return false;
        }

        boolean creditFound = false;
        boolean homeLoanFound = true;
        boolean activeSavingsfound = false;

        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                if (((SavingsAccount) account).isActive()) {
                    activeSavingsfound = true;
                }
            }
            if (account instanceof CreditCardAccount) {
                creditFound = true;
            }
        }

        if (creditFound || !activeSavingsfound) {
            return false;
        }
        return true;
    }

    private boolean passedHLAccountCreationRules(Customer c, String accNum) {
        //Atleast One savings account
        //Savings account has to be active
        //Only one hl account allowed
        //Savings account has to have atleast MIN_DEPOSITS

        List<Account> accounts = cCRUD.findAccounts(c);

        if (accounts == null) {
            return false;
        }

        boolean hlFound = false;
        boolean activeSavingsfound = false;
        boolean minDepositsOK = false;

        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                if (((SavingsAccount) account).isActive()) {
                    activeSavingsfound = true;
                    if (savingsAccountTransactionCRUD.getDepositsByAccount(account.getAccNum()) >= MIN_DEPOSITS) {
                        minDepositsOK = true;
                    }
                }
            }
            if (account instanceof HomeLoanAccount) {
                hlFound = true;
            }
        }

        if (hlFound || !activeSavingsfound || !minDepositsOK) {
            return false;
        }
        return true;
    }

    public void createCreditCardAccount(Customer c, String ccNum, String acctNum) throws CreditCardException {
//        Customer c = customerCRUD.findByCustNum(custNum);
        if (passedAccountCreationRules(c) && isWithinAccountLimit(c)) {
            CreditCardAccount cca = new CreditCardAccount();
            cca.setAccNum(acctNum);
            cca.setCCNum(ccNum);
            cca.setCredit(INITIAL_CREDIT);
            cca.setCreditLmit(INITIAL_CREDIT_LIMIT);
            cca.setcId(c);

            try {
                creditCardAccountCRUD.create(cca);
            } catch (Exception e) {
                throw new CreditCardException("Duplicate Credit Card Account");
            }

        } else {
            logger.log(Level.WARNING, "creditCard Account creation failed");
            throw new CreditCardException("Credit Card Account creation failed");
        }
    }

    public void createHomeLoanAccount(Customer c, String acctNum, double initialBorrow) throws HomeLoanAccountException {
        if (passedHLAccountCreationRules(c, acctNum) && isWithinAccountLimit(c)) {
            HomeLoanAccount hla = new HomeLoanAccount();
            hla.setAccNum(acctNum);
            hla.setcId(c);
            hla.setAmountBorrowed(initialBorrow);
            homeLoanAccountCRUD.create(hla);
        } else {
            throw new HomeLoanAccountException("Home Loan Account creation failed");
        }
    }

    public void createCustomer(Customer c) throws CustomerException {
        //Validate entity here
        try {
            cCRUD.create(c);
        } catch (Exception e) {
            throw new CustomerException("Duplicate Customer ID");
        }
    }

    public String validate(String custNo, String password) throws CustomerException {
        Customer c = cCRUD.findByCustNum(custNo);
        if (c == null) {
            throw new CustomerException("Error");
        }

        if (custNo.equalsIgnoreCase(c.getcId()) && password.equals(c.getPassword())) {
            return "Logged in..";
        } else {
            return "Error";
        }
    }
}
