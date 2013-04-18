<%-- 
    Document   : checkLogin
    Created on : 27/09/2012, 12:07:01 PM
    Author     : wayne
--%>

<%@page import="secure.Encrypt"%>
<%@page import="facade.SystemFacadeRemote"%>

<%

    //Check if username and password is correct
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    out.println("Checking login...<br/><br/>");
    if (username == null || username =="" || password == null)
    {

        out.print("Error: Username and password cannot be blank!<br/>");
        out.print("Please <a href=\"Login.jsp\">Try Again</a>");
    } else {
        // Here you put the check on the username and password DEPENDING ON WHAT IT STARTS WITH 'E' or 'C'
        // E or C decides the redirect to portal
        
        password = Encrypt.encryptPassword(password);
        
        if (username.toLowerCase().startsWith("e")) {
            // Validate username and password
            out.println("Welcome " + username + " <a href=\"EmployeePortal.jsp\">Proceed to Employee Portal</a>");
            //out.println("Your password is " + password);  
            
            
             
            session.setAttribute("username", username);
        } else if (username.toLowerCase().startsWith("c")){
            out.println("Welcome " + username + " <a href=\"CustomerPortal.jsp\">Proceed to Customer Portal</a>");
            session.setAttribute("username", username);
        }
    }




%>