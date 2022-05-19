package items;

public abstract class Item {
    public String name;
    public int weight;
    public int strength;

    public Item(String name,int weight, int strength){
        this.name = name;
        this.weight = weight;
        this.strength = strength;
    }

    public Item(){
        name="";
        weight=0;
        strength=0;
    }


}
