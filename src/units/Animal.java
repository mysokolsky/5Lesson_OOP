package units;

public class Animal extends Unit implements Inventoryless, Moneyless {
    public Animal(String name, int health, int power, int skinParam) {

        super(name, health, power, skinParam);


    }

    @Override
    public void getInventory(Unit victim) {

    }

    @Override
    public void scanTake() {

    }

    @Override
    public void viewInventory() {

    }

    @Override
    public int attack() {

        return 0;
    }

    @Override
    public void defence() {

    }

    @Override
    public void damageArmor(int letter) {

    }

    @Override
    public void damageWeapon() {

    }

    @Override
    public void getMoney(Unit victim) {

    }


}
