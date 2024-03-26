package task3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable{
    private String fullName;
    private Map<String,Double> courseInformation;
    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = courseInformation;
    }

    public Map<String, Double> getCourseInformation() {
        return courseInformation;
    }
    @Override
    public Student clone() {
        try {
            Student clone = (Student) super.clone();
            clone.courseInformation = new HashMap<>(this.courseInformation);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public String toString() {
        return "Student:" +
                "fullName: '" + fullName +
                ", courseInformation: " + courseInformation;
    }
}
