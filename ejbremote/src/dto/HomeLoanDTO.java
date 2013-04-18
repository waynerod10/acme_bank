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
public class HomeLoanDTO extends AccountDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private double amountBorrowed;
    private double amountRepayed;

    public HomeLoanDTO(double amountBorrowed, double amountRepayed) {
        this.amountBorrowed = amountBorrowed;
        this.amountRepayed = amountRepayed;
    }

    public double getAmountBorrowed() {
        return amountBorrowed;
    }

    public double getAmountRepayed() {
        return amountRepayed;
    }
    
    
}
