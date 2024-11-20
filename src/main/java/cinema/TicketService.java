package cinema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);
    private final TicketDAO ticketDAO;

    public TicketService() {
        this.ticketDAO = new TicketDAO();
    }

    public void createTicket(Ticket ticket) {
        try {
            ticketDAO.createTicket(ticket);
            logger.info("Ticket created: {}", ticket);
        } catch (SQLException | IOException e) {
            logger.error("Error creating ticket: {}", e.getMessage());
            throw new RuntimeException("Error creating ticket", e);
        }
    }

    public Ticket readTicket(int ticketId) {
        try {
            Ticket ticket = ticketDAO.readTicket(ticketId);
            if (ticket != null) {
                logger.info("Ticket read: {}", ticket);
            } else {
                logger.warn("Ticket not found for ID: {}", ticketId);
            }
            return ticket;
        } catch (SQLException | IOException e) {
            logger.error("Error reading ticket: {}", e.getMessage());
            throw new RuntimeException("Error reading ticket", e);
        }
    }

    public void updateTicket(Ticket ticket) {
        try {
            ticketDAO.updateTicket(ticket);
            logger.info("Ticket updated: {}", ticket);
        } catch (SQLException | IOException e) {
            logger.error("Error updating ticket: {}", e.getMessage());
            throw new RuntimeException("Error updating ticket", e);
        }
    }

    public void deleteTicket(int ticketId) {
        try {
            ticketDAO.deleteTicket(ticketId);
            logger.info("Ticket deleted with ID: {}", ticketId);
        } catch (SQLException | IOException e) {
            logger.error("Error deleting ticket: {}", e.getMessage());
            throw new RuntimeException("Error deleting ticket", e);
        }
    }

    public List<Ticket> getAllTickets() {
        try {
            List<Ticket> tickets = ticketDAO.getAllTickets();
            logger.info("All tickets retrieved: {}", tickets);
            return tickets;
        } catch (SQLException | IOException e) {
            logger.error("Error retrieving all tickets: {}", e.getMessage());
            throw new RuntimeException("Error retrieving all tickets", e);
        }
    }
}
