package com.cydeo.utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerClass {
    @Test
    public void fakerTest() {


        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
    }
}
