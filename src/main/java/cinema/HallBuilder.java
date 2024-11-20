package cinema;

import java.util.List;

/**
 * Клас конструктора для створення об'єктів Hall.
 */
public class HallBuilder {
    private int numberOfSeats;
    private int hallNumber;
    private List<String> amenities;

    public HallBuilder setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        return this;
    }

    public HallBuilder setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
        return this;
    }

    public HallBuilder setAmenities(List<String> amenities) {
        this.amenities = amenities;
        return this;
    }

    public Hall build() {
        return new Hall(numberOfSeats, hallNumber, amenities);
    }
}
