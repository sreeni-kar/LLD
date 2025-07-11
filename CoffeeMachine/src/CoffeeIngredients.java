//Can make this immutable as an improvement
public class CoffeeIngredients {
    private int sugar;
    private int milk;
    private int beans;

    public CoffeeIngredients(int sugar, int milk, int beans) {
        this.sugar = sugar;
        this.milk = milk;
        this.beans = beans;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }
}
