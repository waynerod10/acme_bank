<%-- 
    Document   : RequestCreditInc
    Created on : 11/10/2012, 9:24:26 PM
    Author     : wayne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Credit Increase</title>
        <!--CSS file link-->
        <link rel="stylesheet" type="text/css" href="../Common/CustomerPortal.css" />
    </head>
    <body>
        <div class="page"> <!--The whole page as one class -->
            <div class="header">
                <jsp:include page="../Common/Header.jsp"/>
            </div>

            <div class="navBar">
                <ul class="links">
                    <li><a href="../index.jsp">Home</a></li>
                    
                    
                </ul>
            </div>

            <div class="content"> <!--Main Body Content-->
                <h1>Request Credit Increase </h1>
                
                 <!--  
                Transfer From P1's Savings to P2's Credit 
                public String transfer(String fromAcctNum, String toAcctNum, double amount)
                
                -->
                
                 <form action="/ACME_Banking_System-war/CustomerServlet" method="POST"> 
                     <div>Account No:<input type="TEXT" name="AccNum"/> </div>
                     <div>New Credit Limit: <input type="TEXT" name="new_cred_lim"/> </div>
                     
                     <!-- Determine what you want the Servlet to do -->
                    <input type="hidden" name="ServFunc" value="RequestCreditInc"/>
                    <input type="SUBMIT" /> 
                </form>          
                
            </div> <!--End of main body content div-->

        </div>  <!-- End of page div -->                
    </body>
</html>
