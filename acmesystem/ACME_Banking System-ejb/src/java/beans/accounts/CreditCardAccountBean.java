/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accounts;

import beans.accounts.exceptions.CreditCardException;
import beans.crud.CreditCardAccountCRUD;
import beans.crud.CreditCardTransactionCRUD;
import beans.crud.CreditChangeRequestCRUD;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.CreditCardAccount;
import model.CreditCardTransaction;
import model.CreditChangeRequest;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class CreditCardAccountBean {

    private static final int MAX_CREDIT_LIMIT = 50000;
    @EJB
    private CreditChangeRequestCRUD creditChangeRequestCRUD;
    private static final Logger logger = Logger.getLogger(CreditCardAccountBean.class.getName());
    @EJB
    private CreditChangeRequestCRUD ccrCRUD;
    @EJB
    private CreditCardTransactionCRUD cctCRUD;
    @EJB
    private CreditCardAccountCRUD ccaCRUD;

    public void cardPurchase(String acctNum, double amount, String description) throws CreditCardException {
        CreditCardAccount acc = (CreditCardAccount) ccaCRUD.findByAccNum(acctNum);
        if ((acc.getCredit() + amount) <= acc.getCreditLmit()) {
            CreditCardTransaction cct = new CreditCardTransaction();
            cct.setAmount(amount);
            cct.setTimeTransacted(new java.util.Date());
            cct.setCcAccount(acc);
            cct.setCreditLimit(acc.getCreditLmit());
            cct.setDescription(description);
            cctCRUD.create(cct);

            acc.setCredit(acc.getCredit() + amount);
            ccaCRUD.edit(acc);
        } else {
            throw new CreditCardException("Credit Limit Violations");
        }
    }

    public void cardPayback(String acctNum, double amount, String description) throws CreditCardException {
        CreditCardAccount acc = (CreditCardAccount) ccaCRUD.findByAccNum(acctNum);
        if ((acc.getCredit() - amount) >= 0.0) {
            CreditCardTransaction cct = new CreditCardTransaction();
            cct.setAmount(-1 * amount);
            cct.setTimeTransacted(new java.util.Date());
            cct.setCcAccount(acc);
            cct.setCreditLimit(acc.getCreditLmit());
            cct.setDescription(description);
            cctCRUD.create(cct);

            acc.setCredit(acc.getCredit() - amount);
            ccaCRUD.edit(acc);
        } else {
            throw new CreditCardException("Credit cannot be negative");
        }
    }

    public void transferTo(String fromAcctNum, String toAcctNum, double amount) throws CreditCardException {
        //TODO check if the account is transferable and transfer it
        String desc = String.format("Transfer from account number %s", fromAcctNum);
        this.cardPayback(toAcctNum, amount, desc);
    }

    public void transferFrom(String fromAcctNum, String toAcctNum, double amount) throws CreditCardException {
        String desc = String.format("Transfer to account number %s", toAcctNum);
        this.cardPurchase(fromAcctNum, amount, desc);
    }

    public void approveAllCreditRequests() {
        List<CreditChangeRequest> requests = creditChangeRequestCRUD.findAll();
        for (CreditChangeRequest ccr : requests) {
            CreditCardAccount cca = ccr.getCreditAccount();
            cca.setCreditLmit(ccr.getnewCreditLimit());
            ccaCRUD.edit(cca);
            ccrCRUD.remove(ccr);
        }
    }

    protected boolean isCreditIncreaseFeasible(CreditCardAccount account) {
        long transactions = cctCRUD.getTransactionsByAccountAndLimit(account);
        if (transactions > 0 && (account.getCredit() == 0.0)) {
            return true;
        }
        return false;
    }

    protected boolean checkCreditIncreaseLimit(double newCreditLimit) {
        if (newCreditLimit > MAX_CREDIT_LIMIT) {
            return false;
        }
        return true;
    }

    public void createCreditRequest(String acctNum, double newCreditLimit) throws CreditCardException {
        CreditCardAccount cca = (CreditCardAccount) ccaCRUD.findByAccNum(acctNum);
        if (checkCreditIncreaseLimit(newCreditLimit)) {
            if (isCreditIncreaseFeasible(cca)) {
                CreditChangeRequest ccr = new CreditChangeRequest();
                ccr.setCreditAccount(cca);
                ccr.setnewCreditLimit(newCreditLimit);
                ccr.setTimeRequested(new Date());

                ccrCRUD.create(ccr);
            } else {
                throw new CreditCardException("Credit increase not possible at this time");
            }
        } else {
            throw new CreditCardException(String.format("Credit Limit cannot exceed %d", MAX_CREDIT_LIMIT));
        }
    }

    public double fetchCredit(String accNum) {
        CreditCardAccount cca = (CreditCardAccount) ccaCRUD.findByAccNum(accNum);
        return cca.getCredit();
    }
}
