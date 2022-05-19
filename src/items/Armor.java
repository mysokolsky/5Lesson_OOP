package items;

import static units.Unit.random;

public class Armor extends Item{
    public double armParam;

    public Armor(String name, int weight, int strength, double armParam) {
        super(name, weight, strength);
        this.armParam = armParam;
    }


    // конструктор реализует задачу по экипировке персонажа бронёй на несколько частей тела.
    // Используется при создании брони
    public Armor(String name, int weight, double armParam) {
        super(name, weight, 0);
        this.strength = strength();
        this.armParam = armParam;
    }



    public int strength(){
        return body() + head() + hands() + legs();

    }

    public int body() {return 40 + random(15);}

    public int head() {return 10 + random(20);}

    public int hands() {return 10 + random(10);}

    public int legs() {return 20 + random(15);}



}
