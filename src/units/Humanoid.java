package units;

import items.*;

import static items.Inventory.*;


public abstract class Humanoid extends Unit {
    public int capacity; //грузоподъёмность
    public int money;


    public Inventory bag;

    public Humanoid(String name, int health, int power, int skinParam,int capacity, int money, Inventory bag) {
        super(name, health, power, skinParam);
        this.capacity = capacity;
        this.money = money;
        this.bag = bag;
    }


    //данный конструктор используется для создания объектов класса Witch, которые не имеют рюкзака Inventory
    public Humanoid(String name, int health, int power, int skinParam, int money) {
        super(name, health, power, skinParam);
        this.money = money;
    }


    @Override
    public int attack() {
        return bag.takeWeapon();
    }

    @Override
    public void defence(){
        bag.takeArmor();
    }

    @Override
    public void damageArmor(int fp) {
        bag.damageArm(fp);
    }

    @Override
    public void damageWeapon() {
        bag.damageWeap();

    }


    public void getInventory(Unit victim) {
        int emptySpace = capacity - bag.invWeight();
        maxA = emptySpace;
        a = 0;
        k = false;
        if (w != -1 ) {
            for (int i=0; i <= w; ++i) {
                if (bag.inventory[i] == null) {
                    victim.scanTake();
                    bag.inventory[i] = perekladka;
                    if (perekladka != null)
                        System.out.println(name + " забрал себе " + bag.inventory[i].name);
                    if (perekladka == null && i==w) System.out.println("У " + victim.name + " нечего взять.");

                }
            }
            if (!k) System.out.println("У " + name + " есть место в повозке, но все вещи у "+ victim.name + " слишком тяжёлые. Повозка развалится, если добавить любую из этих вещей.");
        } else {
            System.out.println("К сожалению, у "+ name + " нет места в повозке для подбора инвентаря "+victim.name);}
    }

        public void scanTake() {
            bag.takeItems();
        }


        public void viewInventory(){
            int i=0;
            int j=0;
            String itemName;
            for (Item item: bag.inventory) {
                ++i;
                if (item==null) {
                    itemName = "пусто";
                    ++j;
                }
                else itemName = item.name;
                System.out.println(i + " - " + itemName);
            }
            System.out.println("________________");
            System.out.println("В повозке всего: " + bag.inventory.length + " мест для инвентаря,");
            System.out.println("а свободно место для " + j + " вещей.");
            System.out.println("Повозка выдерживает нагрузку в " + capacity + " кг.");
            System.out.println("При этом, масса новых вещей не должна превышать " + (capacity - bag.invWeight()) + " килограмм нагрузки.");

        }





    public void getMoney(Unit victim) {
        int victimMoney = ((Humanoid) victim).money;
        System.out.println();
        System.out.println("До сражения у " + name +" было " + money + " золотых монет.");
        System.out.println("У побеждённой жертвы " + victim.name + " оказалось " + victimMoney + " золотых монет.");

        money = money + victimMoney;
        System.out.println("Теперь у " + name +" "+ money + " золотых монет.");
    }


}







