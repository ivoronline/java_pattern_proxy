package ivor.online;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler {

  private IPerson person;

  public PersonInvocationHandler(IPerson person) {
    this.person = person;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    //PRE PROCESSING
    System.out.println("Calling Method " + method.getName() + "()");
    if (method.getName().equals("sayHello")) {
      int age = (int) args[1];
      if (age < 0) { throw new IllegalArgumentException("Age cannot be negative"); }
    }

    //CALL METHOD
    String result = (String) method.invoke(person, args);

    //POST PROCESSING
    System.out.println("Method " + method.getName() + "() executed");

    //RET7URN METHOD RESULT
    return result;

  }

}
