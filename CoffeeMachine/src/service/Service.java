package service;

import exceptionHandlers.InsufficientMaterial;
import models.*;

import java.util.Scanner;

public class Service {

    BeverageFactory beverageFactoryType;
    Milk presentMilk;
    CoffeeBeans presentCoffeeBeans;
    Water water;
    CoffeeSystem cSystem;
    BeverageFactory currBeverageFactory = null;
    Scanner sc = new Scanner(System.in);
    public void instantiateMachine(){

        this.presentMilk = new Milk(100);
        this.presentCoffeeBeans = new CoffeeBeans(100);
        this.water = new Water(100);
        this.cSystem = new CoffeeSystem(presentMilk,presentCoffeeBeans,water);
        System.out.println("User please enter coffee type of your choice...");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        try{
            createOrder(name);
        }catch(Exception e) {
            throw new InsufficientMaterial("Insufficient Material",e.getMessage());
        }
        System.out.println("Want any other drink? (y/n)");
        String resp = sc.next();
        if(resp.equalsIgnoreCase("y")){
            repeatOrder(resp);
        }
    }

    public void createOrder(String name) throws Exception {
        if(name.equalsIgnoreCase("Cappuccino")){
            beverageFactoryType = new Cappuccino();
            currBeverageFactory = beverageFactoryType.getBeverage(cSystem);
            if(currBeverageFactory == null){
               throw new Exception("Sorry Insufficient Material");
            }
        }else if(name.equalsIgnoreCase("Latte")){
            beverageFactoryType = new Latte();
            currBeverageFactory = beverageFactoryType.getBeverage(cSystem);
            if(currBeverageFactory == null){
                throw new Exception("Sorry Insufficient Material");
            }
        }else if(name.equalsIgnoreCase("Mocha")){
            beverageFactoryType = new Mocha();
            currBeverageFactory = beverageFactoryType.getBeverage(cSystem);
            if(currBeverageFactory == null){
                throw new Exception("Sorry Insufficient Material");
            }
        }else if(name.equalsIgnoreCase("Espresso")){
            beverageFactoryType = new Espresso();
            currBeverageFactory = beverageFactoryType.getBeverage(cSystem);
            if(currBeverageFactory == null){
                throw new Exception("Sorry Insufficient Material");
            }
        }
    }
    private void repeatOrder(String resp){
        if(resp.equalsIgnoreCase("y")){
            System.out.println("User please enter coffee type of your choice...");
            String anotherName = sc.next();
            try{
                createOrder(anotherName);
            }catch(Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Want any other drink? (y/n)");
            String anotherResp = sc.next();
            repeatOrder(anotherResp);
        }
    }
}
