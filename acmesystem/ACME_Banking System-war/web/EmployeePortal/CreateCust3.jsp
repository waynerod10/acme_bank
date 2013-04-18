<%-- 
    Document   : CreateCust3
    Created on : 09/10/2012, 4:43:16 PM
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
                <h2>Page 3 - Customer Employment Details</h2>
                
                <%
                     
//                     session.setAttribute("cust_num", request.getParameter("CustNum"));
//                     session.setAttribute("cust_l_name", request.getParameter("LastName"));
//                     session.setAttribute("cust_f_name", request.getParameter("FirstName"));
//                     session.setAttribute("cust_dob", request.getParameter("DOB"));
//                     session.setAttribute("cust_add", request.getParameter("Address"));
//                     session.setAttribute("cust_pass", request.getParameter("Password"));
//    
                
                session.setAttribute("cust_curr_job", request.getParameter("CurrJob"));
                session.setAttribute("cust_spy", request.getParameter("SPY"));
                
                
               // out.println("Cust Num via POST: " + request.getParameter("CustNum"));
                //out.println("Cust Num via Session: " + session.getAttribute("cust_num"));

                %>
                
                <form action="/ACME_Banking_System-war/EmployeePortal/CreateCust4.jsp" method="POST" onsubmit="<% session.removeAttribute("user_selection");%>"> 
                   
                    <input type="radio" name="contact" value="email" /> Email <input type="text" name="email" value="" /><br/>
                    <input type="radio" name="contact" value="phone" /> Phone <input type="text" name="phone" value="" /><br/>
                    <input type="radio" name="contact" value="mail" checked ="checked"/> Mail<br/><br/>
                    <div><input type="SUBMIT" /> </div>
                </form> 

            </div> <!--End of main body content div-->

        </div>  <!-- End of page div -->                
    </body>
</html>

<%
                    } //End of Check Login
%>