<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         import="java.sql.*" %>

<%

response.setHeader(
        "Cache-Control",
        "no-cache, no-store, must-revalidate"
);

response.setHeader(
        "Pragma",
        "no-cache"
);

response.setDateHeader(
        "Expires",
        0
);

%>

<!DOCTYPE html>
<html>
<head>

<title>Add Reservation</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

body{
    background: linear-gradient(to right, #1e3c72, #2a5298);
    color:white;
}

.card{
    border-radius:15px;
    box-shadow:0px 0px 10px rgba(0,0,0,0.3);
}

</style>

</head>
<body>

<%

int nextId = 1;

Connection con = null;

try{

    Class.forName(
            "com.mysql.cj.jdbc.Driver"
    );

    con =
        DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel",
            "root",
            "080606"
        );

    Statement st =
        con.createStatement();

    ResultSet rs =
        st.executeQuery(
            "SELECT MAX(ReservationID) FROM Reservations"
        );

    if(rs.next()){

        nextId =
            rs.getInt(1) + 1;
    }

    con.close();
}

catch(Exception e){

    e.printStackTrace();
}

%>

<!-- NAVBAR -->

<nav class="navbar navbar-dark bg-dark">

<div class="container">

<span class="navbar-brand mb-0 h1">
Hotel Management System
</span>

</div>

</nav>

<!-- FORM -->

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card p-4 text-dark">

<h2 class="text-center mb-4">
Add Reservation
</h2>

<form action="<%=request.getContextPath()%>/add"
      method="post">

<label>
Reservation ID
</label>

<input type="text"
       class="form-control mb-3"
       value="<%= nextId %>"
       readonly>

<label>
Customer Name
</label>

<input type="text"
       name="name"
       class="form-control mb-3"
       required>

<label>
Room Number
</label>

<input type="number"
       name="room"
       class="form-control mb-3"
       required>

<label>
Check In
</label>

<input type="date"
       name="checkin"
       class="form-control mb-3"
       required>

<label>
Check Out
</label>

<input type="date"
       name="checkout"
       class="form-control mb-3"
       required>

<label>
Total Amount
</label>

<input type="number"
       step="0.01"
       name="amount"
       class="form-control mb-3"
       required>

<button type="submit"
        class="btn btn-primary w-100">

Add Reservation

</button>

<a href="<%=request.getContextPath()%>/index.jsp"
   class="btn btn-secondary w-100 mt-3">

Back To Home

</a>

</form>

</div>

</div>

</div>

</div>

</body>
</html>