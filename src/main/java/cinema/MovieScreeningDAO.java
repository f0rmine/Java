package cinema;

import java.io.IOException;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MovieScreeningDAO {

    public void createMovieScreening(MovieScreening screening) throws SQLException, IOException {
        String sql = "INSERT INTO MovieScreening (title, genre, duration, director, start_time) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, screening.getTitle());
            stmt.setString(2, screening.getGenre());
            stmt.setInt(3, screening.getDuration());
            stmt.setString(4, screening.getDirector());
            stmt.setTime(5, Time.valueOf(screening.getStartTime()));
            stmt.executeUpdate();
        }
    }

    public MovieScreening readMovieScreening(int screeningId) throws SQLException, IOException {
        String sql = "SELECT * FROM MovieScreening WHERE screening_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, screeningId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new MovieScreening(
                            rs.getString("title"),
                            rs.getString("genre"),
                            rs.getInt("duration"),
                            rs.getString("director"),
                            rs.getTime("start_time").toLocalTime()
                    );
                }
            }
        }
        return null;
    }

    public void updateMovieScreening(MovieScreening screening) throws SQLException, IOException {
        String sql = "UPDATE MovieScreening SET title = ?, genre = ?, duration = ?, director = ?, start_time = ? WHERE screening_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, screening.getTitle());
            stmt.setString(2, screening.getGenre());
            stmt.setInt(3, screening.getDuration());
            stmt.setString(4, screening.getDirector());
            stmt.setTime(5, Time.valueOf(screening.getStartTime()));
            stmt.setInt(6, screening.getTitle().hashCode()); // Assuming screening_id is the hashcode of the title for simplicity
            stmt.executeUpdate();
        }
    }

    public void deleteMovieScreening(int screeningId) throws SQLException, IOException {
        String sql = "DELETE FROM MovieScreening WHERE screening_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, screeningId);
            stmt.executeUpdate();
        }
    }

    public List<MovieScreening> getAllMovieScreenings() throws SQLException, IOException {
        List<MovieScreening> screenings = new ArrayList<>();
        String sql = "SELECT * FROM MovieScreening";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                screenings.add(new MovieScreening(
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("duration"),
                        rs.getString("director"),
                        rs.getTime("start_time").toLocalTime()
                ));
            }
        }
        return screenings;
    }
}
