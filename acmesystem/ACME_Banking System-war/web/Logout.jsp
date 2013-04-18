<%-- 
    Document   : Logout
    Created on : 05/10/2012, 10:50:28 AM
    Author     : wayne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
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
                    String myname = (String) session.getAttribute("username");

                    if (myname != null) {
                        out.println("User " + myname + " successfully loged out.");
                        out.println(" <a href=\"index.jsp\">Proceed to HomePage</a>");
                        session.removeAttribute("username");
                       session.invalidate();
                        
                        
                        
                    } else {
                        out.println("You are not logged in.");
                        out.println(" <a href=\"index.jsp\">Proceed to HomePage</a>");

                    }

                %>



            </div> <!--End of main body content div-->

            <div class="footer">

            </div>


        </div>  <!-- End of page div -->

    </body>

</html>
