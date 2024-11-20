package cinema;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonEntitySerializer<T> implements EntitySerializer<T> {
    private final ObjectMapper objectMapper;
    private final Class<T> entityClass;

    public JsonEntitySerializer(Class<T> entityClass) {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.entityClass = entityClass;
    }

    @Override
    public String serialize(T entity) throws IOException {
        return objectMapper.writeValueAsString(entity);
    }

    @Override
    public T deserialize(String data) throws IOException {
        return objectMapper.readValue(data, entityClass);
    }

    @Override
    public void writeToFile(T entity, Path filePath) throws IOException {
        Files.writeString(filePath, serialize(entity));
    }

    @Override
    public T readFromFile(Path filePath) throws IOException {
        String data = Files.readString(filePath);
        return deserialize(data);
    }
}
