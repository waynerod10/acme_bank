/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.facade;

import beans.accounts.CreditCardAccountBean;
import beans.accounts.CustomerBean;
import beans.accounts.EmployeeBean;
import dto.employeeDTO;
import facade.EmployeeFacadeRemote;
import beans.accounts.exceptions.CreditCardException;
import beans.accounts.exceptions.CustomerException;
import beans.accounts.exceptions.EmployeeException;
import beans.accounts.exceptions.HomeLoanAccountException;
import beans.accounts.exceptions.SavingsAccountException;
import beans.crud.CustomerCRUD;
import beans.crud.EmployeeCRUD;
import dto.CustomerDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import model.Customer;
import model.Employee;

/**
 *
 * @author Aks
 */
@Stateful
public class EmployeeFacade implements EmployeeFacadeRemote {

    @EJB
    private CreditCardAccountBean ccManager;
    @EJB
    private CustomerCRUD customerCRUD;
    @EJB
    private CustomerBean customerBean;
    @EJB
    private EmployeeBean employeeBean;
    @EJB
    private EmployeeCRUD employeeCRUD;
    //Create local copy of Customer and Employee for temp use
    private Customer cachedCustomer;
    private Employee cachedEmployee;

    private Customer getCachedCustomer(String custNum) {
        if (cachedCustomer == null || !cachedCustomer.getcId().equals(custNum)) {
            cachedCustomer = customerCRUD.findByCustNum(custNum);
        }
        return cachedCustomer;
    }

    @Override
    public void addCustomerBasics(String custNum, String lastname, String firstName, Date dob, String address, String password) {
        cachedCustomer = new Customer();
        cachedCustomer.setcId(custNum);
        cachedCustomer.setLastName(lastname);
        cachedCustomer.setFirstName(firstName);
        cachedCustomer.setDob(dob);
        cachedCustomer.setAddress(address);
        cachedCustomer.setPassword(password);
    }

    @Override
    public void addCustDetails(String currjob, String salaryPY) {
        if (cachedCustomer != null) {
            cachedCustomer.setCurrJob(currjob);
            cachedCustomer.setSalaryPY(Double.parseDouble(salaryPY));
        }
    }

    @Override
    public void addCustFinalDetails(String prefContact) {
        if (cachedCustomer != null) {
            cachedCustomer.setPrefContact(prefContact);
        }
    }

    @Override
    public String commit() {
        try {
            customerBean.createCustomer(cachedCustomer);
            //cachedCustomer = null;
        } catch (CustomerException ex) {
            Logger.getLogger(EmployeeFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }

        return "Commit Successful";
    }

    //Get all Employee details ready for Employee Creation
    @Override
    public String createEmployee(String empNum, String lastName, String firstName, Date dob, String address, String password) {
        //Create Blank employee
        cachedEmployee = new Employee();

        //Fill Employee with details
        cachedEmployee.setEmpNum(empNum);
        cachedEmployee.setLastName(lastName);
        cachedEmployee.setFirstName(firstName);
        cachedEmployee.setDob(dob);
        cachedEmployee.setAddress(address);
        cachedEmployee.setPassword(password);

        //Commit all the changes
        try {
            employeeBean.createEmployee(cachedEmployee);
        } catch (EmployeeException ex) {
            Logger.getLogger(EmployeeFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }

        return "Successfully Created Employee";
    }

    @Override
    public String createSavingsAccount(String custNum, String acctNum, double initialBalance) {
        try {
            customerBean.createSavingsAccount(getCachedCustomer(custNum), acctNum, initialBalance);
        } catch (SavingsAccountException ex) {
            Logger.getLogger(EmployeeFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }

        return "Successfully created Savings Account";
    }

    @Override
    public String createCreditCardAccount(String custNum, String ccNum, String acctNum) {
        try {
            customerBean.createCreditCardAccount(getCachedCustomer(custNum), ccNum, acctNum);
        } catch (CreditCardException ex) {
            Logger.getLogger(EmployeeFacade.class.getName()).log(Level.SEVERE, ex.getMessage());
            return ex.getMessage();
        }

        return "Successfully created Credit Card Account";
    }

    @Override
    public String createHomeLoanAccount(String custNum, String acctNum, double initialBorrow) {
        try {
            customerBean.createHomeLoanAccount(getCachedCustomer(custNum), acctNum, initialBorrow);
        } catch (HomeLoanAccountException ex) {
            return ex.getMessage();
        }

        return "Successfully created Home Loan Account";
    }

    @Override
    public String removeEmployee(String empNo) {
        Employee emp = employeeCRUD.findByEmpNum(empNo);
        if (emp == null) {
            return "Employee not found";
        } else {
            employeeCRUD.remove(emp);
            return "Employee successfully deleted";
        }
    }
    
    

    @Override
    public List<employeeDTO> getAllEmployees() {
        return employeeBean.getAllEmployees();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> custs = null;
        List<CustomerDTO> ret_cust = new ArrayList<CustomerDTO>();

        custs = customerCRUD.findAll();

        if (custs == null || custs.isEmpty()) {
            return null;
        }

        for (Customer cus : custs) {
            CustomerDTO tmp = new CustomerDTO(cus.getcId(), cus.getFirstName(), cus.getLastName(), cus.getDob(), cus.getAddress(), cus.getCurrJob(), cus.getSalaryPY(), cus.getPrefContact());
            ret_cust.add(tmp);
        }
        
        return ret_cust;
    }

    @Override
    public String removeCustomer(String custNo) {
        Customer c = customerCRUD.findByCustNum(custNo);
        customerCRUD.remove(c);
        return "Customer deletion successful";
    }
}
