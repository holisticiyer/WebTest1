<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <style>
            .menu table {
                width: 100%;
                border: none;
            }
            .menu td {
                width: 20%;
                border: none;
            }
            .menu input {
                width: 100%;
                border: none;
                background-color: #FF5733;
                color: white;
                text-align: center;
            }
            .menu input:hover {
                background-color: #FFB533;
            }
        </style>
    </head>
    <body>
        <div class="menu">
            <form action="click" method="post">
                <table>
                    <tr>
                        <td><input name="click" type="submit" value="Home" /></td>
                        <td><input name="click" type="submit" value="My Events" /></td>
                        <%Model.User u = (Model.User) session.getAttribute("thisUser");
                        if(u.getisAdmin()) {%>
                        <td><input name="click" type="submit" value="Venues" /></td>
                        <%}%>
                        <td><input name="click" type="submit" value="Account" /></td>
                        <td><input name="click" type="submit" value="Logout" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
