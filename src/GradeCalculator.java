import java.util.ArrayList;

public class GradeCalculator {


    public static int calculateTotal(ArrayList<Integer> marks) {

        int total = 0;

        for(int mark : marks) {

            total += mark;

        }

        return total;

    }

    public static double calculatePercentage(ArrayList<Integer> marks) {

        int total = calculateTotal(marks);

        return ((double) total / 500) * 100;

    }

    public static String calculateSubjectGrade(int mark) {


        if(mark >= 90)
            return "A+";

        else if(mark >= 85)
            return "A";

        else if(mark >= 80)
            return "B+";

        else if(mark >= 75)
            return "B";

        else if(mark >= 70)
            return "C+";

        else if(mark >= 65)
            return "C";

        else if(mark >= 60)
            return "D+";

        else if(mark >= 50)
            return "D";

        else
            return "F";

    }

    public static double calculateGradePoint(int mark) {


        if(mark >= 85)
            return 4.0;

        else if(mark >= 80)
            return 3.5;

        else if(mark >= 75)
            return 3.0;

        else if(mark >= 70)
            return 2.5;

        else if(mark >= 65)
            return 2.0;

        else if(mark >= 60)
            return 1.5;

        else if(mark >= 50)
            return 1.0;

        else
            return 0.0;

    }

    public static double calculateGPA(ArrayList<Integer> marks) {


        double totalPoints = 0;


        for(int mark : marks) {

            totalPoints += calculateGradePoint(mark);

        }


        return totalPoints / marks.size();

    }

 public static String calculateOverallGrade(double percentage) {


        if(percentage >= 90)
            return "A+";

        else if(percentage >= 85)
            return "A";

        else if(percentage >= 80)
            return "B+";

        else if(percentage >= 75)
            return "B";

        else if(percentage >= 70)
            return "C+";

        else if(percentage >= 65)
            return "C";

        else if(percentage >= 60)
            return "D+";

        else if(percentage >= 50)
            return "D";

        else
            return "F";

    }

public static String calculateStatus(double percentage) {


        if(percentage >= 50)

            return "PASS";

        else

            return "FAIL";

    }

}