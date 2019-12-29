package recruitmentTask;

import recruitmentTask.solver.CourseSolver;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CourseSolver s = new CourseSolver();
        s.solveCourses();
    }
}
