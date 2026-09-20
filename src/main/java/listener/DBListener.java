package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import util.DBConnection;

@WebListener
public class DBListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Swathi Mart application started!");
        System.out.println("HikariCP connection pool initialized!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBConnection.closeDataSource();
        System.out.println("Swathi Mart application stopped!");
        System.out.println("HikariCP connection pool closed!");
    }
}