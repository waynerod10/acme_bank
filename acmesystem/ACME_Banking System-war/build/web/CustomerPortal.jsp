<%-- 
    Document   : CustomerPortal
    Created on : 05/10/2012, 10:41:25 AM
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
                    else if(!myname.toLowerCase().startsWith("c"))
                    {
                        out.println(" <p>Warning: You are not authorised to view the Customer Portal</p>");
                        out.println("<p><a href=\"index.jsp\">Proceed to Home Page</a></p>");

                    }
                 else if (myname!=null && myname.toLowerCase().startsWith("c")) 
                    {
                       

                %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Portal</title>
        <!--CSS file link-->
        <link rel="stylesheet" type="text/css" href="Common/CustomerPortal.css" />
    </head>

    <body>
        <div class="page"> <!--The whole page as one class -->
            <div class="header">
                <jsp:include page="./Common/Header.jsp"/>
            </div>

            <div class="navBar">
                <ul class="links">
                    <li><a href="index.jsp">Home</a></li>
                    
                    
                </ul>
            </div>

            <div class="content"> <!--Main Body Content-->
                <p>ACME Bank Customer Portal</p>
                
                <ul class="links">
                    <li><a href="CustomerPortal/HomeLoan.jsp">Repay a Home Loan Account</a></li>
                    <li><a href="DispCustAccServlet">View all accounts</a></li>
                    <li><a href="CustomerPortal/LocalTransfer.jsp">Transfer Funds internally</a></li>
                    <li><a href="CustomerPortal/B2BTransfer.jsp">Transfer Funds externally</a></li>
                    <li><a href="CustomerPortal/RequestCreditInc.jsp">Request Credit Increase</a></li>
                </ul>
                
                
              
                
            </div> <!--End of main body content div-->

        </div>  <!-- End of page div -->                
    </body>
</html>

<%
                    } //End of Check Login
%>