
package WS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerFacade", targetNamespace = "http://facade.beans/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerFacade {


    /**
     * 
     * @param num2
     * @param num1
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://facade.beans/", className = "WS.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://facade.beans/", className = "WS.AddResponse")
    @Action(input = "http://facade.beans/CustomerFacade/addRequest", output = "http://facade.beans/CustomerFacade/addResponse")
    public double add(
        @WebParam(name = "num1", targetNamespace = "")
        double num1,
        @WebParam(name = "num2", targetNamespace = "")
        double num2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "transfer", targetNamespace = "http://facade.beans/", className = "WS.Transfer")
    @ResponseWrapper(localName = "transferResponse", targetNamespace = "http://facade.beans/", className = "WS.TransferResponse")
    @Action(input = "http://facade.beans/CustomerFacade/transferRequest", output = "http://facade.beans/CustomerFacade/transferResponse")
    public String transfer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        double arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createCreditRequest", targetNamespace = "http://facade.beans/", className = "WS.CreateCreditRequest")
    @ResponseWrapper(localName = "createCreditRequestResponse", targetNamespace = "http://facade.beans/", className = "WS.CreateCreditRequestResponse")
    @Action(input = "http://facade.beans/CustomerFacade/createCreditRequestRequest", output = "http://facade.beans/CustomerFacade/createCreditRequestResponse")
    public String createCreditRequest(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "purchaseOnCreditCard", targetNamespace = "http://facade.beans/", className = "WS.PurchaseOnCreditCard")
    @ResponseWrapper(localName = "purchaseOnCreditCardResponse", targetNamespace = "http://facade.beans/", className = "WS.PurchaseOnCreditCardResponse")
    @Action(input = "http://facade.beans/CustomerFacade/purchaseOnCreditCardRequest", output = "http://facade.beans/CustomerFacade/purchaseOnCreditCardResponse")
    public String purchaseOnCreditCard(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "paybackCreditCard", targetNamespace = "http://facade.beans/", className = "WS.PaybackCreditCard")
    @ResponseWrapper(localName = "paybackCreditCardResponse", targetNamespace = "http://facade.beans/", className = "WS.PaybackCreditCardResponse")
    @Action(input = "http://facade.beans/CustomerFacade/paybackCreditCardRequest", output = "http://facade.beans/CustomerFacade/paybackCreditCardResponse")
    public String paybackCreditCard(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "depositSavingsAccount", targetNamespace = "http://facade.beans/", className = "WS.DepositSavingsAccount")
    @ResponseWrapper(localName = "depositSavingsAccountResponse", targetNamespace = "http://facade.beans/", className = "WS.DepositSavingsAccountResponse")
    @Action(input = "http://facade.beans/CustomerFacade/depositSavingsAccountRequest", output = "http://facade.beans/CustomerFacade/depositSavingsAccountResponse")
    public String depositSavingsAccount(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "withdrawSavingsAccount", targetNamespace = "http://facade.beans/", className = "WS.WithdrawSavingsAccount")
    @ResponseWrapper(localName = "withdrawSavingsAccountResponse", targetNamespace = "http://facade.beans/", className = "WS.WithdrawSavingsAccountResponse")
    @Action(input = "http://facade.beans/CustomerFacade/withdrawSavingsAccountRequest", output = "http://facade.beans/CustomerFacade/withdrawSavingsAccountResponse")
    public String withdrawSavingsAccount(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        double arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSavingsBalance", targetNamespace = "http://facade.beans/", className = "WS.GetSavingsBalance")
    @ResponseWrapper(localName = "getSavingsBalanceResponse", targetNamespace = "http://facade.beans/", className = "WS.GetSavingsBalanceResponse")
    @Action(input = "http://facade.beans/CustomerFacade/getSavingsBalanceRequest", output = "http://facade.beans/CustomerFacade/getSavingsBalanceResponse")
    public double getSavingsBalance(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
