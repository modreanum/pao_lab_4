package task6.serialization.deserializer;

import task6.domain.Student;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TextStudentDeserializer implements StudentDeserializer {
    @Override
    public Student deserializer(InputStream inputStream) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String fullName;
            Map<String, Double> courseInformation = new HashMap<>();
            fullName = reader.readLine();
            if (fullName == null)
                System.err.println("err deserializer,name");
            while ((line = reader.readLine()) != null && !line.equals("-")) {

                String[] strings = line.split(" ");
                if (strings.length == 2) {
                    String courseName = strings[0];
                    double courseGrade = Double.parseDouble(strings[1]);
                    courseInformation.put(courseName, courseGrade);
                } else {
                    System.err.println("err deserializer,grade");
                }

            }
            return new Student(fullName,courseInformation);
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }


        return null;

    }
}
