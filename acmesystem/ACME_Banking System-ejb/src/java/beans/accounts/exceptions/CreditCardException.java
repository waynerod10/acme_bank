package beans.accounts.exceptions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wayne
 */
public class CreditCardException extends Exception
{

    /**
     * Creates a new instance of
     * <code>CreditCardLimitException</code> without detail message.
     */
    public CreditCardException()
    {
            
    }

    /**
     * Constructs an instance of
     * <code>CreditCardLimitException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CreditCardException(String msg)
    {
        super(msg);
    }
}
