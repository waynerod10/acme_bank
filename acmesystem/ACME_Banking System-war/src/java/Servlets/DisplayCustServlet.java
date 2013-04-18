/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import dto.CustomerDTO;
import dto.employeeDTO;
import facade.EmployeeFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wayne
 */
public class DisplayCustServlet extends HttpServlet {
    
     @EJB
    private EmployeeFacadeRemote employeeSessionBean;

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
            out.println("<title>Servlet DisplayCustServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayCustServlet at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException
    {
        //processRequest(request, response);
        
         PrintWriter out = response.getWriter();

       
        //Display Employees
        List<CustomerDTO> custList;
        custList = employeeSessionBean.getAllCustomers();
        
        if(custList==null)
        {
            out.println("<p>No Employees</p>");
        }
     
         try {
//
//
//
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Customers</title>");
            out.println("</head>");
            String str = "";
            str += ("<body><table border=\"1\">");
//

           
            str += ("<thead><tr>\n"
                    + "                            <th>Customer Num</th>\n"
                    + "                            <th>First Name</th>\n"
                    + "                            <th>Last Name</th>\n"
                    + "                            <th>Address</th>\n"
                    + "                            <th>DOB</th>\n"
                    + "                            <th>Current Job</th>\n"
                    + "                            <th>Salary Per Year</th>\n"
                    + "                            <th>Preferred Contact</th>\n"
                    + "<th>Kick Out</th>"
                    + "                            \n"
                    + "                        </tr>\n"
                    + "                    </thead>\n"
                    + "                    <tbody>");

           for (CustomerDTO dTO :  custList) {
                str += ("<tr>");
                str +=
                        str += ("<td>" + dTO.getcId()+"</td>");
                str += ("<td>" + dTO.getFirstName()+"</td>");
                str += ("<td>" + dTO.getLastName()+"</td>");
                str += ("<td>" + dTO.getAddress()+"</td>");
                str += ("<td>" + dTO.getDob()+"</td>");
                str += ("<td>" + dTO.getCurrJob()+"</td>");
                str += ("<td>" + dTO.getSalaryPY()+"</td>");
                str += ("<td>" + dTO.getPrefContact()+"</td>");
                str += ("<td><a href=DisplayAllServlet?action=remove&cust_id=" + dTO.getcId() + ">Kick Out</td>");
                str += ("</tr>");
            }

            out.println(str);

            out.println("</body>");
            out.println("</html>");
             
             //out.println("<p></p>")
//
        }
        finally
        {
            out.close();
        }


        if (request.getParameter("action").equals("remove")) {
            employeeSessionBean.removeEmployee(request.getParameter("cust_id"));
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
        processRequest(request, response);
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
