package cinema;

import java.io.IOException;
import java.nio.file.Path;

public interface EntitySerializer<T> {
    String serialize(T entity) throws IOException;
    T deserialize(String data) throws IOException;
    void writeToFile(T entity, Path filePath) throws IOException;
    T readFromFile(Path filePath) throws IOException;
}
