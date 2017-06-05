<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
    </head>
    <body>
        <div><jsp:include page="Header.jsp" /></div>
        <div><jsp:include page="Menu.jsp" /></div>
        <div>
            <%Model.User u = (Model.User) session.getAttribute("thisUser");%>
            <form action="" method="post">
                <table>
                    <tr>
                        <td>Name : </td>
                        <td><input name="fName" type="text" value="<%=u.getfName()%>" required /></td>
                        <td><input name="lName" type="text" value="<%=u.getlName()%>" required /></td>
                    </tr>
                    <tr>
                        <td><%=u.getuserEmail()%></td>
                        <td><input name="userPassword" type="password" value="<%=u.getuserPassword()%>" required /></td>
                        <td>Change Password</td>
                    </tr>
                    <tr>
                        <td>Enter Phone : </td>
                        <td><input name="phone" type="text" value="<%=u.getPhone()%>" required /></td>
                        <td><input type="submit" value="Save" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
