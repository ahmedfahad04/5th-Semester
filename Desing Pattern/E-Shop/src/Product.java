import java.util.List;

public class Product extends ShopComponent{
    private String name;
    private String description;
    private double price;
    private String image;
    private int inventory;
    private int quantity;

    public Product(IEShopMediator shopMediator) {
        super(shopMediator);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return  "Name = " + name + '\n' +
                "Price = " + price + '\n' +
                "Stock = " + inventory + '\n' +
                "---------------------------------";
    }

    public static void printSlip(List<Product> products, double checkOutAmount, double discount, double discountedPrice){

        System.out.println(Constants.BLUE_BOLD_BRIGHT + "\nThank you for your purchase! Your order has been confirmed." + Constants.RESET);
        System.out.println( Constants.CYAN_BOLD + "| =============================================================== ");
        System.out.printf("| %-30s %-10s %-10s %-10s %n", "Item Name", "Quantity", "Retail Price" ,"Total Amount");
        System.out.println("| --------------------------------------------------------------- ");

        for (Product product : products) {
            double totalAmount = product.getPrice() * product.getQuantity();
            System.out.printf("| %-30s %-10d $%-10.2f $%-10.2f %n", product.getName(), product.getQuantity(), product.getPrice() ,totalAmount);
        }

        System.out.println("| --------------------------------------------------------------- ");
        System.out.printf("| %-52s $%-10.2f %n", "Total", checkOutAmount);
        System.out.printf("| %-52s -$%-10.2f %n", "Discount (-" + (discount * 100) + "%)", discount * checkOutAmount);
        System.out.println("| --------------------------------------------------------------- ");
        System.out.printf("| %-52s $%-10.2f %n", "Grand Total", discountedPrice);
        System.out.println("| =============================================================== ");

        System.out.println("Your total payment is $" + discountedPrice + Constants.RESET);
    }

}
