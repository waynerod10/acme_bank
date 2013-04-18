<%-- 
    Document   : login
    Created on : 27/09/2012, 11:47:53 AM
    Author     : wayne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
                
                
                <% 
  
                
                //Username if exists and logged in
                String myname =  (String)session.getAttribute("username");
                
                if(myname!=null)
                {
                 out.println("Welcome   " + myname);
                }
                else
                {
                
                %>
                
                <form id="login_form" method="post" action="SystemServlet">
                    <div><span class="label">Username:</span><input class="regInput" name="username" type="text" value="" id="username" /></div>
                    <div><span class="label">Password:</span><input class="regInput" name="password" type="password" value="" id="password1"/></div>
                    <div><input class="regInput" id="login_submit" name="submitBtn" type="submit" value="Submit"/></div>
		</form>
                
                <% 
                 }
                %>
                
            </div> <!--End of main body content div-->
            
            <div class="footer">
				
            </div>
            
            
        </div>  <!-- End of page div -->
        
    </body>
    
</html>
