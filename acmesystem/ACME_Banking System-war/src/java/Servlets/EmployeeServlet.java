/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dto.employeeDTO;
import facade.EmployeeFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import secure.Encrypt;

/**
 *
 * @author wayne
 */
public class EmployeeServlet extends HttpServlet {

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
            out.println("<title>Servlet EmployeeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);




        PrintWriter out;


        if(request.getParameter("ServFunc")!=null && request.getParameter("ServFunc").compareToIgnoreCase("CreateHomeLoan")==0 )
        {
             response.getOutputStream().println("Attempting to Create Home Loan Account");
            
//            response.getOutputStream().println("Cust num is: " + request.getParameter("cust_id"));
//            
//          response.getOutputStream().println("Home Loan Acc num is: " + request.getParameter("accnum"));

          
          Double bal = Double.parseDouble(request.getParameter("bal"));
          
         String result = employeeSessionBean.createHomeLoanAccount(request.getParameter("cust_id"), request.getParameter("accnum"), bal);
         
         response.getOutputStream().println(result);
         
        }

//          // If creating Employee
        if (request.getParameter("AccType") != null && request.getParameter("AccType").compareToIgnoreCase("Employee") == 0) {
            // String createEmployee(String empNum, String lastName, String firstName, Date dob, String address) {
            String EmpNum = request.getParameter("EmpNum");
            String LastName = request.getParameter("LastName");
            String FirstName = request.getParameter("FirstName");
            Date DOB = null;
            String Address = request.getParameter("Address");
            String password = Encrypt.encryptPassword(request.getParameter("Password"));

            try {
                //Parse from String to DOB
                DOB = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH).parse(request.getParameter("DOB"));
            } catch (ParseException ex) {
                Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }


            employeeSessionBean.createEmployee(EmpNum, LastName, FirstName, DOB, Address, password);
            out = response.getWriter();
            try {

                out.println("");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet EmployeeServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Successfully created Employee</p>");
                out.println("<a href=\"./EmployeePortal/EmployeeManagement.jsp\">Return to EmployeeManagement Page</a>");
                out.println("</body>");
                out.println("</html>");

            } finally {
                out.close();
            }
        }



        if (request.getParameter("ServFunc") != null && request.getParameter("ServFunc").compareToIgnoreCase("display") == 0 && request.getParameter("AccType") != null && request.getParameter("AccType").compareToIgnoreCase("Employee") == 0) {


            //Display Employees
            List<employeeDTO> empList;
            empList = employeeSessionBean.getAllEmployees();
            System.out.println(empList);
            out = response.getWriter();
            try {

//            out.println("");

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Employees</title>");
                out.println("</head>");
                String str = "";
                str += ("<body>");
//            str+=("<p>List of Employees</p>");

                str += ("<table border=\"1\">");
                str += ("<thead><tr>\n"
                        + "                            <th></th>\n"
                        + "                            <th>Employee Num</th>\n"
                        + "                            <th>First Name</th>\n"
                        + "                            <th>Last Name</th>\n"
                        + "                            <th>Address</th>\n"
                        + "                            <th>DOB</th>\n"
                        + "                            \n"
                        + "                        </tr>\n"
                        + "                    </thead>\n"
                        + "                    <tbody>");

                for (employeeDTO dTO : empList) {
                    str += ("<tr>");
                    str += ("<td>" + dTO.getEmpNum());
                    str += ("<td>" + dTO.getFirstName());
                    str += ("<td>" + dTO.getLastName());
                    str += ("<td>" + dTO.getAddress());
                    str += ("<td>" + dTO.getDob());
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
//                request.setAttribute("employeeList", str);
//                request.getRequestDispatcher("ACME_Banking_System-war/EmployeePortal/EmployeeManagement.jsp").forward(request, response);






//            

                out.println("</body>");
                out.println("</html>");

            } finally {
                out.close();
            }

        }










        // If creating Customer
        if (request.getParameter("AccType")!= null && request.getParameter("AccType").compareToIgnoreCase("Customer") == 0) {
       // if (session.getAttribute("cust_func").compareToIgnoreCase("create") == 0) {

//            <input type="hidden" name="c_num" value="" />
//                    <input type="hidden" name="l_name" value="" />
//                    <input type="hidden" name="f_name" value="" />
//                    <input type="hidden" name="dob" value="" />
//                    <input type="hidden" name="add" value="" />
//                    <input type="hidden" name="pass" value="" />
//                    <input type="hidden" name="curr_job" value="" />
//                    <input type="hidden" name="spy" value="" />
//                    <input type="hidden" name="pref_contact" value="" />

            String CustNum = request.getParameter("c_num");
            String LastName = request.getParameter("l_name");
            String FirstName = request.getParameter("f_name");
            Date DOB = null;
            String Address = request.getParameter("add");
            String Password = Encrypt.encryptPassword(request.getParameter("pass"));
            String CurrJob = request.getParameter("curr_job");
            String SPY = request.getParameter("spy");
            String PrefContact = request.getParameter("pref_contact");


            try {
                //Parse from String to DOB
                DOB = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH).parse(request.getParameter("dob"));
            } catch (ParseException ex) {
                Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Create Customer with Essential Details
            employeeSessionBean.addCustomerBasics(CustNum, LastName, FirstName, DOB, Address, Password);
            employeeSessionBean.addCustDetails(CurrJob, SPY);
            employeeSessionBean.addCustFinalDetails(PrefContact);

            employeeSessionBean.commit();

            out = response.getWriter();
            try {

                out.println("");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet EmployeeServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Successfully created Customer</p>");
                out.println("<a href=\"./EmployeePortal/CustomerManagement.jsp\">Return to Customer Management Page</a>");
                out.println("</body>");
                out.println("</html>");

            } finally {
                out.close();
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
