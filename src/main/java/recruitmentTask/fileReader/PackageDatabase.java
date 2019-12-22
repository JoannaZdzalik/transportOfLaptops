package recruitmentTask.fileReader;

import recruitmentTask.core.Package;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PackageDatabase {

    public static List<Package> getListOfPackagesFromFile() throws IOException {
        Path inputPath = Paths.get("zadanie-dane.txt");
        List<String> lines = Files.readAllLines(inputPath, StandardCharsets.ISO_8859_1);

        List<Package> listOfAvailablePackages = new ArrayList<>();

        for (String lineFromTextFile : lines
        ) {
            String[] holder = lineFromTextFile.split("\t");
            String signature = holder[0];
            int numberOfLaptops = Integer.parseInt(holder[1]);
            Package singlePackage = new Package(signature, numberOfLaptops);
            listOfAvailablePackages.add(singlePackage);
    }
        return listOfAvailablePackages;
    }

}
