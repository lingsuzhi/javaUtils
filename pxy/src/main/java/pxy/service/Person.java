package pxy.service;

public class Person implements  Animal {
    public void eat(String food) {
        System.out.println("人吃" + food);
    }

    public void run() {
        System.out.println("人跑步");
    }
}
