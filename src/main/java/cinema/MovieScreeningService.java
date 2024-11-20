package cinema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MovieScreeningService {

    private static final Logger logger = LoggerFactory.getLogger(MovieScreeningService.class);
    private final MovieScreeningDAO screeningDAO;

    public MovieScreeningService() {
        this.screeningDAO = new MovieScreeningDAO();
    }

    public void createMovieScreening(MovieScreening screening) {
        try {
            screeningDAO.createMovieScreening(screening);
            logger.info("MovieScreening created: {}", screening);
        } catch (SQLException | IOException e) {
            logger.error("Error creating movie screening: {}", e.getMessage());
            throw new RuntimeException("Error creating movie screening", e);
        }
    }

    public MovieScreening readMovieScreening(int screeningId) {
        try {
            MovieScreening screening = screeningDAO.readMovieScreening(screeningId);
            if (screening != null) {
                logger.info("MovieScreening read: {}", screening);
            } else {
                logger.warn("MovieScreening not found for ID: {}", screeningId);
            }
            return screening;
        } catch (SQLException | IOException e) {
            logger.error("Error reading movie screening: {}", e.getMessage());
            throw new RuntimeException("Error reading movie screening", e);
        }
    }

    public void updateMovieScreening(MovieScreening screening) {
        try {
            screeningDAO.updateMovieScreening(screening);
            logger.info("MovieScreening updated: {}", screening);
        } catch (SQLException | IOException e) {
            logger.error("Error updating movie screening: {}", e.getMessage());
            throw new RuntimeException("Error updating movie screening", e);
        }
    }

    public void deleteMovieScreening(int screeningId) {
        try {
            screeningDAO.deleteMovieScreening(screeningId);
            logger.info("MovieScreening deleted with ID: {}", screeningId);
        } catch (SQLException | IOException e) {
            logger.error("Error deleting movie screening: {}", e.getMessage());
            throw new RuntimeException("Error deleting movie screening", e);
        }
    }

    public List<MovieScreening> getAllMovieScreenings() {
        try {
            List<MovieScreening> screenings = screeningDAO.getAllMovieScreenings();
            logger.info("All movie screenings retrieved: {}", screenings);
            return screenings;
        } catch (SQLException | IOException e) {
            logger.error("Error retrieving all movie screenings: {}", e.getMessage());
            throw new RuntimeException("Error retrieving all movie screenings", e);
        }
    }
}
