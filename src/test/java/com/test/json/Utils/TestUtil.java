package com.test.json.Utils;

import com.github.javafaker.Faker;
import com.test.json.datamodels.Post;

import java.util.Random;


public final class TestUtil {

    /**
     * Get Random number between given range
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Return post object generated using faker random data
     *
     * @return
     */
    public static Post getPost() {

        Faker faker = new Faker();
        return new Post("11", faker.idNumber().toString(), faker.book().title(), faker.lorem().fixedString(10));
    }
}