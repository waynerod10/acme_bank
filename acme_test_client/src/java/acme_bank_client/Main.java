/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme_bank_client;

import facade.CustomerFacadeRemote;
import facade.EmployeeFacadeRemote;
import facade.SystemFacadeRemote;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author Aks
 */
public class Main {

    @EJB
    private static CustomerFacadeRemote customerFacade;
    @EJB
    private static EmployeeFacadeRemote employeeFacade;
    @EJB
    private static SystemFacadeRemote systemFacade;
    private static final String CUST_NUM_1 = "C6781";
    private static final String EMP_NUM_1 = "E7654";
    private static final String PASSWORD = "pass";
    private static final String PASSWORD2 = "pass2";
    public static final String SAVINGS_ACCT_1 = "S12233";
    public static final String HL_ACCT_1 = "HL2233";
    public static final String CREDIT_CARD_ACCT_1 = "CC6781";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String output;
        double balance;

        // Customer creation
        System.out.println("\nAttempting to create first Customer..");
        employeeFacade.addCustomerBasics(CUST_NUM_1, "LAST", "FIRST", new Date(),"21 Rd", Encrypt.encryptPassword(PASSWORD));
        
        output = employeeFacade.commit();
        System.out.println("Expected: Commit Successful");
        System.out.println("Received: " + output);

        System.out.println("\nAttempting to create first employee");
        output = employeeFacade.createEmployee(EMP_NUM_1, "Hawking", "Stephen", new Date(), "2 Elizabeth St, Melbourne", Encrypt.encryptPassword(PASSWORD));
        System.out.println("Expected: Successfully Created Employee");
        System.out.println("Received: " + output);

        System.out.println("\nAttempting a CC account creation without a savings accnt");
        output = employeeFacade.createCreditCardAccount(CUST_NUM_1, "3389282737643734", CREDIT_CARD_ACCT_1);
        System.out.println("Expected: Credit Card Account creation failed");
        System.out.println("Received: " + output);

        //Create savings account
        System.out.println("\nAttempting a savings accnt creation with zero balance");
        output = employeeFacade.createSavingsAccount(CUST_NUM_1, SAVINGS_ACCT_1, 0);
        System.out.println("Expected: Successfully created Savings Account");
        System.out.println("Received: " + output);

//        System.out.println("\nAttempting to deposit $20");
//        output = customerFacade.depositSavingsAccount(SAVINGS_ACCT_1, 20);
//        System.out.println("Expected: Successfully Deposited into Savings Account");
//        System.out.println("Received: " + output);

        System.out.println("\nAttempting to withdraw $10");
        output = customerFacade.withdrawSavingsAccount(SAVINGS_ACCT_1, 10);
        System.out.println("Expected: Account not active");
        System.out.println("Received: " + output);

        System.out.println("\nAttempting to deposit $40");
        output = customerFacade.depositSavingsAccount(SAVINGS_ACCT_1, 40);
        System.out.println("Expected: Successfully Deposited into Savings Account");
        System.out.println("Received: " + output);

        System.out.println("\nAttempting to withdraw $10 again");
        output = customerFacade.withdrawSavingsAccount(SAVINGS_ACCT_1, 10);
        System.out.println("Expected: Successfully withdrawn");
        System.out.println("Received: " + output);

        customerFacade.depositSavingsAccount(SAVINGS_ACCT_1, 500);
        customerFacade.withdrawSavingsAccount(SAVINGS_ACCT_1, 20);

        System.out.println("\nAttempting to get balance of Savings Account");
        balance = customerFacade.getSavingsBalance(SAVINGS_ACCT_1);
        System.out.println("Expected: 550.00");
        System.out.println("Received: " + balance);

        System.out.println("\nAttempting to create a CC accnt and make some purchases");
        employeeFacade.createCreditCardAccount(CUST_NUM_1, "3389282737643734", CREDIT_CARD_ACCT_1);
        customerFacade.purchaseOnCreditCard(CREDIT_CARD_ACCT_1, 10, "McDonalds: Feast");
        output = customerFacade.purchaseOnCreditCard(CREDIT_CARD_ACCT_1, 400, "JBhifi: Headphones");
        System.out.println(output);

//        // transfer more than credit
//        System.out.println("\nAttempting transfer to a 'lot':) of money to CC accnt");
//        output = customerFacade.transfer(SAVINGS_ACCT_1, CREDIT_CARD_ACCT_1, 500);
//        System.out.println("Expected: Credit cannot be negative hence rolled back");
//        System.out.println("Received: " + output);

        System.out.println("\nAttempting transfer to a $50 to CC accnt");
        output = customerFacade.transfer(SAVINGS_ACCT_1, CREDIT_CARD_ACCT_1, 50);
        System.out.println("Expected: Transfer Success");
        System.out.println("Received: " + output);

//        System.out.println("\nAttempting to overdraw savings account by transfer");
////        customerFacade.depositSavingsAccount(SAVINGS_ACCT_1, 500);
//        output = customerFacade.transfer(SAVINGS_ACCT_1, CREDIT_CARD_ACCT_1, 600);
//        System.out.println("Expected: Account cannot overdraw");
//        System.out.println("Received: " + output);

        System.out.println("\nAttempting to payback credit card dues");
        output = customerFacade.paybackCreditCard(CREDIT_CARD_ACCT_1, 360, "Payment: Credit Card bill");
        System.out.println("Expected: Successfully payed back Credit Card");
        System.out.println("Received: " + output);

        // Trying to request credit increase > max limit
        System.out.println("\nAttempting to request credit increase > max limit");
        output = customerFacade.createCreditRequest(CREDIT_CARD_ACCT_1, 100000);
        System.out.println("Expected: Credit Limit cannot exceed 50000");
        System.out.println("Received: " + output);

        //Trying to request credit increase
        System.out.println("\nAttempting to request credit increase for $5000");
        output = customerFacade.createCreditRequest(CREDIT_CARD_ACCT_1, 5000);
        System.out.println("Expected: Credit Request Made");
        System.out.println("Received: " + output);

        systemFacade.approveCreditRequests();

        //Trying to request credit increase without any purchases made
        System.out.println("\nAttempting to make another request with no purchases on the new one");
        output = customerFacade.createCreditRequest(CREDIT_CARD_ACCT_1, 10000);
        System.out.println("Expected: Credit increase not possible at this time");
        System.out.println("Received: " + output);

        // BREAK HERE
        customerFacade.depositSavingsAccount(SAVINGS_ACCT_1, 500);
        
        
        // Ass 2 new methods
        
//        System.out.println("\nAttempting to create a HL accnt borrow some");
//        output = employeeFacade.createHomeLoanAccount(CUST_NUM_1, HL_ACCT_1, 12000);
//        System.out.println(output);
//        System.out.println("Received: " + output);
//
//        System.out.println("\nAttempting to repay a HL accnt");
//        output = customerFacade.repayHomeLoan(HL_ACCT_1, 500.0);
//        System.out.println(output);
//        System.out.println("Received: " + output);
//        
//        System.out.println("Attempting to validate an employee");
//        output = systemFacade.validateEmployee("Hel", PASSWORD2);
//        System.out.println(output);
//        
//        System.out.println("Attempting to validate an customer");
//        output = systemFacade.validateCustomer(CUST_NUM_1, PASSWORD);
//        System.out.println(output);
        
        customerFacade.purchaseOnCreditCard(CREDIT_CARD_ACCT_1, 400, "JBhifi: Headphones");
        
        System.out.println("End of Program");
    }
}
