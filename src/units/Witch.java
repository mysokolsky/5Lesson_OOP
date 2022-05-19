package units;

public class Witch extends Humanoid implements Flyable, Inventoryless {

    public Witch(String name, int health, int power, int skinParam,int money) {
        super(name, health, power, skinParam, money);
    }

    public void fly(){
        System.out.println(name + " летит!!!");
    }


    // по моей задумке объекты класса Witch не носят броню и оружие. У них нет инвентаря вообще.
    // Их сила колдовства персонажа - это и есть их оружие.
    // Поэтому ниже переопределены нулевые методы, которые позволяют
    // обойти ошибки при выборе и расчёте брони и оружия


    @Override
    public int attack() {
        fly();
        return 0;
    }



    @Override
    public void damageArmor(int fp) {

    }

    @Override
    public void damageWeapon() {

    }


    @Override
    public void defence() {

    }



    // зато у объектов класса Witch есть особое свойство при забирании себе денег убитого персонажа.
    // Благодаря колдовству они увеличивают это количество и забирают себе ещё больше денег, чем есть у убитого.
    // Это всё отрабатывает переопределённый метод ниже.

    @Override
    public void getMoney(Unit victim) {

        int victimMoney = ((Humanoid) victim).money;
        System.out.println();
        System.out.println("До сражения у " + name +" было " + money + " золотых монет.");
        System.out.println("У побеждённой жертвы " + victim.name + " оказалось " + victimMoney + " золотых монет.");

        int magicMoney = Unit.random(victimMoney);
        System.out.println(name + " применил(а) древнее заклинание приращения золота и смог(ла) " +
                "наколдовать ещё дополнительные " + magicMoney + " золотых монет.");
        money = money + victimMoney + magicMoney;
        System.out.println("Теперь у " + name +" "+ money + " золотых монет.");

    }
}
