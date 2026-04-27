<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Generate Report</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Styling -->
    <style>
        body {
            background: linear-gradient(to right, #4facfe, #00f2fe);
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
<div class="container d-flex justify-content-center align-items-center" style="height: 80vh;">
    
    <div class="card p-4 shadow" style="width: 400px;">
        <h3 class="text-center mb-4">Generate Report</h3>

        <form action="report" method="post">

            <div class="mb-3">
                <label class="form-label">From Date</label>
                <input type="date" name="from" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">To Date</label>
                <input type="date" name="to" class="form-control" required>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Generate Report</button>
            </div>

        </form>
    </div>

</div>

</body>
</html>