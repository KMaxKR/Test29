package databaseConfig;

public class Cars {
    private int id;
    private String cars_name;
    private int hp;
    private double price;
    public Cars(int id, String cars_name, int hp, double price){
        this.id = id;
        this.cars_name = cars_name;
        this.hp = hp;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id= " + id + " Car_name= " + cars_name + " HP= " + hp + " Price= " + price;
    }
}
