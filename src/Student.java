import java.util.ArrayList;

public class Student {

    private String studentId;
    private String name;
    private ArrayList<Integer> marks;


    public Student(String studentId, String name, ArrayList<Integer> marks) {

        this.studentId = studentId;
        this.name = name;
        this.marks = marks;

    }

 public String getStudentId() {

        return studentId;

    }

    public String getName() {

        return name;

    }

public ArrayList<Integer> getMarks() {

        return marks;

    }

}