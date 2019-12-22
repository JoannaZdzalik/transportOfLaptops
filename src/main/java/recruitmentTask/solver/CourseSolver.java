package recruitmentTask.solver;

import recruitmentTask.core.Course;
import recruitmentTask.core.Package;
import recruitmentTask.fileReader.PackageDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseSolver {

    public static List<Course> listOfAllCourses = new ArrayList<>();

    public void solveCourses() throws IOException {
        PackageDatabase.getListOfPackagesFromFile();
        createCourses();
        Course.showAllCourses();
    }

    private static void createCourses() throws IOException {
        List<Package> listOfAvailablePackages = PackageDatabase.getListOfPackagesFromFile();
        while (!listOfAvailablePackages.isEmpty()) {
            List<Package> listOfPackagesInCourse = new ArrayList<>();
            int laptopsThatStillCanBeTaken = 250;

            while (!listOfAvailablePackages.isEmpty() && laptopsThatStillCanBeTaken > 0) {
                int finalLpsToBeTaken = laptopsThatStillCanBeTaken;

                if (listOfAvailablePackages.stream().anyMatch(p -> p.getNumberOfLaptops() == finalLpsToBeTaken)) {
                    Package nextPackage =
                            listOfAvailablePackages.stream()
                                    .filter(p -> p.getNumberOfLaptops() == finalLpsToBeTaken)
                                    .findFirst().orElseThrow(() -> new RuntimeException("No such element"));
                    listOfPackagesInCourse.add(nextPackage);
                    laptopsThatStillCanBeTaken -= nextPackage.getNumberOfLaptops();
                    listOfAvailablePackages.remove(nextPackage);
                } else if (listOfAvailablePackages.stream().anyMatch(p -> p.getNumberOfLaptops() < finalLpsToBeTaken)) {
                    Package nextPackage =
                            listOfAvailablePackages.stream()
                                    .filter(p -> p.getNumberOfLaptops() < finalLpsToBeTaken)
                                    .max(Comparator.comparing(Package::getNumberOfLaptops))
                                    .orElseThrow(() -> new RuntimeException("No such element"));
                    listOfPackagesInCourse.add(nextPackage);
                    laptopsThatStillCanBeTaken -= nextPackage.getNumberOfLaptops();
                    listOfAvailablePackages.remove(nextPackage);
                } else {
                    laptopsThatStillCanBeTaken = 0;
                }
            }
            Course singleCourse = new Course(listOfPackagesInCourse);
            addNewCourseToListOfCourses(singleCourse, listOfAllCourses);
        }
    }

    private static void addNewCourseToListOfCourses(Course course, List<Course> listOfAllCourses) {
        listOfAllCourses.add(course);
    }
}
