package week7_encapsulation.assignment_problems;

public class Cart {
    private final String cartId;   // Fixed cart ID[cite: 7]
    private final double[] prices; // Private array of prices[cite: 7]
    private int itemCount;         // Tracked item count[cite: 7]

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount < prices.length && price > 0) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i]; // Sum computed on request[cite: 7]
        }
        return total;
    }

    public int getItemCount() {
        return itemCount; // Computed item count[cite: 7]
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());       // 500.0[cite: 7]
        System.out.println("Item Count: " + cart.getItemCount()); // 3[cite: 7]
    }
}