package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.ReservationDAO;
import model.Reservation;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try{

            String type =
                    request.getParameter("type");

            ReservationDAO dao =
                    new ReservationDAO();

            // REPORT BY ID

            if(type.equals("id")){

                int id =
                        Integer.parseInt(
                                request.getParameter("id")
                        );

                List<Reservation> all =
                        dao.getAllReservations();

                List<Reservation> result =
                        new ArrayList<>();

                for(Reservation r : all){

                    if(r.getReservationID() == id){

                        result.add(r);
                    }
                }

                request.setAttribute(
                        "list",
                        result
                );
            }

            // REPORT BY DATE RANGE

            else if(type.equals("date")){

                Date from =
                        Date.valueOf(
                                request.getParameter("from")
                        );

                Date to =
                        Date.valueOf(
                                request.getParameter("to")
                        );

                List<Reservation> list =
                        dao.getByDateRange(from, to);

                request.setAttribute(
                        "list",
                        list
                );
            }

            // TOTAL REVENUE REPORT

            else if(type.equals("revenue")){

                Date from =
                        Date.valueOf(
                                request.getParameter("from")
                        );

                Date to =
                        Date.valueOf(
                                request.getParameter("to")
                        );

                double revenue =
                        dao.getTotalRevenue(from, to);

                request.setAttribute(
                        "revenue",
                        revenue
                );
            }

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                            "report_result.jsp"
                    );

            rd.forward(request, response);

        }

        catch(Exception e){

            e.printStackTrace();

            response.getWriter().println(e);
        }
    }
}