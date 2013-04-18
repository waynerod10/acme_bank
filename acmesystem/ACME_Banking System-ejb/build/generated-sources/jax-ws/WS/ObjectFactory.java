
package WS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the WS package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateCreditRequestResponse_QNAME = new QName("http://facade.beans/", "createCreditRequestResponse");
    private final static QName _GetSavingsBalanceResponse_QNAME = new QName("http://facade.beans/", "getSavingsBalanceResponse");
    private final static QName _PurchaseOnCreditCard_QNAME = new QName("http://facade.beans/", "purchaseOnCreditCard");
    private final static QName _PaybackCreditCard_QNAME = new QName("http://facade.beans/", "paybackCreditCard");
    private final static QName _TransferResponse_QNAME = new QName("http://facade.beans/", "transferResponse");
    private final static QName _PurchaseOnCreditCardResponse_QNAME = new QName("http://facade.beans/", "purchaseOnCreditCardResponse");
    private final static QName _GetSavingsBalance_QNAME = new QName("http://facade.beans/", "getSavingsBalance");
    private final static QName _PaybackCreditCardResponse_QNAME = new QName("http://facade.beans/", "paybackCreditCardResponse");
    private final static QName _DepositSavingsAccount_QNAME = new QName("http://facade.beans/", "depositSavingsAccount");
    private final static QName _DepositSavingsAccountResponse_QNAME = new QName("http://facade.beans/", "depositSavingsAccountResponse");
    private final static QName _WithdrawSavingsAccountResponse_QNAME = new QName("http://facade.beans/", "withdrawSavingsAccountResponse");
    private final static QName _CreateCreditRequest_QNAME = new QName("http://facade.beans/", "createCreditRequest");
    private final static QName _AddResponse_QNAME = new QName("http://facade.beans/", "addResponse");
    private final static QName _Transfer_QNAME = new QName("http://facade.beans/", "transfer");
    private final static QName _Add_QNAME = new QName("http://facade.beans/", "add");
    private final static QName _WithdrawSavingsAccount_QNAME = new QName("http://facade.beans/", "withdrawSavingsAccount");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: WS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Transfer }
     * 
     */
    public Transfer createTransfer() {
        return new Transfer();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link CreateCreditRequest }
     * 
     */
    public CreateCreditRequest createCreateCreditRequest() {
        return new CreateCreditRequest();
    }

    /**
     * Create an instance of {@link WithdrawSavingsAccount }
     * 
     */
    public WithdrawSavingsAccount createWithdrawSavingsAccount() {
        return new WithdrawSavingsAccount();
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link PurchaseOnCreditCardResponse }
     * 
     */
    public PurchaseOnCreditCardResponse createPurchaseOnCreditCardResponse() {
        return new PurchaseOnCreditCardResponse();
    }

    /**
     * Create an instance of {@link TransferResponse }
     * 
     */
    public TransferResponse createTransferResponse() {
        return new TransferResponse();
    }

    /**
     * Create an instance of {@link PaybackCreditCard }
     * 
     */
    public PaybackCreditCard createPaybackCreditCard() {
        return new PaybackCreditCard();
    }

    /**
     * Create an instance of {@link GetSavingsBalanceResponse }
     * 
     */
    public GetSavingsBalanceResponse createGetSavingsBalanceResponse() {
        return new GetSavingsBalanceResponse();
    }

    /**
     * Create an instance of {@link PurchaseOnCreditCard }
     * 
     */
    public PurchaseOnCreditCard createPurchaseOnCreditCard() {
        return new PurchaseOnCreditCard();
    }

    /**
     * Create an instance of {@link CreateCreditRequestResponse }
     * 
     */
    public CreateCreditRequestResponse createCreateCreditRequestResponse() {
        return new CreateCreditRequestResponse();
    }

    /**
     * Create an instance of {@link WithdrawSavingsAccountResponse }
     * 
     */
    public WithdrawSavingsAccountResponse createWithdrawSavingsAccountResponse() {
        return new WithdrawSavingsAccountResponse();
    }

    /**
     * Create an instance of {@link DepositSavingsAccountResponse }
     * 
     */
    public DepositSavingsAccountResponse createDepositSavingsAccountResponse() {
        return new DepositSavingsAccountResponse();
    }

    /**
     * Create an instance of {@link DepositSavingsAccount }
     * 
     */
    public DepositSavingsAccount createDepositSavingsAccount() {
        return new DepositSavingsAccount();
    }

    /**
     * Create an instance of {@link PaybackCreditCardResponse }
     * 
     */
    public PaybackCreditCardResponse createPaybackCreditCardResponse() {
        return new PaybackCreditCardResponse();
    }

    /**
     * Create an instance of {@link GetSavingsBalance }
     * 
     */
    public GetSavingsBalance createGetSavingsBalance() {
        return new GetSavingsBalance();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCreditRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "createCreditRequestResponse")
    public JAXBElement<CreateCreditRequestResponse> createCreateCreditRequestResponse(CreateCreditRequestResponse value) {
        return new JAXBElement<CreateCreditRequestResponse>(_CreateCreditRequestResponse_QNAME, CreateCreditRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSavingsBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "getSavingsBalanceResponse")
    public JAXBElement<GetSavingsBalanceResponse> createGetSavingsBalanceResponse(GetSavingsBalanceResponse value) {
        return new JAXBElement<GetSavingsBalanceResponse>(_GetSavingsBalanceResponse_QNAME, GetSavingsBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseOnCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "purchaseOnCreditCard")
    public JAXBElement<PurchaseOnCreditCard> createPurchaseOnCreditCard(PurchaseOnCreditCard value) {
        return new JAXBElement<PurchaseOnCreditCard>(_PurchaseOnCreditCard_QNAME, PurchaseOnCreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaybackCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "paybackCreditCard")
    public JAXBElement<PaybackCreditCard> createPaybackCreditCard(PaybackCreditCard value) {
        return new JAXBElement<PaybackCreditCard>(_PaybackCreditCard_QNAME, PaybackCreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "transferResponse")
    public JAXBElement<TransferResponse> createTransferResponse(TransferResponse value) {
        return new JAXBElement<TransferResponse>(_TransferResponse_QNAME, TransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseOnCreditCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "purchaseOnCreditCardResponse")
    public JAXBElement<PurchaseOnCreditCardResponse> createPurchaseOnCreditCardResponse(PurchaseOnCreditCardResponse value) {
        return new JAXBElement<PurchaseOnCreditCardResponse>(_PurchaseOnCreditCardResponse_QNAME, PurchaseOnCreditCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSavingsBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "getSavingsBalance")
    public JAXBElement<GetSavingsBalance> createGetSavingsBalance(GetSavingsBalance value) {
        return new JAXBElement<GetSavingsBalance>(_GetSavingsBalance_QNAME, GetSavingsBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaybackCreditCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "paybackCreditCardResponse")
    public JAXBElement<PaybackCreditCardResponse> createPaybackCreditCardResponse(PaybackCreditCardResponse value) {
        return new JAXBElement<PaybackCreditCardResponse>(_PaybackCreditCardResponse_QNAME, PaybackCreditCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositSavingsAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "depositSavingsAccount")
    public JAXBElement<DepositSavingsAccount> createDepositSavingsAccount(DepositSavingsAccount value) {
        return new JAXBElement<DepositSavingsAccount>(_DepositSavingsAccount_QNAME, DepositSavingsAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositSavingsAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "depositSavingsAccountResponse")
    public JAXBElement<DepositSavingsAccountResponse> createDepositSavingsAccountResponse(DepositSavingsAccountResponse value) {
        return new JAXBElement<DepositSavingsAccountResponse>(_DepositSavingsAccountResponse_QNAME, DepositSavingsAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawSavingsAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "withdrawSavingsAccountResponse")
    public JAXBElement<WithdrawSavingsAccountResponse> createWithdrawSavingsAccountResponse(WithdrawSavingsAccountResponse value) {
        return new JAXBElement<WithdrawSavingsAccountResponse>(_WithdrawSavingsAccountResponse_QNAME, WithdrawSavingsAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCreditRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "createCreditRequest")
    public JAXBElement<CreateCreditRequest> createCreateCreditRequest(CreateCreditRequest value) {
        return new JAXBElement<CreateCreditRequest>(_CreateCreditRequest_QNAME, CreateCreditRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "transfer")
    public JAXBElement<Transfer> createTransfer(Transfer value) {
        return new JAXBElement<Transfer>(_Transfer_QNAME, Transfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<Add>(_Add_QNAME, Add.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawSavingsAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.beans/", name = "withdrawSavingsAccount")
    public JAXBElement<WithdrawSavingsAccount> createWithdrawSavingsAccount(WithdrawSavingsAccount value) {
        return new JAXBElement<WithdrawSavingsAccount>(_WithdrawSavingsAccount_QNAME, WithdrawSavingsAccount.class, null, value);
    }

}
