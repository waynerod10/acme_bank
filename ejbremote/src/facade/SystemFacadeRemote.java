/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Remote;

/**
 *
 * @author Aks
 */
@Remote
public interface SystemFacadeRemote {

    void approveCreditRequests();
    public String validateEmployee(String empNo, String password);
    public String validateCustomer(String custNo, String password);
    
}
