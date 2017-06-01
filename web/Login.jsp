<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div>
            <%if(request.getAttribute("userEmail") == null)
                request.setAttribute("userEmail", "");
            if(request.getAttribute("userPassword") == null)
                request.setAttribute("userPassword", "");
            if(request.getAttribute("doRemember") == null)
                request.setAttribute("doRemember", "no");
            %>
            <form name="loginForm" action="login" method="post">
                <table>
                    <tr>
                        <td>Login Email : </td>
                        <td><input name="userEmail" type="email" value="<%=request.getAttribute("userEmail")%>" required /></td>
                    </tr>
                    <tr>
                        <td>Password : </td>
                        <td><input name="userPassword" type="password" value="<%=request.getAttribute("userPassword")%>" required /></td>
                    </tr>
                    <tr>
                        <td><input name="doRemember" type="checkbox" value="yes" <%if(request.getAttribute("doRemember").equals("yes")) {%>checked<%}%> /> Remember Me</td>
                        <td><input type="submit" value="Login" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <hr />
        <div>
            <button type="button" onclick="location.href='Register.html'">Register</button>
        </div>
    </body>
</html>
