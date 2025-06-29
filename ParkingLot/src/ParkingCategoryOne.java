import java.util.HashMap;

public class ParkingCategoryOne extends ParkingCategory {

    public ParkingCategoryOne(HashMap<Integer, Car> cars) {
        this.cars = cars;
    }

    @Override
    public int getPricePerHour() {
        return 5;
    }

    @Override
    public int getCapacity() {
        return 50;
    }


}
