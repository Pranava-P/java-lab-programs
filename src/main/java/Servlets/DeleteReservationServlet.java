package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.ReservationDAO;

@WebServlet("/delete")
public class DeleteReservationServlet
        extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id =
                    Integer.parseInt(
                            request.getParameter("id")
                    );

            ReservationDAO dao =
                    new ReservationDAO();

            dao.deleteReservation(id);

            response.sendRedirect(
                    "reservationdelete.jsp"
            );

        }

        catch(Exception e){

            e.printStackTrace();

            response.getWriter().println(e);

        }
    }
}