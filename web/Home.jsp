<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Event ID</th>
                        <th>Event Name</th>
                        <th>Event Type</th>
                        <th>Event Description</th>
                        <th>Event Date</th>
                        <th>Event Venue</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${allEvents}" var="thisEvent">
                        <tr>
                            <td><c:out value="${thisEvent.eventId}" /></td>
                            <td><c:out value="${thisEvent.eventName}" /></td>
                            <td><c:out value="${thisEvent.eventType}" /></td>
                            <td><c:out value="${thisEvent.eventDesc}" /></td>
                            <td><c:out value="${thisEvent.eventDate}" /></td>
                            <td><c:out value="${thisEvent.venueName}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>