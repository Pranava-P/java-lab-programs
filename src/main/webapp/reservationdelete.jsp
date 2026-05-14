<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         import="java.util.*,model.Reservation,DAO.ReservationDAO" %>

<!DOCTYPE html>
<html>
<head>

<title>Delete Reservation</title>

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

.table-container{
    background:white;
    padding:20px;
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

<!-- DELETE FORM -->

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-5">

<div class="card p-4 text-dark">

<h2 class="text-center mb-4">
Delete Reservation
</h2>

<form action="<%=request.getContextPath()%>/delete"
      method="post"

      onsubmit="return confirm(
      'Are you sure you want to delete this reservation?'
      )">

<label>
Reservation ID
</label>

<input type="number"
       name="id"
       class="form-control mb-3"
       required>

<button type="submit"
        class="btn btn-danger w-100">

Delete Reservation

</button>

<a href="<%=request.getContextPath()%>/index.jsp"
   class="btn btn-secondary w-100 mt-3">

Back To Home

</a>

</form>

</div>

</div>

</div>

<br><br>

<!-- TABLE -->

<div class="table-container">

<h3 class="text-dark mb-3">
All Reservations
</h3>

<table class="table table-bordered table-hover">

<thead class="table-dark">

<tr>

<th>ID</th>
<th>Name</th>
<th>Room</th>
<th>Check In</th>
<th>Check Out</th>
<th>Amount</th>

</tr>

</thead>

<tbody>

<%

ReservationDAO dao =
        new ReservationDAO();

List<Reservation> list =
        dao.getAllReservations();

for(Reservation r : list){

%>

<tr>

<td>
<%= r.getReservationID() %>
</td>

<td>
<%= r.getCustomerName() %>
</td>

<td>
<%= r.getRoomNumber() %>
</td>

<td>
<%= r.getCheckIn() %>
</td>

<td>
<%= r.getCheckOut() %>
</td>

<td>
<%= r.getTotalAmount() %>
</td>

</tr>

<%
}
%>

</tbody>

</table>

</div>

</div>

</body>
</html>