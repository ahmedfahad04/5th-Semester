import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Mediator Pattern - Concrete Mediator
public class EShopPlatform implements IEShopMediator {

    private User myusers;
    private Product myproducts;

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

    public double applyDiscount(double discount, double amount) {
        double newPrice = discount*amount;
        System.out.println(discount + " discount applied!");
        return amount - newPrice;
    }

    @Override
    public void createComponent() {
        myusers = new User(this);
        myproducts = new Product(this);
    }

    @Override
    public void connectComponent(ShopComponent shopComponent) {
        if (shopComponent instanceof User) {
            this.users.add((User) shopComponent);
        } else if (shopComponent instanceof Product) {
            this.products.add((Product) shopComponent);
        }
    }

    @Override
    public List<User> getListOfUsers() {
        // read data from the file
        try {
            File myObj = new File("users.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");

                User user = new User(this);
                user.setEmail(data[0]);
                user.setPassword(data[1]);
                user.setName(data[2]);
                user.setAddress(data[3]);
                user.setPhoneNumber(data[4]);
                user.setUserType(Constants.User.valueOf(data[5]));

                this.users.add(user);

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

        // read data from the file
        try {
            File myObj = new File("products.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");

                Product product = new Product(this);
                product.setName(data[0]);
                product.setDescription(data[1]);
                product.setPrice(Double.parseDouble(data[2]));
                product.setImage(data[3]);
                product.setInventory(Integer.parseInt(data[4]));

                this.products.add(product);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public void purchaseProduct(List<Product> products) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Payment Gateway (eg. cc for Credit Card): ");
        System.out.println(Constants.BLUE_BOLD + "cc: Credit Card\ncrc: Cryptocurrency\npp: PayPal" + Constants.RESET);
        String paymentMethod = scanner.next();

        double checkOutAmount = 0;
        double discount = 0.05;
        double discountedPrice = 0;

        for (Product product: products) {

            int quantity = product.getQuantity();

            // Check product availability
            if (product.getInventory() <= 0 && quantity > product.getInventory()) {
                System.out.println("Sorry, the product is out of stock.");
                return;
            } else {
                product.setInventory(product.getInventory() - quantity);
            }

            // calculate amount
            checkOutAmount += product.getPrice() * quantity;

        }


        // Process payment [Strategy Pattern]
        for(IPaymentStrategy paymentStrategy: paymentStrategies) {
            if(paymentStrategy.checkPaymentMethod(paymentMethod)){
                discountedPrice = paymentStrategy.transaction(discount, checkOutAmount);
            }
        }

        if (discountedPrice == -1){
            System.out.println("Insufficient funds");
            return;
        } else {
            discountedPrice = checkOutAmount - discount*checkOutAmount;
        }


        //Send order confirmation and payment receipt
        System.out.println("\nThank you for your purchase! Your order of has been confirmed.");

        System.out.println("| ===========================Receipt====================== ");
        System.out.println("| Item Name \t\t Quantity \t\t Total Amount    ");
        for(Product product: products) {
            System.out.println("| " + product.getName() + " \t\t\t\t " + product.getPrice() +" x " +product.getQuantity() + " \t\t\t = " + product.getPrice()*product.getQuantity() + "     ");
        }
        System.out.println("|     \t\t\t\t\t\t\t\t " + "--------------" + "     ");
        System.out.println("| Total  \t\t\t\t\t\t\t\t = " + checkOutAmount + "     ");
        System.out.println("| Discount \t\t\t\t\t\t\t\t ("+"-"+ discount*checkOutAmount + ")     ");
        System.out.println("|       \t\t\t\t\t\t\t " + "--------------" + "     ");
        System.out.println("| Grand Total \t\t\t\t\t\t\t  " + discountedPrice + "     ");
        System.out.println("| ========================================================= ");

        System.out.println("Your total payment is " + discountedPrice);
    }
}