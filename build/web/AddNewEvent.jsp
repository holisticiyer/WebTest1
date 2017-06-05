<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Venue</title>
        <script>
            function enablesVenues() {
                document.getElementById("venueName").disabled = false;
            }
            function booked() {
                document.getElementById("addParticipant").disabled = false;
            }
        </script>
    </head>
    <body>
        <div><jsp:include page="Header.jsp" /></div>
        <div><jsp:include page="Menu.jsp" /></div>
        <div>
            <%Model.User u = (Model.User) session.getAttribute("thisUser");
            Model.Event e = (Model.Event) session.getAttribute("thisEvent");%>
            <form action="event" method="post">
                <input name="eventName" type="text" placeholder="Event Name" value="<%=e.geteventName()%>" required />
                <input name="eventType" type="text" placeholder="Event Type" value="<%=e.geteventType()%>" required />
                <input name="isPublic" type="checkbox" value="yes" <%if(e.getisPublic()) {%>checked<%}%> /> Public
                <hr />
                <textarea name="eventDesc" placeholder="Description" required><%=e.geteventDesc()%></textarea>
                <hr />
                <input name="eventDate" type="date" onchange="enablesVenues()" />
                <select id="venueName" disabled required>
                    <c:forEach items="${myVenues}" var="thisVenue">
                        <option>${thisVenue.venueName}</option>
                    </c:forEach>
                </select>
                <input name="click" type="submit" value="Book Event" onclick="booked()" />
            </form>
            <hr />
            <c:forEach items="${myParticipants}" var="thisParticipant">
                <form action="event" method="post">
                    <input name="userEmail" type="text" value="${thisParticipant.userEmail}" />
                    <c:set var="Organizer" value="Organizer" />
                    <c:set var="Participant" value="Participant" />
                    <c:set var="Guest" value="Special Guest" />
                    <c:if test="${thisParticipant.role == Organizer}">
                        <select name="role" id="role">
                            <option selected="selected">Organizer</option>
                            <option>Participant</option>
                            <option>Special Guest</option>
                        </select>
                    </c:if>
                    <c:if test="${thisParticipant.role == Participant}">
                        <select name="role" id="role">
                            <option>Organizer</option>
                            <option selected="selected">Participant</option>
                            <option>Special Guest</option>
                        </select>
                    </c:if>
                    <c:if test="${thisParticipant.role == Guest}">
                        <select name="role" id="role">
                            <option>Organizer</option>
                            <option>Participant</option>
                            <option selected="selected">Special Guest</option>
                        </select>
                    </c:if>
                    <input name="click" type="submit" value="Save Participant" disabled /><br />
                </form>
            </c:forEach>
            <form action="event">
                <input name="userEmail" type="text" placeholder="Email" />
                <select name="role" id="role">
                    <option value="Organizer">Organizer</option>
                    <option value="Participant">Participant</option>
                    <option value="Special Guest">Special Guest</option>
                </select>
                <input name="click" id="addParticipant" type="submit" value="Add Participant" disabled />
            </form>
            <hr />
            <form action="Home.jsp"><input type="submit" value="Cancel" /></form>
        </div>
    </body>
</html>