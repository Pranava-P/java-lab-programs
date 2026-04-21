<html>
<head>
    <title>Cookie Management</title>
</head>
<body>

<h2>Add Cookie</h2>

<form action="AddCookieServlet" method="post">
    Cookie Name: <input type="text" name="cname" required><br><br>
    Domain: <input type="text" name="domain" required><br><br>
    Max Age (seconds): <input type="number" name="maxage" required><br><br>
    
    <input type="submit" value="Add Cookie">
</form>

</body>
</html>