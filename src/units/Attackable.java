package units;

public interface Attackable {



    int attack();

    void defence();

    void damageArmor(int letter);

    void damageWeapon();

    void getMoney(Unit victim);

    void getInventory(Unit victim);

    void scanTake();

    void viewInventory();
}
