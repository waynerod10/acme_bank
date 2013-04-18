<%-- 
    Document   : CheckFunction
    Created on : 05/10/2012, 11:59:40 AM
    Author     : wayne
--%>

<%

    //Check if username and password is correct

    String redirectURL;
    String user_selection = request.getParameter("emp_func");
    String managementPage = (String)session.getAttribute("management_page");
    
    session.setAttribute("user_selection", user_selection);
   
    if(user_selection.compareToIgnoreCase("create")==0 && managementPage.compareToIgnoreCase("CustomerManagement.jsp")==0)
    {
        // If Creating a new Customer, take it through the wizard
        redirectURL = "./EmployeePortal/CreateCust1.jsp";
    }
    
//     <input type="hidden" name="AccType" value="Employee"/>
//                    <input type="hidden" name="ServFunc" value="Display" />
                    
  else if(user_selection.compareToIgnoreCase("create")==0 && managementPage.compareToIgnoreCase("EmployeeManagement.jsp")==0)

    {
        redirectURL = "./EmployeePortal/"+managementPage;
    }   

    // Display Employees
       else if(request.getParameter("ServFunc").compareToIgnoreCase("display")==0 && request.getParameter("AccType").compareToIgnoreCase("Employee")==0)

    {
            session.removeAttribute("user_selection");
        redirectURL = "./DisplayAllServlet";
      }
    
    //If Display Customer 
       else if(request.getParameter("ServFunc").compareToIgnoreCase("display")==0 && request.getParameter("AccType").compareToIgnoreCase("Customer")==0)

    {
            session.removeAttribute("user_selection");
            redirectURL = "./DisplayCustServlet";
      }
  
    else
    {
        
         redirectURL = "./EmployeePortal/"+managementPage;
    }

          
    
    
    
    response.sendRedirect(redirectURL);
    
    
//    String password = request.getParameter("password");
//    out.println("Checking login...<br/><br/>");
//    if (username == null || username =="" || password == null)
//    {
//
//        out.print("Error: Username and password cannot be blank!<br/>");
//        out.print("Please <a href=\"Login.jsp\">Try Again</a>");
//    } else {
//        // Here you put the check on the username and password
//        if (username.toLowerCase().trim().equals("admin") && password.toLowerCase().trim().equals("admin")) {
//            out.println("Welcome " + username + " <a href=\"EmployeePortal.jsp\">Proceed to Employee Portal</a>");
//            session.setAttribute("username", username);
//        } else {
//            out.println("Invalid username and password");
//        }
//    }




%>
