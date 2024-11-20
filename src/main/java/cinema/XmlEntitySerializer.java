package cinema;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;

public class XmlEntitySerializer<T> implements EntitySerializer<T> {
    private final XmlMapper xmlMapper;
    private final Class<T> entityClass;

    public XmlEntitySerializer(Class<T> entityClass) {
        this.xmlMapper = new XmlMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        SimpleModule customModule = new SimpleModule();
        customModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer());
        customModule.addSerializer(LocalTime.class, new LocalTimeSerializer());
        this.xmlMapper.registerModule(javaTimeModule);
        this.xmlMapper.registerModule(customModule);
        this.entityClass = entityClass;
    }

    @Override
    public String serialize(T entity) throws IOException {
        return xmlMapper.writeValueAsString(entity);
    }

    @Override
    public T deserialize(String data) throws IOException {
        return xmlMapper.readValue(data, entityClass);
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
