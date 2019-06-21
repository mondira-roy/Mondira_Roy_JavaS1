public class Farmer extends GameCharacters;
{
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public int getStamina() {
        return stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = "Bob";
        this.strength = 75;
        this.health = 100;
        this.stamina = 75;
        this.speed = 10;
        this.attackPower = 1;
    }

    public void run();

    {

    }

    public void harvest();


    public void plow();


    public void attack() {

    }

    public void heal() {

    }

    public void decreaseHealth() {

    }

    public void increaseStamina() {

    }

    public void decreaseStamina() {

    }


}
