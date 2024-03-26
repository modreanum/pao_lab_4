package  task6.serialization.deserializer;

import  task6.domain.Student;

import java.io.InputStream;

public interface StudentDeserializer {
    Student deserializer(InputStream inputStream);
}
