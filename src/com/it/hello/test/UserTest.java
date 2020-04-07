package com.it.hello.test;

import com.it.hello.User;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getName() {
        assertThat(new User().getName(), is("admin"));
    }
}