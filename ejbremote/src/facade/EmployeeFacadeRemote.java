/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.CustomerDTO;
import dto.employeeDTO;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Aks
 */
@Remote
public interface EmployeeFacadeRemote {

    public void addCustomerBasics(String custNum, String lastname, String firstName, Date dob, String address, String password);
    
    void addCustDetails(String currjob, String salaryPY);
    
    void addCustFinalDetails(String prefContact);
    
    String commit();
    
    String createSavingsAccount(String custNum, String acctNum, double initialBalance);
    
    String createCreditCardAccount(String custNum, String ccNum, String acctNum );

    String createEmployee(String empNum, String lastName, String firstName, Date dob, String address, String password);

    String createHomeLoanAccount(String custNum, String acctNum, double initialBorrow);

    String removeEmployee(String empNo);

    List<employeeDTO> getAllEmployees();

    List<CustomerDTO> getAllCustomers();

    String removeCustomer(String custNo);
    
}
