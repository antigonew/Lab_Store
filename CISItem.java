public class CISItem {
    private String name;
    private String location;
    private int price;
    private String description;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocaiton(String locaiton) {
        this.location = locaiton;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public CISItem(String name, String locaiton, int price, String description) {
        this.name = name;
        this.location = locaiton;
        this.price = price;
        this.description = description;
    }
    public String toString() {
        return name + " " + location + " " + price + " " + description;
    }
}