<%@ page session="true" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<%
    String name = request.getParameter("username");
    String timeStr = request.getParameter("time");

    if (name != null && timeStr != null) {

        int time = Integer.parseInt(timeStr);

        // Set session expiry (convert minutes → seconds)
        session.setMaxInactiveInterval(time * 60);

        // Store name in session
        session.setAttribute("user", name);
%>
        <h2>Hello <%= name %>!</h2>
        <p>Session expiry time set to <%= time %> minute(s).</p>

        <a href="check.jsp">Click here to check session</a>

        <p>👉 Click the link within the session time OR wait to see expiry.</p>

<%
    } else {
%>
        <h3>Invalid Input</h3>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>