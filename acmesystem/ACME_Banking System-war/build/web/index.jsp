<%-- 
    Document   : Home
    Created on : 28/09/2012, 11:17:44 AM
    Author     : wayne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <!--CSS file link-->
        <link rel="stylesheet" type="text/css" href="Common/Common.css" />
    </head>

    <body>
<div class="page"> <!--The whole page as one class -->
            <div class="header">
                <h1>ACME Bank</h1>
            </div>
    
            <div class="navBar">
                <jsp:include page="./Common/Navigation.jsp"/>
            </div>
            
            <div class="content"> <!--Main Body Content-->
                <p>Welcome to ACME Bank!</p>
            </div> <!--End of main body content div-->
    
   </div>  <!-- End of page div -->                
    </body>
</html>
