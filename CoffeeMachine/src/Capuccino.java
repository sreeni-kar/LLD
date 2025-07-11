public class Capuccino implements Coffee{
    private static final String COFFEE_TYPE = "Capuccino";
    CoffeeIngredients coffeeIngredients;

    public Capuccino() {
        this.coffeeIngredients = new CoffeeIngredients(3,1,2);
    }

    @Override
    public int getPrice() {
        return 7;
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
