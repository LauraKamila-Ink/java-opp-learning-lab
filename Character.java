//Attributes

public class Character {
    String name;
    int health;
    int damage;
    boolean isAlive;
    int maxHealth;

    //Constructor
    public Character(String name, int health, int damage, boolean isAlive, int maxHealth){
        this.name=name;
        this.health=health;
        this.damage=damage;
        this.isAlive=isAlive;
        this.maxHealth=maxHealth;
        }
    
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Is Alive: " + isAlive);
        System.out.println("Max Health: " + maxHealth);
    }
    public static void main(String[] args){
        Character character1 = new Character("Leira", 100, 40, true, 100);
        Character character2 = new Character("Shareny", 150, 70, true, 150);

        character1.displayInfo();
        character2.displayInfo();
    }

    // Method to attack another character
    public static void attack(Character target, Character attacker) {
        if(attacker.isAlive && target.isAlive) {
            target.health -= attacker.damage;
            System.out.println(attacker.name + "attacks" + target.name + "for" + attacker.damage + "damage");
            if (target.health <=0) {
                target.isAlive = false;
                System.out.println(target.name + "has been defeated");
            }
        }
    }

    // Method to take damage
    public void takeDamage(int damage) {
        if (this.isAlive) {
            if (damage <0){
                System.out.println("Damage cannot be negative");
                return;
            }
            this.health -= damage;
            System.out.println(this.name + "takes" + damage + "damage");
            if (this.health <= 0) {
                this.health = 0;
            }
            if (this.health <= 0) {
                this.isAlive = false;
                System.out.println(this.name + "has been defeated");
            }
        }
    }

    // Method to health character

    public void takeHealth (int health) {
        if (this.isAlive == false) {
            System.out.println("Cannot heal a dead character");
            return;
        }
        if (health < 0){
            System.out.println("Health cannot be negative");
            return;
        }
        this.health += health;
            System.out.println(this.name + " healed for " + health + " health points and now has " + this.health + " health points.");
        }
}