package models;

import java.util.Scanner;

public class Espresso implements BeverageFactory {

    static String name = "Espresso";
    CoffeeBeans coffeeBeans = new CoffeeBeans(70);
    Milk milk = new Milk(0);
    Water water = new Water(30);
    Scanner sc = new Scanner(System.in);
    @Override
    public BeverageFactory getBeverage(CoffeeSystem system) {
        if(system.getMilk().quantity >= this.milk.quantity && system.getCoffeeBeans().quantity >= this.coffeeBeans.quantity && system.getWater().quantity >= this.water.quantity){
            system.setMilk(Math.abs(system.getMilk().quantity - this.milk.quantity));
            system.setWater(Math.abs(system.getWater().quantity - this.water.quantity));
            system.setCoffeeBeans(Math.abs(system.getCoffeeBeans().quantity - this.coffeeBeans.quantity));
            System.out.println("Everything seems good enjoy your drink!");
            System.out.println("Want to see the available items? (y/n)");
            String resp = sc.next();
            if(resp.equalsIgnoreCase("y")){
                system.printAvailableItems();
            }
            return new Espresso();
        }else{
            if(system.getWater().quantity < this.water.quantity){
                System.out.println("Hey bro please fill the required water amount "+Math.abs(system.getWater().quantity - this.water.quantity));
                return null;
            }
            if(system.getMilk().quantity < this.milk.quantity){
                System.out.println("Hey bro please fill the required milk amount "+Math.abs(system.getMilk().quantity - this.milk.quantity));
                return null;
            }
            if(system.getCoffeeBeans().quantity < this.coffeeBeans.quantity){
                System.out.println("Hey bro please fill the required coffeeBeans amount "+Math.abs(system.getCoffeeBeans().quantity - this.coffeeBeans.quantity));
                return null;
            }
            return null;
        }
    }
}
