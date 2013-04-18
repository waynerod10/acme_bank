/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accounts.exceptions;

/**
 *
 * @author Aks
 */
public class HomeLoanAccountException extends Exception {

    /**
     * Creates a new instance of
     * <code>HomeLoanAccountException</code> without detail message.
     */
    public HomeLoanAccountException() {
    }

    /**
     * Constructs an instance of
     * <code>HomeLoanAccountException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public HomeLoanAccountException(String msg) {
        super(msg);
    }
}
