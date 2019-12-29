package recruitmentTask;

import recruitmentTask.solver.CourseSolver;

import java.io.IOException;

public class Main {

    public static void main(String[] args, String aaaaa) throws IOException {

        CourseSolver s = new CourseSolver();
        s.solveCourses();
        System.out.println(aaaaa);
    }
}
