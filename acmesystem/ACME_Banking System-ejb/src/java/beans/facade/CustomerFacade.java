    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.facade;

//import WS.B2B;
import WS.B2B;
import beans.accounts.CreditCardAccountBean;
import beans.accounts.HomeLoanAccountBean;

import beans.accounts.SavingsAccountBean;
import beans.accounts.exceptions.CreditCardException;
import beans.accounts.exceptions.HomeLoanAccountException;
import beans.accounts.exceptions.SavingsAccountException;
import beans.crud.CustomerCRUD;
import dto.AccountDTO;
import dto.CreditCardDTO;
import dto.HomeLoanDTO;
import dto.SavingsDTO;
import facade.CustomerFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;
import model.Account;
import model.CreditCardAccount;
import model.Customer;
import model.HomeLoanAccount;
import model.SavingsAccount;

/**
 * Customer Session Bean
 *
 * @author Aks + Wayne
 */
@WebService(serviceName = "B2B")
@Stateless
public class CustomerFacade implements CustomerFacadeRemote {
    
 @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/B2B/CustomerFacade.wsdl")
    private B2B service;
    @EJB
    private CreditCardAccountBean creditCardManager;
    @EJB
    private SavingsAccountBean savingsAccountManager;
    @EJB
    private HomeLoanAccountBean homeLoanManager;
    @EJB
    private CustomerCRUD customerCRUD;
  

    
    @Override
    public String purchaseOnCreditCard(String acctNum, double amount, String description) {
        try {
            creditCardManager.cardPurchase(acctNum, amount, description);
            return "Purchase Successful";
        } catch (CreditCardException ex) {
            Logger.getLogger(CustomerFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();

        }
    }

    @Override
    public String paybackCreditCard(String acctNum, double amount, String description) {
        try {
            creditCardManager.cardPayback(acctNum, amount, description);
        } catch (CreditCardException ex) {
            Logger.getLogger(CustomerFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }

        return "Successfully payed back Credit Card";
    }

    @Override
    public String depositSavingsAccount(String acctNum, double amount) {
        savingsAccountManager.deposit(acctNum, amount);

        return "Successfully Deposited into Savings Account";

    }

    @Override
    public String withdrawSavingsAccount(String acctNum, double amount) {
        try {
            savingsAccountManager.withdraw(acctNum, amount);
        } catch (SavingsAccountException ex) {
            Logger.getLogger(CustomerFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }

        return "Successfully withdrawn";
    }

    
    @Override
    public double getSavingsBalance(String acctNum) {
        return savingsAccountManager.fetchBalance(acctNum);
    }

    @Override
    public String transfer(String fromAcctNum, String toAcctNum, double amount) {
        if (fromAcctNum.startsWith("S") && toAcctNum.startsWith("CC")) {
            try {
                savingsAccountManager.withdraw(fromAcctNum, amount);
            } catch (SavingsAccountException ex) {
                Logger.getLogger(CustomerFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
                return ex.getMessage();
            }
            try {
                creditCardManager.cardPayback(toAcctNum, amount,
                        String.format("Transfer from Account No. %s", fromAcctNum));
            } catch (CreditCardException ex) {
                Logger.getLogger(CustomerFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
                savingsAccountManager.deposit(fromAcctNum, amount);
                return ex.getMessage() + " hence rolled back";
            }
        }
        return "Transfer Success";
    }

    @Override
    public String createCreditRequest(String acctNum, double newCreditLimit) {
        try {
            creditCardManager.createCreditRequest(acctNum, newCreditLimit);
        } catch (CreditCardException ex) {
            Logger.getLogger(CustomerFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }

        return "Credit Request Made";
    }

    /**
     * SOAP Webservice method ADD
     *
     * @param num1
     * @param num2
     * @return
     */
    @WebMethod(operationName = "add")
    @Override
    public double add(
            @WebParam(name = "num1") double num1,
            @WebParam(name = "num2") double num2) {
        return num1 + num2;
    }

    //Step 5 and 6 of Lab 8
    public double addClient(double num1, double num2) {
        //WS.CustomerFacade port = service.getCustomerFacadePort();
        return 0;//port.add(num1, num2);
    }

    @Override
    public String borrowHomeLoanAccount(String acctNum, double amount) {
        homeLoanManager.borrow(acctNum, amount);
        return "Home Loan Borrow successful";
    }

    @Override
    public String repayHomeLoan(String acctNum, double amount) {
        try {
            homeLoanManager.repay(acctNum, amount);
        } catch (HomeLoanAccountException ex) {
            return ex.getMessage();
        }
        return "Successfully repayed Home Loan account";
    }

    @Override
    public List<AccountDTO> getAllAccounts(String custNo) {
        Customer c = customerCRUD.findByCustNum(custNo);
        List<Account> accounts = customerCRUD.findAccounts(c);
        List<AccountDTO> ret = new ArrayList<AccountDTO>();
        
        if(accounts.isEmpty() || (accounts == null)) return null;
        
        for (Account ac : accounts) {
            
            if(ac instanceof SavingsAccount) {
                SavingsDTO tmp = new SavingsDTO(((SavingsAccount)ac).isActive()
                        , ((SavingsAccount)ac).getBalance());
                tmp.setAccNum(((SavingsAccount)ac).getAccNum());
                ret.add(tmp);
            }
            else if (ac instanceof CreditCardAccount) {
                CreditCardDTO tmp = new CreditCardDTO(((CreditCardAccount)ac).getCCNum(), ((CreditCardAccount)ac).getCreditLmit()
                        , ((CreditCardAccount)ac).getCredit());
                tmp.setAccNum(((CreditCardAccount)ac).getAccNum());
                ret.add(tmp);
            }
            else {
                HomeLoanDTO tmp = new HomeLoanDTO(((HomeLoanAccount) ac).getAmountBorrowed(), ((HomeLoanAccount)ac).getAmountRepayed());
                tmp.setAccNum(((HomeLoanAccount)ac).getAccNum());
                ret.add(tmp);
            }
        }
        return ret;
    }    
}
