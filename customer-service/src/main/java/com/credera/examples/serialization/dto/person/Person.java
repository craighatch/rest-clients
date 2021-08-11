package com.credera.examples.serialization.dto.person;

import java.util.List;

public class Person {
    private String name;
    private List<Hobby> favoriteHobbies;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hobby> getFavoriteHobbies() {
        return favoriteHobbies;
    }

    public void setFavoriteHobbies(List<Hobby> favoriteHobbies) {
        this.favoriteHobbies = favoriteHobbies;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
