package units;

import items.*;


public abstract class Unit implements Attackable{
    public String name; // имя персонажа
    public int health;  //количество здоровья
    public int power;  //сила атаки персонажа без оружия
    public int skinParam; // коэффициент сопротивления кожно-костного строения тела персонажа

//    public static int fullPower;


    public Unit(String name, int health, int power, int skinParam) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.skinParam = skinParam;
        System.out.println(name + " создан!");

    }

    // самый главный метод всей программы, отвечающий за схватку двух персонажей до смерти одного из них
    public void fight(Unit victim){
        if (this != null && victim != null) {
            if (victim.health > 0 && health > 0) {
                System.out.println();
                System.out.println();
                System.out.println("!!!     В Н И М А Н И Е      !!!  ");
                System.out.println();
                System.out.println(this.name + " напал на " + victim.name);


                // вычисление полной силы атаки нападающего. Зависит от оружия.
                // так же происходит вызов метода attack, который отвечает за выбор лучшего оружия из инвентаря.
                // Если оружия нет, то сила атаки равна силе персонажа
                int fullPower = (int) (this.power * (100 + this.attack()) / 100);

                System.out.println("Сила атаки " + name + " = " + fullPower);


                // вызов метода, отвечающего за выбор лучшей брони из инвентаря жертвы перед нанесением ей удара
                victim.defence();


                // данный блок кода ниже предназначен для персонажей, у которых нет брони сейчас или вообще.
                // тогда вместо коэффициента сопр. брони используется
                // коэфф. сопротивления кожно-костного строения тела жертвы нападения
                if (Inventory.maxA == 0) {
                    Inventory.maxA = victim.skinParam;
//                System.out.println(Inventory.maxA + " коэф. кожи жертвы " + victim.name);

                    victim.skinParam = (int) (victim.skinParam * (100 - fullPower / 2) / 100);
//                System.out.println(victim.skinParam + " новый коэф.кожи");
                }


                // расчёт повреждения здоровья жертвы в зависимости от полной силы атаки
                // нападающего и коэф.сопротивления брони или кожно-костного коэф.
                // сопротивления тела жертвы, если нет брони
                int damageHealth = (int) (fullPower * (100 - Inventory.maxA / 2) / 100);

                victim.health -= damageHealth;

                // вызов методов, которые уменьшают силу оружия после удара об броню и коэф. сопротивления брони
                // или кожно-костный коэф. сопротивл. тела жертвы если она без брони
                if (Inventory.w != -1) this.damageWeapon();
                if (Inventory.a != -1) victim.damageArmor(fullPower);

                Inventory.maxA = 0;

                System.out.println(victim.name + " получил урон здоровью -" + damageHealth + " пунктов.");


                //  в случае если здоровье жертвы > 0, происходит перезапуск метода fight,
                //  который случайным образом выбирает атакующего из текущей схватки
                if (victim.health > 0) {

                    System.out.println("И теперь имеет здоровье = " + victim.health + " пунктов.");

                    if (random(1) == 0) {
                        this.fight(victim);
                    } else {
                        victim.fight(this);
                    }

                    // если же здоровье жертвы <= 0, то происходит вывод на экран что персонаж умер,
                    // а так же вызов методов ниже, при которых нападавший забирает себе все деньги жертвы и по возможности инвентарь
                } else {
                    System.out.println();
                    System.out.println(victim.name + " убит. Скорбим ;-(");
                    System.out.println("  ___________");
                    System.out.println(" |           |");
                    System.out.println(" |     |     |");
                    System.out.println(" |   --|--   |");
                    System.out.println(" |     |     |");
                    System.out.println(" |     |     |");
                    System.out.println(" |           |");
                    System.out.println(" |   R.I.P.  |");
                    System.out.println("_______________");


                    //проверка, есть ли у жертвы инвентарь, и если есть, то попытка его забрать себе.
                    if (!(this instanceof Inventoryless) && !(victim instanceof Inventoryless)) {
                        System.out.println();
                        System.out.println(" ---------- Подбор инвентаря жертвы: ------------");
                        System.out.println();
                        System.out.println("до того, как осмотреть убитого, " + name + " проверил свою повозку:");
                        viewInventory();
                        System.out.println();
                        System.out.println("после чего " + name + " проверил повозку жертвы:");
                        victim.viewInventory();
                        System.out.println();
                        System.out.println("В итоге:");
                        System.out.println();
                        getInventory(victim);
                    }


                    if (!(this instanceof Moneyless) && !(victim instanceof Moneyless)) {           // проверка, являются ли атакующий и жертва
                        System.out.println();
                        System.out.println(" ------------ Подбор денег жертвы: ---------------");          // персонажами с деньгами
                        getMoney(victim);                                                           // только персонажи класса Humanoid и наследники носят деньги
                    }

                    // очистка из памяти объекта убитой жертвы
                    victim = null;
                    System.gc();  // принудительная очистка
                }
            }
        }
    }




    public static int random(int i){
        int x = ( int )Math.round(i*Math.random());
        return x;
    }




}
