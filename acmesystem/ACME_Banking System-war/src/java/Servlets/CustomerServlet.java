/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import WS.B2B;
import facade.CustomerFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author wayne
 */
public class CustomerServlet extends HttpServlet
{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/B2B/CustomerFacade.wsdl")
    private B2B service;
    
     @EJB
    private CustomerFacadeRemote customerSessionBean;
    
    
     
     
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerServlet at " + request.getContextPath() + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
        
                    response.getOutputStream().println("Right now, just calling the add function for testing: " + add(2, 5)); 

    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        String result;
        //Determine what you want the Servlet to do
        if(request.getParameter("ServFunc")!= null && request.getParameter("ServFunc").compareToIgnoreCase("B2BTransfer")==0 )
        {
            response.getOutputStream().println("Attempting to Conduct B2B Transfer");
            response.getOutputStream().println("Right now, just calling the add function for testing: " + customerSessionBean.add(2, 5)); 
            
        }
        else  if( request.getParameter("ServFunc")!= null && request.getParameter("ServFunc").compareToIgnoreCase("CreateHomeLoan")==0 )
        {
           
            
            
            //customerSessionBean.borrowHomeLoanAccount(request.getParameter("cust_id"), acc_num);
            
           // response.getOutputStream().println("Right now, just calling the add function for testing: " + customerSessionBean.add(2, 5)); 
            
        }
       else if(request.getParameter("ServFunc")!= null && request.getParameter("ServFunc").compareToIgnoreCase("LocalTransfer")==0 )
        {
           
                Double Amount = Double.parseDouble(request.getParameter("amt"));
  
             result = customerSessionBean.transfer(request.getParameter("fromAccNum"), request.getParameter("toAccNum"), Amount);
            
            response.getOutputStream().println(result);
            
        }
        
         else if(request.getParameter("ServFunc")!= null && request.getParameter("ServFunc").compareToIgnoreCase("RequestCreditInc")==0 )
        {
       
                Double NewLimit = Double.parseDouble(request.getParameter("new_cred_lim"));

           result = customerSessionBean.createCreditRequest(request.getParameter("AccNum"), NewLimit);
            response.getOutputStream().println(result);
        }
         else if(request.getParameter("ServFunc")!= null && request.getParameter("ServFunc").compareToIgnoreCase("RepayHomeLoan")==0 )
        {
                //String cID = (String)request.getSession().getAttribute("username");
                String accNum = request.getParameter("accnum");
                
                Double amount = Double.parseDouble(request.getParameter("amt"));

           result = customerSessionBean.repayHomeLoan(accNum, amount);
            response.getOutputStream().println(result);
        }
    
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private double add(double num1, double num2) {
        WS.CustomerFacade port = service.getCustomerFacadePort();
        return port.add(num1, num2);
    }
}
