<%-- 
    Document   : CreateCust1
    Created on : 09/10/2012, 4:28:01 PM
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
                <h1>Customer Creation Wizard</h1>
                <h2>Page 1 - Customer Personal Details</h2>
                
                
                
                <form action="/ACME_Banking_System-war/EmployeePortal/CreateCust2.jsp" method="POST" onsubmit="<% session.removeAttribute("user_selection");%>"> 
                    
                    <div><span>Customer Number: </span><input type="TEXT" name="CustNum"/></div>
                    <div><span>Last Name: </span><input type="TEXT" name="LastName"/></div>
                    <div><span>First Name: </span><input type="TEXT" name="FirstName"/></div>
                    <div><span>Date of Birth: </span><input type="TEXT" name="DOB"/></div>
                    <div><span>Address: </span><input type="TEXT" name="Address"/></div>
                    <div><span>Password: </span><input type="password" name="Password"/></div>
                    <div><input type="SUBMIT" /> </div>
                </form> 

            </div> <!--End of main body content div-->

        </div>  <!-- End of page div -->                
    </body>
</html>

<%
                    } //End of Check Login
%>