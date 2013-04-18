<%-- 
    Document   : EmployeeUpdate
    Created on : 09/10/2012, 7:25:54 PM
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
        <title>Home Page</title>
        <!--CSS file link-->
        <link rel="stylesheet" type="text/css" href="../Common/Common.css" />
    </head>

    <body>
<div class="page"> <!--The whole page as one class -->
            <div class="header">
                <h1>ACME Bank</h1>
            </div>
    
            <div class="navBar">
                <ul class="links">
                    <li><a href="../index.jsp">Home</a></li>
                    <li><a href="./CustomerManagement.jsp">Customer Management</a></li>
                    <li><a href="./EmployeeManagement.jsp">Employee Management</a></li>


                </ul>
            </div>
            
            <div class="content"> <!--Main Body Content-->
                
                
                <h1>Update or Delete Employee</h1>
                
                
                <p>Operation selected:
                <%
                String user_selection = (String)session.getAttribute("user_selection");
                
                out.println(user_selection);
                
                
                
                %>
                </p>
                
                
                
                
                
                
            </div> <!--End of main body content div-->
    
   </div>  <!-- End of page div -->                
    </body>
</html>

<%
                    } //End of Check Login
%>