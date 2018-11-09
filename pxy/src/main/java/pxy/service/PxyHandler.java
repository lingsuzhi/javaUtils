package pxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PxyHandler implements InvocationHandler {
    private  Animal person ;

    public PxyHandler(Animal person) {
        this.person = person;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(person,args);
    }
}
