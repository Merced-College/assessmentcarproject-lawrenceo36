import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<Car> working = Car.loadCars("Car_Data.csv");

        System.out.println("Loaded " + working.size() + " cars:\n");
        for (Car c : working) {
            System.out.println(c);
        }
    }
}
