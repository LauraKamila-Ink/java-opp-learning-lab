//Attributes

public class Character {
    String name;
    int health;
    int damage;
    boolean isAlive;

    //Constructor
    public Character(String name, int health, int damage, boolean isAlive){
        this.name=name;
        this.health=health;
        this.damage=damage;
        this.isAlive=isAlive;
        }
    
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Is Alive: " + isAlive);
    }

    public static void main(String[] args){
        Character character1 = new Character("Leira", 100, 40, true);
        Character character2 = new Character("Shareny", 150, 70, true);

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
    public static void takeDamage(Character character, int damage) {
        if (character.isAlive) {
            character.health -= damage;
            System.out.println(character.name + "takes" + damage + "damage");
            if (character.health <= 0) {
                character.isAlive = false;
                System.out.println(character.name + "has been defeated");
            }
        }
    }
}