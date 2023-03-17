public abstract class EShopTemplate {

    public IEShopMediator mediator = new EShopPlatform();

    public void shop() {

        displayProducts();
//        login(Constants.User.Customer);
        addToCart();
        checkOutOrder();
    }

    public abstract void checkOutOrder();

    public abstract void displayProducts();

    public abstract boolean login(Constants.User userType);

    public abstract void register(User user);

    public abstract void addToCart();


}
