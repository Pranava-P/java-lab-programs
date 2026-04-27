package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.ReservationDAO;
import model.Reservation;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Date from = Date.valueOf(request.getParameter("from"));
            Date to = Date.valueOf(request.getParameter("to"));

            ReservationDAO dao = new ReservationDAO();

            List<Reservation> list = dao.getByDateRange(from, to);
            double revenue = dao.getTotalRevenue(from, to);

            request.setAttribute("list", list);
            request.setAttribute("revenue", revenue);

            RequestDispatcher rd = request.getRequestDispatcher("report_result.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}