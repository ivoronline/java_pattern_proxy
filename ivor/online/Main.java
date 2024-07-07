package ivor.online;

import java.lang.reflect.Proxy;

public class Main {

  public static void main(String[] args) {

    //CREATE PROXY OBJECT AROUND PERSON OBJECT
    Person                  person                  = new Person();
    PersonInvocationHandler personInvocationHandler = new PersonInvocationHandler(person);
    IPerson                 personProxy             = (IPerson) Proxy.newProxyInstance (
        Person.class.getClassLoader()
      , new Class[] { IPerson.class } //person.getClass().getInterfaces()
      , personInvocationHandler
    );

    //CALL PROXY METHOD
    String result = personProxy.sayHello("Jill", 30);
    System.out.println(result);

  }

}
