public class CoffeeInventory {
    private static final CoffeeInventory instance = new CoffeeInventory(new CoffeeIngredients(10,8,5));
    private static final int BORDERLINE_QUANTITY = 2;

    private final CoffeeIngredients storageQuantity;


    private CoffeeInventory(CoffeeIngredients storageQuantity) {
        this.storageQuantity = storageQuantity;
    }

    synchronized public void dispense(Coffee coffee){
        useInventory(coffee);
    }

    private void useInventory(Coffee coffee){
        CoffeeIngredients coffeeIngredients = coffee.getCoffeeIngredients();

        if(storageQuantity.getSugar() < coffeeIngredients.getSugar() || storageQuantity.getBeans() < coffeeIngredients.getBeans() || storageQuantity.getMilk() < coffeeIngredients.getMilk()){
            System.out.println("Insufficient Ingredients to make " + coffee.getCoffeeType());
            return;
        }

        storageQuantity.setBeans(storageQuantity.getBeans() - coffeeIngredients.getBeans());
        storageQuantity.setMilk(storageQuantity.getMilk() - coffeeIngredients.getMilk());
        storageQuantity.setSugar(storageQuantity.getSugar() - coffeeIngredients.getSugar());

        notifyLackOfIngredients();
    }

    private void notifyLackOfIngredients(){
        if(storageQuantity.getSugar() < BORDERLINE_QUANTITY){
            System.out.println("Low on Sugar in Inventory!");
        }

        if(storageQuantity.getMilk() < BORDERLINE_QUANTITY){
            System.out.println("Low on Milk in Inventory!");
        }

        if(storageQuantity.getBeans() < BORDERLINE_QUANTITY) {
            System.out.println("Low on Coffee Beans in Inventory!");
        }
    }

    synchronized public boolean checkIngredientsAvailability(Coffee coffee){
        CoffeeIngredients coffeeIngredients = coffee.getCoffeeIngredients();
        return storageQuantity.getSugar() >= coffeeIngredients.getSugar() && storageQuantity.getBeans() >= coffeeIngredients.getBeans() && storageQuantity.getMilk() >= coffeeIngredients.getMilk();
    }


    public static CoffeeInventory getInstance(){
        return instance;
    }
}
