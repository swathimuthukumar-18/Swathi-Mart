package model;
import java.util.ArrayList;

public class Cart {

    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Integer> quantities = new ArrayList<>();

    // Add product
    public void addProduct(Product product, int quantity) {

        products.add(product);
        quantities.add(quantity);

        System.out.println(product.name + " added to cart!");
    }

    // Display cart
    public void displayCart() {

        if (products.size() == 0) {
            System.out.println("\nCart is empty!");
            return;
        }

        System.out.println("\n===== YOUR CART =====");

        double total = 0;

        for (int i = 0; i < products.size(); i++) {

            Product p = products.get(i);
            int q = quantities.get(i);

            double amount = p.price * q;
            total += amount;

            System.out.println(
                (i + 1) + ". " + p.name +
                " - Rs." + p.price +
                " x " + q +
                " = Rs." + amount
            );
        }

        System.out.println("Total = Rs." + total);
    }

    // Remove product
    public void removeProduct(int productNumber) {

        if (productNumber >= 1 && productNumber <= products.size()) {

            int index = productNumber - 1;

            System.out.println(
                products.get(index).name + " removed from cart!"
            );

            products.remove(index);
            quantities.remove(index);

        } 
        else {

            System.out.println("Invalid product number!");
        }
    }
}