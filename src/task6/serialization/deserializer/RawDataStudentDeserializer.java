package  task6.serialization.deserializer;

import  task6.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class RawDataStudentDeserializer implements StudentDeserializer{
    @Override
    public Student deserializer(InputStream inputStream) {

            try  {
                ObjectInputStream o = new ObjectInputStream(inputStream);
                Object obj = o.readObject();
                if (obj instanceof Student) {

                    //System.out.println("deserializer");
                    return (Student) obj;
                } else
                    return null;

            } catch (IOException | ClassNotFoundException e) {

                System.out.println(e.getMessage());}

      return null;
    }}
