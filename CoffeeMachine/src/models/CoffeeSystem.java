package models;

public class CoffeeSystem {
    static Milk milk;
    static CoffeeBeans coffeeBeans;
    static Water water;

    public CoffeeSystem(Milk availMilk, CoffeeBeans availCoffeeBeans, Water availWater) {
        this.milk = availMilk;
        this.coffeeBeans = availCoffeeBeans;
        this.water = availWater;
    }

    public Milk getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk.quantity = milk;
    }

    public CoffeeBeans getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans.quantity = coffeeBeans;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water.quantity = water;
    }
    public void printAvailableItems(){
        System.out.println("Available CoffeeBeans is "+this.getCoffeeBeans().quantity);
        System.out.println("Available Milk is "+this.getMilk().quantity);
        System.out.println("Available Water is "+this.getWater().quantity);
    }
}
