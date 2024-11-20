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

    // Package-private constructor to allow access from HallBuilder
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

    // Static method to get the Builder instance
    public static HallBuilder builder() {
        return new HallBuilder();
    }
}
