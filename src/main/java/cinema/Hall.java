package cinema;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/**
 * Представляє зал з такими деталями, як кількість місць, номер залу та зручності.
 */
public class Hall {
    @Min(value = 1, message = "Кількість місць має бути натуральним числом.")
    private int numberOfSeats;

    @Min(value = 1, message = "Номер залу повинен бути натуральним числом.")
    private int hallNumber;

    @Size(min = 1, message = "Список зручностей не повинен бути порожнім.")
    private List<String> amenities;

    // Package-private constructor to enforce the use of the Builder
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