public class Warrior extends GameCharacters {

    private int health;
    private int stamina;
    private int speed;
    private int attackPower;
    protected int shieldStrength;
    protected String name;
    private int strength;


    public Warrior() {
    }



    public Warrior(int strength, int health, int stamina, int speed, int attackPower, int shieldStrength) {
        this.strength = 75;
        this.health = 100;
        this.stamina = 100;
        this.speed = 50;
        this.attackPower = 10;
        this.shieldStrength = 100;

    }
/*
    public int getStrength(int strength) {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth(int health) {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina(int stamina) {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed(int speed) {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower(int attackPower) {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
*/
    public int getShieldStrength(int shieldStrength) {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }


   public void run(){

    }
    public void attack() {

    }
    public void heal() {
    }
    public void decreaseHealth() {

    }
    public void increaseStamina() {
        ;
    }
    public void decreaseShieldStrength() {

    }
       }
