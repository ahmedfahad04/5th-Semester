import java.io.IOException;

public abstract class EShopTemplate {

    public IEShopMediator mediator = new EShopPlatform();

    public void shop() throws IOException {

        displayProducts();
        addToCart();
        checkOutOrder();
    }

    public abstract void checkOutOrder() throws IOException;

    public abstract void displayProducts();

    public abstract boolean login(Constants.User userType);

    public abstract void register(User user);

    public abstract void addToCart();


}
