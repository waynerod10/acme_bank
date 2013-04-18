/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Aks
 */
public class CreditCardDTO extends AccountDTO implements Serializable{
    private String CCNum;
    
    private double creditLmit;
    
    private double credit;

    public CreditCardDTO(String CCNum, double creditLmit, double credit) {
        this.CCNum = CCNum;
        this.creditLmit = creditLmit;
        this.credit = credit;
    }

    public String getCCNum() {
        return CCNum;
    }

    public double getCreditLmit() {
        return creditLmit;
    }

    public double getCredit() {
        return credit;
    }
    
    
}
