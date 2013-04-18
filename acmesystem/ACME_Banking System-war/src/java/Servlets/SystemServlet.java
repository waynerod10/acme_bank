/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import facade.EmployeeFacadeRemote;
import facade.SystemFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import secure.Encrypt;

/**
 *
 * @author Aks
 */
public class SystemServlet extends HttpServlet {
    
     @EJB
    private SystemFacadeRemote systemSessionBean;

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
            out.println("<title>Servlet SystemServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SystemServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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

// TODO: authenticate passwords and approve credit card increase
        //processRequest(request, response);
        //systemSessionBean.validateCustomer(null, null)
        
        
        //Check if username and password is correct
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    PrintWriter out = response.getWriter();
    String result;
    String redirectURL;
    
    HttpSession session = request.getSession();
    
    out.println("Checking login...<br/><br/>");
    if (username == null || username =="" || password == null)
    {

        out.print("Error: Username and password cannot be blank!<br/>");
        out.print("Please <a href=\"Login.jsp\">Try Again</a>");
    } else {
        // Here you put the check on the username and password DEPENDING ON WHAT IT STARTS WITH 'E' or 'C'
        // E or C decides the redirect to portal
        
        password = Encrypt.encryptPassword(password);
        
        if (username.toLowerCase().startsWith("e")) {
            // Validate username and password
            
            //out.println("Your password is " + password);  
            
            
           result = systemSessionBean.validateEmployee(username, password);
            
           if(result.equals("Error"))
           {
               out.println(result);  
           }
          else
           {
                out.println("Welcome " + username + " <a href=\"EmployeePortal.jsp\">Proceed to Employee Portal</a>");
                redirectURL = "EmployeePortal.jsp";
               session.setAttribute("username", username);
               response.sendRedirect(redirectURL);
           }
           
           
           
           
           // 
        } else if (username.toLowerCase().startsWith("c")){
           
            
            
            result = systemSessionBean.validateCustomer(username, password);
            
          if(result.equals("Error"))
           {
               out.println(result);  
           }
          else
           {
                out.println("Welcome " + username + " <a href=\"CustomerPortal.jsp\">Proceed to Customer Portal</a>");
                redirectURL = "CustomerPortal.jsp";
                session.setAttribute("username", username);
                
               response.sendRedirect(redirectURL);
               
           }
            //session.setAttribute("username", username);
           
        }
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
}
