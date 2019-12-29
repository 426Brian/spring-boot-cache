package com.springbootcache;

import com.mysql.cj.jdbc.MysqlXAConnection;
import com.mysql.cj.xdevapi.SessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;

@SpringBootApplication
@MapperScan("com.springbootcache.mapper")
@EnableCaching
public class SpringBootCacheApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootCacheApplication.class, args);

    }

    @Bean
    public ViewResolver myViewResolver(){

        return new MyViewResolver();
    }

    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

    // 测试数据库连接
    public static void DbConnect() {
        String url = "jdbc:mysql://localhost:3306/spring_cache?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "18d0b61;9";
        String classname = "com.mysql.jdbc.Driver";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection == "+connection);
            if(connection != null){
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}

