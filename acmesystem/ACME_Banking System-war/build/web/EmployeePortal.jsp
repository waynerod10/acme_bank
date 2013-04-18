<%-- 
    Document   : index
    Created on : 27/07/2012, 11:56:28 AM
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
                        out.println("<p><a href=\"Login.jsp\">Proceed to Login Page</a></p>");
                      
                        
                        
                        
                    }
                      else if(!myname.toLowerCase().startsWith("e"))
                    {
                        out.println(" <p>Warning: You are not authorised to view the Employee Portal</p>");
                        out.println("<p><a href=\"index.jsp\">Proceed to Home Page</a></p>");

                    }
                 else if (myname!=null && myname.toLowerCase().startsWith("e")) 
                    {
                       

                %>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Portal</title>
        <!--CSS file link-->
        <link rel="stylesheet" type="text/css" href="Common/Common.css" />
    </head>
    <body>
        <div class="page"> <!--The whole page as one class -->
            <div class="header">
                <jsp:include page="./Common/Header.jsp"/>
            </div>

            <div class="navBar">
                <ul class="links">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="./EmployeePortal/CustomerManagement.jsp">Customer Management</a></li>
                   <li><a href="./EmployeePortal/EmployeeManagement.jsp">Employee Management</a></li>
                   <li><a href="Logout.jsp">Logout</a></li>
                    
                    
                </ul>
            </div>

            <div class="content"> <!--Main Body Content-->
                <p>ACME Bank Employee Portal</p>
            </div> <!--End of main body content div-->

        </div>  <!-- End of page div -->                
    </body>
</html>

<%
                    } //End of Check Login
%>
