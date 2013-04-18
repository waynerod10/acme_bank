/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dto.AccountDTO;
import dto.CreditCardDTO;
import dto.CustomerDTO;
import dto.HomeLoanDTO;
import dto.SavingsDTO;
import facade.CustomerFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wayne
 */
public class DispCustAccServlet extends HttpServlet {

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
            out.println("<title>Servlet DispCustAccServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DispCustAccServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

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



        //PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        //Display Employees
        List<AccountDTO> custList;

        custList = customerSessionBean.getAllAccounts((String) session.getAttribute("username"));

        if (custList == null) {
            response.getOutputStream().println("No accounts");

        } else {
            
            for (AccountDTO a : custList) {
                if(a instanceof SavingsDTO)
                {   
                    
                   response.getOutputStream().println("Account Number: " + a.getAccNum()
                           + "\nBalance: " + ((SavingsDTO)a).getBalance() + 
                           "\n Active: " + ((SavingsDTO)a).isActive());
                }
                
                if(a instanceof CreditCardDTO)
                {   
                    
                   response.getOutputStream().println("Account Number: " + a.getAccNum()
                           + "\nCredit Card Number: " + ((CreditCardDTO)a).getCCNum() + 
                           "\n Credit Limit: " + ((CreditCardDTO)a).getCreditLmit() +
                           "\n Credit : " + ((CreditCardDTO)a).getCredit());
                           
                }
                
                if(a instanceof HomeLoanDTO)
                {   
                    
                   response.getOutputStream().println("Account Number: " + a.getAccNum()
                           + "\nAmount Borrowed : " + ((HomeLoanDTO)a).getAmountBorrowed()
                           + "\nAmount Repayed: " + ((HomeLoanDTO)a).getAmountRepayed()  
                           );
                }
                
                response.getOutputStream().println("\n\n");
            }
            
        }
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
            throws ServletException, IOException {
        //processRequest(request, response);
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
}
