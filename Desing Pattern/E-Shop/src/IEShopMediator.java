import java.io.IOException;
import java.util.List;

// Mediator Pattern - Mediator Interface
public interface IEShopMediator {

    void createComponent();
    void connectComponent(ShopComponent shopComponent);
    List<User> getListOfUsers();
    List<Product> getListOfProducts();
    void purchaseProduct(List<Product> products) throws IOException;
    boolean checkPassword(User user);
    boolean ifRegistered(User user);
}
