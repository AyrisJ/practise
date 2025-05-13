package com.ayris.mybatisplus;

import com.ayris.mybatisplus.dao.UserDao;
import com.ayris.mybatisplus.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Resource
    private UserDao userDao;

    @Test
    void contextLoads() {

    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userDao.selectList(null);
        userList.forEach(System.out::println);
    }


}
