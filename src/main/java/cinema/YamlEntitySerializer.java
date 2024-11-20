package cinema;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class YamlEntitySerializer<T> implements EntitySerializer<T> {
    private final YAMLMapper yamlMapper;
    private final Class<T> entityClass;

    public YamlEntitySerializer(Class<T> entityClass) {
        this.yamlMapper = new YAMLMapper();
        this.yamlMapper.registerModule(new JavaTimeModule());
        this.entityClass = entityClass;
    }

    @Override
    public String serialize(T entity) throws IOException {
        return yamlMapper.writeValueAsString(entity);
    }

    @Override
    public T deserialize(String data) throws IOException {
        return yamlMapper.readValue(data, entityClass);
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
