<%-- 
    Document   : CreateCust2
    Created on : 09/10/2012, 4:36:36 PM
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
                <h2>Page 2 - Customer Employment Details</h2>
                
                <%
                     
                     session.setAttribute("cust_num", request.getParameter("CustNum"));
                     session.setAttribute("cust_l_name", request.getParameter("LastName"));
                     session.setAttribute("cust_f_name", request.getParameter("FirstName"));
                     session.setAttribute("cust_dob", request.getParameter("DOB"));
                     session.setAttribute("cust_add", request.getParameter("Address"));
                     session.setAttribute("cust_pass", request.getParameter("Password"));
    

                %>
                
                <form action="/ACME_Banking_System-war/EmployeePortal/CreateCust3.jsp" method="POST" onsubmit="<% session.removeAttribute("user_selection");%>"> 

                    <div><span>Current Job </span><input type="TEXT" name="CurrJob"/></div>
                    <div><span>Salary Per Year: </span><input type="TEXT" name="SPY"/></div>
                    <div><input type="SUBMIT" /> </div>
                </form> 

            </div> <!--End of main body content div-->

        </div>  <!-- End of page div -->                
    </body>
</html>
<%
                    } //End of Check Login
%>