import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Mediator Pattern - Concrete Mediator
public class EShopPlatform implements IEShopMediator {

    // all available users and products in EShop
    private List<User> users;
    private List<Product> products;

    private final List<IPaymentStrategy> paymentStrategies = List.of(
            new PayWithCard(),
            new PayWithCrypto(),
            new PayWithPayPal()
    );

    public EShopPlatform() {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void addProduct(Product product) {

        this.products.add(product);
    }

    @Override
    public List<User> getListOfUsers() {
        try {
            File myObj = new File("users.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                this.users.add(new User(data[0],data[1],data[2],data[3],data[4],data[5]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return this.users;
    }

    @Override
    public List<Product> getListOfProducts() {
        try {
            File myObj = new File("products.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                this.products.add(new Product(data[0],data[1],Double.parseDouble(data[2]),data[3],Integer.parseInt(data[4])));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public void purchaseProduct(List<Product> products, User user, String paymentMethod) {

        double checkOutAmount = 0;

        for (Product product: products) {

            int quantity = product.getQuantity();

            // Check product availability
            if (product.getInventory() <= 0 && quantity > product.getInventory()) {
                System.out.println("Sorry, the product is out of stock.");
                return;
            } else {
                product.setInventory(product.getInventory() - quantity);
            }

            // Login as user at that point

            // calculate amount
            checkOutAmount += product.getPrice() * quantity;

        }

        // Process payment [Strategy Pattern]

        for(IPaymentStrategy paymentStrategy: paymentStrategies) {
            if(paymentStrategy.checkPaymentMethod(paymentMethod)){
                paymentStrategy.transaction(checkOutAmount);
            }
        }

        //Send order confirmation and payment receipt
        System.out.println("Thank you for your purchase! Your order of has been confirmed.");
        System.out.println("Your total payment is " + checkOutAmount + ". A receipt will be sent to your email.");
    }
}