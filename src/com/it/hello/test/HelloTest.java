package com.it.hello.test;

import com.it.hello.Hello;
import org.junit.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HelloTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before Class");
    }

    @Before
    public void before(){
        System.out.println("before method");
    }
    @After
    public void after(){
        System.out.println("after method");
    }


    @AfterClass
    public static void afterClass(){
        System.out.println("after Class");
    }

    @Test
    public void add() {
        int a = new Hello().add(3,4);
        assertThat(a, is(7));
    }

    @Test
    public void sub() {
        int a = new Hello().sub(3,4);
        assertThat(a, is(-1));
    }

    @Test
    public void multi() {
        int a = new Hello().multi(3,4);
        assertThat(a, is(12));
    }

    @Test
    public void divide() {
        int a = new Hello().divide(3,4);
        assertThat(a, is(0));
    }
}