package cinema;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Arrays;


public class SerializerTest {

    @Test
    public void testJsonSerializer() throws IOException {
        MovieScreening screening = new MovieScreening("Inception", "Sci-Fi", 148, "Christopher Nolan", LocalTime.of(19, 30));
        JsonEntitySerializer<MovieScreening> jsonSerializer = new JsonEntitySerializer<>(MovieScreening.class);

        String json = jsonSerializer.serialize(screening);
        System.out.println("JSON: " + json);

        Path filePath = Paths.get("movie_screening.json");
        jsonSerializer.writeToFile(screening, filePath);

        MovieScreening deserializedScreening = jsonSerializer.readFromFile(filePath);
        System.out.println("Deserialized from JSON: " + deserializedScreening);
    }

    @Test
    public void testXmlSerializer() throws IOException {
        MovieScreening screening = new MovieScreening("Inception", "Sci-Fi", 148, "Christopher Nolan", LocalTime.of(19, 30));
        XmlEntitySerializer<MovieScreening> xmlSerializer = new XmlEntitySerializer<>(MovieScreening.class);

        String xml = xmlSerializer.serialize(screening);
        System.out.println("XML: " + xml);

        Path filePath = Paths.get("movie_screening.xml");
        xmlSerializer.writeToFile(screening, filePath);


        MovieScreening deserializedScreening = xmlSerializer.readFromFile(filePath);
        System.out.println("Deserialized from XML: " + deserializedScreening);
    }

    @Test
    public void testYamlSerializer() throws IOException {
        MovieScreening screening = new MovieScreening("Inception", "Sci-Fi", 148, "Christopher Nolan", LocalTime.of(19, 30));
        YamlEntitySerializer<MovieScreening> yamlSerializer = new YamlEntitySerializer<>(MovieScreening.class);

        String yaml = yamlSerializer.serialize(screening);
        System.out.println("YAML: " + yaml);

        Path filePath = Paths.get("movie_screening.yaml");
        yamlSerializer.writeToFile(screening, filePath);

        MovieScreening deserializedScreening = yamlSerializer.readFromFile(filePath);
        System.out.println("Deserialized from YAML: " + deserializedScreening);
    }

    @Test
    public void testHallBuilderValidation() {
        try {
            Hall.builder()
                    .setNumberOfSeats(0)
                    .setHallNumber(1)
                    .setAmenities(Arrays.asList("AC", "3D"))
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        try {
            Hall.builder()
                    .setNumberOfSeats(100)
                    .setHallNumber(0)
                    .setAmenities(Arrays.asList("AC", "3D"))
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        try {
            Hall.builder()
                    .setNumberOfSeats(100)
                    .setHallNumber(1)
                    .setAmenities(Arrays.asList("AC", "3D", "Invalid@Amenity"))
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
