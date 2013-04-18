<%-- 
    Document   : HomeLoan.jsp
    Created on : 09/10/2012, 8:00:39 PM
    Author     : wayne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Home Loan</title>
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
                    
                    
                </ul>
            </div>

            <div class="content"> <!--Main Body Content-->
                <h1>Repay a Home Loan Account</h1>
                
              
                
                  
                
                 <form action="/ACME_Banking_System-war/CustomerServlet" method="POST"> 
                    <div>Home Loan Account Number:<input type="TEXT" name="accnum"/> </div>
                    <!--<div>Customer ID:<input type="TEXT" name="cust_id"/> </div>-->
                    <div>Amount:<input type="TEXT" name="amt"/> </div>
                     <!-- Determine what you want the Servlet to do -->
                    <input type="hidden" name="ServFunc" value="RepayHomeLoan"/>
                    <input type="hidden" name="session_cust_id" value="<% String session_cust_id = (String)session.getAttribute("username");%>">
                    
                    <input type="SUBMIT" /> 
                </form>  
                

                
                
                
                
            </div> <!--End of main body content div-->

        </div>  <!-- End of page div -->                
    </body>
</html>
