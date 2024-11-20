package cinema;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public void createTicket(Ticket ticket) throws SQLException, IOException {
        String sql = "INSERT INTO Ticket (seat_number, price, purchase_date, payment_method, buyer_name) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ticket.getSeatNumber());
            stmt.setDouble(2, ticket.getPrice());
            stmt.setDate(3, Date.valueOf(ticket.getPurchaseDate()));
            stmt.setString(4, ticket.getPaymentMethod());
            stmt.setString(5, ticket.getBuyerName());
            stmt.executeUpdate();
        }
    }

    public Ticket readTicket(int ticketId) throws SQLException, IOException {
        String sql = "SELECT * FROM Ticket WHERE ticket_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ticketId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ticket(
                            rs.getInt("seat_number"),
                            rs.getDouble("price"),
                            rs.getDate("purchase_date").toLocalDate(),
                            rs.getString("payment_method"),
                            rs.getString("buyer_name")
                    );
                }
            }
        }
        return null;
    }

    public void updateTicket(Ticket ticket) throws SQLException, IOException {
        String sql = "UPDATE Ticket SET seat_number = ?, price = ?, purchase_date = ?, payment_method = ?, buyer_name = ? WHERE ticket_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ticket.getSeatNumber());
            stmt.setDouble(2, ticket.getPrice());
            stmt.setDate(3, Date.valueOf(ticket.getPurchaseDate()));
            stmt.setString(4, ticket.getPaymentMethod());
            stmt.setString(5, ticket.getBuyerName());
            stmt.setInt(6, ticket.getSeatNumber()); // Assuming ticket_id is the same as seat_number for simplicity
            stmt.executeUpdate();
        }
    }

    public void deleteTicket(int ticketId) throws SQLException, IOException {
        String sql = "DELETE FROM Ticket WHERE ticket_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ticketId);
            stmt.executeUpdate();
        }
    }

    public List<Ticket> getAllTickets() throws SQLException, IOException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM Ticket";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                tickets.add(new Ticket(
                        rs.getInt("seat_number"),
                        rs.getDouble("price"),
                        rs.getDate("purchase_date").toLocalDate(),
                        rs.getString("payment_method"),
                        rs.getString("buyer_name")
                ));
            }
        }
        return tickets;
    }
}
