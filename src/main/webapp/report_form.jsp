<%@ page language="java"
         contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>Generate Reports</title>

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

<!-- NAVBAR -->

<nav class="navbar navbar-dark bg-dark">

<div class="container">

<span class="navbar-brand mb-0 h1">
Hotel Management System
</span>

</div>

</nav>

<div class="container mt-5">

<div class="row">

<!-- REPORT 1 -->

<div class="col-md-4">

<div class="card p-4 text-dark">

<h4 class="text-center mb-3">
Reservation By ID
</h4>

<form action="<%=request.getContextPath()%>/report"
      method="post">

<input type="hidden"
       name="type"
       value="id">

<label>
Reservation ID
</label>

<input type="number"
       name="id"
       class="form-control mb-3"
       required>

<button type="submit"
        class="btn btn-primary w-100">

Generate

</button>

</form>

</div>

</div>

<!-- REPORT 2 -->

<div class="col-md-4">

<div class="card p-4 text-dark">

<h4 class="text-center mb-3">
Reservations By Date
</h4>

<form action="<%=request.getContextPath()%>/report"
      method="post">

<input type="hidden"
       name="type"
       value="date">

<label>
From Date
</label>

<input type="date"
       name="from"
       class="form-control mb-3"
       required>

<label>
To Date
</label>

<input type="date"
       name="to"
       class="form-control mb-3"
       required>

<button type="submit"
        class="btn btn-success w-100">

Generate

</button>

</form>

</div>

</div>

<!-- REPORT 3 -->

<div class="col-md-4">

<div class="card p-4 text-dark">

<h4 class="text-center mb-3">
Total Revenue
</h4>

<form action="<%=request.getContextPath()%>/report"
      method="post">

<input type="hidden"
       name="type"
       value="revenue">

<label>
From Date
</label>

<input type="date"
       name="from"
       class="form-control mb-3"
       required>

<label>
To Date
</label>

<input type="date"
       name="to"
       class="form-control mb-3"
       required>

<button type="submit"
        class="btn btn-warning w-100">

Generate

</button>

</form>

</div>

</div>

</div>

<br>

<a href="<%=request.getContextPath()%>/index.jsp"
   class="btn btn-secondary">

Back To Home

</a>

</div>

</body>
</html>