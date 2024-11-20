package cinema;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CinemaService {

    /**
     * Знаходить сеанс фільму з найбільш раннім часом початку.
     *
     * @param screenings Список кіносеансів.
     * @return Сеанс фільму з найбільш раннім часом початку.
     */
    public MovieScreening findEarliestScreening(List<MovieScreening> screenings) {
        return screenings.stream()
                .min(MovieScreening::compareTo)
                .orElse(null);
    }

    /**
     * Знаходить всі квитки, придбані на певну дату.
     *
     * @param tickets Список квитків.
     * @param date Дата, за якою потрібно відфільтрувати квитки.
     * @return Список квитків, придбаних на вказану дату.
     */
    public List<Ticket> findTicketsByPurchaseDate(List<Ticket> tickets, LocalDate date) {
        return tickets.stream()
                .filter(ticket -> ticket.getPurchaseDate().equals(date))
                .collect(Collectors.toList());
    }

    /**
     * Сортує зали за кількістю місць у порядку спадання.
     *
     * @param halls Список залів.
     * @return Список залів, відсортованих за кількістю місць у порядку спадання.
     */
    public List<Hall> sortHallsByNumberOfSeatsDescending(List<Hall> halls) {
        return halls.stream()
                .sorted(Comparator.comparingInt(Hall::getNumberOfSeats).reversed())
                .collect(Collectors.toList());
    }
}
