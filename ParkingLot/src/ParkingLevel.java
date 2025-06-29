import java.util.List;

public class ParkingLevel {
    private final List<ParkingCategory> categories;

    public ParkingLevel(List<ParkingCategory> categories) {
        this.categories = categories;
    }

    public List<ParkingCategory> getCategories() {
        return categories;
    }
}
