package com.qa.util;

import java.util.*;

public class MapperExample {
    public static void main (String [] arguments) {
        TreeMap<String, String> dictionarry = new TreeMap<>();
        dictionarry.put("Brave", "Ready to face and endure Danger");
        dictionarry.put("Brilliant", "Exceptionnaly clever or talented");
        dictionarry.put("Joy", "Feeling of pleasure and happiness");
        dictionarry.put("Confidence", "State of feeling certain about the truth of something");
//        for (String word : dictionarry.keySet()) {
//            System.out.println(word + " ||  " + dictionarry.get(word));
//        }
        for (Map.Entry<String, String> entry : dictionarry.entrySet()) {
            System.out.println(entry);
        }

    }
    class User {
        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

    }
}
