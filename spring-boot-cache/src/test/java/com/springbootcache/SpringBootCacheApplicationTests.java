package com.springbootcache;

import com.springbootcache.bean.Employee;
import com.springbootcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 操作 k-V 字符串
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 操作 k-V 对象
     */
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        Employee employee = employeeMapper.getEmpById(5);
        System.out.println(employee.toString());
    }

    /**
     * Redis 常见的五大类型：
     *  String(字符串)  List(列表)  Set(集合)  Hash(散列)  ZSet(有序集合)
     */
    @Test
    public void testRedis(){
        String k1 = stringRedisTemplate.opsForValue().get("k1");
        redisTemplate.opsForValue().set("emp", employeeMapper.getEmpById(5));
        Object emp = redisTemplate.opsForValue().get("emp");

        System.out.println("*** k1 === "+k1);
        System.out.println("*** emp === "+emp);
    }
}

