import java.util.Arrays;
import java.util.List;

public class CoffeeServiceImplementation implements CoffeeService {
    private final List<Coffee> coffeeTypes;
    private final CoffeeInventory coffeeInventory;

    public CoffeeServiceImplementation(CoffeeInventory coffeeInventory) {
        this.coffeeTypes = Arrays.asList(new Latte(), new Capuccino(), new Expresso());
        this.coffeeInventory = coffeeInventory;
    }

    public void listCoffees() {
        for (Coffee coffee : coffeeTypes) {
            System.out.println(coffee.getCoffeeType() + " " + "Price: $" + coffee.getPrice());
        }
    }

    public void buyCoffee(Coffee coffee, int amount) {
        if (coffee.getPrice() > amount) {
            System.out.println("Insufficient funds to buy " + coffee.getCoffeeType());
            return;
        }

        if (!coffeeInventory.checkIngredientsAvailability(coffee)){
            System.out.println("Insufficient Ingredients to make " + coffee.getCoffeeType());
            return;
        }

        coffeeInventory.dispense(coffee);
        System.out.println("Successfully received coffee:" + coffee.getCoffeeType() + " Change provided $" + (amount - coffee.getPrice()));
    }
}
