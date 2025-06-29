import java.util.HashMap;

public class ParkingCategoryTwo extends ParkingCategory {

    public ParkingCategoryTwo(HashMap<Integer, Car> cars) {
        this.cars = cars;
    }

    @Override
    public int getPricePerHour() {
        return 50;
    }

    @Override
    public int getCapacity() {
        return 100;
    }

}
