public class lastorder {
    private final String item,restaurant;
    private final int quantity,delivery_charge;
    private final float price;

    public lastorder(String item, String restaurant, int quantity, int delivery_charge, float price) {
        this.item = item;
        this.restaurant = restaurant;
        this.quantity = quantity;
        this.delivery_charge = delivery_charge;
        this.price = price;
    }

    @Override
    public String toString() {
        return ("Bought item: " + item +", Quantity: " + quantity + "for Rs " + price+" from Restaurant " +restaurant+" and Delivery Charge: " +delivery_charge);

    }
}
