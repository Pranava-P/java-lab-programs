<%@ page import="java.util.*, model.Reservation" %>
<!DOCTYPE html>
<html>
<head>
    <title>Report Result</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: #eef2f7;
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

<div class="container mt-5">

    <h3 class="text-center mb-4">Report Results</h3>

    <div class="card p-4 shadow">

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Room</th>
                </tr>
            </thead>

            <tbody>
            <%
            List<Reservation> list = (List<Reservation>) request.getAttribute("list");

            if(list != null && !list.isEmpty()){
                for(Reservation r : list){
            %>
                <tr>
                    <td><%=r.getReservationID()%></td>
                    <td><%=r.getCustomerName()%></td>
                    <td><%=r.getRoomNumber()%></td>
                </tr>
            <%
                }
            } else {
            %>
                <tr>
                    <td colspan="3" class="text-center">No data found</td>
                </tr>
            <%
            }
            %>
            </tbody>
        </table>

        <!-- Revenue Section -->
        <div class="mt-4 text-center">
            <h4 class="text-success">
                Total Revenue: ₹ <%=request.getAttribute("revenue")%>
            </h4>
        </div>

        <!-- Buttons -->
        <div class="text-center mt-4">
            <a href="report_form.jsp" class="btn btn-primary">Back to Report</a>
            <a href="index.jsp" class="btn btn-secondary">Home</a>
        </div>

    </div>

</div>

</body>
</html>