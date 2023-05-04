package main.DataStoreTest2;

import java.io.Serializable;

public class Persons implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;
    
    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
