package cinema;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Клас конструктора для створення об'єктів Hall.
 */

public class HallBuilder {
    private int numberOfSeats;
    private int hallNumber;
    private List<String> amenities = new ArrayList<>();

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
        Hall hall = new Hall(numberOfSeats, hallNumber, amenities);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Hall>> violations = validator.validate(hall);

        if (!violations.isEmpty()) {
            List<String> validationErrors = new ArrayList<>();
            for (ConstraintViolation<Hall> violation : violations) {
                validationErrors.add(violation.getPropertyPath() + ": " + violation.getInvalidValue() + " - " + violation.getMessage());
            }
            throw new IllegalArgumentException("Validation errors: " + validationErrors);
        }

        return hall;
    }
}
