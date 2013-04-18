/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accounts;

import beans.accounts.exceptions.HomeLoanAccountException;
import beans.crud.HomeLoanAccountCRUD;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import model.HomeLoanAccount;

/**
 *
 * @author Aks
 */
@Stateless
@LocalBean
public class HomeLoanAccountBean {
    @EJB
    private HomeLoanAccountCRUD homeLoanAccountCRUD;

    
    public void borrow(String acctNum, double amount) {
        HomeLoanAccount hla = (HomeLoanAccount) homeLoanAccountCRUD.findByAccNum(acctNum);
        // Check amount borrow limit
        hla.setAmountBorrowed(amount + hla.getAmountBorrowed());
        homeLoanAccountCRUD.edit(hla);
        
    }
    
    public void repay(String accNum, double amount) throws HomeLoanAccountException{
        HomeLoanAccount hla = (HomeLoanAccount) homeLoanAccountCRUD.findByAccNum(accNum);
        if((hla.getAmountRepayed() + amount) > hla.getAmountBorrowed() ) {
            throw new HomeLoanAccountException("Can pay back more than borrowed");
        }
        hla.setAmountRepayed(amount + hla.getAmountRepayed());
        homeLoanAccountCRUD.edit(hla);
    }

}
