/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
public class DisplayAllServlet extends HttpServlet {

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
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);      






        PrintWriter out = null;
        out = response.getWriter();

        //Display Employees
        List<employeeDTO> empList;
        empList = employeeSessionBean.getAllEmployees();
        
        if(empList==null)
        {
            out.println("<p>No Employees</p>");
        }

        
        try {



            out.println("<html>");
            out.println("<head>");
            out.println("<title>Employees</title>");
            out.println("</head>");
            String str = "";
            str += ("<body>");
//            str+=("<p>List of Employees</p>");

            str += ("<table border=\"1\">");
            str += ("<thead>\n"
                    + "                            <th>Employee Num</th>\n"
                    + "                            <th>First Name</th>\n"
                    + "                            <th>Last Name</th>\n"
                    + "                            <th>Address</th>\n"
                    + "                            <th>DOB</th>\n"
                    + "<th>Kick Out</th>\n"
                    + "                            \n"
                    + "                        </tr>\n"
                    + "                    </thead>\n"
                    + "                    <tbody>");

            for (employeeDTO dTO : empList) {
                str += ("<tr>");
                str +=
                        str += ("<td>" + dTO.getEmpNum());
                str += ("<td>" + dTO.getFirstName());
                str += ("<td>" + dTO.getLastName());
                str += ("<td>" + dTO.getAddress());
                str += ("<td>" + dTO.getDob());
                str += ("<td><a href=DisplayAllServlet?action=remove&employee_id=" + dTO.getEmpNum() + ">Kick Out</td>");
                str += ("</tr>");
            }
//                        for(int i=0; i<empList.size();i++)
//        {
//            str+=("<tr>");
//            str+=("<td>"+ ((employeeDTO)(empList.get(i))).getEmpNum());
//            str+=("<td>"+ empList.get(i).getFirstName());
//            str+=("<td>"+ empList.get(i).getLastName());
//            str+=("<td>"+ empList.get(i).getAddress());
//            str+=("<td>"+ empList.get(i).getDob());
//            str+=("</tr>");
            out.println(str);
            //request.setAttribute("employeeList", str);
            //request.getRequestDispatcher("EmployeeManagement.jsp").forward(request, response);






//            

            out.println("</tbody></table></body>");
            out.println("</html>");

        } finally {
            out.close();
        }


        if (request.getParameter("action").equals("remove")) {
            employeeSessionBean.removeEmployee(request.getParameter("employee_id"));
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
