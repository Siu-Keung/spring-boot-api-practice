package com.oocl.springBootApiDemo.entity;

/**
 * @author Dylan Wei
 * @date 2018-07-24 12:41
 */
public class Employee {
    private String id;
    private String name;
    private Integer age;
    private String gender;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Employee(String id, String name, Integer age, String gender) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Employee() {

    }
}
