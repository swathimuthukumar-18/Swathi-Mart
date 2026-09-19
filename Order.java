public class Order {

    Product product;
    int quantity;

    Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    void placeOrder() {
        System.out.println("Order placed successfully!");
    }
}