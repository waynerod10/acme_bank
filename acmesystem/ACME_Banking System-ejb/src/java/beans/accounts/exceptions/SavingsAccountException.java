/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accounts.exceptions;

/**
 *
 * @author wayne
 */
public class SavingsAccountException extends Exception {

    /**
     * Creates a new instance of
     * <code>SavingsAccountException</code> without detail message.
     */
    public SavingsAccountException() {
    }

    /**
     * Constructs an instance of
     * <code>SavingsAccountException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public SavingsAccountException(String msg) {
        super(msg);
    }
}
