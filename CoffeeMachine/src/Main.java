public class Main {
    public static void main(String[] args) {
        CoffeeInventory inventory = CoffeeInventory.getInstance();
        CoffeeService coffeeService = new CoffeeServiceImplementation(inventory);

        System.out.println("=== Coffee Menu ===");
        coffeeService.listCoffees();

        // Simulate multiple users ordering concurrently
        Runnable user1 = () -> coffeeService.buyCoffee(new Latte(), 10);
        Runnable user2 = () -> coffeeService.buyCoffee(new Capuccino(), 10);
        Runnable user3 = () -> coffeeService.buyCoffee(new Expresso(), 10);
        Runnable user4 = () -> coffeeService.buyCoffee(new Latte(), 5); // should fail due to funds

        Thread t1 = new Thread(user1, "User-1");
        Thread t2 = new Thread(user2, "User-2");
        Thread t3 = new Thread(user3, "User-3");
        Thread t4 = new Thread(user4, "User-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}
