package units;

public class Dragon extends Animal implements Flyable{

    public Dragon(String name, int health, int power, int skinParam) {
        super(name, health, power, skinParam);
    }

    public void fly(){
        System.out.println(name + " летит!!!");
    }

    @Override
    public int attack() {
        fly();
        return 0;
    }
}
