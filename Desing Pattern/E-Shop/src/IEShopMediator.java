import java.util.List;

// Mediator Pattern - Mediator Interface
public interface IEShopMediator {
    void addUser(User user);
    void addProduct(Product product);
    List<User> getListOfUsers();
    List<Product> getListOfProducts();
    void purchaseProduct(Product product, User user, IPayment paymentMethod);
}
