<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hotel Management System</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Styling -->
    <style>
        body {
            background: linear-gradient(to right, #1e3c72, #2a5298);
            color: white;
        }
        .card {
            border-radius: 15px;
            transition: 0.3s;
        }
        .card:hover {
            transform: scale(1.05);
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <span class="navbar-brand mb-0 h1">Hotel Management System</span>
    </div>
</nav>

<!-- Main Section -->
<div class="container text-center mt-5">
    <h1 class="mb-4">Welcome</h1>
    <p class="mb-5">Manage reservations, bookings, and reports easily</p>

    <div class="row justify-content-center">

        <!-- Add Reservation -->
        <div class="col-md-3">
            <div class="card text-dark p-3">
                <h4>Add</h4>
                <p>Book new reservations</p>
                <a href="<%=request.getContextPath()%>/reservationadd.jsp" class="btn btn-primary">Go</a>
            </div>
        </div>

        <!-- View Reservations -->
        <div class="col-md-3">
            <div class="card text-dark p-3">
                <h4>View</h4>
                <p>See all reservations</p>
                <a href="<%=request.getContextPath()%>/display" class="btn btn-success">Go</a>
            </div>
        </div>

        <!-- Reports -->
        <div class="col-md-3">
            <div class="card text-dark p-3">
                <h4>Reports</h4>
                <p>Analyze bookings & revenue</p>
                <a href="<%=request.getContextPath()%>/report_form.jsp" class="btn btn-warning">Go</a>
            </div>
        </div>

    </div>
</div>

</body>
</html>