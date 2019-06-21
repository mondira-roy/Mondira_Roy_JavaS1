

public class IceCreamShop extends IceCreamFactory{
    private String flavourChoice;
    private String shopName;
    private String shopLocation;

    public IceCreamShop(String flavourChoice, String shopName, String shopLocation) {
        this.flavourChoice = flavourChoice;
        this.shopName = shopName;
        this.shopLocation = shopLocation;
    }

    public IceCreamShop(String brand, String type, String lot, String expiry, String flavourChoice, String shopName, String shopLocation) {
        super(brand, type, lot, expiry);
        this.flavourChoice = flavourChoice;
        this.shopName = shopName;
        this.shopLocation = shopLocation;
    }

    public void chooseFlavour(){
}
public void addTopping(){

}
public void pay(){
 }
}