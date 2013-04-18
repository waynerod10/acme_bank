package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Aks
 */
@Entity
@Table(name = "HOMELOAN")
public class HomeLoanAccount extends Account implements Serializable {

    private static final long serialVersionUID = 1L;
    private double amountBorrowed;
    private double amountRepayed;

    public double getAmountBorrowed() {
        return amountBorrowed;
    }

    public void setAmountBorrowed(double amountBorrowed) {
        this.amountBorrowed = amountBorrowed;
    }

    public double getAmountRepayed() {
        return amountRepayed;
    }

    public void setAmountRepayed(double amountRepayed) {
        this.amountRepayed = amountRepayed;
    }
}
