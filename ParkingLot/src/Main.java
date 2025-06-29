import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create categories
        ParkingCategory category1 = new ParkingCategoryOne(new HashMap<>()); // 50 capacity, ₹5/hr
        ParkingCategory category2 = new ParkingCategoryTwo(new HashMap<>()); // 100 capacity, ₹25/hr

        // Add categories to levels
        List<ParkingCategory> level1Categories = new ArrayList<>();
        level1Categories.add(category1);
        level1Categories.add(category2);

        List<ParkingCategory> level2Categories = new ArrayList<>();
        level2Categories.add(new ParkingCategoryOne(new HashMap<>()));
        level2Categories.add(new ParkingCategoryTwo(new HashMap<>()));

        // Create parking levels
        ParkingLevel level1 = new ParkingLevel(level1Categories);
        ParkingLevel level2 = new ParkingLevel(level2Categories);

        // Add levels to parking lot
        List<ParkingLevel> parkingLevels = new ArrayList<>();
        parkingLevels.add(level1);
        parkingLevels.add(level2);

        ParkingLot parkingLot = new ParkingLot(parkingLevels);

        // Create a car
        Car car1 = new Car(101, null);

        // Show initial space info
        System.out.println("Before entry:");
        parkingLot.getSpaceInfo();

        // Enter the car at level 0, category 0
        parkingLot.enter(car1, 0, 1);

        // Simulate wait time (2 seconds = 0 hours, just for testing)
        Thread.sleep(2000);

        System.out.println("After entry:");
        parkingLot.getSpaceInfo();

        // Exit the car and calculate cost
        int cost = parkingLot.exitAndCalculateCost(car1, 0, 1);
        System.out.println("Cost for car ID " + car1.getId() + ": ₹" + cost);

        // Show space info after exit
        System.out.println("After exit:");
        parkingLot.getSpaceInfo();
    }
}
