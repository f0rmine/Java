package cinema;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class CinemaTest {
    // Представлення показу фільму з заданими параметрами
    @Test
    public void testMovieScreening() {
        MovieScreening screening = new MovieScreening(
                "Inception",
                "Sci-Fi",
                148,
                "Christopher Nolan",
                LocalTime.of(19, 30)
        );

        assertEquals(screening.getTitle(), "Inception");
        assertEquals(screening.getGenre(), "Sci-Fi");
        assertEquals(screening.getDuration(), 148);
        assertEquals(screening.getDirector(), "Christopher Nolan");
        assertEquals(screening.getStartTime(), LocalTime.of(19, 30));

        System.out.println(screening);
    }

    // Представлення білету для фільму з заданими параметрами
    @Test
    public void testTicket() {
        Ticket ticket = new Ticket(
                15,
                12.50,
                LocalDate.of(2023, 10, 15),
                "Credit Card",
                "John Doe"
        );

        assertEquals(ticket.getSeatNumber(), 15);
        assertEquals(ticket.getPrice(), 12.50, 0.01);
        assertEquals(ticket.getPurchaseDate(), LocalDate.of(2023, 10, 15));
        assertEquals(ticket.getPaymentMethod(), "Credit Card");
        assertEquals(ticket.getBuyerName(), "John Doe");

        System.out.println(ticket);
    }

    // Представлення залу фільму з заданими параметрами та використанням білдера
    @Test
    public void testHall() {
        Hall hall = Hall.builder()
                .setNumberOfSeats(100)
                .setHallNumber(1)
                .setAmenities(Arrays.asList("AC", "3D"))
                .build();

        assertEquals(hall.getNumberOfSeats(), 100);
        assertEquals(hall.getHallNumber(), 1);
        assertEquals(hall.getAmenities(), Arrays.asList("AC", "3D"));

        System.out.println(hall);
    }
}
