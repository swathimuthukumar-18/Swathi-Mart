package util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class SeedTest {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            String sql = new String(
                Files.readAllBytes(
                    Paths.get("src/main/resources/seed.sql")
                )
            );

            stmt.execute(sql);

            System.out.println("Admin seed inserted successfully!");

        } catch (Exception e) {
            System.out.println("Seed insertion failed!");
            e.printStackTrace();
        }
    }
}