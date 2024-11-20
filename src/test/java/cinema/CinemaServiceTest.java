package cinema;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class CinemaServiceTest {

    @Test
    public void testFindEarliestScreening() {
        List<MovieScreening> screenings = Arrays.asList(
                new MovieScreening("Inception", "Sci-Fi", 148, "Christopher Nolan", LocalTime.of(19, 30)),
                new MovieScreening("The Matrix", "Sci-Fi", 136, "Wachowskis", LocalTime.of(18, 00)),
                new MovieScreening("Interstellar", "Sci-Fi", 169, "Christopher Nolan", LocalTime.of(20, 00))
        );

        CinemaService service = new CinemaService();
        MovieScreening earliestScreening = service.findEarliestScreening(screenings);

        assertEquals(earliestScreening.getTitle(), "The Matrix");
        System.out.println("Earliest Screening: " + earliestScreening);
    }

    @Test
    public void testFindTicketsByPurchaseDate() {
        List<Ticket> tickets = Arrays.asList(
                new Ticket(15, 12.50, LocalDate.of(2023, 10, 15), "Credit Card", "John Doe"),
                new Ticket(16, 12.50, LocalDate.of(2023, 10, 16), "Credit Card", "Jane Smith"),
                new Ticket(17, 12.50, LocalDate.of(2023, 10, 15), "Cash", "Alice Johnson")
        );

        CinemaService service = new CinemaService();
        List<Ticket> filteredTickets = service.findTicketsByPurchaseDate(tickets, LocalDate.of(2023, 10, 15));

        assertEquals(filteredTickets.size(), 2);
        System.out.println("Filtered Tickets: " + filteredTickets);
    }

    @Test
    public void testSortHallsByNumberOfSeatsDescending() {
        List<Hall> halls = Arrays.asList(
                Hall.builder().setNumberOfSeats(100).setHallNumber(1).setAmenities(Arrays.asList("AC", "3D")).build(),
                Hall.builder().setNumberOfSeats(150).setHallNumber(2).setAmenities(Arrays.asList("AC", "IMAX")).build(),
                Hall.builder().setNumberOfSeats(200).setHallNumber(3).setAmenities(Arrays.asList("AC", "Dolby")).build()
        );

        CinemaService service = new CinemaService();
        List<Hall> sortedHalls = service.sortHallsByNumberOfSeatsDescending(halls);

        assertEquals(sortedHalls.get(0).getNumberOfSeats(), 200);
        assertEquals(sortedHalls.get(1).getNumberOfSeats(), 150);
        assertEquals(sortedHalls.get(2).getNumberOfSeats(), 100);
        System.out.println("Sorted Halls: " + sortedHalls);
    }
}
