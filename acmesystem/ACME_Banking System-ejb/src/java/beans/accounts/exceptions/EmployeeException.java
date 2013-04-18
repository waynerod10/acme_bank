/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.accounts.exceptions;

/**
 *
 * @author wayne
 */
public class EmployeeException extends Exception {

    /**
     * Creates a new instance of
     * <code>EmployeeException</code> without detail message.
     */
    public EmployeeException() {
    }

    /**
     * Constructs an instance of
     * <code>EmployeeException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public EmployeeException(String msg) {
        super(msg);
    }
}
