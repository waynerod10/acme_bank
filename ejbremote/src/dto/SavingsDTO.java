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
public class SavingsDTO extends AccountDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private boolean active;
    private double balance;

    public boolean isActive() {
        return active;
    }

    public SavingsDTO(boolean active, double balance) {
        this.active = active;
        this.balance = balance;
    }

    
    public double getBalance() {
        return balance;
    }
    
}
