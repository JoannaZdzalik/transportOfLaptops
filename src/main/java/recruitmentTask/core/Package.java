package recruitmentTask.core;

public class Package {

    private String signature;
    private int numberOfLaptops;

    public int getNumberOfLaptops() {
        return numberOfLaptops;
    }


    public Package(String signature, int numberOfLaptops) {
        this.signature = signature;
        this.numberOfLaptops = numberOfLaptops;
    }

    @Override
    public String toString() {
        return  signature + ", laptops inside: " + numberOfLaptops ;
    }
}
