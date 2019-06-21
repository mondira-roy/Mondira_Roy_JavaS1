public class IceCreamFactory {
    private String brand;
    private String type;
    private String lot;
    private String expiry;

    public IceCreamFactory() {
    }

    public void makeIceCream(){
    }
    public void deliverIcecream(){
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public IceCreamFactory(String brand, String type, String lot, String expiry) {
        this.brand = brand;
        this.type = type;
        this.lot = lot;
        this.expiry = expiry;
    }

    public void inventory(){

    }

}
