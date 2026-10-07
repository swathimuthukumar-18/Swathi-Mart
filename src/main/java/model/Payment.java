package model;

public class Payment {

    int amount;

    Payment(int amount) {
        this.amount = amount;
    }

    void makePayment() {
        System.out.println("Payment successful!");
        System.out.println("Amount Paid: Rs." + amount);
    }
}