package task6.serialization.serializer;

import task6.domain.Student;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class RawDataStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) {
        try{
            ObjectOutputStream o = new ObjectOutputStream(outputStream);
            o.writeObject(student);
            //System.out.println("serializer");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
