<%-- 
    Document   : EmployeeManagement
    Created on : 05/10/2012, 11:33:28 AM
    Author     : wayne
--%>

<%@page import="dto.employeeDTO"%>
<%@page import="facade.EmployeeFacadeRemote"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Employee Management</title>
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
                <h2>Employee Management</h2>

                <%
                    String user_selection = (String) session.getAttribute("user_selection");
                    if (user_selection == null) {
                        session.setAttribute("management_page", "EmployeeManagement.jsp");

                %>
                <form id="emp_form" method="post" action="../CheckFunction.jsp">
                    Select a function:
                    <select name="emp_func" id="emp_func">
                        <option value="create">Create Employee</option>
                        <option value="remove">Remove Employee</option>
                        <option value="update">Update Employee</option>
                        <option value="display">Display Employee</option>

                    </select>
                    <input type="hidden" name="AccType" value="Employee"/>
                    <input type="hidden" name="ServFunc" value="Display" />
                    <div>
                        <input type="submit" name="enter" value="Submit Form" />
                    </div>
                </form>

                <%                } else if (user_selection.compareToIgnoreCase("create") == 0) {
                    out.println("-- User selected function as: " + user_selection + " --");
                %>
                <p>Create Employee</p>

                <form action="/ACME_Banking_System-war/EmployeeServlet" method="POST" onsubmit="<% session.removeAttribute("user_selection");%>"> 
                    <!--<form action="/ACME_Banking_20System-war/CustomerServlet" method="POST"> -->
                    <div><span>Employee Number: </span><input type="TEXT" name="EmpNum"/></div>
                    <div><span>Last Name: </span><input type="TEXT" name="LastName"/></div>
                    <div><span>First Name: </span><input type="TEXT" name="FirstName"/></div>
                    <div><span>Date of Birth: </span><input type="TEXT" name="DOB"/></div>
                    <div><span>Address: </span><input type="TEXT" name="Address"/></div>
                    <div><span>Password: </span><input type="password" name="Password"/></div>

                    <!-- Determine whether to create employee or customer account -->
                    <input type="hidden" name="AccType" value="Employee"/>
                    <div><input type="SUBMIT" /> </div>
                </form> 


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