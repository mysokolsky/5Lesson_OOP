import items.*;
import units.*;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {


        Human human1 = new Human("Ланселот",20,10, 10,500,500, new Inventory(5));
        Weapon sword = new Weapon("Меч-кладинец!",15,60,35);
        Armor kirasa = new Armor("кираса Лепорелло",20, 40, 70);
        human1.bag.inventory[0] = sword;
        human1.bag.inventory[1] = kirasa;



        Human human2 = new Human("Рэмбо",60,20, 10,60, 300, new Inventory(7));
        Weapon uzi = new Weapon("Автомат УЗИ",10, 30, 100);
        Armor bronik = new Armor("бронежилет спецназа ГРУ",15, 60, 80);
        human2.bag.inventory[3] = uzi;
        human2.bag.inventory[6] = bronik;


        Human human3 = new Human("Штирлиц",200, 15, 10,57, 0,new Inventory(4));
        Weapon knife = new Weapon("кинжал ассасина!",5, 20, 15);
        Armor kolchuga = new Armor("кольчуга Александра Невского",25, 30, 60);
        human3.bag.inventory[1] = knife;
        human3.bag.inventory[3] = kolchuga;


        //        Персонаж типа Орк не носит никакую броню никогда, но может носить другие предметы и оружие.
        //        У него есть инвентарь, но броня в него добавляться не будет

        Orc orc1 = new Orc("Орчелло",200, 50, 20,100, 3000, new Inventory(10));
        Weapon hummer = new Weapon("Молот Тора!",25, 100, 30);
        orc1.bag.inventory[0] = hummer;



        Witch koldun = new Witch("Чернокнижник",700,50, 10, 2000);
        Weapon magic = new Weapon("свиток колдовства ведьмы из Блэр",0,1000,40);
        // персонаж ведьма не может носить оружие или броню.
        // Он обладает только магией, то есть сила персонажа и есть сила его магии.
        // именно поэтому для него создан конструктор, не предполагающий инвентаря


        // персонажи класса Animal не носят броню и предметы вообще, у них нет инвентаря
        // для расчёта сопротивляемости удару вместо брони у них берётся костно-кожный коэффициент их тела

        Dragon gorynych = new Dragon("Змей Горыныч",300, 50, 40);

        Animal bear = new Animal("медведь Балу",100, 30, 30);

        Animal wolf = new Animal("волк Акелла", 50,20, 25);



        //реализация задания по созданию комплексной брони на руки, ноги, голову и туловище через конструктор
        Armor powerShield = new Armor("силовой щит Paul Atreides",1, 100);
        human2.bag.inventory[2] = powerShield;


//Ланселот
        human1.bag.inventory = new Item[]{null, hummer, knife, null, kirasa, null, null, hummer, knife, null, kirasa, null, null, hummer, knife, null, kirasa, null};
// Штирлиц
        human3.bag.inventory = new Item[]{null, knife, uzi, hummer,magic, sword};



        human1.fight(human3);
        wolf.fight(koldun);
        gorynych.fight(koldun);
        bear.fight(orc1);
        orc1.fight(koldun);
        human3.fight(human2);




    }



}
