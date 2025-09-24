package com.sheridan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloTest {
    @Test
    public void testSayHello(){
        Hello hello = new Hello();
        assertEquals("Hello World", hello.sayHello());
    }
}
