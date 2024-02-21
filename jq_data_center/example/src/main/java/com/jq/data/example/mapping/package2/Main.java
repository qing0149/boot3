package com.jq.data.example.mapping.package2;

import com.jq.data.example.mapping.package2.copier.StudentPeopleCopier;
import com.jq.data.example.mapping.package2.enums.SexEnum;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-18 10:00
 **/
public class Main {
    public static void main(String[] args) {
        People people = new People();
        people.setName("张三");
        people.setSexEnum(SexEnum.MAN);
        people.setAge(20);
/*        Dog dog = new Dog();
        dog.setName("土狗");
        dog.setAge(21);
        people.setDog(dog);*/
        System.out.println(people);
        Student student = StudentPeopleCopier.instance.getStudent(people);
        System.out.println(student);

    }
}
