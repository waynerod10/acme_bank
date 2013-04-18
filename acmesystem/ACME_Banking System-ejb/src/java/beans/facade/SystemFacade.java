/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.facade;

import facade.SystemFacadeRemote;
import beans.accounts.CreditCardAccountBean;
import beans.accounts.CustomerBean;
import beans.accounts.EmployeeBean;
import beans.accounts.exceptions.CustomerException;
import beans.accounts.exceptions.EmployeeException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aks
 */
@Stateless
public class SystemFacade implements SystemFacadeRemote {

    @EJB
    private EmployeeBean employeeBean;
    @EJB
    private CustomerBean customerBean;
    @EJB
    private CreditCardAccountBean ccManager;

    @Override
    public void approveCreditRequests() {
        ccManager.approveAllCreditRequests();
    }

    @Override
    public String validateEmployee(String empNo, String password){
        try {
            return employeeBean.validate(empNo, password);
        } catch (EmployeeException ex) {
            return ex.getMessage();
        }
    }

    @Override
    public String validateCustomer(String custNo, String password){
        try {
            return customerBean.validate(custNo, password);
        } catch (CustomerException ex) {
            return ex.getMessage();
        }
    }
}
