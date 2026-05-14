<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         import="java.util.*,model.Reservation" %>

<!DOCTYPE html>
<html>
<head>

<title>Report Result</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

body{
    background: linear-gradient(to right, #1e3c72, #2a5298);
    color:white;
}

.table-container{
    background:white;
    padding:20px;
    border-radius:15px;
}

</style>

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

<div class="table-container">

<h2 class="text-dark text-center mb-4">
Report Result
</h2>

<%

Double revenue =
(Double)request.getAttribute("revenue");

if(revenue != null){

%>

<h3 class="text-success">
Total Revenue :
₹ <%= revenue %>
</h3>

<%
}
%>

<%

List<Reservation> list =
(List<Reservation>)request.getAttribute("list");

if(list != null && !list.isEmpty()){

%>

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

<%
}
%>

<a href="<%=request.getContextPath()%>/report_form.jsp"
   class="btn btn-primary">

Back To Reports

</a>

</div>

</div>

</body>
</html>