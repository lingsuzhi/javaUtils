package pxy;

import pxy.service.Animal;
import pxy.service.Person;
import pxy.service.Pig;
import pxy.service.PxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    //    public static void main(String[] args) {
//        Animal pig = new Pig();
////        pig.eat();
////        pig.run();
//
//        Animal person = new Person();
////        person.eat();
////        person.run();
//
//        PxyHandler pxyHandler = new PxyHandler(pig);
//        Animal proxy   =(Animal)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Animal.class},pxyHandler);
//        proxy.eat();
//        proxy.run();
//
//
//
//    }
    Animal animal = null;

    public static void main(String[] args) {
        Main main1 = new Main();


        main1.testDo();
    }
    public void testDo(){
        InvocationHandler pxyHandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                return null;
            }
        };
        Animal proxy   =(Animal)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Animal.class},pxyHandler);
        animal = proxy;

        animal.run();
        animal.eat("饭啊");
    }
}
