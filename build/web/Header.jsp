<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body>
        <%Model.User u = (Model.User) session.getAttribute("thisUser");%>
        <font color="green">Welcome, <%=u.getfName()%> <%=u.getlName()%></font>
    </body>
</html>