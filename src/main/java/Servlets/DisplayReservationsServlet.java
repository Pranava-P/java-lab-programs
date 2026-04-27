package Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.ReservationDAO;
import model.Reservation;

@WebServlet("/display")
public class DisplayReservationsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ReservationDAO dao = new ReservationDAO();
            List<Reservation> list = dao.getAllReservations();

            request.setAttribute("list", list);
            RequestDispatcher rd = request.getRequestDispatcher("reservationdisplay.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}