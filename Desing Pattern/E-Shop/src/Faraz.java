import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Faraz extends EShopTemplate {

    private List<Product> products = new ArrayList<Product>();
    private List<User> users = new ArrayList<User>();

    @Override
    public void displayProducts() {
        products = mediator.getListOfProducts();

        while (true) {
            if (products.size() == 0) {
                System.out.println("No products available. Only Admin Can add Products.");
                addNewProduct();
            } else {
                System.out.println("PRODUCT LIST: ============= Total Products: " + products.size());
                for (int i = 0; i < products.size(); i++) {
                    int id = i + 1;
                    System.out.println("ID: " + id + "\n" + products.get(i));
                }
                break;
            }
        }

    }

    @Override
    public boolean login(Constants.User userType) {
        users = mediator.getListOfUsers();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your EMAIL:");
        String username = scanner.nextLine();
        System.out.println("Please enter your PASSWORD:");
        String password = scanner.nextLine();

        // TODO: Validation Process faulty.
        User user = new User(username, password);
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getEmail().equals(username) && users.get(i).getPassword().equals(password)) {
                user.setUserType(users.get(i).getUserType());
                break;
            }
        }

        // TODO: Strategy pattern
        if (ifRegistered(user)) {
            if (user.getUserType() == Constants.User.Admin) {
                System.out.println("Welcome " + user.getName() + "!");
                return true;
            } else if (user.getUserType() == Constants.User.Customer) {
                System.out.println("You are successfully logged in. Now you can add to cart!");
                return true;
            } else {
                return false;
            }
        } else {
            if (ifRegistered(user)) {
                System.out.println("Invalid email or password");
            } else {
                System.out.println("You are not registered. Register first!");
                register(user);
            }
            return false;
        }
    }

    @Override
    public void register(User user) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your NAME:");
        user.setName(scanner.nextLine());
        System.out.println("Please enter your ADDRESS:");
        user.setAddress(scanner.nextLine());
        System.out.println("Please enter your MOBILE NUMBER:");
        user.setPhoneNumber(scanner.nextLine());

        user.setUserType(Constants.User.Customer);

        mediator.addUser(user);

        try (FileWriter fileWriter = new FileWriter("users.txt", true)) {
            fileWriter.write(user.getName() +','+ user.getEmail() +','+ user.getPassword() +','+ user.getPhoneNumber() +','+ user.getAddress() +','+user.getUserType() + '\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(user.getName() + " has successfully registered. Total Users: " + mediator.getListOfUsers().size());
    }

    @Override
    public void addToCart() {

        List<Product> productCart = new ArrayList<Product>();

//        System.out.println("Login first to proceed...");
//        while (!login(Constants.User.Customer)) {
//            System.out.println("Please Try again...");
//        }

        String status = "y";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter product ID: ");
            int productID = scanner.nextInt();

            productCart.add(products.get(productID - 1));

            System.out.println("Add more? (yes/no)");
            status = scanner.next();
            if (!status.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Shopping done. Now pay to get your receipt...");
    }

    public void addNewProduct() {
        System.out.println("Before you proceeds, Login as Admin...");

        while (!login(Constants.User.Admin)) {
            System.out.println("Please Login again...");
        }
        System.out.println("Admin Login Successfully...");

        String status = null;

        try (FileWriter fileWriter = new FileWriter("products.txt", true)) { // Open the file for appending
            while (true) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Please enter the PRODUCT NAME: ");
                String productName = scanner.nextLine();
                System.out.println("Please enter PRODUCT DETAILS: ");
                String productDetails = scanner.nextLine();
                System.out.println("Please enter the PRODUCT PRICE: ");
                double productPrice = scanner.nextDouble();       // TODO: crash when we enter string
                System.out.println("Please enter Quantity: ");
                int productQuantity = scanner.nextInt();

                mediator.addProduct(new Product(productName, productDetails, productPrice, null, productQuantity));
                // Save the product to the file
                fileWriter.write(productName +','+ productDetails +','+ productPrice +','+ null +','+ productQuantity + '\n');
                System.out.println("Product " + productName.toUpperCase() + " has been added successfully");

                System.out.println("Add more? (yes/no)");
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
        public boolean ifRegistered (User user){

            users = mediator.getListOfUsers();

            for (User x : users) {
                if (Objects.equals(x.getName(), user.getName())) {
                    return true;
                } else if (Objects.equals(x.getPassword(), user.getPassword())) {
                    return true;
                }
            }
            return false;
        }
    }
