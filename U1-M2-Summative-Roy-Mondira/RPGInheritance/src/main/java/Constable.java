public class Warrior extends Constable{
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed ;

    //public Constable(int strength, int health, int stamina, int speed, int attackPower, int shieldStrength) {
    //    super(strength, health, stamina, speed, attackPower, shieldStrength);
    }

    @Override
    public int getShieldStrength(int shieldStrength) {
        return super.getShieldStrength(shieldStrength);
    }

    @Override
    public void setShieldStrength(int shieldStrength) {
        super.setShieldStrength(shieldStrength);
    }

    @Override
    public void decreaseShieldStrength() {
        super.decreaseShieldStrength();
    }

    public Constable() {
    }

    private int attackPower;

    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength) {
        super(strength, health, stamina, speed, attackPower, shieldStrength);
    }

    private int jurisdiction;

    public String getName(String name) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJurisdiction(int jurisdiction) {
        return jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

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

    public Constable(int strength, int health, int stamina, int speed, int attackPower) {
        this.strength = 60;
        this.health =100;
        this.stamina =  60;
        this.speed = 20;
        this.attackPower = 5;
    }

 public void run(){

 }
    public void arrest(){

    }
    public void attack(){

    }
    public void heal(){

    }
    public void decreaseHealth(){

    }
    public void increaseStamina(){

    }
    public void decreaseStamina(){

    }
}
