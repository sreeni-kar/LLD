import java.util.Date;

public class Car {
    private final int id;
    public Date entryDate;

    public Car(int id, Date entryDate) {
        this.id = id;
        this.entryDate = entryDate;
    }

    public int getId() {
        return id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
