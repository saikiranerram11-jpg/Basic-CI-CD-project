package com.devops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void testApplicationMessage() {

        String message = "Hello from Basic CI/CD Project!";

        assertEquals(
            "Hello from Basic CI/CD Project!",
            message
        );
    }

}
