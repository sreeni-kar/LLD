public class Player {
    private final int id;
    private final String name;
    private int currPos;

    public Player(int id, String name, int currPos) {
        this.id = id;
        this.name = name;
        this.currPos = currPos;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrPos() {
        return currPos;
    }

    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }
}
