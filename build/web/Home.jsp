<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div><jsp:include page="Header.jsp" /></div>
        <div><jsp:include page="Menu.jsp" /></div>
        <div><jsp:include page="AddNewEventButton.html" /></div>
        <%Model.User u = (Model.User) session.getAttribute("thisUser");%>
        <div>Home Page</div>
    </body>
</html>