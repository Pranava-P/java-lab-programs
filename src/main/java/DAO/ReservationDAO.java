package DAO;

import java.sql.*;
import java.util.*;

import model.Reservation;

public class ReservationDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/hotel";
    private String jdbcUsername = "root";
    private String jdbcPassword = "080606";

    // DATABASE CONNECTION
    private Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                jdbcURL,
                jdbcUsername,
                jdbcPassword
        );
    }

    // INSERT RESERVATION
    public int insertReservation(Reservation r) throws Exception {

        int generatedId = 0;

        String sql = "INSERT INTO Reservations "
                + "(CustomerName, RoomNumber, CheckIn, CheckOut, TotalAmount) "
                + "VALUES (?, ?, ?, ?, ?)";

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
        );

        ps.setString(1, r.getCustomerName());
        ps.setInt(2, r.getRoomNumber());
        ps.setDate(3, r.getCheckIn());
        ps.setDate(4, r.getCheckOut());
        ps.setDouble(5, r.getTotalAmount());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            generatedId = rs.getInt(1);
        }

        con.close();

        return generatedId;
    }

    // DISPLAY ALL RESERVATIONS
    public List<Reservation> getAllReservations() throws Exception {

        List<Reservation> list = new ArrayList<>();

        Connection con = getConnection();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM Reservations"
        );

        while (rs.next()) {

            Reservation r = new Reservation();

            r.setReservationID(
                    rs.getInt("ReservationID")
            );

            r.setCustomerName(
                    rs.getString("CustomerName")
            );

            r.setRoomNumber(
                    rs.getInt("RoomNumber")
            );

            r.setCheckIn(
                    rs.getDate("CheckIn")
            );

            r.setCheckOut(
                    rs.getDate("CheckOut")
            );

            r.setTotalAmount(
                    rs.getDouble("TotalAmount")
            );

            list.add(r);
        }

        con.close();

        return list;
    }

    // DELETE RESERVATION
    public void deleteReservation(int id) throws Exception {

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM Reservations WHERE ReservationID=?"
        );

        ps.setInt(1, id);

        ps.executeUpdate();

        con.close();
    }

    // UPDATE RESERVATION
    public void updateReservation(Reservation r) throws Exception {

        String sql = "UPDATE Reservations SET "
                + "CustomerName=?, "
                + "RoomNumber=?, "
                + "CheckIn=?, "
                + "CheckOut=?, "
                + "TotalAmount=? "
                + "WHERE ReservationID=?";

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, r.getCustomerName());
        ps.setInt(2, r.getRoomNumber());
        ps.setDate(3, r.getCheckIn());
        ps.setDate(4, r.getCheckOut());
        ps.setDouble(5, r.getTotalAmount());
        ps.setInt(6, r.getReservationID());

        ps.executeUpdate();

        con.close();
    }

    // REPORT : DATE RANGE
    public List<Reservation> getByDateRange(
            java.sql.Date from,
            java.sql.Date to
    ) throws Exception {

        List<Reservation> list = new ArrayList<>();

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM Reservations "
              + "WHERE CheckIn>=? AND CheckOut<=?"
        );

        ps.setDate(1, from);
        ps.setDate(2, to);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Reservation r = new Reservation();

            r.setReservationID(
                    rs.getInt("ReservationID")
            );

            r.setCustomerName(
                    rs.getString("CustomerName")
            );

            r.setRoomNumber(
                    rs.getInt("RoomNumber")
            );

            r.setCheckIn(
                    rs.getDate("CheckIn")
            );

            r.setCheckOut(
                    rs.getDate("CheckOut")
            );

            r.setTotalAmount(
                    rs.getDouble("TotalAmount")
            );

            list.add(r);
        }

        con.close();

        return list;
    }

    // REPORT : TOTAL REVENUE
    public double getTotalRevenue(
            java.sql.Date from,
            java.sql.Date to
    ) throws Exception {

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT SUM(TotalAmount) "
              + "FROM Reservations "
              + "WHERE CheckIn BETWEEN ? AND ?"
        );

        ps.setDate(1, from);
        ps.setDate(2, to);

        ResultSet rs = ps.executeQuery();

        double revenue = 0;

        if (rs.next()) {
            revenue = rs.getDouble(1);
        }

        con.close();

        return revenue;
    }
}