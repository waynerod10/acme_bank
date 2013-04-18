<%-- 
    Document   : CustomerManagement
    Created on : 05/10/2012, 11:40:05 AM
    Author     : wayne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%

                    //Username if exists and logged in
                    String myname = (String) session.getAttribute("username");

                    if (myname == null)
                    {
                       
                        out.println(" <p>Warning: You are not logged in</p>");
                        out.println("<p><a href=\"../Login.jsp\">Proceed to Login Page</a></p>");
                      
                        
                        
                        
                    }
                      else if(!myname.toLowerCase().startsWith("e"))
                    {
                        out.println(" <p>Warning: You are not authorised to view the Employee Portal</p>");
                        out.println("<p><a href=\"../index.jsp\">Proceed to Home Page</a></p>");

                    }
                 else if (myname!=null && myname.toLowerCase().startsWith("e")) 
                    {
                       

                %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Customer Management</title>
        <!--CSS file link-->
        <link rel="stylesheet" type="text/css" href="../Common/Common.css" />
    </head>
      <body>
        <div class="page"> <!--The whole page as one class -->
            <div class="header">
                <jsp:include page="../Common/Header.jsp"/>
            </div>

            <div class="navBar">
                <ul class="links">
                    <li><a href="../index.jsp">Home</a></li>
                    <li><a href="./CustomerManagement.jsp">Customer Management</a></li>
                   <li><a href="./EmployeeManagement.jsp">Employee Management</a></li>
                    
                    
                </ul>
            </div>

            <div class="content"> <!--Main Body Content-->
                <h1>ACME Bank Employee Portal</h1>
                <h2>Customer Management</h2>

                <%
                    String user_selection = (String) session.getAttribute("user_selection");
                    if (user_selection == null) {
                        session.setAttribute("management_page","CustomerManagement.jsp");

                %>
                <!--<form id="cust_form" method="post" action="../CheckFunction.jsp">
                    Select a function:
                    <select name="emp_func" id="emp_func">
                        <option value="create">Create Customer</option>
                        <option value="remove">Remove Customer</option>
                        <option value="update">Update Customer</option>
                        <option value="display">Display Customer</option>
                    </select>
                    <div>
                          <input type="hidden" name="AccType" value="Customer"/>
                        <input type="hidden" name="ServFunc" value="Display" />
                        <input type="submit" name="enter" value="Submit Form" />
                    </div>
                </form>-->

                <div><ul class="links">
                    <li><a href="CreateCust1.jsp">Create Customer</a></li>
                    <li><a href="../DisplayCustServlet">View Customers</a></li>
                    <li><a href="HomeLoan.jsp">Create Home Loan Account</a></li>
                    
                </ul>
                </div>
                
                <!-- 
                This Form sends itself to CheckFunction.
                CheckFunction will see if there is create customer.
                If so, take it to the multi-page wizard
                -->
                
                 <%
                } else if (user_selection.compareToIgnoreCase("remove") == 0 || user_selection.compareToIgnoreCase("display") == 0 || user_selection.compareToIgnoreCase("update") == 0) {
                    out.println("-- User selected function as: " + user_selection + " --");

                %>
                
                
                <table border="1">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Employee Num</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Address</th>
                            <th>DOB</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td><a href="EmployeeUpdate.jsp">e00001</a></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            
                        </tr>
                        <tr>
                            <td>2</td>
                            <td><a href="EmployeeUpdate.jsp">e00002</a></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            
                        </tr>
                    </tbody>
                </table>

                
                <%
                    }
                %>




            </div> <!--End of main body content div-->

        </div>  <!-- End of page div -->                
    </body>
</html>
<%
                    } //End of Check Login
%>