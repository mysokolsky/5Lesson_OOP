package units;

import items.Inventory;

public class Orc extends Humanoid{

    public Orc(String name, int health, int power, int skinParam,int capacity, int money, Inventory bag) {
        super(name, health, power, skinParam,capacity, money, bag);
    }


    // по моей задумке объекты класса Orc не носят броню. Но носят оружие.
    // Поэтому ниже переопределены нулевые методы, которые позволяют
    // обойти ошибки при расчёте повреждений брони и выбора лучшей из инвентаря
    @Override
    public void defence() {

    }

    @Override
    public void damageArmor(int fp) {

    }

}
