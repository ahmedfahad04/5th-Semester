public abstract class EShopTemplate {

    public IEShopMediator mediator = new EShopPlatform();

    public void shop() {

        displayProducts();
        login(null);
        addToCart();
//        mediator.purchaseProduct(null, null, null);
    }

    public abstract void displayProducts();

    public abstract boolean login(Constants.User userType);

    public abstract void register(User user);

    public abstract void addToCart();

}
