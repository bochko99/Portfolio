package com.crypterium.cryptApi.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com/crypterium/cryptApi/database")
public class ApplicationContext {

    @Bean
    public DataSource beta1() {
        return createDS("jdbc:sqlserver://crypterium-backend-beta-1.c0nlua1jnl1p.us-west-2.rds.amazonaws.com:41450", "work", "sql");
    }

    @Bean
    public DataSource beta2() {
        return createDS("jdbc:sqlserver://crypterium-backend-beta-2.c0nlua1jnl1p.us-west-2.rds.amazonaws.com:41450", "work", "sql");
    }

    private DataSource createDS(String url, String user, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
