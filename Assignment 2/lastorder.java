public class lastorder {
    private final String restaurant;
    private final int quantity,deliverycharge;
    private final float price;

    public lastorder(String restaurant, int quantity, float price,int deliverycharge) {
        this.restaurant = restaurant;
        this.quantity = quantity;
        this.deliverycharge=deliverycharge;
        this.price = price;
    }

    @Override
    public String toString() {
        return ("There were few items, Total Quantity: " + quantity + "for Rs " + price+" from Restaurant " +restaurant
        +" With delivery charge: "+deliverycharge);

    }
}
