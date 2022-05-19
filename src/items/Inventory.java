package items;

public class Inventory {
    public Item[] inventory;

    public static int w=-1, a=-1;
    public static double maxA = 0;
    public static boolean k = false;

    public Inventory(int size){
        this.inventory = new Item[size];
    }

    public static Item perekladka = null;

        // Ниже метод расчёта массы всего инвентаря персонажа. В качестве временной переменной
        // для расчёта используется глобальная переменная для сохранения максимального коэф. сопротивления брони
    public int invWeight(){
        maxA = 0;
        w=-1;
        int i=-1;
        for (Item invent: inventory
             ) {
            ++i;
            if (invent != null) {maxA += invent.weight;
            }
            else{ w=i; }
        }
        return (int) maxA;
    }

    // захват предметов из инвентаря жертвы
    public void takeItems(){
        perekladka = null;

        for (; a<inventory.length;++a) {
            if (inventory[a] != null) {
                if (inventory[a].weight <= maxA) {
                    perekladka = inventory[a];
                    maxA = maxA - inventory[a].weight;
                    inventory[a] = null;
                    ++a;
                    k = true;
                    return;
                }
            }



        }

    }






    // выбор лучшего оружия из инвентаря и запоминание его индекса в глобальную переменную w
    public int takeWeapon(){


        int maxW = 0;

         w = -1;


        for (int i=0; i<inventory.length; ++i) {

            if (inventory[i] instanceof Weapon) {
                if (((Weapon) inventory[i]).power>maxW){
                    maxW = ((Weapon) inventory[i]).power;
                    w = i;
                }

            }

        }

        if (w!=-1) {
            System.out.println();
            System.out.println();
            System.out.println("--------- Выбрано оружие " + inventory[w].name + ": -------------");
            System.out.println("Масса, кг: " + inventory[w].weight);
            System.out.println("Остаток прочности: " + inventory[w].strength);
            System.out.println("Коэф. силы оружия (Больше - лучше):  " + maxW);
            System.out.println("-----------------------------------------------------");
            System.out.println();
        }

        return maxW;

    }


    // метод выбора лучшей защиты из инвентаря и запоминание её индекса в глобальную переменную a
    public void takeArmor(){

        maxA = 0;

        a = -1;

        for (int i=0; i<inventory.length; ++i) {


                if (inventory[i] instanceof Armor) {

                    if (((Armor) inventory[i]).armParam>maxA){
                         maxA = ((Armor) inventory[i]).armParam;    // глобальная переменная, которая служит для запоминания максимального значения коэф. сопротивления брони
                         a = i;
                    }
                }


        }

        if (a!=-1) {
            System.out.println();
            System.out.println();
            System.out.println("--------- Выбрана броня " + inventory[a].name + " : -------------");
            System.out.println("Масса, кг: " + inventory[a].weight);
            System.out.println("Остаток прочности: " + inventory[a].strength);
            System.out.println("Коэф. сопр. атаке ( = 50 ... 100. Больше - лучше):  " + (int) maxA);
            System.out.println("---------------------------------------------------------------");
            System.out.println();
        }
    }



    // метод расчёта повреждения оружия нападающего
    public void damageWeap() {      // повреждение оружия

        Weapon weapon = (Weapon) inventory[w];

        weapon.strength -= 5;       // при каждом нападении оружие уменьшает свою прочность на 5 единиц

        weapon.power = (int) (weapon.power*(100-maxA/6)/100);   // при каждой атаке травмирующая сила оружия нападающего снижается
                                                                // в зависимости от коэффициента сопротивления брони жертвы

        System.out.println();
        System.out.println("Оружие " + weapon.name  + " в результате схватки повредилось на 5 пунктов прочности. ");
        if(weapon.strength>0)
        System.out.println("Новые характеристики оружия:  Прочность = " + weapon.strength +". Коэф. силы оружия = "+ weapon.power);
        else {System.out.println("Оружие " + weapon.name + " полностью разрушено.");
            inventory[w] = null;}
        System.out.println();



    }

    // метод расчёта повреждения брони жертвы
    public void damageArm(int fp) {         // повреждение брони


        Armor armor = (Armor) inventory[a];

        int damageArm=(10 * (100 + fp) / 100);      // вычисление повреждения брони в текущей атаке

        armor.strength = armor.strength - damageArm;      // уменьшение прочности брони из-за текущей атаки

        armor.armParam *= (double) (100 - fp / 3) / 100;        // уменьшение коэффициента сопротивления брони из-за текущей атаки


        System.out.println();
        System.out.println("Броня  " + armor.name  + " в результате схватки повредилась на " + damageArm + " пунктов.");
        if(armor.strength>0)
        System.out.println("Новые характеристики брони:  Прочность = " + armor.strength +". Коэф. сопр. атаке = "+ (int)armor.armParam);
        else {System.out.println("Броня " + armor.name + " полностью разрушена.");
            inventory[a] = null;}
        System.out.println();




    }
}


