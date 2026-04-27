package DAO;

import java.sql.*;
import java.util.*;
import model.Reservation;
import java.sql.Date;

public class ReservationDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/hotel";
    private String jdbcUsername = "root";
    private String jdbcPassword = "080606";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // INSERT
    public void insertReservation(Reservation r) throws Exception {
        String sql = "INSERT INTO Reservations VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, r.getReservationID());
        ps.setString(2, r.getCustomerName());
        ps.setString(3, r.getRoomNumber());
        ps.setDate(4, r.getCheckIn());
        ps.setDate(5, r.getCheckOut());
        ps.setDouble(6, r.getTotalAmount());

        ps.executeUpdate();
        con.close();
    }

    // SELECT ALL
    public List<Reservation> getAllReservations() throws Exception {
        List<Reservation> list = new ArrayList<>();
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Reservations");

        while (rs.next()) {
            Reservation r = new Reservation();
            r.setReservationID(rs.getInt("ReservationID"));
            r.setCustomerName(rs.getString("CustomerName"));
            r.setRoomNumber(rs.getString("RoomNumber"));
            r.setCheckIn(rs.getDate("CheckIn"));
            r.setCheckOut(rs.getDate("CheckOut"));
            r.setTotalAmount(rs.getDouble("TotalAmount"));
            list.add(r);
        }
        con.close();
        return list;
    }

    // DELETE
    public void deleteReservation(int id) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM Reservations WHERE ReservationID=?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    // UPDATE
    public void updateReservation(Reservation r) throws Exception {
        String sql = "UPDATE Reservations SET CustomerName=?, RoomNumber=?, CheckIn=?, CheckOut=?, TotalAmount=? WHERE ReservationID=?";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, r.getCustomerName());
        ps.setString(2, r.getRoomNumber());
        ps.setDate(3, r.getCheckIn());
        ps.setDate(4, r.getCheckOut());
        ps.setDouble(5, r.getTotalAmount());
        ps.setInt(6, r.getReservationID());

        ps.executeUpdate();
        con.close();
    }

    // REPORTS
    public List<Reservation> getByDateRange(Date from, Date to) throws Exception {
        List<Reservation> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Reservations WHERE CheckIn>=? AND CheckOut<=?"
        );
        ps.setDate(1, from);
        ps.setDate(2, to);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Reservation r = new Reservation();
            r.setReservationID(rs.getInt("ReservationID"));
            r.setCustomerName(rs.getString("CustomerName"));
            r.setRoomNumber(rs.getString("RoomNumber"));
            r.setCheckIn(rs.getDate("CheckIn"));
            r.setCheckOut(rs.getDate("CheckOut"));
            r.setTotalAmount(rs.getDouble("TotalAmount"));
            list.add(r);
        }
        con.close();
        return list;
    }

    public double getTotalRevenue(Date from, Date to) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT SUM(TotalAmount) FROM Reservations WHERE CheckIn BETWEEN ? AND ?"
        );
        ps.setDate(1, from);
        ps.setDate(2, to);

        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getDouble(1);
    }
}