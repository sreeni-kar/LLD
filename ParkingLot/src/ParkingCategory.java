import java.util.Date;
import java.util.HashMap;

public abstract class ParkingCategory {
    public HashMap<Integer,Car> cars;

    abstract int getPricePerHour();
    abstract int getCapacity();

    public boolean enter(Car car){
        if(!cars.containsKey(car.getId())){
            cars.put(car.getId(), car);
            car.setEntryDate(new Date());
            return true;
        } else {
            return false;
        }
    }

    public void exit(Car car) {
        if(!cars.containsKey(car.getId())){
            return;
        }
        cars.remove(car.getId());
    }

    public int getCurrentCapacity() {
        return cars.size();
    }

    public boolean isFull() {
        return cars.size() == getCapacity();
    }
}
