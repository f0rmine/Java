package cinema;

import java.util.List;
import java.util.Objects;

/**
 * Представляє зал з такими деталями, як кількість місць, номер залу та зручності.
 */
public class Hall {
    private int numberOfSeats;
    private int hallNumber;
    private List<String> amenities;

    Hall(int numberOfSeats, int hallNumber, List<String> amenities) {
        this.numberOfSeats = numberOfSeats;
        this.hallNumber = hallNumber;
        this.amenities = amenities;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "numberOfSeats=" + numberOfSeats +
                ", hallNumber=" + hallNumber +
                ", amenities=" + amenities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return numberOfSeats == hall.numberOfSeats &&
                hallNumber == hall.hallNumber &&
                Objects.equals(amenities, hall.amenities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfSeats, hallNumber, amenities);
    }

    public static HallBuilder builder() {
        return new HallBuilder();
    }
}
