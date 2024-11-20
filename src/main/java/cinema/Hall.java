package cinema;

import java.util.List;
import java.util.Objects;

/**
 * Represents a hall with details such as number of seats, hall number, and amenities.
 */
public class Hall {
    private int numberOfSeats;
    private int hallNumber;
    private List<String> amenities;

    private Hall(Builder builder) {
        this.numberOfSeats = builder.numberOfSeats;
        this.hallNumber = builder.hallNumber;
        this.amenities = builder.amenities;
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
}
