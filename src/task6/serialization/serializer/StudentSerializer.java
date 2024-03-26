package task6.serialization.serializer;

import  task6.domain.Student;

import java.io.OutputStream;

public interface StudentSerializer {
    void serialize(OutputStream outputStream, Student student);
}
