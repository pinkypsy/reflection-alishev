package edu.alvin;

import java.beans.Transient;

public class Person {

    public String publicString = "I am public look at me";
    private int age;
    private String name;


    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Author
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Person{" + "publicString='" + publicString + '\'' + ", age="
                + age + ", name='" + name + '\'' + '}';
    }
}
