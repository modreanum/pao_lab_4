package  task6.serialization.serializer;

import  task6.domain.Student;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;


public class TextStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) {
        try{
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(student.getFullName() + "\n");
            for (Map.Entry<String, Double> entry : student.getCourseInformation().entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            writer.write("-\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
