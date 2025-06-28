public class Dice {
    private final int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int roll() {
        int totalSum = 0;
        for (int i = 0; i < numberOfDice; i++) {
            totalSum += ((int) (Math.random() * 6)) + 1;
        }
        return totalSum;
    }
}
