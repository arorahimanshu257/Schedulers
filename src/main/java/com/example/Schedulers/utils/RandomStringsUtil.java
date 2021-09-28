package com.example.Schedulers.utils;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Random;

@Component
public class RandomStringsUtil {

    public String randomName() {
        Faker fake = new Faker();
        return fake.name().fullName();
    }

    public String randomMessage() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
}
