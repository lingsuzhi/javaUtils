package pxy.service;

public class Pig implements  Animal {
    public void eat(String food) {
        System.out.println("猪吃" + food);
    }

    public void run() {
        System.out.println("猪跑步");
    }
}
