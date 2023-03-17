public abstract class ShopComponent {
    IEShopMediator shopMediator;
    public ShopComponent(IEShopMediator shopMediator){
        this.shopMediator = shopMediator;
    };

    // changed() method
    public void sendData() {
        // widgetChanged() method
        shopMediator.connectComponent(this);
    }
}
