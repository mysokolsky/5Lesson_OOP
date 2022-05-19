package items;


public class Weapon extends Item{
    public int power;

    public Weapon(String name, int weight, int strength, int power) {
        super(name, weight, strength);
        this.power = power;
    }

    public Weapon() {
        super();
        power=0;

    }


}
