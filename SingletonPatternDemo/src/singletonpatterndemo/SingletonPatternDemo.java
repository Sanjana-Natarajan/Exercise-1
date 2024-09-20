
package singletonpatterndemo;

/**
 *
 * @author sanja
 */
class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Private constructor to prevent instantiation
        System.out.println("Database Connection established!");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}

public class SingletonPatternDemo {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.query("SELECT * FROM users");

        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.query("SELECT * FROM products");

        // Both db1 and db2 are the same instance
    }
}

