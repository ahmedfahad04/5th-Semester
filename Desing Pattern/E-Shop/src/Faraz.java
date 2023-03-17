import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.CompletionService;

public class Faraz extends EShopTemplate {

    private List<Product> products = mediator.getListOfProducts();
    private List<User> users = mediator.getListOfUsers();
    private List<Product> productCart = new ArrayList<Product>();

    @Override
    public void displayProducts() {

        while (true) {
            if (products.size() == 0) {
                System.out.println("\n--------------------------------");
                System.out.println("No products available. Let ADMIN to Login & Products");
                addNewProduct();
            } else {
                System.out.println("PRODUCT LIST: ============= Total Products: " + products.size());
                for (int i = 0; i < products.size(); i++) {
                    int id = i + 1;
                    System.out.println("ID: " + id + "\n" + products.get(i));
                }
                System.out.println(Constants.RED + "Before purchasing products, please Login...\n" + Constants.RESET);
                break;
            }
        }

    }

    @Override
    public boolean login(Constants.User userType) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your " + Constants.GREEN +  "EMAIL: " + Constants.RESET);
        String email = scanner.nextLine();
        System.out.print("Enter your " + Constants.GREEN +  "PASSWORD: " + Constants.RESET);
        String password = scanner.nextLine();

        // TODO: Validation Process faulty.
        User user = new User(mediator);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserType(userType);

        // TODO: Strategy pattern
        if (checkPassword(user)) {
            if (userType == Constants.User.Admin) {
                System.out.println(Constants.BLUE_BOLD + "\nWelcome " + user.getEmail() + "!" + Constants.RESET);
                return true;
            } else if (userType == Constants.User.Customer) {
                System.out.println(Constants.BLUE_BOLD + "\nYou are successfully logged in. Now you can add to cart!\n"+Constants.RESET);
                return true;
            } else {
                return false;
            }
        } else {
            if (ifRegistered(user)) {
                System.out.println(Constants.RED + "\nInvalid email or password\n" + Constants.RESET);
            } else {
                System.out.println(Constants.RED + "\nYou are not registered. Register first!\n" + Constants.RESET);
                register(user);
            }
            return false;
        }
    }

    @Override
    public void register(User user) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your " + Constants.GREEN +  "NAME:");
        user.setName(scanner.nextLine());
        System.out.print("Please enter your " + Constants.GREEN +  "ADDRESS:");
        user.setAddress(scanner.nextLine());
        System.out.print("Please enter your " + Constants.GREEN +  "MOBILE NUMBER:");
        user.setPhoneNumber(scanner.nextLine());

        user.setUserType(Constants.User.Customer);

        mediator.connectComponent(user);

        try (FileWriter fileWriter = new FileWriter("users.txt", true)) {
            fileWriter.write(user.getName() + ',' + user.getEmail() + ',' + user.getPassword() + ',' + user.getPhoneNumber() + ',' + user.getAddress() + ',' + user.getUserType() + '\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(user.getName() + " has successfully registered. Total Users: " + mediator.getListOfUsers().size());
    }

    @Override
    public void addToCart() {

        Product product = null;

        while (!login(Constants.User.Customer)) {
            System.out.println("Please Login again...");
        }

        String status = "y";
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter " + Constants.GREEN +  "Product ID: " + Constants.RESET);
            int productID = scanner.nextInt();

            System.out.print("Enter " + Constants.GREEN +  "Product Quantity: ");
            int productQuantity = scanner.nextInt();

            product = products.get(productID - 1);
            product.setQuantity(productQuantity);

            productCart.add(product);
            System.out.println(Constants.GREEN_BOLD + "Product added" + Constants.RESET);

            System.out.println("Add more? (yes/no)");
            status = scanner.next();
            if (!status.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nShopping done. Now pay to get your receipt...\n");
    }

    @Override
    public void checkOutOrder() {
        mediator.purchaseProduct(productCart);
    }

    public void addNewProduct() {
        System.out.println(Constants.RED + "Before you proceeds, Login as Admin...\n" + Constants.RESET);


        while (!login(Constants.User.Admin)) {
            System.out.println("Please Login again...");
        }


        System.out.println(Constants.BLUE + "Admin Login Successfully...\n" + Constants.RESET);

        String status = null;

        try (FileWriter fileWriter = new FileWriter("products.txt", true)) { // Open the file for appending
            while (true) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("\nEnter the "+ Constants.GREEN + "PRODUCT NAME: " + Constants.RESET);
                String productName = scanner.nextLine();
                System.out.print("Enter "+ Constants.GREEN + "PRODUCT DETAILS: " + Constants.RESET);
                String productDetails = scanner.nextLine();
                System.out.print("Enter the "+ Constants.GREEN + "PRODUCT PRICE: " + Constants.RESET);
                double productPrice = scanner.nextDouble();       // TODO: crash when we enter string
                System.out.print("Enter "+ Constants.GREEN + " Quantity: " + Constants.RESET);
                int productQuantity = scanner.nextInt();

                // -----------------------------------------------
                Product product = new Product(mediator);
                product.setName(productName);
                product.setDescription(productDetails);
                product.setPrice(productPrice);
                product.setImage(null);
                product.setInventory(productQuantity);

                mediator.connectComponent(product);
                // -----------------------------------------------

                // Save the product to the file
                fileWriter.write(productName + ',' + productDetails + ',' + productPrice + ',' + null + ',' + productQuantity + '\n');
                System.out.println(Constants.BLUE_BOLD + "\nProduct " + productName.toUpperCase() + " has been added successfully\n" + Constants.RESET);

                System.out.println(Constants.CYAN_BOLD + "Add more? (yes/no)" + Constants.RESET);
                status = scanner.next();
                if (!status.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // THis need to be moved...
    public boolean ifRegistered(User user) {

        for (User x : users) {
            if (x.getUserType() == user.getUserType()) {
                if (Objects.equals(x.getEmail(), user.getEmail()) || Objects.equals(x.getPassword(), user.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPassword(User user) {

        for (User x : users) {
            if (x.getUserType() == user.getUserType()) {
                if (Objects.equals(x.getEmail(), user.getEmail()) && Objects.equals(x.getPassword(), user.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
}
