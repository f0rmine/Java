package cinema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HallService {

    private static final Logger logger = LoggerFactory.getLogger(HallService.class);
    private final HallDAO hallDAO;

    public HallService() {
        this.hallDAO = new HallDAO();
    }

    public void createHall(Hall hall) {
        try {
            hallDAO.createHall(hall);
            logger.info("Hall created: {}", hall);
        } catch (SQLException | IOException e) {
            logger.error("Error creating hall: {}", e.getMessage());
            throw new RuntimeException("Error creating hall", e);
        }
    }

    public Hall readHall(int hallId) {
        try {
            Hall hall = hallDAO.readHall(hallId);
            if (hall != null) {
                logger.info("Hall read: {}", hall);
            } else {
                logger.warn("Hall not found for ID: {}", hallId);
            }
            return hall;
        } catch (SQLException | IOException e) {
            logger.error("Error reading hall: {}", e.getMessage());
            throw new RuntimeException("Error reading hall", e);
        }
    }

    public void updateHall(Hall hall) {
        try {
            hallDAO.updateHall(hall);
            logger.info("Hall updated: {}", hall);
        } catch (SQLException | IOException e) {
            logger.error("Error updating hall: {}", e.getMessage());
            throw new RuntimeException("Error updating hall", e);
        }
    }

    public void deleteHall(int hallId) {
        try {
            hallDAO.deleteHall(hallId);
            logger.info("Hall deleted with ID: {}", hallId);
        } catch (SQLException | IOException e) {
            logger.error("Error deleting hall: {}", e.getMessage());
            throw new RuntimeException("Error deleting hall", e);
        }
    }

    public List<Hall> getAllHalls() {
        try {
            List<Hall> halls = hallDAO.getAllHalls();
            logger.info("All halls retrieved: {}", halls);
            return halls;
        } catch (SQLException | IOException e) {
            logger.error("Error retrieving all halls: {}", e.getMessage());
            throw new RuntimeException("Error retrieving all halls", e);
        }
    }
}
