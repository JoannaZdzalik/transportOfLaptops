package recruitmentTask.core;

import recruitmentTask.solver.CourseSolver;

import java.util.List;

public class Course {

    public static long COUNTER = 1;
    private long courseId;
    private List<Package> listOfPackages;

    public List<Package> getListOfPackages() {
        return listOfPackages;
    }

    public Course(List<Package> listOfPackages) {
        courseId = COUNTER++;
        this.listOfPackages = listOfPackages;
    }

    public static void showAllCourses() {
        System.out.println("Courses in total: " + countAllCourses());
        for (Course c : CourseSolver.listOfAllCourses
        ) {
            if (c != null) {
                System.out.println(c);
            }
        }
    }

    private static int countAllCourses() {
        return CourseSolver.listOfAllCourses.size();
    }

    @Override
    public String toString() {
        return "Course[" + courseId + "] :\n" + getListOfPackages() + "\n";
    }
}
