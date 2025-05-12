package com.ayris.simple;

import com.ayris.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("prod")
public class SimpleTest {

    @Autowired
    private UserService userService;

    @Test
    public void testEmpty() {

    }

    @Test
    public void testUserService(){
        System.out.println(userService.getUser(1));
    }

}
