package com.example.testdefindspringbootstart;

import com.example.testdefindspringbootstart.bean.User;
import com.example.testdefindspringbootstart.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan(basePackages ="com.example.testdefindspringbootstart.bean")
public class ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CacheManager cacheManager;
    @Test
    public void test() throws Exception {

        // 创建10条记录
        userDao.save(new User("AAA", 10));
        userDao.save(new User("BBB", 20));
        userDao.save(new User("CCC", 30));
        userDao.save(new User("DDD", 40));
        userDao.save(new User("EEE", 50));
        userDao.save(new User("FFF", 60));
        userDao.save(new User("GGG", 70));
        userDao.save(new User("HHH", 80));
        userDao.save(new User("III", 90));
        userDao.save(new User("JJJ", 100));

        // 测试findAll, 查询所有记录
       // Assert.assertEquals(0, userDao.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
       // Assert.assertEquals(60, userDao.findUserByUserName("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
       // Assert.assertEquals(60, userDao.findUser("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userDao.findUserByUserNameAndAge("FFF", 60).getUserName());

        // 测试删除姓名为AAA的User
       // userRepository.delete(userDao.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        //Assert.assertEquals(9, userDao.findAll().size());

    }

    @Test
    public void test1() throws Exception {
        System.out.println("CacheManager type : " + cacheManager.getClass());
        // 创建1条记录
        userDao.save(new User("AAA", 10));

        User u1 = userDao.findUserByUserName("AAA");
        System.out.println("第一次查询：" + u1.getAge());

        User u2 = userDao.findUserByUserName("AAA");
        System.out.println("第二次查询：" + u2.getAge());
    }
}