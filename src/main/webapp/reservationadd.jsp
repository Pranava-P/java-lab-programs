<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Reservation</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #667eea, #764ba2);
        }
        .card {
            border-radius: 15px;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Hotel System</a>
    </div>
</nav>

<!-- Form Section -->
<div class="container d-flex justify-content-center align-items-center" style="height: 85vh;">

    <div class="card p-4 shadow" style="width: 450px;">
        <h3 class="text-center mb-4">Add Reservation</h3>

        <form action="add" method="post">

            <div class="mb-3">
                <label class="form-label">Reservation ID</label>
                <input type="number" name="id" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Customer Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Room Number</label>
                <input type="text" name="room" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Check-In Date</label>
                <input type="date" name="checkin" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Check-Out Date</label>
                <input type="date" name="checkout" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Total Amount (₹)</label>
                <input type="number" name="amount" class="form-control" min="0">
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Add Reservation</button>
            </div>

            <div class="text-center mt-3">
                <a href="index.jsp" class="btn btn-secondary">Back</a>
            </div>

        </form>
    </div>

</div>

</body>
</html>