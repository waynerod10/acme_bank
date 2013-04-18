package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Aks
 */
@Entity
@Table(name = "SAVINGS")
public class SavingsAccount extends Account implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean active;
    @Column(name = "BALANCE")
    private double balance;
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
