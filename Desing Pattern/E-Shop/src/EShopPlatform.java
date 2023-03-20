import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// Mediator Pattern - Concrete Mediator
public class EShopPlatform implements IEShopMediator {

    double checkOutAmount = 0;
    double discount = 0.05;
    double discountedPrice = 0;

    Scanner scanner = new Scanner(System.in);
    private User myUsers;
    private Product myProducts;

    // all available users and products in EShop
    private final List<User> users;
    private final List<Product> products;

    private final List<IPaymentStrategy> paymentStrategies = List.of(
            new PayWithCard(),
            new PayWithCrypto(),
            new PayWithPayPal()
    );

    public EShopPlatform() {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
    }

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

    @Override
    public void createComponent() {
        myUsers = new User(this);
        myProducts = new Product(this);
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

    public void updateProductInventory() throws IOException {

        // Read the data from the file
        File file = new File("products.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();

        // Update the inventory value of the products
        for (Product product : products) {
            String productName = product.getName();

            for (int i = 0; i < lines.size(); i++) {
                String[] productDetails = lines.get(i).split(",");
                if (productDetails[0].equalsIgnoreCase(productName)) {
                    productDetails[4] = Integer.toString(product.getInventory());
                    lines.set(i, String.join(",", productDetails));
                    break;
                }
            }
        }

        // Write the updated data back to the file
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (String l : lines) {
            bw.write(l + "\n");
        }
        bw.close();
    }

    @Override
    public void purchaseProduct(List<Product> products) throws IOException {

        for (Product product: products) {

            int quantity = product.getQuantity();

            // Check product availability
            if (product.getInventory() <= 0 || quantity > product.getInventory()) {
                System.out.println("Sorry, the product is out of stock.");
                return;
            } else {
                product.setInventory(product.getInventory() - quantity);
                updateProductInventory();
            }

            // calculate amount
            checkOutAmount += product.getPrice() * quantity;
        }

        // payment prompts
        System.out.println(Constants.CMD_PAYEMENT);
        String paymentMethod = scanner.next();

        // Process payment [Strategy Pattern]
        for (int i=0; i<paymentStrategies.size(); i++) {
            if(paymentStrategies.get(i).checkPaymentMethod(paymentMethod)){
                discountedPrice = paymentStrategies.get(i).transaction(discount, checkOutAmount);

                if (discountedPrice == -1){
                    System.out.println(Constants.RED_BOLD_BRIGHT + "Insufficient funds. Try another payment method\n" + Constants.RESET);
                    i = -1;

                    System.out.println(Constants.CMD_PAYEMENT);
                    paymentMethod = scanner.next();
                } else {
                    discountedPrice = checkOutAmount - discount*checkOutAmount;
                    System.out.println(Constants.PURPLE_BOLD + "Payment successful!" + Constants.RESET);
                    break;
                }
            }
        }

        //Send order confirmation and payment receipt
        Product.printSlip(products, checkOutAmount, discount, discountedPrice);

    }
}