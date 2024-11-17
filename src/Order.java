public class Order {

    private String type;
    private String size;
    private String color;
    private double price;


    public Order(String pType, String pSize, String pColor, Double pPrice){
        type = pType;
        size = pSize;
        color = pColor;
        price = pPrice;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }
}