public class Expresso implements Coffee{
    private static final String COFFEE_TYPE = "Expresso";
    private final CoffeeIngredients coffeeIngredients;


    public Expresso() {
        this.coffeeIngredients = new CoffeeIngredients(2,1,3);
    }

    @Override
    public int getPrice() {
        return 2;
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
