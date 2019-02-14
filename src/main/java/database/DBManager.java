package database;

import groovy.lang.Singleton;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DBManager {

    private volatile static DBManager instance;
    private static AbstractApplicationContext context;

    private DBManager() {
        context = new AnnotationConfigApplicationContext(ApplicationContext.class);
    }

    public static DBManager getInstance() {
        DBManager localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DBManager();
                }
            }
        }
        return localInstance;
    }

    public JdbcTemplate db1() {
        return new JdbcTemplate((DataSource) context.getBean("db1"));
    }

    public JdbcTemplate db2() {
        return new JdbcTemplate((DataSource) context.getBean("db2"));
    }
}
