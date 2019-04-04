package textspeech.thezaxis.emandi;

public class Sell {
    private String name, details, id;
    private double rate, area, quantity, price;

    public Sell(String name, String details, double rate, double area, double quantity, double price) {
        this.name = name;
        this.details = details;
        this.rate = rate;
        this.area = area;
        this.quantity = quantity;
        this.price = price;
    }

    public Sell() {
    }

    public Sell(String name, String details, String id, double rate, double area, double quantity, double price) {
        this.name = name;
        this.details = details;
        this.id = id;
        this.rate = rate;
        this.area = area;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
