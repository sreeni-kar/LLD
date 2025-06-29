import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    private final List<ParkingLevel> parkingLevels;

    public ParkingLot(List<ParkingLevel> parkingLevels) {
        this.parkingLevels = parkingLevels;
    }

    public void getSpaceInfo() {
        for (int i = 0; i < parkingLevels.size(); i++) {
            List<ParkingCategory> parkingCategories = parkingLevels.get(i).getCategories();
            System.out.println("Details of floor " + i + ":");
            for (int j = 0; j < parkingCategories.size(); j++) {
                System.out.println("Category: " + (j + 1) + " No Of Vehicles: " + parkingCategories.get(j).getCurrentCapacity() + " " + "Total Vehicle Capacity: " + parkingCategories.get(j).getCapacity());
            }
        }
    }

    public void enter(Car car, int level, int category) {
        if (level > parkingLevels.size()) {
            System.out.println("Floor does not exist!");
            return;
        } else {
            ParkingCategory parkingCategory = parkingLevels.get(level).getCategories().get(category - 1);
            if (parkingCategory.isFull()) {
                System.out.println("Parking Category" + " " + category + " is full!");
                return;
            } else {
                if (!parkingCategory.enter(car)) {
                    System.out.println("Car already entered!!!");
                    return;
                }
                System.out.println("Car with ID " + " " + car.getId() + "has entered level : " + level + " category : " + category);
            }
        }
    }

    public int exitAndCalculateCost(Car car, int level, int category) {
        if (level > parkingLevels.size()) {
            System.out.println("Floor does not exist!");
            return -1;
        } else {
            ParkingCategory parkingCategory = parkingLevels.get(level).getCategories().get(category - 1);
            parkingCategory.exit(car);
            Date exitDate = new Date();

            int hours = getHours(car.getEntryDate(), exitDate);

            return hours * parkingCategory.getPricePerHour();
        }
    }

    private int getHours(Date start, Date end) {
        long diffInMillis = end.getTime() - start.getTime();
        long hours = TimeUnit.MILLISECONDS.toHours(diffInMillis);
        return Math.toIntExact(hours);
    }
}
