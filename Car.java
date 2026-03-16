/*
Lawrence Oro
Date: 03-15-26
Program: Reads data from Car_Data.csv file storing the data as objects 
allowing user to search, sort, and compute stats using a console menu.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Car {
    private String carID;
    private String brand;
    private String model;
    private int year;
    private String fuelType;
    private String color;
    private double mileageKmpl;

    // Parameterized constructor to initialize all fields of the Car class
    public Car(String carID, String brand, String model, int year, String fuelType, String color, double mileageKmpl) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.color = color;
        this.mileageKmpl = mileageKmpl;
    }
//getters and setters for all fields of the Car class
    public String getCarID() {
         return carID; 
         }
    public void setCArID(String carID) { 
        this.carID = carID; 
    }
    public String getBrand() { 
        return brand;
         }
    public void setBrand(String brand) { 
        this.brand = brand; 
    }
    public String getModel() {
         return model;
         }
    public void setModel(String model) { 
        this.model = model; 
    }
    public int getYear() { 
        return year; 
    }
    public void setYear(int year) { 
        this.year = year; 
    }
    public String getFuelType() { 
        return fuelType;
         }
    public void setFuelType(String fuelType) { 
        this.fuelType = fuelType; 
    }
    public String getColor() { 
        return color;
         }
    public void setColor(String color) { 
        this.color = color; 
    }
    public double getMileageKmpl() { 
        return mileageKmpl;
         }
    public void setMileageKmpl(double mileageKmpl) { 
        this.mileageKmpl = mileageKmpl; 
    }
//returning a string representation of the Car object for easy display
    @Override
    public String toString() {
        return String.format("%s, %s %s (%d), %s, %s, %.2f kmpl",
                carID, brand, model, year, fuelType, color, mileageKmpl);
    }
    // Static method to load cars from a CSV file and return an ArrayList of Car objects
    public static ArrayList<Car> loadCars(String fileName) {
        ArrayList<Car> working = new ArrayList<>();
// using try-with-resources to ensure the Scanner is closed after use
        try (Scanner scanner = new Scanner(new File(fileName))) {
            // skipping header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // reading each line from the CSV file, parsing it, and creating Car objects
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 7) continue;

                String carID = parts[0].trim();
                String brand = parts[1].trim();
                String model = parts[2].trim();
                int year = Integer.parseInt(parts[3].trim());
                String fuelType = parts[4].trim();
                String color = parts[5].trim();
                double mileageKmpl = Double.parseDouble(parts[6].trim());

                Car car = new Car(carID, brand, model, year, fuelType, color, mileageKmpl);
                working.add(car);
            }
            // handle potential exceptions related to file access and data parsing
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (NumberFormatException d) {
            System.err.println("Invalid number format in CSV: " + d.getMessage());
        }

        return working;
    }
}
