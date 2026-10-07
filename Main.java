import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== REGISTER =====
        System.out.println("===== REGISTER =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = new User(name, email, password);

        System.out.println("\nRegistration successful!");

        // ===== LOGIN =====
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Email: ");
        String loginEmail = sc.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = sc.nextLine();

        if (loginEmail.equals(user.email) &&
            loginPassword.equals(user.password)) {

            System.out.println("\nLogin successful!");

            // ===== PRODUCTS =====
            Product laptop = new Product("Laptop", 50000);
            Product mobile = new Product("Mobile", 20000);
            Product headphone = new Product("Headphone", 2000);

            Cart cart = new Cart();

            int choice;

            do {

                System.out.println("\n===== PRODUCTS =====");
                System.out.println("1. Laptop - Rs.50000");
                System.out.println("2. Mobile - Rs.20000");
                System.out.println("3. Headphone - Rs.2000");
                System.out.println("4. View Cart");
                System.out.println("5. Remove from Cart");
                System.out.println("6. Checkout");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                // ===== ADD PRODUCT =====
                if (choice >= 1 && choice <= 3) {

                    Product selectedProduct = null;

                    if (choice == 1) {
                        selectedProduct = laptop;
                    } 
                    else if (choice == 2) {
                        selectedProduct = mobile;
                    } 
                    else {
                        selectedProduct = headphone;
                    }

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    if (quantity > 0) {
                        cart.addProduct(selectedProduct, quantity);
                    } 
                    else {
                        System.out.println("Invalid quantity!");
                    }
                }

                // ===== VIEW CART =====
                else if (choice == 4) {

                    cart.displayCart();
                }

                // ===== REMOVE FROM CART =====
                else if (choice == 5) {

                    cart.displayCart();

                    System.out.print("Enter product number to remove: ");
                    int productNumber = sc.nextInt();

                    cart.removeProduct(productNumber);
                }

                // ===== CHECKOUT =====
                else if (choice == 6) {

                    System.out.println("\n===== CHECKOUT =====");

                    cart.displayCart();

                    System.out.println("\nOrder placed successfully!");

                    break;
                }

                // ===== EXIT =====
                else if (choice == 7) {

                    System.out.println("Thank you for shopping!");
                }

                else {

                    System.out.println("Invalid choice!");
                }

            } while (choice != 7);
        }

        else {

            System.out.println("\nInvalid email or password!");
        }

        sc.close();
    }
}