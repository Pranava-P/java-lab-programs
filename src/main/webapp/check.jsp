<html>
<head>
    <title>Check Session</title>
</head>
<body>

<%
    String user = (String) session.getAttribute("user");

    if (user != null) {
%>
        <h2>Hello <%= user %> (Session Active)</h2>
<%
    } else {
%>
        <h2>Session Expired!</h2>
        <a href="index.jsp">Enter Details Again</a>
<%
    }
%>

</body>
</html>