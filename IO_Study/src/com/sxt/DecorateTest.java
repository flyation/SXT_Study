package com.sxt;

public class DecorateTest {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        System.out.println(coffee.info()+"==>"+coffee.cost());
        Decorate milk = new Milk(coffee);
        System.out.println(milk.info()+"==>"+milk.cost());
        Decorate suger = new Suger(milk);
        System.out.println(suger.info()+"==>"+suger.cost());
    }
}

//抽象组件
interface Drink{
    String info();
    int cost();
}

//具体组件
class Coffee implements Drink{
    private String name = "original coffee";
    private int price = 10;
    @Override
    public String info() {
        return  name;
    }

    @Override
    public int cost() {
        return price;
    }
}

//抽象装饰
abstract class Decorate implements Drink{
    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }
    @Override
    public String info() {
        return drink.info();
    }

    @Override
    public int cost() {
        return drink.cost();
    }
}

//具体装饰
class Milk extends Decorate{
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public String info() {
        return super.info()+", add milk";
    }

    @Override
    public int cost() {
        return super.cost()+8;
    }
}

class Suger extends Decorate{
    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public String info() {
        return super.info()+", add suger";
    }

    @Override
    public int cost() {
        return super.cost()+4;
    }
}

