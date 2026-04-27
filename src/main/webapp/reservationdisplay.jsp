<%@ page import="java.util.*, model.Reservation" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Reservations</title>

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

    <h3 class="text-center mb-4">All Reservations</h3>

    <div class="card p-4 shadow">

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Room</th>
                    <th>Check-In</th>
                    <th>Check-Out</th>
                    <th>Amount</th>
                    <th>Action</th>
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
                    <td><%=r.getCheckIn()%></td>
                    <td><%=r.getCheckOut()%></td>
                    <td>₹ <%=r.getTotalAmount()%></td>
                    <td>
                        <a href="delete?id=<%=r.getReservationID()%>" 
                           class="btn btn-danger btn-sm">
                           Delete
                        </a>
                    </td>
                </tr>
            <%
                }
            } else {
            %>
                <tr>
                    <td colspan="7" class="text-center">No reservations found</td>
                </tr>
            <%
            }
            %>
            </tbody>
        </table>

        <!-- Buttons -->
        <div class="text-center mt-4">
            <a href="index.jsp" class="btn btn-secondary">Home</a>
        </div>

    </div>

</div>

</body>
</html>