package Servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.ReservationDAO;
import model.Reservation;

@WebServlet("/add")
public class AddReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Reservation r = new Reservation();

            r.setCustomerName(
                    request.getParameter("name")
            );

            r.setRoomNumber(
                    Integer.parseInt(
                            request.getParameter("room")
                    )
            );

            r.setCheckIn(
                    Date.valueOf(
                            request.getParameter("checkin")
                    )
            );

            r.setCheckOut(
                    Date.valueOf(
                            request.getParameter("checkout")
                    )
            );

            r.setTotalAmount(
                    Double.parseDouble(
                            request.getParameter("amount")
                    )
            );

            ReservationDAO dao = new ReservationDAO();

            int generatedId =
                    dao.insertReservation(r);

            request.setAttribute(
                    "generatedId",
                    generatedId
            );

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                            "success.jsp"
                    );

            rd.forward(request, response);

        }

        catch(Exception e) {

            e.printStackTrace();

            response.getWriter().println(e);

        }
    }
}