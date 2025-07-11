public class Latte implements Coffee{
    private static final String COFFEE_TYPE = "Latte";
    private final CoffeeIngredients coffeeIngredients;

    public Latte() {
        this.coffeeIngredients = new CoffeeIngredients(1,1,1);
    }

    @Override
    public int getPrice() {
        return 10;
    }

    @Override
    public CoffeeIngredients getCoffeeIngredients() {
        return coffeeIngredients;
    }

    @Override
    public String getCoffeeType() {
        return COFFEE_TYPE;
    }
}
