//Attributes
public class Character {
    private String name;
    private int health;
    private int damage;
    private boolean isAlive;
    private int maxHealth;

    //Constructor
    public Character(String name, int health, int damage, boolean isAlive, int maxHealth){
        this.name=name;
        this.health=health;
        this.damage=damage;
        this.isAlive=isAlive;
        this.maxHealth=maxHealth;
        
        //Rules for character attributes
        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
            System.out.println("Name cannot be null or empty. Setting name to 'Unknown'.");
        }
        if (isAlive == false && health >0){
            this.isAlive = true;
            System.out.println(this.name + " cannot be dead with positive health. Setting isAlive to true.");
        }
        if (health < 0) {
            this.health = 0;
            System.out.println(this.name + " health cannot be negative. Setting health to 0.");
        }
        if (health > maxHealth) {
            this.health = maxHealth;
            System.out.println(this.name + " health cannot exceed max health. Setting health to max health: " + maxHealth);
        }
        if (maxHealth < 0) {
            this.maxHealth = 0;
            System.out.println(this.name + " max health cannot be negative. Setting max health to 0.");
        }
        if (damage < 0) {
            this.damage = 0;
            System.out.println(this.name + " damage cannot be negative. Setting damage to 0.");
        }
        if (damage > health) {
            this.damage = health;
            System.out.println(this.name + " damage cannot exceed health. Setting damage to health: " + health);
        }
        if (maxHealth < health) {
            this.maxHealth = health;
            System.out.println(this.name + " max health cannot be less than current health. Setting max health to current health: " + health);
        }
    }
    
    // Getters and Setters
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getDamage(){
        return damage;
    }
    public boolean getIsAlive(){
        return isAlive;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public String setName(String name){
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be null or empty. Name not changed.");
            return this.name;
        } else {
            this.name = name;
            return this.name;
        }
    }
    
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Is Alive: " + isAlive);
        System.out.println("Max Health: " + maxHealth);
    }
    public static void main(String[] args) {
        Character character1 = new Character("Leira", 100, 40, true, 100);
        Character character2 = new Character("Shareny", 150, 70, true, 150);
        Character character3 = new Character("Wendy", 200, 100, true, 200);

        character1.displayInfo();
        character2.displayInfo();
        character3.displayInfo();
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
        
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
            System.out.println(this.name + " is now at max health: " + this.maxHealth);
        }
    }
}