<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>

<title>Success</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

body{
    background: linear-gradient(to right, #1e3c72, #2a5298);
    color:white;
}

.card{
    border-radius:15px;
}

</style>

</head>
<body>

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-5">

<div class="card p-4 text-center text-dark">

<h2>
Reservation Added Successfully
</h2>

<hr>

<h3>
Generated Reservation ID :
<%= request.getAttribute("generatedId") %>
</h3>

<br>

<a href="index.jsp"
   class="btn btn-primary">
Back Home
</a>

</div>

</div>

</div>

</div>

</body>
</html>