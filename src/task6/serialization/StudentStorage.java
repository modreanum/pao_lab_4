package task6.serialization;

import task6.domain.Student;
import task6.serialization.deserializer.StudentDeserializer;
import task6.serialization.serializer.StudentSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StudentStorage {
    private final StudentSerializer serializer;
    private final StudentDeserializer deserializer;

    public StudentStorage(StudentSerializer serializer, StudentDeserializer deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public List<Student> readAllStudents(InputStream inputStream) {
        try {List<Student> students=new ArrayList<>();
            while (inputStream.available() != 0) {
                students.add(this.deserializer.deserializer(inputStream));
            }
            return students;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return Collections.emptyList();
    }

    public void writeAllStudents(OutputStream outputStream, List<Student> students) {
        for (Student s : students) {
            this.serializer.serialize(outputStream, s);
        }
    }
}
