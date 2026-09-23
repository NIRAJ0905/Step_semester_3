package week7_encapsulation.assignment_problems;

public class GameCharacter {
    private final int maxHealth; // Fixed max health[cite: 7]
    private int health;          // Private current health[cite: 7]

    public GameCharacter(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Starts fully healed[cite: 7]
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health = Math.max(0, health - amount); // Clamped at 0[cite: 7]
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health = Math.min(maxHealth, health + amount); // Capped at maxHealth[cite: 7]
        }
    }

    public int getHealth() {
        return health; // Read-only access[cite: 7]
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        GameCharacter c = new GameCharacter(100);
        c.takeDamage(30);
        System.out.println("Health: " + c.getHealth()); // 70[cite: 7]
        c.heal(50);
        System.out.println("Health: " + c.getHealth()); // 100 (capped)[cite: 7]
        c.takeDamage(150);
        System.out.println("Health: " + c.getHealth()); // 0 (floored)[cite: 7]
    }
}