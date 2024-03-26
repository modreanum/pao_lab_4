package task3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Double> map=new HashMap<>();
        map.put("Info",8.5);
        map.put("Math",9.0);
        Student s1 = new Student("Student_name",map);
        Student s2=s1.clone();
        s2.getCourseInformation().put("info2",5.0);
        System.out.println(s1.toString());
        System.out.println(s2.toString());




    }

}
