package ivor.online;

public class Person implements IPerson {

  @Override
  public String sayHello(String name, int age) {
    return "Hello " + name + ", you are " + age + " years old";
  }

}
