<%-- 
    Document   : navigation
    Created on : 27/09/2012, 12:50:15 PM
    Author     : wayne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="navH">Site Links:</div>
<ul class="links">
        <li><a href="index.jsp">Home</a></li>

        <% 

        //Username if exists and logged in
        String myname =  (String)session.getAttribute("username");

        
        //If not logged in, show login page
        if(myname==null)
        {
         out.println("<li><a href=\"Login.jsp\">Login</a></li>");
        }
        else
        {
            out.println("<li><a href=\"Logout.jsp\">Logout</a></li>");
        }
        

        %>

        <li><a href="EmployeePortal.jsp">Employee Portal</a></li>
        <li><a href="CustomerPortal.jsp">Customer Portal</a></li>


</ul>
