package Servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.ReservationDAO;

@WebServlet("/delete")
public class DeleteReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            ReservationDAO dao = new ReservationDAO();
            dao.deleteReservation(id);

            response.sendRedirect("display");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}