package util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class SchemaTest {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            String sql = new String(
                Files.readAllBytes(
                    Paths.get("src/main/resources/schema.sql")
                )
            );

            String[] queries = sql.split(";");

            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    stmt.execute(query);
                }
            }

            System.out.println("Database tables created successfully!");

        } catch (Exception e) {
            System.out.println("Schema creation failed!");
            e.printStackTrace();
        }
    }
}