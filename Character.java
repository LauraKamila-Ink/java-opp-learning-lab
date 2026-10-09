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
    
    public static void displayInfo(){
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
}