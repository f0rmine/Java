package cinema;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HallDAO {

    public void createHall(Hall hall) throws SQLException, IOException {
        String sql = "INSERT INTO Hall (number_of_seats, hall_number, amenities) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hall.getNumberOfSeats());
            stmt.setInt(2, hall.getHallNumber());
            stmt.setString(3, String.join(",", hall.getAmenities()));
            stmt.executeUpdate();
        }
    }

    public Hall readHall(int hallId) throws SQLException, IOException {
        String sql = "SELECT * FROM Hall WHERE hall_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hallId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Hall(
                            rs.getInt("number_of_seats"),
                            rs.getInt("hall_number"),
                            List.of(rs.getString("amenities").split(","))
                    );
                }
            }
        }
        return null;
    }

    public void updateHall(Hall hall) throws SQLException, IOException {
        String sql = "UPDATE Hall SET number_of_seats = ?, hall_number = ?, amenities = ? WHERE hall_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hall.getNumberOfSeats());
            stmt.setInt(2, hall.getHallNumber());
            stmt.setString(3, String.join(",", hall.getAmenities()));
            stmt.setInt(4, hall.getHallNumber()); // Assuming hall_id is the same as hall_number for simplicity
            stmt.executeUpdate();
        }
    }

    public void deleteHall(int hallId) throws SQLException, IOException {
        String sql = "DELETE FROM Hall WHERE hall_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hallId);
            stmt.executeUpdate();
        }
    }

    public List<Hall> getAllHalls() throws SQLException, IOException {
        List<Hall> halls = new ArrayList<>();
        String sql = "SELECT * FROM Hall";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                halls.add(new Hall(
                        rs.getInt("number_of_seats"),
                        rs.getInt("hall_number"),
                        List.of(rs.getString("amenities").split(","))
                ));
            }
        }
        return halls;
    }
}
