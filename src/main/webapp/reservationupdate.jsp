<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         import="java.util.*,model.Reservation,DAO.ReservationDAO" %>

<!DOCTYPE html>
<html>
<head>

<title>Update Reservation</title>

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

<script>

function fillData(){

    var data =
            document.getElementById("reservationSelect").value;

    if(data == ""){
        return;
    }

    var values = data.split("|");

    document.getElementById("id").value =
            values[0];

    document.getElementById("name").value =
            values[1];

    document.getElementById("room").value =
            values[2];

    document.getElementById("checkin").value =
            values[3];

    document.getElementById("checkout").value =
            values[4];

    document.getElementById("amount").value =
            values[5];
}

</script>

</head>
<body>

<nav class="navbar navbar-dark bg-dark">

<div class="container">

<span class="navbar-brand mb-0 h1">
Hotel Management System
</span>

</div>

</nav>

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-7">

<div class="card p-4 text-dark">

<h2 class="text-center mb-4">
Update Reservation
</h2>

<%

ReservationDAO dao =
        new ReservationDAO();

List<Reservation> list =
        dao.getAllReservations();

%>

<label>
Select Reservation ID
</label>

<select id="reservationSelect"
        class="form-control mb-4"
        onchange="fillData()">

<option value="">
-- Select Reservation --
</option>

<%

for(Reservation r : list){

String data =
        r.getReservationID() + "|" +
        r.getCustomerName() + "|" +
        r.getRoomNumber() + "|" +
        r.getCheckIn() + "|" +
        r.getCheckOut() + "|" +
        r.getTotalAmount();

%>

<option value="<%=data%>">

Reservation ID :
<%=r.getReservationID()%>

</option>

<%
}
%>

</select>

<form action="<%=request.getContextPath()%>/update"
      method="post">

<label>
Reservation ID
</label>

<input type="number"
       id="id"
       name="id"
       class="form-control mb-3"
       readonly>

<label>
Customer Name
</label>

<input type="text"
       id="name"
       name="name"
       class="form-control mb-3"
       required>

<label>
Room Number
</label>

<input type="number"
       id="room"
       name="room"
       class="form-control mb-3"
       required>

<label>
Check In
</label>

<input type="date"
       id="checkin"
       name="checkin"
       class="form-control mb-3"
       required>

<label>
Check Out
</label>

<input type="date"
       id="checkout"
       name="checkout"
       class="form-control mb-3"
       required>

<label>
Total Amount
</label>

<input type="number"
       step="0.01"
       id="amount"
       name="amount"
       class="form-control mb-3"
       required>

<button type="submit"
        class="btn btn-primary w-100">
Update Reservation
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

for(Reservation r : list){

%>

<tr>

<td><%= r.getReservationID() %></td>
<td><%= r.getCustomerName() %></td>
<td><%= r.getRoomNumber() %></td>
<td><%= r.getCheckIn() %></td>
<td><%= r.getCheckOut() %></td>
<td><%= r.getTotalAmount() %></td>

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