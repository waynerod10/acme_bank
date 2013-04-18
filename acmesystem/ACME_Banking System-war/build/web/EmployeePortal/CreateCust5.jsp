<%-- 
    Document   : CreateCust5
    Created on : 09/10/2012, 4:43:45 PM
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
                <h2>Page 5 - Finalising Customer Creation</h2>
                
                <%
                    if(request.getParameter("agree").compareToIgnoreCase("no")==0)
                                               {
                        out.println("You need to agree to our terms to create an employee<br/>");
                        out.println("Since you have chose not to agree, the process has been cancelled");
                %>
                
                <a href="/ACME_Banking_System-war/EmployeePortal/CustomerManagement.jsp">Back to Customer Management Page</a>
                
                
                <%
                        
                    }
                    else
                                               {
                %>
                
                <p>Please Confirm Your Details</p>
                <%
                  
                       out.println("Agreed Value:" + (String)session.getAttribute("cust_agree") );

                %>
                
                
                <p>Customer Number: <% out.println((String)session.getAttribute("cust_num"));%><br/>
                Last Name: <% out.println((String)session.getAttribute("cust_l_name"));%><br/>
                First Name: <% out.println((String)session.getAttribute("cust_f_name"));%><br/>
                DOB: <% out.println((String)session.getAttribute("cust_dob"));%><br/>
                Address: <% out.println((String)session.getAttribute("cust_add"));%><br/>
                <!--Password: <% out.println((String)session.getAttribute("cust_pass"));%><br/>-->
                Current Job: <% out.println((String)session.getAttribute("cust_curr_job"));%><br/>
                Salary Per Year: <% out.println((String)session.getAttribute("cust_spy"));%><br/>
                Preferred Contact: <% out.println((String)session.getAttribute("cust_pref_contact"));%></p>
              
                
                <form action="/ACME_Banking_System-war/EmployeeServlet" method="POST" onsubmit="<% session.removeAttribute("user_selection"); session.setAttribute("cust_func","create");%>"> 
                     <!-- Determine whether to create employee or customer account -->
                    <input type="hidden" name="AccType" value="Customer"/>
                    
                    <input type="hidden" name="c_num" value="<% out.println((String)session.getAttribute("cust_num"));%>" />
                    <input type="hidden" name="l_name" value="<% out.println((String)session.getAttribute("cust_l_name"));%>" />
                    <input type="hidden" name="f_name" value="<% out.println((String)session.getAttribute("cust_f_name"));%>" />
                    <input type="hidden" name="dob" value="<% out.println((String)session.getAttribute("cust_dob"));%>" />
                    <input type="hidden" name="add" value="<% out.println((String)session.getAttribute("cust_add"));%>" />
                    <input type="hidden" name="pass" value="<% out.println((String)session.getAttribute("cust_pass"));%>" />
                    <input type="hidden" name="curr_job" value="<% out.println((String)session.getAttribute("cust_curr_job"));%>" />
                    <input type="hidden" name="spy" value="<% out.println((String)session.getAttribute("cust_spy"));%>" />
                    <input type="hidden" name="pref_contact" value="<% out.println((String)session.getAttribute("cust_pref_contact"));%>" />
                    
                      <input type="hidden" name="AccType" value="Customer"/>
                     
                    <div><input type="SUBMIT" value="Confirm"/></div>
                </form> 
                
                
                <%
                               }
                %>

            </div> <!--End of main body content div-->

        </div>  <!-- End of page div -->                
    </body>
</html>

<%
                    } //End of Check Login
%>